package Game.Games.Runner.RunnerModel;

import Game.Games.Runner.RunnerController.ControlEnum;
import Game.Games.Runner.RunnerController.PlayerEnum;
import Game.Model.AbstractGameModel;
import Player.Player;

public class RunnerModel extends AbstractGameModel {

    public final static int DEFAULT_STEPS_AMOUNT = 40;

    private final RunCounter firstPlayerCounter;
    private final RunCounter secondPlayerCounter;

    public RunnerModel(Player[] listPlayers) {
        super(listPlayers);

        this.firstPlayerCounter = new RunCounter(RunnerModel.DEFAULT_STEPS_AMOUNT);
        this.secondPlayerCounter = new RunCounter(RunnerModel.DEFAULT_STEPS_AMOUNT);
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
}
