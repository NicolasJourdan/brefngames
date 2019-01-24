package Online.Client.SocketConnection;

import Scene.Model.ActionEnum;

import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class ClientConnectionService extends Observable implements Observer {

    private Socket socket;

    public void startConnection(AddressDataObject addressDataObject) {
        // launch thread based on client connection runnable
        ClientConnectionRunnable runnable = new ClientConnectionRunnable(addressDataObject);
        runnable.addObserver(this);
        (new Thread(runnable)).start();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof ActionEnum) {
            this.setChanged();
            this.notifyObservers(arg);
            return;
        }

        this.socket = (Socket) arg;
        this.setChanged();
        this.notifyObservers(ActionEnum.CONNECTED_TO_SERVER);
    }

    public Socket getSocket() {
        return this.socket;
    }
}
