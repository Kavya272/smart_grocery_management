package com.smart_grocery.smart_grocery_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.smart_grocery.smart_grocery_api.entities.OrderEntity;
import com.smart_grocery.smart_grocery_api.repository.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // ✅ Get all orders with pagination
    public Page<OrderEntity> getAllOrders(int page, int size) {
        return orderRepository.findAll(PageRequest.of(page, size));
    }

    // ✅ Get order by ID
    public Optional<OrderEntity> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // ✅ Create a new order
    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    // ✅ Update an existing order (only updating date)
    public Optional<OrderEntity> updateOrder(Long id, OrderEntity orderDetails) {
        return orderRepository.findById(id).map(order -> {
            order.setDate(orderDetails.getDate()); // Only updating date
            return orderRepository.save(order);
        });
    }

    // ✅ Delete an order
    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

