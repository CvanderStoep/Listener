package listener;

import java.io.IOException;

/**
 * Trying to start server first and then client, but no successful so far?
 * multithreading?
 */

public class StartClient {
    public static void main(String[] args) throws IOException {

        Server server = new Server();
        Client client = new Client();

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
        client.create(port);

    }

}
