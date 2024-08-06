package com.enoca.ecommorce.repositories;

import com.enoca.ecommorce.entities.compositekeys.OrderedProductId;
import com.enoca.ecommorce.entities.concretes.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductRepository extends JpaRepository<OrderedProduct, OrderedProductId> {

}
