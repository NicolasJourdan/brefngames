package Contest.Model;

import ContestSettings.DataObject.ContestSettingsDataObject;
import Game.GameScene;
import Game.Model.GameEnum;
import Map.Model.GameHistory;
import Map.Model.History;
import Player.*;
import Repository.Player.PlayerRepository;
import Repository.Player.PlayerStatsEnum;
import Repository.Player.PlayerStatsRepository;
import Scene.Factory.GameSceneEnumFactory;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
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

    /**
     * Array containing the playing players
     */
    protected Player[] playersList;

    /**
     * Type of the current game
     */
    private GameEnum currentGameType;

    /**
     * The current game
     */
    private GameScene currentGameScene;

    /**
     * History for the map
     */
    private History history;

    /**
     * Stores if the next is the map
     */
    private boolean nextSceneIsMap;

    /**
     * @return Player[]
     */
    public Player[] getPlayersList() {
        return this.playersList;
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

        Map<PlayerStatsEnum, String> firstPlayerStats = PlayerStatsRepository.getByPlayerId(settingsDataObject.getFirstPlayerName());
        Map<PlayerStatsEnum, String> secondPlayerStats = PlayerStatsRepository.getByPlayerId(settingsDataObject.getSecondPlayerName());

        this.playersList = new  Player[2];
        this.playersList[0] = new LocalPlayer(
            settingsDataObject.getFirstPlayerName(),
            settingsDataObject.getFirstPlayerColor(),
            settingsDataObject.getFirstPlayerIcon(),
            (null == firstPlayerStats) ? AbstractPlayer.initialStatsMap() : firstPlayerStats
        );

        this.playersList[1] = new LocalPlayer(
            settingsDataObject.getSecondPlayerName(),
            settingsDataObject.getSecondPlayerColor(),
            settingsDataObject.getSecondPlayerIcon(),
            (null == secondPlayerStats) ? AbstractPlayer.initialStatsMap() : secondPlayerStats
        );

        PlayerRepository.save(this.playersList[0]);
        PlayerRepository.save(this.playersList[1]);

        this.history = new History(
            this.playersList,
            new ArrayList<GameHistory>(),
            this.matchesAmount,
            false
        );

        this.nextSceneIsMap = true;
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
        // if next scene is a map
        if (this.nextSceneIsMap) {
            this.nextSceneIsMap = false;
            return SceneEnum.MAP;
        }
        this.nextSceneIsMap = true;

        if (this.matchesPlayed >= this.matchesAmount) { // no more games to be played
            return SceneEnum.CONTEST_FINISHED;
        }

        // randomize next game type and return corresponding SceneEnum
        this.currentGameType = this.getNextGameType();
        return GameSceneEnumFactory.createSceneEnum(
            this.currentGameType
        );
    }

    /**
     * save the winner of the current game
     * null for a draw
     *
     * @param action
     */
    public void setWinner(ActionEnum action) {
        Player winner = null;
        switch (action) {
            case PLAYER_1_WON:
                winner = this.playersList[0];
            case PLAYER_2_WON:
                winner = this.playersList[1];
            case DRAW:
                break;
            default:
                throw new RuntimeException("Illegal ActionEnum " + action + " used");
        }

        // update history for the map
        this.history.addGameHistory(
            new GameHistory(
                GameSceneEnumFactory.createSceneEnum(this.currentGameType),
                this.playersList,
                action
            )
        );

        this.matchesPlayed++;
    }

    public History getHistory() {
        return history;
    }
}
