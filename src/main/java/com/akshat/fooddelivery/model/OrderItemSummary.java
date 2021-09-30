package com.akshat.fooddelivery.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemSummary {

    @Id
    @GeneratedValue
    private int itemSummaryId;

    @NotBlank
    private int itemId;

    @NotBlank
    private String itemName;

    @NotNull
    private double itemPrice;

    @NotNull
    private float discount;

    @NotNull
    @Column(name = "order_id")
    private int orderId;
}