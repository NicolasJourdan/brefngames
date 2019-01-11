package Online.Server.Controller;

import Online.Server.SocketConnection.ServerConnectionService;
import Scene.Controller.AbstractSceneController;
import Scene.Model.ActionEnum;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.net.Socket;
import java.util.Observable;

public class ServerController extends AbstractSceneController {

    private ServerConnectionService serverConnectionService;
    private Socket socket;

    public ServerController(AbstractModel model, AbstractView view) {
        super(model, view);
    }

    @Override
    public void update(Observable o, Object action) {
        switch ((ActionEnum) action) {
            case LAUNCH_SERVER:
                this.createServer();
                break;

            case CLIENT_CONNECTED:
                this.socket = this.serverConnectionService.getSocket();
                System.out.println("Server: client is " + this.socket.getInetAddress() + " " + this.socket.getPort());
                break;

            default:
                throw new RuntimeException("Unable to find : " + action);
        }
    }

    private void createServer() {
        this.serverConnectionService = new ServerConnectionService();
        this.serverConnectionService.addObserver(this);
        this.serverConnectionService.startConnection();
    }
}
