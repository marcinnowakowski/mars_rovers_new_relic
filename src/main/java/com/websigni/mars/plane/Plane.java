package com.websigni.mars.plane;

import java.util.List;
import java.util.ArrayList;

import com.websigni.mars.rover.Rover;
import com.websigni.mars.rover.Position;

import static com.websigni.mars.config.ApplicationConfig.DEBUG;

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

    public Plane launch() {
        
        return rovers.stream()
            .reduce(new Plane(x, y),
                // lunch rover and add single rover mission reuslt to result plane
                (plane, rover) -> 
                    plane.addRover(rover.launch(plane)),
                // accumulate multiple rover mission results
                (p1, p2) -> {
                    p1.rovers.addAll(p2.rovers);
                    return p1;
                }
            );
    }

    public Position isInRange(Position position) {
        
        if(DEBUG)
            System.out.println(position.x + " " + position.y + " " + position.direction);

        if(position.x < 0 || position.x > x) {
            throw new IndexOutOfBoundsException(
                "Rover out of range (" + x + ", " + y + "): position.x = " + position.x);
        }

        if(position.y < 0 || position.y > y) {
            throw new IndexOutOfBoundsException(
                "Rover out of range (" + x + ", " + y + "): position.y = " + position.y);
        }

        return position;
    }
}