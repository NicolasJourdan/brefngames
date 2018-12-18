package Game.Controller;

import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Scene.Controller.AbstractSceneController;

/**
 * The game controllers have to extend this controller.
 */
public abstract class AbstractGameController extends AbstractSceneController {
    protected boolean isTraining;

    public AbstractGameController(AbstractGameModel model, AbstractGameView view, boolean isTraining) {
        super(model, view);
        this.isTraining = isTraining;
        if (this.isTraining){
            ((AbstractGameView) this.view).setScoreDisplay(false);
        }
    }
}
