package Game.Games.Runner.RunnerModel;

import Game.Games.Runner.RunnerController.ControlEnum;

public class RunCounter {
    private boolean isLeftNextDirection;
    private int remainingSteps;

    public RunCounter(int stepAmount) {
        this.remainingSteps = stepAmount;
        this.isLeftNextDirection = true;
    }

    /**
     * Return true if the step is legal
     *
     * @param controlEnum
     * @return
     */
    public boolean registerStep(ControlEnum controlEnum) {
        if (
            (ControlEnum.LEFT == controlEnum && this.isLeftNextDirection) ||
            (ControlEnum.RIGHT == controlEnum && !this.isLeftNextDirection)
            ) {
            // the step is legal
            this.remainingSteps--;
            this.isLeftNextDirection = !this.isLeftNextDirection;

            return true;
        }
        return false;
    }

    public int getRemainingSteps() {
        return remainingSteps;
    }

    public boolean hasFinished() {
        return this.remainingSteps <= 0;
    }

    public boolean isNextKeyLeft() {
        return this.isLeftNextDirection;
    }
}
