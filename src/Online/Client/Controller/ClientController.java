package Online.Client.Controller;

import Online.Client.SocketConnection.ClientConnectionService;
import Online.Client.View.ClientView;
import Scene.Controller.AbstractSceneController;
import Scene.Model.ActionEnum;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.net.Socket;
import java.util.Observable;

public class ClientController extends AbstractSceneController {

    private ClientConnectionService clientConnectionService;
    private Socket socket;

    public ClientController(AbstractModel model, AbstractView view) {
        super(model, view);
    }

    @Override
    public void update(Observable o, Object action) {
        switch ((ActionEnum) action) {
            case JOIN_SERVER:
                this.joinServer();
                break;

            case CONNECTED_TO_SERVER:
                this.socket = this.clientConnectionService.getSocket();
                System.out.println("Client: server is " + this.socket.getInetAddress() + " " + this.socket.getPort());

                this.setChanged();
                this.notifyObservers(ActionEnum.CONNECTED_TO_SERVER);
                break;

            default:
                throw new RuntimeException("Unable to find : " + action);
        }
    }

    private void joinServer() {
        this.clientConnectionService = new ClientConnectionService();
        this.clientConnectionService.addObserver(this);
        this.clientConnectionService.startConnection(((ClientView) this.view).getAddressDataObject());
    }

    public Socket getSocket() {
        return this.socket;
    }
}
