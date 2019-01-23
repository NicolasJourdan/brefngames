package Scene.Model;

import Structure.AbstractController;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.Observable;
import java.util.Observer;

public abstract class Scene extends Observable implements Observer {

    protected AbstractController controller;

    protected AbstractModel model;

    protected AbstractView view;

    @Override
    public void update(Observable o, Object arg) {
        this.setChanged();
        this.notifyObservers((ActionEnum) arg);
    }

    public AbstractView getView() {
        return this.view;
    }

    public Object getController() {
        return this.controller;
    }
}
