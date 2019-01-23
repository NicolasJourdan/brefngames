package Contest.Model;

import Player.Player;
import Repository.Player.PlayerRepository;

public class OnlineContest extends AbstractContest {

    private static final int SERVER_PLAYER_INDEX = 0;
    private static final int CLIENT_PLAYER_INDEX = 1;
    private boolean isServer;

    @Override
    public void savePlayers(Player[] players) {
        if (AbstractContest.DEFAULT_NB_PLAYERS != players.length) {
            throw new RuntimeException("Exactly " + AbstractContest.DEFAULT_NB_PLAYERS + " are required");
        }

        PlayerRepository.save(
                this.isServer ? players[OnlineContest.SERVER_PLAYER_INDEX] : players[OnlineContest.CLIENT_PLAYER_INDEX]
        );
    }

    public void setServer(boolean server) {
        this.isServer = server;
    }
}
