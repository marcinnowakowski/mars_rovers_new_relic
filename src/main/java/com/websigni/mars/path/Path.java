package com.websigni.mars.path;

import java.util.List;
import java.util.ArrayList;

public class Path {

    final public List<Order> orders = new ArrayList<>();

    public Path addOrder(Order order) {
        orders.add(order);
        return this;
    }
}