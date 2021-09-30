package com.akshat.fooddelivery.Controller;

import com.akshat.fooddelivery.model.FoodItems;
import com.akshat.fooddelivery.model.Restaurant;
import com.akshat.fooddelivery.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/api/v1/food"})
public class FoodController {


    private final FoodItemRepository foodItemRepository;

    @Autowired
    public FoodController(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }


    @GetMapping({"/allFood","/AllFood","/Allfood"})
    public ResponseEntity<List<FoodItems>> getAllFoodItems(){
        return null;
    }
    @GetMapping({"/{Id}"})
    public ResponseEntity<FoodItems> foodItemById(@PathVariable("Id") Long Id){
        return null;
    }
    @PostMapping({""})
    public ResponseEntity<FoodItems> addFoodItem(@RequestBody FoodItems foodItems){
        return null;
    }
    @PutMapping({"/{Id}"})
    public ResponseEntity<FoodItems> updateFoodItem(@PathVariable("Id") Long Id){
        foodItemRepository.findById(Id);
        return null;
    }
    @DeleteMapping({"/{Id}"})
    public void deleteFoodItem(@PathVariable Long Id){
       foodItemRepository.deleteAllById(Collections.singleton(Id));

    }
    @GetMapping({"/{foodName}"})
    public ResponseEntity<List<Restaurant>> getRestaurant(@RequestParam("rating") Optional<Integer> rating,
                                                          @RequestParam("price") Optional<Integer> averagePrice,
                                                          @PathVariable String foodName){
        return null;
    }

}
