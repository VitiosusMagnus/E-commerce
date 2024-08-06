package com.enoca.ecommorce.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetProductResponse {
    private Long id;
    private String name;
    private int price;
    private int stockAmount;
    private String description;
}
