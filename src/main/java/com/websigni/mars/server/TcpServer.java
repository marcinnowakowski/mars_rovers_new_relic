package com.websigni.mars.server;

import java.net.Socket;
import java.net.ServerSocket;

import java.io.IOException;

/**
 * @see https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
 */
public class TcpServer {

    /**
     * Start socket server. 
     * 
     * Method is blocking runs as long no server socket occurs or kill signal is
     * sent to the application.
     * @param portNumber
     */
    public void start(int portNumber) {

        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {

            System.err.println("Error starting tcp server: " + e.getMessage());
            return;
        }

        while(true) {

            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {

                System.err.println("Error accepting client connection: " + e.getMessage());
                return;
            }
            
            new Thread(
                new Session(clientSocket)
            ).start();
            
        }
    } 
}