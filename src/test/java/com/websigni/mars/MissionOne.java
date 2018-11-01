package com.websigni.mars;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

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

        Plane missionResult = p.launch();
        Rover r1 = missionResult.rovers.get(0);
        Rover r2 = missionResult.rovers.get(1);

        assertThat(r1.position.x).isEqualTo(1);
        assertThat(r1.position.y).isEqualTo(3);
        assertThat(r1.position.direction).isEqualTo(Direction.NORTH);

        assertThat(r2.position.x).isEqualTo(5);
        assertThat(r2.position.y).isEqualTo(1);
        assertThat(r2.position.direction).isEqualTo(Direction.EAST);

    }
    
}