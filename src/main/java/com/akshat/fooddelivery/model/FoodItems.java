package com.akshat.fooddelivery.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodItems {
    @Id
    @NotNull
    private Long itemId;
    @NotNull
    private Long restaurantId;
    @NotBlank
    private String restaurantName;
    @NotNull
    private double itemPrice;
}
