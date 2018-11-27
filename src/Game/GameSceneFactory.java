package Game;

import Game.Games.TicTacToe.TicTacToeScene;
import Map.MapScene;
import Map.Model.History;
import Player.Player;
import Scene.Model.SceneEnum;
import Scene.Model.SceneFactoryInterface;
import Training.TrainingMenuScene;

public class GameSceneFactory implements SceneFactoryInterface {

    private Player[] listPLayers;

    private History history;

    public GameSceneFactory(Player[] listPlayers) {
        this.listPLayers = listPlayers;
    }

    /**
     * Create a game associated to an game
     */
    public GameScene createScene(SceneEnum gameEnum) {
        // TODO fill the switch when scenes will be created
        switch (gameEnum) {
            case MAP:
                return new MapScene(this.history);
            case TIC_TAC_TOE:
                return new TicTacToeScene(this.listPLayers);
            case RUNNER:
                // return new RunnerScene(this.listPlayers);
            case CONNECT_FOUR:
                // return new ConnectFourScene(this.listPlayers);
            case COOKIE_CLICKER:
                // return new CookieClickerScene(this.listPlayers);
            case TRAINING_MENU:
                return new TrainingMenuScene();
            default:
                throw new RuntimeException("GameEnum (" + gameEnum + ") is unknown");
        }
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
