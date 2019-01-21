package Online.Server.SocketConnection;

import Scene.Model.ActionEnum;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class ServerConnectionService extends Observable implements Observer {

    private final ServerSocketGeneratorService serverSocketServiceGenerator;

    private ServerSocket serverSocket;
    private Socket socket;

    public ServerConnectionService() {
        this.serverSocketServiceGenerator = new ServerSocketGeneratorService();
    }

    public void startConnection() {
        this.serverSocket = this.serverSocketServiceGenerator.generateServerSocket();

        System.out.println("Server Socket: " + this.serverSocket);

        if (null == this.serverSocket) {
            System.err.println("No port available");
            return;
        }

        // launch thread based on server connection runnable
        ServerConnectionRunnable runnable = new ServerConnectionRunnable(this.serverSocket);
        runnable.addObserver(this);
        (new Thread(runnable)).start();
    }

    @Override
    public void update(Observable o, Object socket) {
        this.socket = (Socket) socket;
        this.setChanged();
        this.notifyObservers(ActionEnum.CLIENT_CONNECTED);
    }

    public Socket getSocket() {
        return this.socket;
    }
}
