package com.enoca.ecommorce.repositories;

import com.enoca.ecommorce.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
