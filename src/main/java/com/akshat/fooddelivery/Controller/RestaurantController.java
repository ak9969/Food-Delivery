package com.akshat.fooddelivery.Controller;

import com.akshat.fooddelivery.model.FoodItems;
import com.akshat.fooddelivery.model.Restaurant;
import com.akshat.fooddelivery.repository.RestaurantRepository;
import com.akshat.fooddelivery.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {


    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        return new ResponseEntity<>(restaurantRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Restaurant> getRestaurantsById(@RequestBody Restaurant restaurant){
        restaurantRepository.save(restaurant);
        return new ResponseEntity<>(restaurant,HttpStatus.OK);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Restaurant> updateRestaurantsById(@PathVariable Long Id,
                                                            @RequestBody Restaurant restaurant){
        return new ResponseEntity<>(restaurantService.updateRestaurantsById(restaurant,Id),
                                                HttpStatus.CREATED);
    }

    @DeleteMapping("/{Id}")
    public void deleteRestaurantsById(@PathVariable Long Id){
        restaurantRepository.deleteById(Id);
    }


}
