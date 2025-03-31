////package com.smart_grocery.smart_grocery_api.controllers;
////
////import com.smart_grocery.smart_grocery_api.entities.GroceryEntity;
////import com.smart_grocery.smart_grocery_api.services.GroceryService;
////import org.springframework.data.domain.Page;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////import com.smart_grocery.smart_grocery_api.repository.GroceryRepository;
////import java.util.List;
////import java.util.Optional;
////
////@RestController
////@RequestMapping("/groceries")
////public class GroceryController {
////
////    private final GroceryService groceryService;
////
////    public GroceryController(GroceryService groceryService) {
////        this.groceryService = groceryService;
////    }
////
////    @GetMapping
////    public ResponseEntity<Page<GroceryEntity>> getAllGroceries(
////            @RequestParam(defaultValue = "0") int page,
////            @RequestParam(defaultValue = "5") int size,
////            @RequestParam(defaultValue = "name") String sortBy,
////            @RequestParam(defaultValue = "asc") String direction) {
////        return ResponseEntity.ok(groceryService.getAllGroceries(page, size, sortBy, direction));
////    }
////
////    @GetMapping("/{id}")
////    public ResponseEntity<GroceryEntity> getGroceryById(@PathVariable Long id) {
////        Optional<GroceryEntity> grocery = groceryService.getGroceryById(id);
////        return grocery.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
////    }
////
////    @GetMapping("/groceries/by-price")
////    public List<GroceryEntity> getGroceriesByPrice(
////            @RequestParam double min,
////            @RequestParam double max) {
////        return GroceryRepository.findByPriceBetween(min, max);
////    }
////
////    @GetMapping("/recent")
////    public ResponseEntity<List<GroceryEntity>> getRecentGroceries() {
////        return ResponseEntity.ok(groceryService.getRecentGroceries());
////    }
////
////    @PostMapping
////    public ResponseEntity<?> addGrocery(@RequestBody GroceryEntity grocery) {
////        if (grocery.getPrice() < 10 || grocery.getPrice() > 100) {
////            return ResponseEntity.badRequest().body("Price must be between 10 and 100");
////        }
////        return ResponseEntity.ok(groceryService.addGrocery(grocery));
////    }
////
////    @PutMapping("/{id}")
////    public ResponseEntity<?> updateGrocery(@PathVariable Long id, @RequestBody GroceryEntity updatedGrocery) {
////        if (updatedGrocery.getPrice() < 10 || updatedGrocery.getPrice() > 100) {
////            return ResponseEntity.badRequest().body("Price must be between 10 and 100");
////        }
////        GroceryEntity updated = groceryService.updateGrocery(id, updatedGrocery);
////        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
////    }
////
////    @DeleteMapping("/{id}")
////    public ResponseEntity<String> deleteGrocery(@PathVariable Long id) {
////        if (groceryService.deleteGrocery(id)) {
////            return ResponseEntity.ok("Data deleted successfully");
////        } else {
////            return ResponseEntity.status(404).body("Grocery not found");
////        }
////    }
////}
//// 
//
//package com.smart_grocery.smart_grocery_api.controllers;
//
//import com.smart_grocery.smart_grocery_api.entities.GroceryEntity;
//import com.smart_grocery.smart_grocery_api.services.GroceryService;
//import org.springframework.data.domain.Page;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/groceries")
//@CrossOrigin("*")  // Enables CORS for all origins
//public class GroceryController {
//
//    private final GroceryService groceryService;
//
//    public GroceryController(GroceryService groceryService) {
//        this.groceryService = groceryService;
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<GroceryEntity>> getAllGroceries(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "5") int size,
//            @RequestParam(defaultValue = "name") String sortBy,
//            @RequestParam(defaultValue = "asc") String direction) {
//        return ResponseEntity.ok(groceryService.getAllGroceries(page, size, sortBy, direction));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<GroceryEntity> getGroceryById(@PathVariable Long id) {
//        Optional<GroceryEntity> grocery = groceryService.getGroceryById(id);
//        return grocery.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping("/by-price")
//    public ResponseEntity<List<GroceryEntity>> getGroceriesByPrice(
//            @RequestParam double min,
//            @RequestParam double max) {
//        return ResponseEntity.ok(groceryService.getGroceriesByPrice(min, max));
//    }
//
//    @GetMapping("/recent")
//    public ResponseEntity<List<GroceryEntity>> getRecentGroceries() {
//        return ResponseEntity.ok(groceryService.getRecentGroceries());
//    }
//
//    @PostMapping
//    public ResponseEntity<?> addGrocery(@RequestBody GroceryEntity grocery) {
//        if (grocery.getPrice() < 10 || grocery.getPrice() > 100) {
//            return ResponseEntity.badRequest().body("Price must be between 10 and 100");
//        }
//        return ResponseEntity.ok(groceryService.addGrocery(grocery));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateGrocery(@PathVariable Long id, @RequestBody GroceryEntity updatedGrocery) {
//        if (updatedGrocery.getPrice() < 10 || updatedGrocery.getPrice() > 100) {
//            return ResponseEntity.badRequest().body("Price must be between 10 and 100");
//        }
//        GroceryEntity updated = groceryService.updateGrocery(id, updatedGrocery);
//        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteGrocery(@PathVariable Long id) {
//        if (groceryService.deleteGrocery(id)) {
//            return ResponseEntity.ok("Data deleted successfully");
//        } else {
//            return ResponseEntity.status(404).body("Grocery not found");
//        }
//    }
//}
