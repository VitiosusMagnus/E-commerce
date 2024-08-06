package com.enoca.ecommorce.repositories;

import com.enoca.ecommorce.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
