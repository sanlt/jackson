package ch.bfh.http;

import java.io.*;
import java.net.*;

public class JsonServer {

    public static final int PORT = 8080;

    public static void main(String[] args) {
        
        try (ServerSocket serverConnect = new ServerSocket(PORT)) {

            System.out.println("Server started.\nListening for connections on port : " + PORT + " ...\n");
            
            // we listen until user halts server execution
            while (true) {
                RequestHandler handler = new RequestHandler(serverConnect.accept());
                Thread thread = new Thread(handler);
                thread.start();
            }
            
        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }
}
