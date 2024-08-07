package com.enoca.ecommorce.controllers;

import com.enoca.ecommorce.dto.request.UpdateCartRequest;
import com.enoca.ecommorce.dto.response.getCartResponse;
import com.enoca.ecommorce.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("{cartId}")
    public getCartResponse getCart(@PathVariable Long cartId) {
        return cartService.getCart(cartId);
    }
    @PutMapping()
    public void updateCart(@RequestBody UpdateCartRequest request){
        cartService.updateCart(request);
    }

    @DeleteMapping("{cartId}/empty")
    public void emptyCart(@PathVariable Long cartId){
        cartService.emptyCart(cartId);
    }

    @PostMapping("{cartId}/{productId}")
    public void addProduct(@PathVariable Long cartId, @PathVariable Long productId){
        cartService.addProduct(cartId, productId);
    }

    @DeleteMapping("{cartId}/{productId}")
    public void removeProduct(@PathVariable Long cartId, @PathVariable Long productId){
        cartService.removeProduct(cartId, productId);
    }

}
