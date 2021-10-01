package com.akshat.fooddelivery.services;

import com.akshat.fooddelivery.model.FoodItems;

public interface FoodService {
    FoodItems updateFoodItem(Long Id, FoodItems foodItems);
}
