package com.akshat.fooddelivery.Controller;

import com.akshat.fooddelivery.model.FoodItems;
import com.akshat.fooddelivery.model.Location;
import com.akshat.fooddelivery.model.Restaurant;
import com.akshat.fooddelivery.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocation(){
        return null;
    }
    @GetMapping("/{location}")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(@RequestParam("rating") Optional<Long> rating,
                                                              @RequestParam("price") Optional<Double> avePrice,
                                                              @PathVariable String location){
        return null;
    }
    @PostMapping({""})
    public ResponseEntity<Location> addLocation(@RequestBody FoodItems foodItems){
        return null;
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<Location> updateLocation(@PathVariable String id){
        return null;
    }
    @GetMapping({"/{id}"})
    public ResponseEntity<Location> getLocationById(@PathVariable String id){
        return null;
    }
}
