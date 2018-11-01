package com.websigni.mars.rover;

public class Position {

    final public int x;
    final public int y;
    final public Direction direction;

    public Position(int ax, int ay, Direction d) {
        x = ax;
        y = ay;
        direction = d;
    }

    private Position perform(Order o) {

        switch(o.ot) {
            case OrderType.LEFT:
                return new Position(this.x, this.y, this.direction.left);
            case OrderType.RIGHT:
                return new Position(this.x, this.y, this.direction.left);
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