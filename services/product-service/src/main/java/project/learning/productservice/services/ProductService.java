package project.learning.productservice.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.learning.productservice.DTO.*;
import project.learning.productservice.exceptions.ProductPurchaseException;
import project.learning.productservice.models.Product;
import project.learning.productservice.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    public Integer createProduct(ProductRequest request) {
        Product product=this.mapper.toProduct(request);
        this.repository.save(product);
        return product.getId();
    }

    public ProductResponse getById(Integer id) {
        return this.mapper.fromProduct(repository.findById(id).orElseThrow(()->new EntityNotFoundException("can not find product")));
    }

    public List<ProductResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::fromProduct)
                .collect(Collectors.toList());
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> requests) throws ProductPurchaseException {
        List<Integer> productIDs=requests
                .stream()
                .map(ProductPurchaseRequest::id)
                .toList();
        List<Product> storedProducts=repository.findAllByIdInOrderById(productIDs);
        if (productIDs.size() < storedProducts.size()) throw new ProductPurchaseException("one or more Products does not exist");
        List<ProductPurchaseRequest> requestedProducts=requests
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::id))
                .collect(Collectors.toList());
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i=0;i< storedProducts.size();i++){
            Product storedProduct=storedProducts.get(i);
            ProductPurchaseRequest requestedProduct=requestedProducts.get(i);
            if (storedProduct.getAvailableQuantity()<requestedProduct.quantity())  throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + requestedProduct.id());
            var newAvailableQuantity=storedProduct.getAvailableQuantity() - requestedProduct.quantity();
            storedProduct.setAvailableQuantity(newAvailableQuantity);
            repository.save(storedProduct);
            purchasedProducts.add(mapper.toProductPurchaseResponse(storedProduct,requestedProduct.quantity()));
        }
        return purchasedProducts;
    }
}
