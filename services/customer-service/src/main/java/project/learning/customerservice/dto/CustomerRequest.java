package project.learning.customerservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import project.learning.customerservice.models.Address;

public record CustomerRequest(
        String id,
        @NotNull(message = "firstname Required")
        String firstname,
        @NotNull(message = "lastname Required")
        String lastname,
        @NotNull(message = "email Required")
        @Email(message = "email not valid")
        String email,
        Address address
) {
}
