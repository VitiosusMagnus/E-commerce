package com.enoca.ecommorce.controllers;

import com.enoca.ecommorce.dto.response.GetOrderResponse;
import com.enoca.ecommorce.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("{orderId}")
    public GetOrderResponse getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping("/user/{userId}")
    public List<GetOrderResponse> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }
    @PostMapping("{userId}")
    public void createOrder(@PathVariable Long userId, @RequestBody String address) {
        orderService.createOrder(userId, address);
    }
}
