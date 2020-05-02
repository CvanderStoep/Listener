package listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class listens to a network port and sends it out as TextProducer to who-ever is subscribed.
 */

public class Server {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        int port = 2020;
        server.create(port);
    }

    public void create(int port) throws IOException {
        System.out.println("Server started.");
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String string = bufferedReader.readLine();
        System.out.println("Information received by server: " + string);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Information send by server: Yes, I am ready to receive information!");
        printWriter.flush();

    }
}

