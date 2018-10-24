package Game;

import java.util.*;

/**
 * @author BrefNGames
 */
public abstract class Game {

    /**
     * Default constructor
     */
    public Game() {
    }

    /**
     * 
     */
    private Player[] ListPlayers;

    /**
     * 
     */
    private Set<Statistic> ListStatistics;







    /**
     * Returns an array of string of all needed param keys
     */
    public static abstract void getNeededParams();

}