package Online.Socket.Reception;

import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Scene.Model.ActionEnum;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Observable;

public class SocketReceptionRunnable extends Observable implements Runnable {

    private final ObjectInputStream objectInputStream;

    public SocketReceptionRunnable(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Serializable message = (Serializable) this.objectInputStream.readObject();
                this.setChanged();
                this.notifyObservers(message);
            } catch (Exception e) {
                this.setChanged();
                this.notifyObservers(new MessageDataObject(MessageType.ERROR));
                break;
            }
        }
    }
}
