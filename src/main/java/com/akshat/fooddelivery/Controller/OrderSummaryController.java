package com.akshat.fooddelivery.Controller;

import com.akshat.fooddelivery.model.OrderItemSummary;
import com.akshat.fooddelivery.model.OrderSummary;
import com.akshat.fooddelivery.repository.OrderRepository;
import com.akshat.fooddelivery.services.OrderSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/order")
public class OrderSummaryController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderSummaryService orderSummaryService;

    @GetMapping("/")
    public ResponseEntity<List<OrderSummary>> getAllOrder(){
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{Id}")
    public ResponseEntity<OrderSummary> getOrderById(@PathVariable Long Id){
        Optional<OrderSummary> orderSummary =  orderRepository.findById(Id);
        return orderSummary.map(summary -> new ResponseEntity<>(summary, HttpStatus.OK)).orElse(null);
    }
    @PostMapping("")
    public ResponseEntity<OrderSummary> postOrderById(@RequestBody OrderSummary orderSummary){
        return new ResponseEntity<>(orderRepository.save(orderSummary),HttpStatus.CREATED);
    }
    @PutMapping("/{Id}/{OrderId}")
    public ResponseEntity<OrderSummary> updateOrderById(@PathVariable Long Id,
                                                        @PathVariable Long OrderId,
                                                        @RequestBody OrderItemSummary orderItemSummary){
        return new ResponseEntity<>(orderSummaryService.updateOrderSummary(Id,OrderId,orderItemSummary),
                                            HttpStatus.CREATED);
    }
    @DeleteMapping("/{Id}")
    public void deleteOrderById(@PathVariable Long Id){
        orderRepository.deleteById(Id);
    }

}
