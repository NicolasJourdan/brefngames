package Game.Games.Runner.RunnerModel;

import Game.Games.Runner.RunnerController.ControlEnum;
import Game.Games.Runner.RunnerController.PlayerEnum;
import Game.Model.AbstractGameModel;
import Player.Player;
import Statistic.Model.Statistic;

import java.util.List;

public class RunnerModel extends AbstractGameModel {

    // TODO: choose a value here
    public static int STEPS_AMOUNT = 20;

    private final RunCounter firstPlayerCounter;
    private final RunCounter secondPlayerCounter;

    public RunnerModel(Player[] listPlayers) {
        super(listPlayers);

        this.firstPlayerCounter = new RunCounter(RunnerModel.STEPS_AMOUNT);
        this.secondPlayerCounter = new RunCounter(RunnerModel.STEPS_AMOUNT);
    }

    @Override
    public List<Statistic> getListStatistics() {
        return null;
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
        return RunnerModel.STEPS_AMOUNT;
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
        if (this.firstPlayerCounter.hasFinished()) {
            return true;
        }
        else if(this.secondPlayerCounter.hasFinished()) {
            return true;
        }
        return false;
    }

    public boolean isFirstPlayerWinner() {
        return this.firstPlayerCounter.hasFinished();
    }
}
