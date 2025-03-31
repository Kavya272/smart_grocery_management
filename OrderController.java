package com.smart_grocery.smart_grocery_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.smart_grocery.smart_grocery_api.entities.OrderEntity;
import com.smart_grocery.smart_grocery_api.services.OrderService;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // ✅ Get all orders with pagination
    @GetMapping
    public Page<OrderEntity> getAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return orderService.getAllOrders(page, size);
    }

    // ✅ Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable Long id) {
        Optional<OrderEntity> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Create a new order (POST)
    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order) {
        OrderEntity savedOrder = orderService.createOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    // ✅ Update an existing order (PUT - only updating date)
    @PutMapping("/{id}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long id, @RequestBody OrderEntity orderDetails) {
        Optional<OrderEntity> updatedOrder = orderService.updateOrder(id, orderDetails);
        return updatedOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGrocery(@PathVariable Long id) {
        if (orderService.deleteOrder(id)) {
            return ResponseEntity.ok("Data deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Order not found");
        }
    }
}

