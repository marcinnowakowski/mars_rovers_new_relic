package com.websigni.mars.rover;

import java.util.Optional;

import com.websigni.mars.plane.Plane;
import com.websigni.mars.path.OrderType;
import com.websigni.mars.path.Path;

import static com.websigni.mars.config.ApplicationConfig.DEBUG;

public class Rover {
    
    public final Position position;

    private Optional<Path> oPath = Optional.empty();

    public Rover(int x, int y, Direction d) {
        
        position = new Position(x, y, d);
    }

    public Rover(Position p) {
        
        position = p;
    }

    public Rover setPath(Path path) {
        oPath = Optional.of(path);
        return this;
    }

    /**
     * Find new rover possition on basis of path defined by order sequence.
     * 
     * @param plane
     * @return
     */
    public Rover launch(Plane plane) {
        
        if(DEBUG) {
            System.out.println("------------------------------------------");
            System.out.println("ROVER: " + position.x + " " + position.y + " " + position.direction);
        }

        // if path is empty rover doesn't move
        if(!oPath.isPresent()) {
            return new Rover(position.x, position.y, position.direction);
        }

        return new Rover(oPath.get().orders.stream()
            .reduce(position, 
                (position, order) ->
                    plane.isInRange(position.perform(order)),
                // this reduction cannot be parallelized
                (p1, p2) -> {
                    throw new UnsupportedOperationException();
                }
            )
        );

    }
    
}