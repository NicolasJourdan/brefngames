package Scene.Controller;

import Scene.Model.ActionEnum;
import Scene.Model.Scene;
import Structure.AbstractController;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.Observable;

public abstract class AbstractSceneController extends AbstractController {

    protected Scene scene;

    public AbstractSceneController(AbstractModel model, AbstractView view, Scene scene) {
        super(model, view);
        this.scene = scene;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.scene.end((ActionEnum) arg);
    }
}
