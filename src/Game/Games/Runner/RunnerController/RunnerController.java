package Game.Games.Runner.RunnerController;

import Game.Controller.AbstractGameController;
import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;

public class RunnerController extends AbstractGameController {
    public RunnerController(AbstractGameModel model, AbstractGameView view, boolean isTraining) {
        super(model, view, isTraining);
    }
}
