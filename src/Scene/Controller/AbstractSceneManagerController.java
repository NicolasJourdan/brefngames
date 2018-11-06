package Scene.Controller;

import Structure.AbstractController;
import Structure.AbstractModel;
import Structure.AbstractView;

/**
 * Controllers extending this controller manage scenes
 */
public abstract class AbstractSceneManagerController extends AbstractController {

    public AbstractSceneManagerController(AbstractModel model, AbstractView view) {
        super(model, view);
    }
}
