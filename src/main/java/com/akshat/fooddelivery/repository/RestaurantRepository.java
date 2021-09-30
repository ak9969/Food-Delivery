package com.akshat.fooddelivery.repository;

import com.akshat.fooddelivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
