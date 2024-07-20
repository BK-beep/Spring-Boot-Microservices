package project.learning.productservice.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
        @NotNull(message = "Product is mandatory")
        Integer id,
        @Positive(message = "Quantity is mandatory")
        double quantity
) {
}
