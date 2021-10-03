package com.akshat.fooddelivery.Controller;

import com.akshat.fooddelivery.model.Location;
import com.akshat.fooddelivery.model.Restaurant;
import com.akshat.fooddelivery.repository.LocationRepository;
import com.akshat.fooddelivery.services.LocationService;
import com.akshat.fooddelivery.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationService locationService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocation(){
        return new ResponseEntity<>(locationRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{locationId}")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(@RequestParam("rating") Optional<Double> rating,
                                                              @RequestParam("price") Optional<Double> avePrice,
                                                              @PathVariable Integer locationId){
        if(rating.isPresent() && avePrice.isPresent()){
            return new ResponseEntity<>(
                    restaurantService.findByLocationAndPriceAndRating(locationId,avePrice.get(),rating.get()),
                    HttpStatus.OK);
        }
        else if(rating.isPresent()){
            return new ResponseEntity<>(
                    restaurantService.findByLocationAndRating(locationId,rating.get()),
                    HttpStatus.OK);
        }
        else if(avePrice.isPresent()){
            return new ResponseEntity<>(
                    restaurantService.findByLocationAndPrice(locationId,avePrice.get()),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(
                restaurantService.findByLocation(locationId),
                HttpStatus.OK);
    }
    @PostMapping({""})
    public ResponseEntity<Location> addLocation(@RequestBody Location location){
        locationRepository.save(location);
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<Location> updateLocation(@PathVariable Long id,@RequestBody Location location){
        return new ResponseEntity<>(locationService.updateLocation(id,location),HttpStatus.CREATED);
    }
}
