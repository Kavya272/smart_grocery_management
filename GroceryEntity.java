////package com.smart_grocery.smart_grocery_api.entities;
////
////import jakarta.persistence.*;
////import jakarta.validation.constraints.*;
////
////@Entity
////@Table(name = "groceries")
////public class GroceryEntity {
////    
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long id;
////
////    @NotNull(message = "Name cannot be null")
////    private String name;
////
////    @Min(value = 1, message = "Count must be at least 1")
////    private int count;
////
////    @Min(value = 10, message = "Price must be at least 10")
////    private double price;
////
////    @Min(value = 1, message = "Quantity must be at least 1")
////    private int quantity;
////
////    // ✅ Default Constructor (Fixes the Instantiation Error)
////    public GroceryEntity() {}
////
////    // ✅ Parameterized Constructor
////    public GroceryEntity(String name, int count, double price, int quantity) {
////        this.name = name;
////        this.count = count;
////        this.price = price;
////        this.quantity = quantity;
////    }
////
////    // ✅ Getters and Setters (Required for JPA)
////    public Long getId() {
////        return id;
////    }
////
////    public void setId(Long id) {
////        this.id = id;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public int getCount() {
////        return count;
////    }
////
////    public void setCount(int count) {
////        this.count = count;
////    }
////
////    public double getPrice() {
////        return price;
////    }
////
////    public void setPrice(double price) {
////        this.price = price;
////    }
////
////    public int getQuantity() {
////        return quantity;
////    }
////
////    public void setQuantity(int quantity) {
////        this.quantity = quantity;
////    }
////}
//
//
//package com.smart_grocery.smart_grocery_api.entities;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
//
//@Entity
//@Table(name = "groceries")
//public class GroceryEntity {
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotNull(message = "Name cannot be null")
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Min(value = 1, message = "Count must be at least 1")
//    @Column(name = "count")
//    private int count;
//
//    @Min(value = 10, message = "Price must be at least 10")
//    @Column(name = "price")
//    private double price;
//
//    @Min(value = 1, message = "Quantity must be at least 1")
//    @Column(name = "quantity")
//    private int quantity;
//
//    public GroceryEntity() {}
//
//    public GroceryEntity(String name, int count, double price, int quantity) {
//        this.name = name;
//        this.count = count;
//        this.price = price;
//        this.quantity = quantity;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//}

//
//package com.smart_grocery.smart_grocery_api.entities;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "groceries")
//public class GroceryEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    private double price;
//    private int quantity;
//
//    @ManyToMany(mappedBy = "groceries")
//    private List<CartEntity> carts;
//
//    public GroceryEntity() {}
//
//    public GroceryEntity(String name, double price, int quantity) {
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//    }
//
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public double getPrice() { return price; }
//    public void setPrice(double price) { this.price = price; }
//
//    public int getQuantity() { return quantity; }
//    public void setQuantity(int quantity) { this.quantity = quantity; }
//
//    public List<CartEntity> getCarts() { return carts; }
//    public void setCarts(List<CartEntity> carts) { this.carts = carts; }
//}


//package com.smart_grocery.smart_grocery_api.entities;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//public class GroceryEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private double price;
//
//    @ManyToMany(mappedBy = "groceryItems")
//    private List<OrderEntity> orders;
//
//    // Getters and Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public double getPrice() { return price; }
//    public void setPrice(double price) { this.price = price; }
//
//    public List<OrderEntity> getOrders() { return orders; }
//    public void setOrders(List<OrderEntity> orders) { this.orders = orders; }
//}


//package com.smart_grocery.smart_grocery_api.entities;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//public class GroceryEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private int quantity;  // ✅ Added quantity field
//    private double price;
//    private int categoryId; // ✅ Added categoryId field
//
//    @ManyToMany(mappedBy = "groceryItems")
//    private List<OrderEntity> orders;
//
//    // ✅ Default Constructor (JPA Requirement)
//    public GroceryEntity() {}
//
//    // ✅ Parameterized Constructor (Used in DataSeeder)
//    public GroceryEntity(String name, int quantity, double price, int categoryId) {
//        this.name = name;
//        this.quantity = quantity;
//        this.price = price;
//        this.categoryId = categoryId;
//    }
//
//    // Getters and Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public int getQuantity() { return quantity; }
//    public void setQuantity(int quantity) { this.quantity = quantity; }
//
//    public double getPrice() { return price; }
//    public void setPrice(double price) { this.price = price; }
//
//    public int getCategoryId() { return categoryId; }
//    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
//
//    public List<OrderEntity> getOrders() { return orders; }
//    public void setOrders(List<OrderEntity> orders) { this.orders = orders; }
//}


package com.smart_grocery.smart_grocery_api.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "groceries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroceryEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;
    private double price;
    private int rating;  // Example extra field

    public GroceryEntity(String name, int quantity, double price, int rating) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.rating = rating;
    }

	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
}
