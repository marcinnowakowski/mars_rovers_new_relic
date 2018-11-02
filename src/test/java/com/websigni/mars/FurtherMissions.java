package com.websigni.mars;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import com.websigni.mars.parse.MissionParser;

public class FurtherMissions {

    @Test
    public void missionOne(){

        mission(
            "5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM",
            "1 3 N 5 1 E"
        );
    }

    private mission(String input, String expectedOutput) {

        String output = MissionParser.parse(input).printToString();

        assertThat(r2.position.direction).isEqualTo(Direction.EAST);
    }
    
}