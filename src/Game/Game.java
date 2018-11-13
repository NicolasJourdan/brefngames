package Game;

import Parameter.Model.ParameterEnum;
import Player.Player;
import Statistic.Model.Statistic;

import java.util.*;

public abstract class Game {

    private Player[] listPlayers;

    private List<Statistic> listStatistics;

    /**
     * Returns an array of string of all needed param keys
     */
    public abstract List<ParameterEnum> getNeededParams();
}
