package Contest.Model;

import Game.Game;
import Game.GameFactory;
import Parameter.Model.Configurable;
import Parameter.Model.ParametersEnum;
import Player.Player;
import Structure.AbstractModel;

import java.util.*;

public abstract class AbstractContest extends AbstractModel {
    /**
     * List of games
     */
    private List<Game> gameList;

    private Player[] playerList;

    /**
     * The current game
     */
    private Game currentGame;

    /**
     * Defines if the contest is a training
     */
    private boolean isTraining = false;

    private GameFactory gameFactory;

    private Map<ParametersEnum, Configurable> contestParameters;
}
