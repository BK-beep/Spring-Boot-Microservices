package project.learning.customerservice.exceptions;

import lombok.Data;

@Data

public class CustomerNotFoundException extends RuntimeException {
    private final String msg;
}
