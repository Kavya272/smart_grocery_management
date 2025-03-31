//package com.smart_grocery.smart_grocery_api.entities;
//
//import jakarta.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name = "orders") // Avoids conflict with SQL keyword "ORDER"
//public class OrderEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private LocalDate date; // Stores only DATE (without time)
//
//    // ✅ Default Constructor
//    public OrderEntity() {
//    }
//
//    // ✅ Parameterized Constructor
//    public OrderEntity(LocalDate date) {
//        this.date = date;
//    }
//
//    // ✅ Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }
//}
//


//package com.smart_grocery.smart_grocery_api.entities;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "orders")
//public class OrderEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private UserEntity user;
//
//    @OneToMany
//    @JoinColumn(name = "order_id")
//    private List<CartEntity> carts;
//
//    public OrderEntity() {}
//
//    public OrderEntity(UserEntity user, List<CartEntity> carts) {
//        this.user = user;
//        this.carts = carts;
//    }
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public UserEntity getUser() { return user; }
//    public void setUser(UserEntity user) { this.user = user; }
//
//    public List<CartEntity> getCarts() { return carts; }
//    public void setCarts(List<CartEntity> carts) { this.carts = carts; }
//}


package com.smart_grocery.smart_grocery_api.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;

    @ManyToMany
    @JoinTable(
        name = "order_grocery",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "grocery_id")
    )
    private List<GroceryEntity> groceryItems;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public List<GroceryEntity> getGroceryItems() { return groceryItems; }
    public void setGroceryItems(List<GroceryEntity> groceryItems) { this.groceryItems = groceryItems; }
	public Object getDate() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setDate(Object date) {
		// TODO Auto-generated method stub
		
	}
}
