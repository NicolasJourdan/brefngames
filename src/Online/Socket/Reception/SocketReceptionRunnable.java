package Online.Socket.Reception;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Observable;

public class SocketReceptionRunnable extends Observable implements Runnable {

    private final ObjectInputStream objectInputStream;
    private boolean shouldContinue;

    public SocketReceptionRunnable(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
        this.shouldContinue = true;
    }

    @Override
    public void run() {
        System.out.println("Reception starting");

        while(this.shouldContinue) {
            try {
                Serializable message = (Serializable) this.objectInputStream.readObject();
                this.setChanged();
                this.notifyObservers(message);
            } catch (EOFException e) {
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Reception stopping");
    }

    public void end() {
        try {
            this.shouldContinue = false;
            this.objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
