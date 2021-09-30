package com.akshat.fooddelivery.repository;

import com.akshat.fooddelivery.model.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderSummary,Long> {
}
