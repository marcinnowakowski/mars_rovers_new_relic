package com.websigni.mars.plane;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.websigni.mars.rover.RoverParser;

public class PlaneParser {

    private static final Pattern PLANE_PATTERN = Pattern.compile(
        "(\\d+) (\\d+)"
    );

    public static Plane parse(String input) {

        Matcher m = PLANE_PATTERN.matcher(input);
        m.find();

        final Plane p = new Plane(
            Integer.parseInt(m.group(1)),
            Integer.parseInt(m.group(2))
        );

        RoverParser.parse(input.substring(m.end())).stream()
            .forEach(
                r -> p.addRover(r) 
            );

        return p;
    }
}