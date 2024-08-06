package com.enoca.ecommorce.services;

import com.enoca.ecommorce.dto.response.GetOrderResponse;
import com.enoca.ecommorce.dto.response.getCardResponse;
import com.enoca.ecommorce.entities.concretes.Cart;
import com.enoca.ecommorce.entities.concretes.Order;
import com.enoca.ecommorce.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CartService cartService;



    public GetOrderResponse getOrder(Long orderId) {
        return modelMapper.map(
                orderRepository.findById(orderId).orElseThrow(),
                GetOrderResponse.class
        );
    }


    public List<GetOrderResponse> getOrdersByUserId(Long userId) {
        return orderRepository.findAllByCustomerId(userId).stream().map(
                order -> modelMapper.map(order, GetOrderResponse.class)
        ).collect(Collectors.toList());
    }

    public void createOrder(Long userId, String address) {
        getCardResponse cart = cartService.getCart(userId);
        Order order = Order.builder()
                .customer(cart.getCustomer())
                .products(cart.getProducts())
                .address(address)
                .totalPrice(cart.getTotalPrice())
                .build();
        orderRepository.save(order);
        cartService.emptyCart(userId);
    }
}
