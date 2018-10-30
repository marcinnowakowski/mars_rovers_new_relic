package com.websigni.mars.path;

public class Path {

    final public List<Order> orders = new ArrayList<>();

    public Path addOrder(Order order) {
        orders.add(order);
        return this;
    }
}