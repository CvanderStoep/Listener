package listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class sends text to a local network port.
 * This can be picked up by a Listener (server) who will then sends this as Textproducers to who-ever has subscribed.
 */

public class Client {
    public void create(int port) throws IOException {
        System.out.println("Client started.");
        Socket socket = new Socket("localhost", port);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Information send by Client: Hello is anybody listening?");
        printWriter.flush();

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String string = bufferedReader.readLine();
        System.out.println("Information received from server: " + string);

    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        int port = 2020;
        client.create(port);
    }

}
