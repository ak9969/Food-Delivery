package com.akshat.fooddelivery.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
    @Id()
    private int restaurantId;

    @NotBlank
    private String restaurantName;

    @NotNull
    private int rating;

    @NotNull
    private double maxPrice;

    private int locationId;
}
