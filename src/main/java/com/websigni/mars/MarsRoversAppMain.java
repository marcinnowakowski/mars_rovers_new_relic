package com.websigni.mars;

import static com.websigni.mars.config.ApplicationConfig.DEBUG;
import static com.websigni.mars.config.ApplicationConfig.PORT_NUMBER;

import com.websigni.mars.server.TcpServer;

public class MarsRoversAppMain {

    public static void main(String[] args) {
        
        if(DEBUG) {
            System.out.println("******************************************");
            System.out.println("STARTING MARS ROVER APP");
        }

        new TcpServer().start(PORT_NUMBER);

        if(DEBUG) {
            System.out.println("******************************************");
            System.out.println("MARS ROVER APP STOPPED");
        }
    }
}