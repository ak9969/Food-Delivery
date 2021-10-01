package com.akshat.fooddelivery.Controller;

import com.akshat.fooddelivery.model.FoodItems;
import com.akshat.fooddelivery.model.Restaurant;
import com.akshat.fooddelivery.repository.FoodItemRepository;
import com.akshat.fooddelivery.services.FoodService;
import com.akshat.fooddelivery.services.Imp.FoodServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/api/v1/food"})
public class FoodController {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private FoodServiceImp foodServiceImp;


    @GetMapping({"/allFood","/AllFood",})
    public ResponseEntity<List<FoodItems>> getAllFoodItems(){
        return new ResponseEntity<>(foodItemRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping({"/{Id}"})
    public ResponseEntity<FoodItems> foodItemById(@PathVariable("Id") Long Id){
        Optional<FoodItems> foodItems = foodItemRepository.findById(Id);
        return foodItems.map(items -> new ResponseEntity<>(items, HttpStatus.OK)).orElse(null);
    }
    @PostMapping({""})
    public ResponseEntity<FoodItems> addFoodItem(@RequestBody FoodItems foodItems){
        foodItemRepository.save(foodItems);
        return new ResponseEntity<>(foodItems,HttpStatus.CREATED);
    }
    @PutMapping({"/{Id}"})
    public ResponseEntity<FoodItems> updateFoodItem(@PathVariable("Id") Long Id,
                                                    @RequestBody FoodItems foodItems){

        return new ResponseEntity<>(foodServiceImp.updateFoodItem(Id,foodItems),HttpStatus.CREATED);
    }
    @PutMapping(value = "/updateItemPrice/{item_id}/{restaurant_id}")
    public ResponseEntity<FoodItems> updateItemPrice(@PathVariable("restaurant_id") Long restaurantId,
                                                     @PathVariable("item_id") int itemId,
                                                     @RequestParam("price") double price){
        Optional<FoodItems> foodItems = foodItemRepository.findByItemIdAndRestaurantId(itemId,restaurantId);
        if(foodItems.isPresent()){
            FoodItems getFoodItem = foodItems.get();
            getFoodItem.setItemPrice(price);
            foodItemRepository.save(getFoodItem);
            return new ResponseEntity<>(getFoodItem,HttpStatus.CREATED);
        }
        return null;
    }
}
