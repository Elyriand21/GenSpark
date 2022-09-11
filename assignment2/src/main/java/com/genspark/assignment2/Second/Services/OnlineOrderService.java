package com.genspark.assignment2.Second.Services;

import com.genspark.assignment2.Second.Entities.OnlineOrder;

import java.util.List;

public interface OnlineOrderService {

    List<OnlineOrder> getAllOrders();
    OnlineOrder getOrderById(int orderId);
    OnlineOrder addOrder(OnlineOrder order);
    OnlineOrder updateOrder(OnlineOrder order);
    String deleteOrderById(int id);
}
