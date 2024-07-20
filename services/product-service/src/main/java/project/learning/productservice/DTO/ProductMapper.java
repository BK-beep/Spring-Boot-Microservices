package project.learning.productservice.DTO;

import org.springframework.stereotype.Component;
import project.learning.productservice.DTO.ProductPurchaseResponse;
import project.learning.productservice.DTO.ProductRequest;
import project.learning.productservice.DTO.ProductResponse;
import project.learning.productservice.models.Product;

import java.math.BigDecimal;

@Component
public class ProductMapper {
    public Product toProduct(ProductRequest request){
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(request.category())
                .build();
    }

    public ProductResponse fromProduct(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory());
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice().doubleValue(),
                BigDecimal.valueOf(quantity));
    }
}
