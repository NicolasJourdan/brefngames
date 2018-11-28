package Contest.Model;

import ContestSettings.DataObject.ContestSettingsDataObject;
import Game.GameScene;
import Game.Model.GameEnum;
import Player.Player;
import Player.LocalPlayer;
import Scene.Factory.GameSceneEnumFactory;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.SceneEnum;

import java.util.*;

public abstract class AbstractContest extends AbstractSceneManagerModel {

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
    private List<GameEnum> gameTypes;

    /**
     * List of games
     */
    private List<GameScene> gameSceneList;

    protected Player[] playerList;

    /**
     * The current game
     */
    private GameScene currentGameScene;

    public Player[] getPlayerList() {
        return playerList;
    }

    /**
     * Set up the settings of a contests
     *
     * @param settingsDataObject
     */
    public void setUpContest(ContestSettingsDataObject settingsDataObject) {
        this.matchesAmount = settingsDataObject.getNumberOfMatches();
        this.matchesPlayed = 0;

        this.gameTypes = settingsDataObject.getSelectedGameTypes();

        this.playerList = new  Player[2];
        this.playerList[0] = new LocalPlayer(
            settingsDataObject.getFirstPlayerName(),
            settingsDataObject.getFirstPlayerColor(),
            settingsDataObject.getFirstPlayerIcon()
        );
        this.playerList[1] = new LocalPlayer(
            settingsDataObject.getSecondPlayerName(),
            settingsDataObject.getSecondPlayerColor(),
            settingsDataObject.getSecondPlayerIcon()
        );
    }

    /**
     * Randomize the next game type to be played
     *
     * @return GameEnum
     */
    private GameEnum getNextGameType() {
        Random random = new Random();
        return this.gameTypes.get(
            random.nextInt(this.gameTypes.size())
        );
    }

    /**
     * Randomize next game type and return corresponding SceneEnum
     *
     * @return SceneEnum
     */
    public SceneEnum getNextGameScene() {
        if (this.matchesPlayed >= this.matchesAmount) { // no more games to be played
            return SceneEnum.CONTEST_FINISHED;
        }

        this.matchesPlayed++;

        // randomize next game type and return corresponding SceneEnum
        return GameSceneEnumFactory.createSceneEnum(
            this.getNextGameType()
        );
    }
}
