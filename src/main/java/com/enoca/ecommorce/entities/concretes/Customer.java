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
@Builder
public class Customer extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany
    private Collection<Order> orders;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cart cart;
}
