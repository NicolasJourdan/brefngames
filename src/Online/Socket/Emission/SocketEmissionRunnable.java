package Online.Socket.Emission;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class SocketEmissionRunnable implements Runnable {

    private static final int STACK_CAPACITY = 50;

    private final Queue<Serializable> stack;
    private final ObjectOutputStream objectOutputStream;

    public SocketEmissionRunnable(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
        this.stack = new ArrayBlockingQueue<>(SocketEmissionRunnable.STACK_CAPACITY);
    }

    @Override
    public void run() {
        while (true) {
            if (!this.stack.isEmpty()) {
                Serializable message = this.stack.remove();
                try {
                    this.objectOutputStream.writeObject(message);
                    this.objectOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void emit(Serializable message) {
        this.stack.add(message);
    }
}
