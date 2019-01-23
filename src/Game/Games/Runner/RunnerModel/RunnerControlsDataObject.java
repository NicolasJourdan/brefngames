package Game.Games.Runner.RunnerModel;

import java.io.Serializable;

public class RunnerControlsDataObject implements Serializable {

    private boolean isNextKeyLeft;
    private int stepsAmount;

    public RunnerControlsDataObject(boolean isNextKeyLeft, int stepsAmount) {
        this.isNextKeyLeft = isNextKeyLeft;
        this.stepsAmount = stepsAmount;
    }

    public boolean isNextKeyLeft() {
        return this.isNextKeyLeft;
    }

    public int getStepsAmount() {
        return this.stepsAmount;
    }
}
