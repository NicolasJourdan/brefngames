package Online.Socket.Emission;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Observer;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class SocketEmissionRunnable implements Runnable {

    private static final int STACK_CAPACITY = 50;

    private final Queue<Serializable> stack;
    private final ObjectOutputStream objectOutputStream;
    private boolean shouldContinue;

    public SocketEmissionRunnable(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
        this.stack = new ArrayBlockingQueue<>(SocketEmissionRunnable.STACK_CAPACITY);
        this.shouldContinue = true;
    }

    @Override
    public void run() {
        System.out.println("Emission starting");

        while (this.shouldContinue) {
            if (!this.stack.isEmpty()) {
                Serializable message = this.stack.remove();
                try {
                    // reset so already serialized object are send with the updated values
                    this.objectOutputStream.reset();
                    this.objectOutputStream.writeObject(message);
                    this.objectOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        System.out.println("Emission stopping");
    }

    public void emit(Serializable message) {
        this.stack.add(message);
    }

    public void end() {
        try {
            this.shouldContinue = false;
            this.objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
