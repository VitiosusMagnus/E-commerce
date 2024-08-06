package com.enoca.ecommorce.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetOrderResponse {
    private Long id;
    private List<GetOrderProductResponse> products;
    private String address;
    private double totalPrice;
}
