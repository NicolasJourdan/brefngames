package Online.Socket.Emission;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class SocketEmissionService {

    private final Socket socket;
    private SocketEmissionRunnable runnable;

    public SocketEmissionService(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());

        this.runnable = new SocketEmissionRunnable(objectOutputStream);
        (new Thread(this.runnable)).start();
    }

    public void emit(Serializable message) {
        this.runnable.emit(message);
    }
}
