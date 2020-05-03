package listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * This class sends text to a local network port.
 * This can be picked up by a Listener (server) who will then sends this as Textproducers to who-ever has subscribed.
 */

public class Client {

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        String host = "localhost";
        String lex = "192.168.68.106";
        int port = 2020;
        client.create(host, port);
    }

    public void create(String host, int port) throws IOException {
        System.out.println("Client started.");
        Socket socket = new Socket(host, port);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String string = input.nextLine();
            printWriter.println(string);
            printWriter.flush();
            if (string.equals("Quit")) break;
        }

//        printWriter.println("Information send by Client: Hello is anybody listening?");
//        printWriter.flush();

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String string = bufferedReader.readLine();
        System.out.println("Information received from server: " + string);

    }



}
