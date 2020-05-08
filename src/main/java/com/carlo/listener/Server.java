package com.carlo.listener;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class listens to a network port and sends it out as TextProducer to who-ever is subscribed.
 */

//TODO add as textproducer
public class Server {
    private List<TextListener> textListeners = new ArrayList<>();

    public void addListener(TextListener tl){
        textListeners.add(tl);
    }
    public boolean removeListener(TextListener tl){
        return textListeners.remove(tl);
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        int port = 2020;
        TextListener guiListener = new GUI();
        server.addListener(guiListener);
        server.create(port);
    }

    public void create(int port) throws IOException {
        System.out.println("Server started.");
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while(true) {
            String string = bufferedReader.readLine();
            System.out.println("Information received by server: " + string);
            for (TextListener tl: textListeners){
                tl.textUpdate(string);
            }

            System.out.flush();
            if (string.equals("Quit")) {
                socket.close();
                break;}
        }


//        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
//        printWriter.println("Information send by server: Yes, I am ready to receive information!");
//        printWriter.flush();
    }
}

