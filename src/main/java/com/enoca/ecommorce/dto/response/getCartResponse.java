package com.enoca.ecommorce.dto.response;

import com.enoca.ecommorce.entities.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class getCartResponse {
    private GetCartCustomerResponse customer;
    private List<Product> products;
    private double totalPrice;
}
