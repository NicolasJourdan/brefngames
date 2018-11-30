package Game.Games.Runner.RunnerController;

import Game.Controller.AbstractGameController;
import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Scene.Model.ActionEnum;

import java.util.Observable;

public class RunnerController extends AbstractGameController {
    public RunnerController(AbstractGameModel model, AbstractGameView view, boolean isTraining) {
        super(model, view, isTraining);
    }

    @Override
    public void update(Observable o, Object arg) {
        switch ((ActionEnum) arg) {
            case KEY_PRESS_A:
            case KEY_PRESS_Z:
            case KEY_PRESS_R:
            case KEY_PRESS_T:
                System.out.println(arg);
                break;
        }
    }
}
