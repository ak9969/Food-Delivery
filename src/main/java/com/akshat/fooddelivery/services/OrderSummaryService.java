package com.akshat.fooddelivery.services;

import com.akshat.fooddelivery.model.OrderItemSummary;
import com.akshat.fooddelivery.model.OrderSummary;

public interface OrderSummaryService {
    OrderSummary updateOrderSummary(Long id, Long OrderId, OrderItemSummary orderItemSummary);
}
