package project.learning.customerservice.dto;

import project.learning.customerservice.models.Address;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {}
