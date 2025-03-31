package com.smart_grocery.smart_grocery_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.smart_grocery.smart_grocery_api.entities.CartEntity;
import com.smart_grocery.smart_grocery_api.repository.CartRepository;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // Get all carts with pagination
    public Page<CartEntity> getAllCarts(int page, int size) {
        return cartRepository.findAll(PageRequest.of(page, size));
    }

    // Get cart by ID
    public Optional<CartEntity> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    // Create cart
    public CartEntity createCart(CartEntity cart) {
        return cartRepository.save(cart);
    }

    // Delete cart
    public boolean deleteCart(Long id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
