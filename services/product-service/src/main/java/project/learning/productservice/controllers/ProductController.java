package project.learning.productservice.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.learning.productservice.DTO.ProductPurchaseRequest;
import project.learning.productservice.DTO.ProductPurchaseResponse;
import project.learning.productservice.DTO.ProductRequest;
import project.learning.productservice.DTO.ProductResponse;
import project.learning.productservice.exceptions.ProductPurchaseException;
import project.learning.productservice.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    @PostMapping
    public ResponseEntity<Integer> createProduct(
            @RequestBody @Valid ProductRequest request){
        return ResponseEntity.ok(this.service.createProduct(request));
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable Integer id){
        return ResponseEntity.ok(this.service.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAll(){
        return ResponseEntity.ok(this.service.getAll());
    }
    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody @Valid List<ProductPurchaseRequest> requests) throws ProductPurchaseException {
        return ResponseEntity.ok(this.service.purchaseProducts(requests));
    }

}
