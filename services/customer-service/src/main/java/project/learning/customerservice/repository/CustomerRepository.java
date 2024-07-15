package project.learning.customerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.learning.customerservice.models.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String> {
}
