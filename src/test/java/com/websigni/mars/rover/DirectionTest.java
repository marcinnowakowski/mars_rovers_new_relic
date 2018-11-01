package com.websigni.mars.rover;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import com.websigni.mars.rover.Direction;

public class DirectionTest {

    @Test
    public void check360Anticlockwise(){

        assertThat(
            Direction.NORTH
                .countLeft()
                .countLeft()
                .countLeft()
                .countLeft()
        ).isEqualTo(Direction.NORTH);
    }

    public void check360Clockwise(){
        assertThat(
            Direction.NORTH
                .countRight()
                .countRight()
                .countRight()
                .countRight()
        ).isEqualTo(Direction.NORTH);
    }

    public void check90Clockwise(){
    
        assertThat(
            Direction.NORTH
                .countRight()
        ).isEqualTo(Direction.EAST);
    }

    public void check270ClockwiseAnticlockwise(){
    
        assertThat(
            Direction.NORTH
                .countRight()
                .countRight()
                .countRight()
                .countLeft()
                .countLeft()
                .countLeft()
        ).isEqualTo(Direction.NORTH);
    }
}