package project.learning.customerservice.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import project.learning.customerservice.dto.CustomerMapper;
import project.learning.customerservice.dto.CustomerRequest;
import project.learning.customerservice.dto.CustomerResponse;
import project.learning.customerservice.exceptions.CustomerNotFoundException;
import project.learning.customerservice.models.Customer;
import project.learning.customerservice.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        Customer customer=mapper.toCustomer(request);
        customerRepository.save(customer);
        return customer.getId();
    }

    public String updateCustomer(CustomerRequest request) {
        Customer customer=customerRepository.findById(request.id()).orElseThrow(()-> new CustomerNotFoundException("Customer not Found, can not update"));
        merge(customer,request);
        customerRepository.save(customer);
        return customer.getId();
    }

    private void merge(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.lastname())) {
            customer.setFirstname(request.lastname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean exists(String id) {
        return customerRepository.existsById(id);
    }

    public CustomerResponse findById(String customerId) {
        return mapper.fromCustomer(customerRepository.findById(customerId).orElseThrow(()-> new CustomerNotFoundException("customer not found")));
    }

    public void deleteById(String customerId) {
        customerRepository.deleteById(customerId);
    }
}
