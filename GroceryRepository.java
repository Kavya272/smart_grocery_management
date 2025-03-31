//package com.smart_grocery.smart_grocery_api.repository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.smart_grocery.smart_grocery_api.entities.GroceryEntity;
//import java.util.List;
//import java.util.Optional;
//
//public interface GroceryRepository extends JpaRepository<GroceryEntity, Long> {
//
//    //  Find by ID
//    Optional<GroceryEntity> findById(Long id);
//
//    // Find by Name
//    List<GroceryEntity> findByNameContainingIgnoreCase(String name);
//
//    //  Get paginated and sorted groceries
//    Page<GroceryEntity> findAll(Pageable pageable);
//
//    //  Get recent groceries sorted by ID
//    @Query("SELECT g FROM GroceryEntity g ORDER BY g.id DESC")
//    List<GroceryEntity> findRecentGroceries();
//
//    // Get groceries with price between 10 and 100
//    @Query("SELECT g FROM GroceryEntity g WHERE g.price BETWEEN 10 AND 100")
//    List<GroceryEntity> findGroceriesWithinPriceRange();
//
//    @Query("SELECT g FROM Grocery g WHERE g.price BETWEEN :min AND :max")
//	static
//    List<GroceryEntity> findByPriceBetween(@Param("min") double min, @Param("max") double max) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
//


//package com.smart_grocery.smart_grocery_api.repository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.smart_grocery.smart_grocery_api.entities.GroceryEntity;
//import java.util.List;
//import java.util.Optional;
//
//public interface GroceryRepository extends JpaRepository<GroceryEntity, Long> {
//
//    Optional<GroceryEntity> findById(Long id);
//
//    List<GroceryEntity> findByNameContainingIgnoreCase(String name);
//
//    Page<GroceryEntity> findAll(Pageable pageable);
//
//    @Query("SELECT g FROM GroceryEntity g ORDER BY g.id DESC")
//    List<GroceryEntity> findRecentGroceries();
//
//    @Query("SELECT g FROM GroceryEntity g WHERE g.price BETWEEN :min AND :max")
//    List<GroceryEntity> findByPriceBetween(@Param("min") double min, @Param("max") double max);
//}

//package com.smart_grocery.smart_grocery_api.repository;
//
//import com.smart_grocery.smart_grocery_api.entities.GroceryEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import java.util.List;
//
//public interface GroceryRepository extends JpaRepository<GroceryEntity, Long> {
//    @Query("SELECT g FROM GroceryEntity g WHERE g.price > :price")
//    List<GroceryEntity> findExpensiveGroceries(@Param("price") double price);
//}


//package com.smart_grocery.smart_grocery_api.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import com.smart_grocery.smart_grocery_api.entities.GroceryEntity;
//
//public interface GroceryRepository extends JpaRepository<GroceryEntity, Long> {
//}
//

package com.smart_grocery.smart_grocery_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smart_grocery.smart_grocery_api.entities.GroceryEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends JpaRepository<GroceryEntity, Long> {
}
