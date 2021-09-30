package com.akshat.fooddelivery.repository;

import com.akshat.fooddelivery.model.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItems,Long> {
}
