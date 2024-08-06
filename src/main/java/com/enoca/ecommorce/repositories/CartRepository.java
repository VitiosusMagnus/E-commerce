package com.enoca.ecommorce.repositories;

import com.enoca.ecommorce.entities.concretes.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByCustomerId(Long userId);
}
