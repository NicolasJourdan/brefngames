package Game;

import ContestSettings.ContestSettingsScene;
import Game.Games.TicTacToe.TicTacToeScene;
import Online.Client.ClientScene;
import Online.Server.ServerScene;
import Online.Socket.SocketCommunicatorService;
import OnlineContestMenu.OnlineContestMenuScene;
import Player.Player;
import Scene.Model.SceneEnum;

public class OnlineGameSceneFactory extends GameSceneFactory {

    private boolean isServer;
    private SocketCommunicatorService socketCommunicatorService;

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
                return new ContestSettingsScene(this.isServer, this.socketCommunicatorService);
            case TIC_TAC_TOE:
                return new TicTacToeScene(this.playersList, this.isTraining, this.history.getCurrentScore(), this.isServer, this.socketCommunicatorService);
            default:
                throw new RuntimeException("GameEnum (" + gameEnum + ") is unknown");
        }
    }

    public void setIsServer(boolean isServer) {
        this.isServer = isServer;
    }

    public void setSocketCommunicatorService(SocketCommunicatorService socketCommunicatorService) {
        this.socketCommunicatorService = socketCommunicatorService;
    }
}
