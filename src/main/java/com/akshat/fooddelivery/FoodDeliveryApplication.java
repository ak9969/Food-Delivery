package com.akshat.fooddelivery;

import com.akshat.fooddelivery.services.FoodService;
import com.akshat.fooddelivery.services.Imp.FoodServiceImp;
import com.akshat.fooddelivery.services.Imp.LocationServiceImp;
import com.akshat.fooddelivery.services.Imp.RestaurantServiceImp;
import com.akshat.fooddelivery.services.LocationService;
import com.akshat.fooddelivery.services.RestaurantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoodDeliveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodDeliveryApplication.class, args);
    }
}
