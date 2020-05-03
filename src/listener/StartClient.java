package listener;

import java.io.IOException;

/**
 * This is the starter code for Client-Server interface using multithreading in one output console.
 * Alternatively:
 * You can also start Server manually first and than start Client Manually afterwards.
 * This will create to output consoles.
 */

public class StartClient {
    public static void main(String[] args) throws IOException {

        Server server = new Server();
        Client client = new Client();

        String host = "localhost";
        int port = 2020;

        Thread serverthread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    server.create(port);
                } catch (IOException e) {
                    e.printStackTrace();
                }            }
        });

        serverthread.start();
        client.create(host,port);

    }

}
