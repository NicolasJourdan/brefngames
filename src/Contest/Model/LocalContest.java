package Contest.Model;

import Game.Model.GameEnum;

/**
 * @author BrefNGames
 */
public class LocalContest extends AbstractContest {

    /**
     * Total amount of matches
     */
    private int matchesAmount;

    /**
     * Number of matches played, keeps track of the current game
     */
    private int matchesPlayed;

    /**
     * Types of game tha will be played
     */
    private GameEnum[] gameTypes;

    /**
     * Set up the settings of a contests
     *
     * @param matchesAmount
     * @param gameTypes
     */
    public void setUpContest(int matchesAmount, GameEnum[] gameTypes)
    {
        this.matchesAmount = matchesAmount;
        this.matchesPlayed = 0;
        this.gameTypes = gameTypes;
    }
}
