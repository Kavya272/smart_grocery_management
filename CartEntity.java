//package com.smart_grocery.smart_grocery_api.entities;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "cart")
//public class CartEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    // Default Constructor
//    public CartEntity() {
//    }
//
//    // Parameterized Constructor
//    public CartEntity(Long id) {
//        this.id = id;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//}


package com.smart_grocery.smart_grocery_api.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToMany
    @JoinTable(
        name = "cart_grocery",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "grocery_id")
    )
    private List<GroceryEntity> groceries;

    public CartEntity() {}

    public CartEntity(UserEntity user, List<GroceryEntity> groceries) {
        this.user = user;
        this.groceries = groceries;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }

    public List<GroceryEntity> getGroceries() { return groceries; }
    public void setGroceries(List<GroceryEntity> groceries) { this.groceries = groceries; }
}
