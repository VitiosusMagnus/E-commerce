package com.enoca.ecommorce.entities.concretes;

import com.enoca.ecommorce.entities.compositekeys.OrderedProductId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderedProduct {

    @EmbeddedId
    private OrderedProductId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    private double price;


}
