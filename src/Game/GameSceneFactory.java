package Game;

import Player.Player;
import Scene.Model.SceneEnum;
import Scene.Model.SceneFactoryInterface;

public class GameSceneFactory implements SceneFactoryInterface {

    private Player[] listPLayers;

    public GameSceneFactory(Player[] listPlayers) {
        this.listPLayers = listPlayers;
    }

    /**
     * Create a game associated to an game
     */
    public GameScene createScene(SceneEnum gameEnum) {
        // TODO fill the switch when scenes will be created
        switch (gameEnum) {
            case TIC_TAC_TOE:
                // return new TicTacToeScene(this.listPlayers);
            case RUNNER:
                // return new RunnerScene(this.listPlayers);
            case CONNECT_FOUR:
                // return new ConnectFourScene(this.listPlayers);
            case COOKIE_CLICKER:
                // return new CookieClickerScene(this.listPlayers);
            default:
                throw new RuntimeException("GameEnum (" + gameEnum + ") is unknown");
        }
    }
}
