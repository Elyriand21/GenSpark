package com.genspark.assignment2.Second.Controller;

import com.genspark.assignment2.Second.Entities.OnlineOrder;
import com.genspark.assignment2.Second.Services.OnlineOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private OnlineOrderService onlineOrderService;

    @GetMapping("/")
    public String homePage(){
        return "<HTML><H1>Welcome to the Online Order Access Homepage</H1></HTML>";
    }

    @GetMapping("/orders")
    public List<OnlineOrder> getOrders(){
        return this.onlineOrderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public OnlineOrder getOrderById(@PathVariable int id) {
        return this.onlineOrderService.getOrderById(id);
    }
    @PostMapping("/orders")
    public OnlineOrder addOrder(@RequestBody OnlineOrder order){
        return this.onlineOrderService.addOrder(order);
    }

    @PutMapping("/orders")
    public OnlineOrder updateOrder(@RequestBody OnlineOrder order){
        return this.onlineOrderService.updateOrder(order);
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable int id){
        return this.onlineOrderService.deleteOrderById(id);
    }
}
