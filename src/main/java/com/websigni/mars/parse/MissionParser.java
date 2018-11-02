package com.websigni.mars.parse;

import static com.websigni.mars.config.ApplicationConfig.DEBUG;

import com.websigni.mars.parse.MissionFormatException;
import com.websigni.mars.plane.Plane;

public class MissionParser {

    private static final String REGEXP = 
        //plane
        "\\d+ \\d+" + 
        // rovers
        "( \\d+ \\d+ [N,E,S,W]" +
            //path
            "( [L,R,M]+)?" +
        ")*";

    public Plane parse(String input) {
        
        verifyExpression(input);
        //return Plane.parse(input);
        return new Plane(1, 1);
    }

    private void verifyExpression(String input) {
        
        if(DEBUG) {
            System.out.println("REGEXP = " + REGEXP);
            System.out.println("MISSION = " + input);
        }

        if(!input.matches(REGEXP))
            throw new MissionFormatException(input);

    }
}