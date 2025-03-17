package lk.ijse.affililink.repo;

import lk.ijse.affililink.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
