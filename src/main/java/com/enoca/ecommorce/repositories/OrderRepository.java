package com.enoca.ecommorce.repositories;

import com.enoca.ecommorce.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
