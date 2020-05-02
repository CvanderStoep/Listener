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
        //TODO create server and then client, at this moment the server is started and code is waiting for the client
        server.create(port);
        client.create(port);

    }

}
