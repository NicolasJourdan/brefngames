package Game.Games.Runner.RunnerModel;

import Contest.Model.ContestDataPersistor;
import Game.Games.Runner.RunnerController.ControlEnum;
import Game.Games.Runner.RunnerController.PlayerEnum;
import Game.Games.Runner.RunnerStatsEnum;
import Game.Model.AbstractGameModel;
import Player.Player;
import Repository.Player.PlayerStatsEnum;
import Utils.Chronometer.Chronometer;

import java.util.HashMap;
import java.util.Map;

public class RunnerModel extends AbstractGameModel {

    public final static int DEFAULT_STEPS_AMOUNT = 40;

    private final RunCounter firstPlayerCounter;
    private final RunCounter secondPlayerCounter;

    private Chronometer chronometer;

    public RunnerModel(Player[] listPlayers) {
        super(listPlayers);

        this.firstPlayerCounter = new RunCounter(RunnerModel.DEFAULT_STEPS_AMOUNT);
        this.secondPlayerCounter = new RunCounter(RunnerModel.DEFAULT_STEPS_AMOUNT);

        this.initStatistics();
    }

    /**
     * Return true if the move is legal
     *
     * @param direction
     * @param player
     * @return
     */
    public boolean keyPressed(ControlEnum direction, PlayerEnum player) {
        return PlayerEnum.FIRST_PLAYER == player ?
                this.firstPlayerCounter.registerStep(direction) :
                this.secondPlayerCounter.registerStep(direction);
    }

    public int getStepsAmount() {
        return RunnerModel.DEFAULT_STEPS_AMOUNT;
    }

    public int getRemainingSteps(PlayerEnum player) {
        return PlayerEnum.FIRST_PLAYER == player ?
                this.firstPlayerCounter.getRemainingSteps() :
                this.secondPlayerCounter.getRemainingSteps();
    }

    public boolean isNextKeyLeft(PlayerEnum player) {

        return PlayerEnum.FIRST_PLAYER == player ?
                this.firstPlayerCounter.isNextKeyLeft() :
                this.secondPlayerCounter.isNextKeyLeft();
    }

    public boolean isGameFinished() {
        return this.firstPlayerCounter.hasFinished() || this.secondPlayerCounter.hasFinished();
    }

    public boolean isFirstPlayerWinner() {
        return this.firstPlayerCounter.hasFinished();
    }

    /*
     * Statistics related functions
     */

    private void initStatistics() {
        this.chronometer = new Chronometer();
    }

    protected Map<RunnerStatsEnum, String> gatherStatistics() {
        Map<RunnerStatsEnum, String> statisticsMap = new HashMap<>();

        statisticsMap.put(RunnerStatsEnum.RUNNER_NB_GAMES, "1");

        int nbClicks = (DEFAULT_STEPS_AMOUNT * 2) - this.firstPlayerCounter.getRemainingSteps() - this.secondPlayerCounter.getRemainingSteps();
        statisticsMap.put(RunnerStatsEnum.RUNNER_NB_CLICKS, Integer.toString(nbClicks));

        statisticsMap.put(RunnerStatsEnum.RUNNER_TOTAL_TIME, Integer.toString(this.chronometer.getDuration()));

        return statisticsMap;
    }

    protected Map gatherFirstPlayerStatistics() {
        Map<PlayerStatsEnum, String> statisticsMap = new HashMap<>();

        statisticsMap.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        statisticsMap.put(PlayerStatsEnum.TOTAL_NB_WIN, this.isFirstPlayerWinner() ? "1" : "0");
        statisticsMap.put(PlayerStatsEnum.TOTAL_NB_LOOSE, this.isFirstPlayerWinner() ? "0" : "1");
        statisticsMap.put(PlayerStatsEnum.RUNNER_NB_GAME, "1");
        statisticsMap.put(PlayerStatsEnum.RUNNER_NB_WIN, this.isFirstPlayerWinner() ? "1" : "0");

        return statisticsMap;
    }

    protected Map gatherSecondPlayerStatistics() {
        Map<PlayerStatsEnum, String> statisticsMap = new HashMap<>();

        statisticsMap.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        statisticsMap.put(PlayerStatsEnum.TOTAL_NB_WIN, !this.isFirstPlayerWinner() ? "1" : "0");
        statisticsMap.put(PlayerStatsEnum.TOTAL_NB_LOOSE, !this.isFirstPlayerWinner() ? "0" : "1");
        statisticsMap.put(PlayerStatsEnum.RUNNER_NB_GAME, "1");
        statisticsMap.put(PlayerStatsEnum.RUNNER_NB_WIN, !this.isFirstPlayerWinner() ? "1" : "0");

        return statisticsMap;
    }

    public void saveStatistics() {
        Map firstPlayerStatisticsMap = this.gatherFirstPlayerStatistics();
        ContestDataPersistor.updateDataPlayer(
                this.listPlayers[0].getName(),
                firstPlayerStatisticsMap
        );

        Map secondPlayerStatisticsMap = this.gatherSecondPlayerStatistics();
        ContestDataPersistor.updateDataPlayer(
                this.listPlayers[1].getName(),
                secondPlayerStatisticsMap
        );

        Map statisticsMap = this.gatherStatistics();
        ContestDataPersistor.updateRunner(statisticsMap);
    }
}
