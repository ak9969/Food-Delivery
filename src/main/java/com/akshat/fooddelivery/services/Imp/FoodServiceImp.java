package com.akshat.fooddelivery.services.Imp;

import com.akshat.fooddelivery.model.FoodItems;
import com.akshat.fooddelivery.repository.FoodItemRepository;
import com.akshat.fooddelivery.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodServiceImp implements FoodService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Override
    public FoodItems updateFoodItem(Long Id, FoodItems foodItems){
        Optional<FoodItems> currentFoodItem = foodItemRepository.findById(Id);
        FoodItems getFoodItem = null;
        if(currentFoodItem.isPresent()){
            getFoodItem = currentFoodItem.get();
            getFoodItem.setItemId(foodItems.getItemId());
            getFoodItem.setItemPrice(foodItems.getItemPrice());
            getFoodItem.setRestaurantId(foodItems.getRestaurantId());
            getFoodItem.setRestaurantName(foodItems.getRestaurantName());
        }
        return getFoodItem;
    }


}
