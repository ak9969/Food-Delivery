package com.akshat.fooddelivery.Controller;

import com.akshat.fooddelivery.model.OrderItemSummary;
import com.akshat.fooddelivery.model.OrderSummary;
import com.akshat.fooddelivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderSummaryController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderSummaryController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<OrderSummary>> getAllOrder(){
        return null;
    }
    @GetMapping("/{Id}")
    public ResponseEntity<OrderSummary> getOrderById(@PathVariable Long Id){
        return null;
    }
    @PostMapping("")
    public ResponseEntity<OrderSummary> postOrderById(@RequestBody OrderSummary orderSummary){
        return null;
    }
    @PutMapping("/{Id}/{OrderId}")
    public ResponseEntity<OrderSummary> updateOrderById(@PathVariable Long Id, @PathVariable Long OrderId, @RequestBody OrderItemSummary orderItemSummary){
        return null;
    }
    @DeleteMapping("/{Id}")
    public void deleteOrderById(@PathVariable Long Id){
        orderRepository.deleteById(Id);
    }

}
