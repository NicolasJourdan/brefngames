package Contest.Model;

import ContestSettings.DataObject.ContestSettingsDataObject;
import Game.GameScene;
import Game.Model.GameEnum;
import Player.Player;
import Player.LocalPlayer;
import Scene.Model.AbstractSceneManagerModel;

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
}
