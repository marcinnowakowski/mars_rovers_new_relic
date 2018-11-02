package com.websigni.mars.parse;

import com.websigni.mars.plane.Plane;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class MissionParserTest {

    @Test
    public void parseMissionOne() {
        Plane p = new MissionParser().parse(
            "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM"
        );

        assertThat(p.x).isEqualTo(5);
        assertThat(p.rovers.size()).isEqualTo(2);
    }

    @Test
    public void parseEmptyOrderPaths() {
        Plane p = new MissionParser().parse(
            "5 5 1 2 N 3 3 E MMRMMRMRRM 3 3 E"
        );

        assertThat(p.rovers.size()).isEqualTo(3);
    }

    @Test
    public void parseNoRovers() {
        Plane p = new MissionParser().parse(
            "5 5"
        );

        assertThat(p.rovers.size()).isEqualTo(0);
    }

    @Test
    public void parseErrorousInput() {
        Plane p = new MissionParser().parse(
            "5 5 1 2 N 'THIS IS WRONG!' 3 3 E MMRMMRMRRM"
        );
    }
}