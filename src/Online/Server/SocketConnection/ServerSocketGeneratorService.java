package Online.Server.SocketConnection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class ServerSocketGeneratorService {

    /**
     * MIN_PORT is 1024 because the range of well know ports is form 0 to 1023
     * see https://en.wikipedia.org/wiki/List_of_TCP_and_UDP_port_numbers
     */
    private static final int MIN_PORT = 1024;
    private static final int MAX_PORT = 65535;

    /**
     * Generate a ServerSocket using an available port
     *
     * @return ServerSocket
     */
    public ServerSocket generateServerSocket() {
        ServerSocket serverSocket = null;

        // find available port
        for (int port = MIN_PORT; port <= MAX_PORT; port++) {
            // try to create a socket using an available port, if the port is unusable, then an error is thrown
            try {
                serverSocket = new ServerSocket(port, 1, InetAddress.getByName(InetAddress.getLocalHost().getHostAddress()));
                break;
            } catch (IOException e) {
            }
        }

        return serverSocket;
    }
}
