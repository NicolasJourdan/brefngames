package Map.Model;

import Game.Model.AbstractGameModel;
import Player.*;

public class MapModel extends AbstractGameModel {

    public MapModel(Player[] listPlayers) {
        super(listPlayers);
    }

    public int[] getCurrentScore(History history) {
        return history.getCurrentScore();
    }

    public boolean isFinish(History history) {
        return 0 == history.getNbRemainingGames();
    }
}
