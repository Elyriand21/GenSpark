package com.genspark.assignment2.Second.Services;

import com.genspark.assignment2.Second.Entities.OnlineOrder;
import com.genspark.assignment2.Second.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OnlineOrderServiceImplementation implements OnlineOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OnlineOrder> getAllOrders() {
        return Streamable.of(this.orderRepository.findAll()).toList();
    }

    @Override
    public OnlineOrder getOrderById(int id) {
        Optional<OnlineOrder> order = this.orderRepository.findById(id);
        OnlineOrder temp = null;

        if(order.isPresent()){
            temp = order.get();
        }
        else{
            throw new RuntimeException("Student by the ID of " + id + " cannot be found.");
        }
        return temp;
    }

    @Override
    public OnlineOrder addOrder(OnlineOrder order) {
        return this.orderRepository.save(order);
    }

    @Override
    public OnlineOrder updateOrder(OnlineOrder order) {

        return this.orderRepository.save(order);
    }

    @Override
    public String deleteOrderById(int id) {

        this.orderRepository.deleteById(id);
        return "Order by the ID of " + id + " has been successfully deleted...";
    }
}
