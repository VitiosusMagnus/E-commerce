package com.enoca.ecommorce.services;

import com.enoca.ecommorce.dto.response.GetOrderResponse;
import com.enoca.ecommorce.dto.response.getCartResponse;
import com.enoca.ecommorce.entities.compositekeys.OrderedProductId;
import com.enoca.ecommorce.entities.concretes.Customer;
import com.enoca.ecommorce.entities.concretes.Order;
import com.enoca.ecommorce.entities.concretes.OrderedProduct;
import com.enoca.ecommorce.entities.concretes.Product;
import com.enoca.ecommorce.repositories.OrderRepository;
import com.enoca.ecommorce.repositories.OrderedProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderedProductRepository orderedProductRepository;
    private final ModelMapper modelMapper;
    private final CartService cartService;



    public GetOrderResponse getOrder(Long orderId) {
        GetOrderResponse response = modelMapper.map(
                orderRepository.findById(orderId).orElseThrow(),
                GetOrderResponse.class
        );
        return updatePrice(response);
    }


    public List<GetOrderResponse> getOrdersByUserId(Long userId) {
        return orderRepository.findAllByCustomerId(userId).stream().map(
                order -> {
                    GetOrderResponse response = modelMapper.map(order, GetOrderResponse.class);
                    return updatePrice(response);
                }
        ).collect(Collectors.toList());
    }

    public void createOrder(Long userId, String address) {
        getCartResponse cart = cartService.getCart(userId);
        validateStock(cart.getProducts());
        Order order = Order.builder()
                .customer(modelMapper.map(cart.getCustomer(), Customer.class))
                .products(cart.getProducts())
                .address(address)
                .totalPrice(cart.getTotalPrice())
                .build();
        order = orderRepository.save(order);
        createOrderedProducts(cart.getProducts(),order);
        cartService.emptyCart(userId);
    }

    private void createOrderedProducts(List<Product> products, Order order) {
        products.forEach(product -> {
            orderedProductRepository.save(
                    OrderedProduct.builder()
                            .id(new OrderedProductId(order.getId(), product.getId()))
                            .product(product)
                            .order(order)
                            .price(product.getPrice())
                            .build()
            );
        });
    }

    private void validateStock(List<Product> products) {
        products.forEach(product -> {
            if (product.getStockAmount() <= 0) {
                throw new RuntimeException("Stock is not enough for product id: " + product.getId());
            }
        });
    }

    private GetOrderResponse updatePrice(GetOrderResponse response) {
        response.getProducts().forEach(product -> {
           double price = orderedProductRepository.findById(
                   OrderedProductId.builder()
                           .orderId(response.getId())
                           .productId(product.getId())
                           .build()
           ).get().getPrice();
           product.setPrice(price);
        });
        return response;
    }
}
