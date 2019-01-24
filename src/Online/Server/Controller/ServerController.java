package Online.Server.Controller;

import Online.Server.SocketConnection.ServerConnectionService;
import Online.Server.View.ServerView;
import Scene.Controller.AbstractSceneController;
import Scene.Model.ActionEnum;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.net.ServerSocket;
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
                ServerSocket serverSocket = this.serverConnectionService.getServerSocket();
                ((ServerView) this.view).setContestIp(
                        this.formatIp(serverSocket.getInetAddress().toString())
                );
                ((ServerView) this.view).setContestPort(Integer.toString(serverSocket.getLocalPort()));
                ((ServerView) this.view).toggleCreateContestButton();
                break;
            case CLIENT_CONNECTED:
                this.serverConnectionService.closeServerSocket();
                this.socket = this.serverConnectionService.getSocket();
                System.out.println("Server: client is " + this.socket.getInetAddress() + " " + this.socket.getPort());

                this.setChanged();
                this.notifyObservers(ActionEnum.CLIENT_CONNECTED);
                break;
            case ONLINE_CONTEST_MENU:
                if (null != this.serverConnectionService) {
                    this.serverConnectionService.stopConnection();
                }
                this.setChanged();
                this.notifyObservers(action);
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

    public Socket getSocket() {
        return this.socket;
    }

    private String formatIp(String unformatedIp) {
        return unformatedIp.replace("/", "");
    }
}
