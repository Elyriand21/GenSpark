package com.genspark.assignment2.Second.Entities;

import javax.persistence.*;

@Entity
@Table(name="tbl_orders")
public class OnlineOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(nullable = false)
    private String customerName;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String address;

    public OnlineOrder() {
    }

    public OnlineOrder(String customerName, String date, String address) {
        this.customerName = customerName;
        this.date = date;
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
