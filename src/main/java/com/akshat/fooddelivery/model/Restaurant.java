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
    @Id
    private Long restaurantId;

    @NotBlank
    private String restaurantName;

    @NotNull
    private double rating;

    @NotNull
    private double avgPrice;

    private int locationId;
}
