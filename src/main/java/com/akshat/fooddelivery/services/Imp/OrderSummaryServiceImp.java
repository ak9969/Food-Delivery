package com.akshat.fooddelivery.services.Imp;

import com.akshat.fooddelivery.model.OrderItemSummary;
import com.akshat.fooddelivery.model.OrderSummary;
import com.akshat.fooddelivery.repository.OrderRepository;
import com.akshat.fooddelivery.services.OrderSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderSummaryServiceImp implements OrderSummaryService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderSummary updateOrderSummary(Long id, Long OrderId, OrderItemSummary orderItemSummary) {
        Optional<OrderSummary> currentOrderSummary = orderRepository.findById(id);
        OrderSummary getOrderSummary = null;
        if(currentOrderSummary.isPresent()){
            getOrderSummary = currentOrderSummary.get();
            List<OrderItemSummary> getAllOrderItemSummaries = getOrderSummary.getOrderItemList();
            OrderItemSummary currentItem = (OrderItemSummary) getOrderSummary.getOrderItemList().stream()
                    .filter(p->p.getOrderId()==OrderId);
            getAllOrderItemSummaries.remove(currentItem);
            currentItem.setItemPrice(orderItemSummary.getItemPrice());
            currentItem.setOrderId(orderItemSummary.getOrderId());
            currentItem.setItemName(orderItemSummary.getItemName());
            currentItem.setDiscount(orderItemSummary.getDiscount());
            currentItem.setQuantity(orderItemSummary.getQuantity());
            getAllOrderItemSummaries.add(orderItemSummary);
        }
        return getOrderSummary;
    }
}
