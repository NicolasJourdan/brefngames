package Scene.Model;

import Structure.AbstractController;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.Observable;

public abstract class Scene extends Observable {

    protected AbstractController controller;

    protected AbstractModel model;

    protected AbstractView view;

    public void end(ActionEnum actionEnum) {
        this.setChanged();
        this.notifyObservers(actionEnum);
    }

    public AbstractView getView() {
        return this.view;
    }
}
