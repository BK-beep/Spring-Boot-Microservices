package project.learning.customerservice.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.learning.customerservice.dto.CustomerRequest;
import project.learning.customerservice.dto.CustomerResponse;
import project.learning.customerservice.services.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;
    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(service.createCustomer(request));
    }

    @PostMapping("update")
    public ResponseEntity<String> updateCustomer(
            @RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(service.updateCustomer(request));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(path = "/exists/{id}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable String id
    ){
        return ResponseEntity.ok(service.exists(id));
    }
    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(
            @PathVariable("customer-id") String customerId
    ) {
        return ResponseEntity.ok(this.service.findById(customerId));
    }
    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("customer-id") String customerId
    ) {
        return ResponseEntity.accepted().build();
    }
}
