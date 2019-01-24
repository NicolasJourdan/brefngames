package Online.Server.SocketConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class ServerConnectionRunnable extends Observable implements Runnable {

    private ServerSocket serverSocket = null;
    private Socket socket;

    public ServerConnectionRunnable(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            this.socket = this.serverSocket.accept();
            System.out.println("Server: client joined");

            this.setChanged();
            this.notifyObservers(this.socket);
        } catch (IOException e) {
            System.err.println("Server: error");
            System.err.println(e);
        }
    }
}
