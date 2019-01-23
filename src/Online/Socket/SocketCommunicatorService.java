package Online.Socket;

import Online.Socket.Emission.SocketEmissionService;
import Online.Socket.Reception.SocketReceptionService;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.Observer;

public class SocketCommunicatorService {

    private SocketEmissionService socketEmissionService;
    private SocketReceptionService socketReceptionService;

    public SocketCommunicatorService(Socket socket) {
        try {
            this.socketEmissionService = new SocketEmissionService(socket);
            this.socketEmissionService.start();

            this.socketReceptionService = new SocketReceptionService(socket);
            this.socketReceptionService.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addReceptionObserver(Observer observer) {
        this.socketReceptionService.addObserver(observer);
    }

    public void deleteReceptionObserver(Observer observer) {
        this.socketReceptionService.deleteObserver(observer);
    }

    public void emit(Serializable message) {
        this.socketEmissionService.emit(message);
    }
}
