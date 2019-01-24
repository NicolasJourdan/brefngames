package Online.Socket.Reception;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class SocketReceptionService extends Observable implements Observer {

    private final Socket socket;
    private Thread thread;
    private SocketReceptionRunnable runnable;

    public SocketReceptionService(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(this.socket.getInputStream());

        this.runnable = new SocketReceptionRunnable(objectInputStream);
        this.runnable.addObserver(this);
        this.thread = (new Thread(this.runnable));
        this.thread.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setChanged();
        this.notifyObservers(arg);
    }

    public void end() {
        this.deleteObservers();
        this.runnable.end();
    }
}
