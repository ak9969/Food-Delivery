package com.akshat.fooddelivery.services;

import com.akshat.fooddelivery.model.FoodItems;
import com.akshat.fooddelivery.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findByLocation(int locationId);

    List<Restaurant> findByLocationAndPrice(int locationId,double price);

    List<Restaurant> findByLocationAndRating(int locationId,double rating);

    List<Restaurant> findByLocationAndPriceAndRating(int locationId,double price, double rating);

    Restaurant updateRestaurantsById(Restaurant restaurant,Long id);


}
