package com.websigni.mars;

public class MissionOne {

    public static void main(String[] args){

        // define plane surface
        Plane p = new Plane(5, 5);

        // define first rower
        p.addRower(
            new Rower(1, 2, Direction.NORTH)
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
            )
        );

        // define first rower
        p.addRower(
            new Rower(3, 3, Direction.EAST)
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
            )
        );

        p.launch();

    }
    
}

LM LM LM LM M 3 3 E MMR MMR MRRM