package com.websigni.mars.server;

import java.net.Socket;

import com.websigni.mars.parse.MissionParser;

public class Session implements Runnable {

    private final Socket s;

    Session(Socket aS) {
        s = aS;
    } 

    public void run() {

        PrintWriter out =
            new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));

        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            outputLine = MissionParser.parse(input).launch().printToString();
            out.println(outputLine);
        }

    }
}