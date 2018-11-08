package Scene.Controller;

import Scene.Model.SceneEnum;
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

    public void switchScene(SceneEnum sceneEnum) {
        // Factoru.create(sceneEnum)
    }
}
