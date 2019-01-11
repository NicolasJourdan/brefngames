package Online.Client.SocketConnection;

import java.io.IOException;
import java.net.Socket;
import java.util.Observable;

public class ClientConnectionRunnable extends Observable implements Runnable {

    private final AddressDataObject addressDataObject;

    public ClientConnectionRunnable(AddressDataObject addressDataObject) {
        this.addressDataObject = addressDataObject;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(addressDataObject.getAddress(), Integer.parseInt(addressDataObject.getPort()));
            System.out.println("Client: connected to server");

            this.setChanged();
            this.notifyObservers(socket);
        } catch (IOException e) {
            System.err.println("Client: error");
            e.printStackTrace();
        }
    }
}
