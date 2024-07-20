package project.learning.productservice.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import project.learning.productservice.models.Category;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "name required")
        String name,
        @NotNull(message = "description required")
        String description,

        @Positive(message = "Available Quantity should be positive")
        double availableQuantity,
        @Positive(message = "price should be positive")
        BigDecimal price,

        @NotNull(message = "Category required")
        Category category
) {}

