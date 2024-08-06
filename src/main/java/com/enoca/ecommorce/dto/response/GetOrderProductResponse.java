package com.enoca.ecommorce.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class GetOrderProductResponse {
    private Long id;
    private String name;
    private double price;
}
