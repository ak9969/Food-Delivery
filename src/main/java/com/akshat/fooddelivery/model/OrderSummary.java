package com.akshat.fooddelivery.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSummary implements Serializable {
    @Id
    @GeneratedValue
    private int Id;
    private int userId;

    private int restaurantId;

    private String restaurantName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<OrderItemSummary> orderItemList;

}
