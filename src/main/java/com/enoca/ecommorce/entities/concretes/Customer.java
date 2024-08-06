package com.enoca.ecommorce.entities.concretes;

import com.enoca.ecommorce.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntity {

    @Setter
    @Column(name = "name")
    private String name;

    @OneToMany
    private Collection<Order> orders;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
}
