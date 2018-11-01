package com.websigni.mars.rover;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import com.websigni.mars.rover.Direction;

public class DirectionTest {

    @Test
    public void check360Anticlockwise(){

        assertThat(
            Direction.NORTH
                .left()
                .left()
                .left()
                .left()
        ).isEqualTo(Direction.NORTH);
    }

    @Test
    public void check360Clockwise(){
        assertThat(
            Direction.NORTH
                .right()
                .right()
                .right()
                .right()
        ).isEqualTo(Direction.NORTH);
    }

    @Test
    public void check90Clockwise(){
    
        assertThat(
            Direction.NORTH
                .right()
        ).isEqualTo(Direction.EAST);
    }

    @Test
    public void check270ClockwiseAnticlockwise(){
    
        assertThat(
            Direction.NORTH
                .right()
                .right()
                .right()
                .left()
                .left()
                .left()
        ).isEqualTo(Direction.NORTH);
    }
}