package com.websigni.mars.rover;

import com.websigni.mars.path.Order;
import static com.websigni.mars.path.OrderType.LEFT;
import static com.websigni.mars.path.OrderType.RIGHT;

public class Position {

    final public int x;
    final public int y;
    final public Direction direction;

    public Position(int ax, int ay, Direction d) {
        x = ax;
        y = ay;
        direction = d;
    }

    public Position perform(Order o) {

        switch(o.ot) {
            case LEFT:
                return new Position(this.x, this.y, this.direction.left());
            case RIGHT:
                return new Position(this.x, this.y, this.direction.right());
            default:
                return move();
        }

    }

    private Position move() {

        switch(this.direction) {
            case NORTH:
                return new Position(this.x, this.y + 1, this.direction);
            case EAST:
                return new Position(this.x + 1, this.y, this.direction);
            case SOUGHT:
                return new Position(this.x, this.y - 1, this.direction);
            default:
                // WEST
                return new Position(this.x - 1, this.y, this.direction);
        }

    }
}