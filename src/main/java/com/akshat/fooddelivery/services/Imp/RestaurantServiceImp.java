package com.akshat.fooddelivery.services.Imp;

import com.akshat.fooddelivery.model.FoodItems;
import com.akshat.fooddelivery.model.Restaurant;
import com.akshat.fooddelivery.repository.FoodItemRepository;
import com.akshat.fooddelivery.repository.RestaurantRepository;
import com.akshat.fooddelivery.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImp implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Override
    public List<Restaurant> findByLocation(int locationId) {
        return restaurantRepository.findByLocationId(locationId);
    }

    @Override
    public List<Restaurant> findByLocationAndPrice(int locationId, double price) {
        return restaurantRepository.findByLocationIdAndAvgPrice(locationId,price);
    }

    @Override
    public List<Restaurant> findByLocationAndRating(int locationId, double rating) {
        return restaurantRepository.findByLocationIdAndRating(locationId,rating);
    }

    @Override
    public List<Restaurant> findByLocationAndPriceAndRating(int locationId, double price, double rating) {
        return restaurantRepository.findByLocationIdAndAvgPriceAndRating(locationId,price,rating);
    }

    @Override
    public Restaurant updateRestaurantsById(Restaurant restaurant, Long id) {
        Optional<Restaurant> currentRestaurant = restaurantRepository.findById(id);
        Restaurant updatedRestaurant = null;
        if(currentRestaurant.isPresent()){
            updatedRestaurant = currentRestaurant.get();
            updatedRestaurant.setRestaurantId(restaurant.getRestaurantId());
            updatedRestaurant.setRestaurantName(restaurant.getRestaurantName());
            updatedRestaurant.setAvgPrice(restaurant.getAvgPrice());
            updatedRestaurant.setRating(restaurant.getRating());
            updatedRestaurant.setLocationId(restaurant.getLocationId());
        }
        return updatedRestaurant;
    }

    @Override
    public List<FoodItems> findItemByRestaurantId(Long restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }


    @Override
    public FoodItems updateItemPriceByRestaurantId(Long restaurantId, int itemId, double itemPrice) {
        Optional<FoodItems> foodItems = foodItemRepository.findByIdAndRestaurantId(itemId,restaurantId);
        if(foodItems.isPresent()){
            FoodItems foodItemObj = foodItems.get();
            foodItemObj.setItemPrice(itemPrice);
            return foodItemRepository.save(foodItemObj);
        }
        return null;
    }
}
