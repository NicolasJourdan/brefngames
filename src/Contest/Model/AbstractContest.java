package Contest.Model;

import Game.GameScene;
import Game.GameSceneFactory;
import Parameter.Parameters.Configurable;
import Parameter.Model.ParameterEnum;
import Player.Player;
import Scene.Model.AbstractSceneManagerModel;
import Structure.AbstractModel;

import java.util.*;

public abstract class AbstractContest extends AbstractSceneManagerModel {
    /**
     * List of games
     */
    private List<GameScene> gameSceneList;

    protected Player[] playerList;

    /**
     * The current game
     */
    private GameScene currentGameScene;

    /**
     * Defines if the contest is a training
     */
    private boolean isTraining = false;

    private GameSceneFactory gameSceneFactory;

    private Map<ParameterEnum, Configurable> contestParameters;

    public Player[] getPlayerList() {
        return playerList;
    }
}
