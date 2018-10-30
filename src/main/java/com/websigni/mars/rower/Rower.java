package com.websigni.mars.rower;

public class Rower {

    final public int x;
    final public int y;
    final public Direction direction;
    
    private Path path;

    public Rower(int aX, int aY, Direction d, Path p) {
        x = aX;
        y = aY;
        direction = d;
        path = p;
    }

    
}