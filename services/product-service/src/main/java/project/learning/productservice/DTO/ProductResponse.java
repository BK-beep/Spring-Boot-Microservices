package project.learning.productservice.DTO;

import project.learning.productservice.models.Category;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        Category category
) {}
