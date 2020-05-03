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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        client.create(port);

    }

}
