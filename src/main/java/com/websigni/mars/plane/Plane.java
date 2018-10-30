package com.websigni.mars.plane;

import java.util.List;
import java.util.ArrayList;

import com.websigni.mars.rover.Rover;

public class Plane {
    
    final public int x;
    final public int y;

    final public List<Rover> rovers = new ArrayList<>();

    public Plane(int aX, int aY) {
        x = aX;
        y = aY;
    }

    public Plane addRover(Rover rover) {
        rovers.add(rover);
        return this;
    }

    public void launch() {
        throw new UnsupportedOperationException();
    }
}