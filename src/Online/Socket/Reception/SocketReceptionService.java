package Online.Socket.Reception;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class SocketReceptionService extends Observable implements Observer {

    private final Socket socket;

    public SocketReceptionService(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(this.socket.getInputStream());

        SocketReceptionRunnable runnable = new SocketReceptionRunnable(objectInputStream);
        runnable.addObserver(this);
        (new Thread(runnable)).start();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setChanged();
        this.notifyObservers(arg);
    }
}
