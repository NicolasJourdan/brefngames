package Game.Controller;

import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Scene.Controller.AbstractSceneController;

/**
 * The game controllers have to extend this controller.
 */
public abstract class AbstractGameController extends AbstractSceneController {

    public AbstractGameController(AbstractGameModel model, AbstractGameView view) {
        super(model, view);
    }
}
