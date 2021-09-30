package com.akshat.fooddelivery.Controller;

import com.akshat.fooddelivery.model.FoodItems;
import com.akshat.fooddelivery.model.Restaurant;
import com.akshat.fooddelivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {


    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    @GetMapping("")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        return null;
    }

    @PostMapping("")
    public ResponseEntity<Restaurant> getRestaurantsById(@RequestBody Restaurant restaurant){
        return null;
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Restaurant> updateRestaurantsById(@PathVariable String Id){
        return null;
    }

    @DeleteMapping("/{Id}")
    public void deleteRestaurantsById(@PathVariable Long Id){
        restaurantRepository.deleteById(Id);
    }
    @PutMapping(value = "/updateItemPrice/{restaurant_id}/{item_id}/{price}")
    public ResponseEntity<FoodItems> updateItemPrice(@PathVariable("restaurant_id") int restaurantId,
                                                     @PathVariable("item_id") int itemId,
                                                     @PathVariable String price){
        return null;
    }
}
