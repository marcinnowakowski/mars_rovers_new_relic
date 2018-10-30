package com.websigni.mars;

import org.junit.Test;

import com.websigni.mars.plane.Plane;
import com.websigni.mars.rover.Rover;
import com.websigni.mars.rover.Direction;
import com.websigni.mars.path.Path;
import com.websigni.mars.path.Order;
import com.websigni.mars.path.OrderType;

public class MissionOne {

    @Test
    public void sendTwoRoversToMars(){

        // define plane surface
        Plane p = new Plane(5, 5);

        // define first rover
        p.addRover(new Rover(1, 2, Direction.NORTH)
            .setPath(new Path()
                .addOrder(new Order(OrderType.LEFT))
                .addOrder(new Order(OrderType.MOVE))
                .addOrder(new Order(OrderType.LEFT))
                .addOrder(new Order(OrderType.MOVE))
                .addOrder(new Order(OrderType.LEFT))
                .addOrder(new Order(OrderType.MOVE))
                .addOrder(new Order(OrderType.LEFT))
                .addOrder(new Order(OrderType.MOVE))
                .addOrder(new Order(OrderType.MOVE))
            )
        );

        // define first rover
        p.addRover(new Rover(3, 3, Direction.EAST)
            .setPath(new Path()
                .addOrder(new Order(OrderType.MOVE))
                .addOrder(new Order(OrderType.MOVE))
                .addOrder(new Order(OrderType.RIGHT))
                .addOrder(new Order(OrderType.MOVE))
                .addOrder(new Order(OrderType.MOVE))
                .addOrder(new Order(OrderType.RIGHT))
                .addOrder(new Order(OrderType.MOVE))
                .addOrder(new Order(OrderType.RIGHT))
                .addOrder(new Order(OrderType.RIGHT))
                .addOrder(new Order(OrderType.MOVE))
            )
        );

        p.launch();

    }
    
}