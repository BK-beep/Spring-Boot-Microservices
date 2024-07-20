package project.learning.productservice.handlers;

import java.util.Map;

public record ErrorMessage(
        Map<String,String> errors
) {
}
