////package com.smart_grocery.smart_grocery_api.services;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.data.domain.*;
////import org.springframework.stereotype.Service;
////import com.smart_grocery.smart_grocery_api.entities.GroceryEntity;
////import com.smart_grocery.smart_grocery_api.repository.GroceryRepository;
////
////
////import java.util.List;
////import java.util.Optional;
////
////@Service
////public class GroceryService {
////
////    @Autowired
////    private GroceryRepository groceryRepository;
////
////    // ✅ Create a new grocery item with price validation
////    public GroceryEntity addGrocery(GroceryEntity grocery) {
////        validatePrice(grocery.getPrice());
////        return groceryRepository.save(grocery);
////    }
////
////    // ✅ Get all groceries with pagination and sorting
////    public Page<GroceryEntity> getAllGroceries(int page, int size, String sortBy, String direction) {
////        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
////        Pageable pageable = PageRequest.of(page, size, sort);
////        return groceryRepository.findAll(pageable);
////    }
////
////    // ✅ Get a grocery by ID
////    public Optional<GroceryEntity> getGroceryById(Long id) {
////        return groceryRepository.findById(id);
////    }
////
////    // ✅ Get groceries by name (case-insensitive)
////    public List<GroceryEntity> getGroceriesByName(String name) {
////        return groceryRepository.findByNameContainingIgnoreCase(name);
////    }
////
////    // ✅ Get recently added groceries (sorted by ID in descending order)
////    public List<GroceryEntity> getRecentGroceries() {
////        return groceryRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
////    }
////
////    // ✅ Update a grocery item with price validation
////    public GroceryEntity updateGrocery(Long id, GroceryEntity updatedGrocery) {
////        return groceryRepository.findById(id).map(existingGrocery -> {
////            existingGrocery.setName(updatedGrocery.getName());
////            existingGrocery.setCount(updatedGrocery.getCount());
////
////            // Validate price before updating
////            validatePrice(updatedGrocery.getPrice());
////            existingGrocery.setPrice(updatedGrocery.getPrice());
////
////            existingGrocery.setQuantity(updatedGrocery.getQuantity());
////            return groceryRepository.save(existingGrocery);
////        }).orElse(null);
////    }
////
////    // ✅ Delete a grocery item by ID
////    public boolean deleteGrocery(Long id) {
////        if (groceryRepository.existsById(id)) {
////            groceryRepository.deleteById(id);
////            return true;
////        }
////        return false;
////    }
////
////    // ✅ Helper method to validate price range
////    private void validatePrice(double price) {
////        if (price < 10 || price > 100) {
////            throw new IllegalArgumentException("Price must be between 10 and 100");
////        }
////    }
////
////
////}
////
//
//
//package com.smart_grocery.smart_grocery_api.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.*;
//import org.springframework.stereotype.Service;
//import com.smart_grocery.smart_grocery_api.entities.GroceryEntity;
//import com.smart_grocery.smart_grocery_api.repository.GroceryRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class GroceryService {
//
//    @Autowired
//    private GroceryRepository groceryRepository;
//
//    public GroceryEntity addGrocery(GroceryEntity grocery) {
//        validatePrice(grocery.getPrice());
//        return groceryRepository.save(grocery);
//    }
//
//    public Page<GroceryEntity> getAllGroceries(int page, int size, String sortBy, String direction) {
//        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
//        Pageable pageable = PageRequest.of(page, size, sort);
//        return groceryRepository.findAll(pageable);
//    }
//
//    public Optional<GroceryEntity> getGroceryById(Long id) {
//        return groceryRepository.findById(id);
//    }
//
//    public List<GroceryEntity> getGroceriesByPrice(double min, double max) {
//        return groceryRepository.findByPriceBetween(min, max);
//    }
//
//    public List<GroceryEntity> getRecentGroceries() {
//        return groceryRepository.findRecentGroceries();
//    }
//
//    public GroceryEntity updateGrocery(Long id, GroceryEntity updatedGrocery) {
//        return groceryRepository.findById(id).map(existingGrocery -> {
//            existingGrocery.setName(updatedGrocery.getName());
//            existingGrocery.setCount(updatedGrocery.getCount());
//            validatePrice(updatedGrocery.getPrice());
//            existingGrocery.setPrice(updatedGrocery.getPrice());
//            existingGrocery.setQuantity(updatedGrocery.getQuantity());
//            return groceryRepository.save(existingGrocery);
//        }).orElse(null);
//    }
//
//    public boolean deleteGrocery(Long id) {
//        if (groceryRepository.existsById(id)) {
//            groceryRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//
//    private void validatePrice(double price) {
//        if (price < 10 || price > 100) {
//            throw new IllegalArgumentException("Price must be between 10 and 100");
//        }
//    }
//}
//
//
