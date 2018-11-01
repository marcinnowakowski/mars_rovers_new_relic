package com.websigni.mars.rover;

public enum Direction {
    NORTH,
    EAST,
    SOUGHT,
    WEST;

    /**
     * Rover turns left
     * @return new direction
     */
    public Direction left() {
        switch(this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUGHT:
                return EAST;
            default:
                // WEST
                return SOUGHT;
        }
    }

     /**
     * Rover turns right
     * @return new direction
     */
    public Direction right() {
        switch(this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUGHT;
            case SOUGHT:
                return WEST;
            default:
                // WEST
                return NORTH;
        }
    }
}