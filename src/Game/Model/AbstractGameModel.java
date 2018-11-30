package Game.Model;

import Player.Player;
import Structure.AbstractModel;

/**
 * The game models have to extend this model.
 */
public abstract class AbstractGameModel extends AbstractModel {

    protected Player[] listPlayers;

    public AbstractGameModel(Player[] listPlayers) {
        this.listPlayers = listPlayers;
    }
}
