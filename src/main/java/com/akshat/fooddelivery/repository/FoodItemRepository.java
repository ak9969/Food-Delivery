package com.akshat.fooddelivery.repository;

import com.akshat.fooddelivery.model.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodItemRepository extends JpaRepository<FoodItems,Long> {
    List<FoodItems> findByRestaurantId(Long restaurantId);

    Optional<FoodItems> findByItemIdAndRestaurantId(int itemId, Long restaurantId);
}
