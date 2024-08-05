package com.enoca.ecommorce.entities.concretes;

import com.enoca.ecommorce.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order extends BaseEntity {

    @Column()
    @ManyToMany()
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Collection<Product> products;


    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
