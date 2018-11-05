package com.websigni.mars.server;

import java.net.Socket;

/**
 * @see https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
 */
public class TcpServer {

    public void start(int portNumber) {

        ServerSocket serverSocket = new ServerSocket(portNumber);

        while(true) {

            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {

                throw new IllegalStateException(
                    "Error accepting client connection", e);
            }
            
            new Thread(
                new Session(clientSocket)
            ).start();
            
        }
    } 
}