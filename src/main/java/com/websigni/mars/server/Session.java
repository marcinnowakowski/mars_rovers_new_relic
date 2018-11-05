package com.websigni.mars.server;

import java.net.Socket;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import com.websigni.mars.parse.MissionFormatException;
import com.websigni.mars.parse.MissionParser;

public class Session implements Runnable {

    private final Socket s;

    Session(Socket aS) {
        s = aS;
    } 

    public void run() {

        try {

            PrintWriter out =
                new PrintWriter(s.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));

            String inputLine, outputLine;

            while ((inputLine = in.readLine()) != null) {
                try {
                    outputLine = MissionParser.parse(inputLine).launch().printToString();
                    out.println(outputLine);
                } catch(MissionFormatException mfe) {
                    out.println(mfe.getMessage());
                }
            }

        } catch (IOException e) {

            System.err.println("Client socket error: " + e.getMessage());
            return;
        }

    }
}