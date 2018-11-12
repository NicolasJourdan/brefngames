package Launcher.Controller;

import Parameter.Model.Configurable;
import Parameter.Model.ParameterEnum;
import Scene.Controller.AbstractSceneManagerController;
import Menu.MenuScene;
import Scene.Model.Scene;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.*;

/**
 * This is the MasterController (Its view is the window)
 */
public class LauncherController extends AbstractSceneManagerController {

    private Map<ParameterEnum, Configurable> configurations;

    public LauncherController(AbstractModel model, AbstractView view) {
        super(model, view);

        // create scene menu
        this.currentScene = new MenuScene();
        this.currentScene.addObserver(this);
        this.view.add(this.currentScene.getView());
        this.view.repaint();
        this.view.validate();
    }

    @Override
    public void update(Observable o, Object arg) {
        // Scene.end()
    }

    // TODO switchScenes or something like that
}
