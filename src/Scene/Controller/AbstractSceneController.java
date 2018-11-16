package Scene.Controller;

import Scene.Model.ActionEnum;
import Structure.AbstractController;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.Observable;

public abstract class AbstractSceneController extends AbstractController {

    public AbstractSceneController(AbstractModel model, AbstractView view) {
        super(model, view);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setChanged();
        this.notifyObservers((ActionEnum) arg);
    }
}
