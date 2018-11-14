package Game.Controller;

import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Parameter.Model.ParameterEnum;
import Scene.Controller.AbstractSceneController;
import Scene.Model.Scene;

import java.util.List;

/**
 * The game controllers have to extend this controller.
 */
public abstract class AbstractGameController extends AbstractSceneController {

    public AbstractGameController(AbstractGameModel model, AbstractGameView view, Scene scene) {
        super(model, view, scene);
    }

    /**
     * Returns an array of string of all needed parameters keys
     */
    public abstract List<ParameterEnum> getNeededParams();

}
