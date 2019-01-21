package Game;

import ContestSettings.ContestSettingsScene;
import Online.Client.ClientScene;
import Online.Server.ServerScene;
import OnlineContestMenu.OnlineContestMenuScene;
import Player.Player;
import Scene.Model.SceneEnum;

import java.net.Socket;

public class OnlineGameSceneFactory extends GameSceneFactory {

    private boolean isServer;
    private Socket socket;

    public OnlineGameSceneFactory(Player[] listPlayers, boolean isTraining) {
        super(listPlayers, isTraining);
    }

    @Override
    public GameScene createScene(SceneEnum gameEnum) {
        switch (gameEnum) {
            case CREATE_SERVER_SCENE:
                return new ServerScene();
            case JOIN_SERVER_SCENE:
                return new ClientScene();
            case ONLINE_CONTEST_MENU:
                return new OnlineContestMenuScene();
            case CONTEST_MENU:
                return new ContestSettingsScene(this.isServer, this.socket);
            default:
                throw new RuntimeException("GameEnum (" + gameEnum + ") is unknown");
        }
    }

    public void setIsServer(boolean isServer) {
        this.isServer = isServer;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
