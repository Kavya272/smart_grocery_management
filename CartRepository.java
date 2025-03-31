package com.smart_grocery.smart_grocery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smart_grocery.smart_grocery_api.entities.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
}
