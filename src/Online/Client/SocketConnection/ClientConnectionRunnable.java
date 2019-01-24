package Online.Client.SocketConnection;

import Scene.Model.ActionEnum;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Observable;

public class ClientConnectionRunnable extends Observable implements Runnable {

    private static final int TIMEOUT = 10000;
    private final AddressDataObject addressDataObject;

    public ClientConnectionRunnable(AddressDataObject addressDataObject) {
        this.addressDataObject = addressDataObject;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket();
            socket.connect(
                    new InetSocketAddress(addressDataObject.getAddress(), Integer.parseInt(addressDataObject.getPort())), 
                    ClientConnectionRunnable.TIMEOUT
            );
            System.out.println("Client: connected to server");

            this.setChanged();
            this.notifyObservers(socket);
        } catch (Exception e) {
            System.err.println("Client: error");
            e.printStackTrace();
            this.setChanged();
            this.notifyObservers(ActionEnum.ERROR);
        }
    }
}
