package com.Lakkam.product_service.Repository;

import com.Lakkam.product_service.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
