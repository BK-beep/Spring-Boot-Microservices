package project.learning.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.learning.productservice.models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> findAllByIdInOrderById(List<Integer> ids);
}
