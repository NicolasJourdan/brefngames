package Game;

import Player.Player;

public class GameSceneFactory {

    /**
     * Create a game associated to an EnumGame
     */
    public GameScene getGame(GameEnum gameEnum, Player[] listPlayers) {
        // TODO fill the switch when scenes will be created
        switch (gameEnum) {
            case TIC_TAC_TOE:
                // return new TicTacToeScene(listPlayers);
            case RUNNER:
                // return new RunnerScene(listPlayers);
            case CONNECT_FOUR:
                // return new ConnectFourScene(listPlayers);
            case COOKIE_CLICKER:
                // return new CookieClickerScene(listPlayers);
            default:
                throw new RuntimeException("GameEnum (" + gameEnum + ") is unknown");
        }
    }
}
