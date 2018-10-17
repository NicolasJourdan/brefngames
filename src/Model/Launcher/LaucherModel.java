package Model.Launcher;

import Controller.AbstractSceneController;
import Model.DummyModel;
import Controller.DummyController;
import Model.Launcher.Scene.Action;
import Model.Launcher.Scene.Scene;
import Model.Model;
import Observer.Observer;
import View.DummyView;

public class LaucherModel extends Model implements Observer {
    
    private Scene scene;

    public LaucherModel() {
        AbstractSceneController controller = new DummyController(
            new DummyModel(),
            new DummyView(),
            Action.Menu
        );
        this.scene = new Scene(controller);
        this.scene.addObserver(this);
        controller.setScene(scene);
    }
    
    /*
     * Observer methods
     */

    @Override
    public void update() {
        this.updateScene();
    }

    private void updateScene() {
        switch(this.scene.getAction()) {
            case Menu:
            case Contest:
            case Training:
            case Configure:
                AbstractSceneController controller = new DummyController(
                    new DummyModel(),
                    new DummyView(),
                    this.scene.getAction()
                );
                this.scene = new Scene(controller);
                this.scene.addObserver(this);
                controller.setScene(scene);
            case Quit:
                System.exit(0);
                break;
        }
    }
    
}
