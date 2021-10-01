package com.akshat.fooddelivery.repository;

import com.akshat.fooddelivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    List<Restaurant> findByLocationId(int locationId);

    List<Restaurant> findByLocationIdAndAvgPrice(int locationId,double price);

    List<Restaurant> findByLocationIdAndRating(int locationId,double rating);

    List<Restaurant> findByLocationIdAndAvgPriceAndRating(int locationId, double price, double rating);
}
