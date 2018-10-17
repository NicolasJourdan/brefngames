package Model.Launcher.Scene;

import Controller.AbstractSceneController;
import Controller.Controller;
import Observer.Observable;
import Observer.Observer;
import java.util.ArrayList;
import javax.swing.JComponent;


public class Scene implements Observable {

    private final AbstractSceneController controller;
    private final ArrayList<Observer> observers;
    private Action action;

    public Scene(AbstractSceneController controller) {
        this.observers = new ArrayList<>();
        this.controller = controller;
        this.controller.setScene(this);
    }

    public JComponent getView() {
        return this.controller.getViewComponent();
    }
    
    public void notify(Action action) {
        this.action = action;
        this.notifyObservers();
    }
    
    public Action getAction() {
        return this.action;
    }

    /*
     * Observer functions
     */
    
    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update();
        }
    }
    
}
