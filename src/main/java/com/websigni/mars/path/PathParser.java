package com.websigni.mars.path;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.websigni.mars.path.Path;

public class PathParser {

    private static final Pattern PATH_PATTERN = Pattern.compile(
        "[L,R,M]"
    );
    
    public static Path parse(String input) {

        Path p = new Path();

        Matcher m = PATH_PATTERN.matcher(input);

        while(m.find()) {
            Order o = new Order(
                parseOrderType(m.group(0))
            );
            
            p.addOrder(o);
        }

        return p;
    }

    public static OrderType parseOrderType(String input) {

        switch(input) {
            case "L":
                return OrderType.LEFT;
            case "R":
                return OrderType.RIGHT;
            default:
                return OrderType.MOVE;
        }

    }
}