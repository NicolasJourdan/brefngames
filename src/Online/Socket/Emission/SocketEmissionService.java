package Online.Socket.Emission;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class SocketEmissionService {

    private final Socket socket;
    private SocketEmissionRunnable runnable;
    private Thread thread;

    public SocketEmissionService(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());

        this.runnable = new SocketEmissionRunnable(objectOutputStream);
        this.thread = new Thread(this.runnable);
        this.thread.start();
    }

    public void emit(Serializable message) {
        this.runnable.emit(message);
    }

    public void end() {
        this.runnable.end();
        this.thread.interrupt();
    }
}
