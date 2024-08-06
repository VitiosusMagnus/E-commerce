package com.enoca.ecommorce.services;

import com.enoca.ecommorce.dto.request.UpdateCartRequest;
import com.enoca.ecommorce.dto.response.getCardResponse;
import com.enoca.ecommorce.entities.concretes.Product;
import com.enoca.ecommorce.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;
    private final ProductService productService;

    public void addProduct(Long cartId, Long productId) {
        cartRepository.findById(cartId).ifPresent(cart -> {
            Product product = modelMapper
                    .map(productService.getProduct(productId), Product.class);
            cart.getProducts().add(product);
            cartRepository.save(cart);
        });
    }

    public getCardResponse getCart(Long cartId) {
        return cartRepository.findById(cartId)
                .map(cart -> modelMapper.map(cart, getCardResponse.class))
                .orElse(null);
    }

    public void updateCart(UpdateCartRequest request) {
        cartRepository.findById(request.getCartId()).ifPresent(cart -> {
            cart.getProducts().clear();
            request.getProducts().forEach(updateCartProductRequest -> {
                Product product = modelMapper
                        .map(productService.getProduct(updateCartProductRequest.getProductId()), Product.class);
                cart.getProducts().add(product);
            });
            cartRepository.save(cart);
        });
    }

    public void emptyCart(Long cartId) {
        cartRepository.findById(cartId).ifPresent(cart -> {
            cart.getProducts().clear();
            cartRepository.save(cart);
        });
    }

    public void removeProduct(Long cartId, Long productId) {
        cartRepository.findById(cartId).ifPresent(cart -> {
            cart.getProducts().removeIf(product -> product.getId().equals(productId));
            cartRepository.save(cart);
        });
    }
}
