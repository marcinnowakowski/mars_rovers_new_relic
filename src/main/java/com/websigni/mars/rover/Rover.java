package com.websigni.mars.rover;

import com.websigni.mars.path.Path;

public class Rover {

    final public int x;
    final public int y;
    final public Direction direction;
    
    private Path path;

    public Rover(int aX, int aY, Direction aDirection) {
        x = aX;
        y = aY;
        direction = aDirection;
    }

    public Rover setPath(Path aPath) {
        path = aPath;
        return this;
    }

    
}