package Scene.Controller;

import Scene.Model.Scene;
import Structure.AbstractController;
import Structure.AbstractModel;
import Structure.AbstractView;

public abstract class AbstractSceneController extends AbstractController {

    protected Scene scene;

    public AbstractSceneController(AbstractModel model, AbstractView view, Scene scene) {
        super(model, view);
        this.scene = scene;

    }
}
