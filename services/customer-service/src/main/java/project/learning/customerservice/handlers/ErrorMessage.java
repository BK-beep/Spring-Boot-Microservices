package project.learning.customerservice.handlers;

import java.util.Map;

public record ErrorMessage(
        Map<String, String > errors
) {
}
