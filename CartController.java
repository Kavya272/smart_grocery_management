package com.smart_grocery.smart_grocery_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.smart_grocery.smart_grocery_api.entities.CartEntity;
import com.smart_grocery.smart_grocery_api.services.CartService;

import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    // Get all carts with pagination
    @GetMapping
    public Page<CartEntity> getAllCarts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return cartService.getAllCarts(page, size);
    }

    // Get cart by ID
    @GetMapping("/{id}")
    public ResponseEntity<CartEntity> getCartById(@PathVariable Long id) {
        Optional<CartEntity> cart = cartService.getCartById(id);
        return cart.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create cart
    @PostMapping
    public ResponseEntity<CartEntity> createCart(@RequestBody CartEntity cart) {
        return ResponseEntity.ok(cartService.createCart(cart));
    }

    // Delete cart
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        return cartService.deleteCart(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
