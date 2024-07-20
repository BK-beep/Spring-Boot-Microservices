package project.learning.productservice.DTO;

import project.learning.productservice.models.Category;
import project.learning.productservice.models.Product;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
        Integer id,
        String name,
        String description,
        double Quantity,
        BigDecimal price) {}
