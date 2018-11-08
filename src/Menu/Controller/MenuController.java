package Menu.Controller;

import Scene.Controller.AbstractSceneController;
import Scene.Model.ActionEnum;
import Scene.Model.Scene;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.Observable;

public class MenuController extends AbstractSceneController {

    public MenuController(AbstractModel model, AbstractView view, Scene scene) {
        super(model, view, scene);
    }

    @Override
    public void update(Observable o, Object arg) {
    }
}
