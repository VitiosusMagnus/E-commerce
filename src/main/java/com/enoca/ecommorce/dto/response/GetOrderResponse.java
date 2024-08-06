package com.enoca.ecommorce.dto.response;

import java.util.List;

public class GetOrderResponse {
    private Long id;
    private List<GetOrderProductResponse> products;
    private String address;
}
