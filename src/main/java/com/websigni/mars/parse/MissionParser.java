package com.websigni.mars.parse;

import static com.websigni.mars.config.ApplicationConfig.DEBUG;

import com.websigni.mars.parse.MissionFormatException;
import com.websigni.mars.plane.Plane;
import com.websigni.mars.plane.PlaneParser;

public class MissionParser {

    private static final String REGEXP = 
        //plane
        "\\d+ \\d+" + 
        // rovers
        "( \\d+ \\d+ [N,E,S,W]" +
            //path
            "( [L,R,M]+)?" +
        ")*";

    public static Plane parse(String input) {
        
        verifyExpression(input);
        return PlaneParser.parse(input);
    }

    private static void verifyExpression(String input) {
        
        if(DEBUG) {
            System.out.println("REGEXP = " + REGEXP);
            System.out.println("MISSION = " + input);
        }

        if(!input.matches(REGEXP))
            throw new MissionFormatException(input);

    }
}