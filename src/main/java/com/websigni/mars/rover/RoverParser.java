package com.websigni.mars.rover;

import java.util.List;
import java.util.ArrayList;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.websigni.mars.rover.Direction;
import com.websigni.mars.rover.Rover;

import com.websigni.mars.path.PathParser;

public class RoverParser {
    
    private static final Pattern ROVER_PATTERN = Pattern.compile(
        " (\\d+) (\\d+) ([N,E,S,W])( [L,R,M]+)?"
    );

    public static List<Rover> parse(String input) {
        
        List<Rover> rovers = new ArrayList<>();

        if(input.equals(""))
            return rovers;

        Matcher m = ROVER_PATTERN.matcher(input);

        while(m.find()) {
            Rover r = new Rover(
                Integer.parseInt(m.group(1)),
                Integer.parseInt(m.group(2)),
                parseDirection(m.group(3))
            );

            if(m.group(4) != null)
                r.setPath(PathParser.parse(m.group(4)));
            
            rovers.add(r);
        }

        return rovers;
        
    }

    private static Direction parseDirection(String input) {

        switch(input) {
            case "N":
                return Direction.NORTH;
            case "E":
                return Direction.EAST;
            case "W":
                return Direction.SOUGHT;
            default:
                return Direction.WEST;
        }
    } 
}