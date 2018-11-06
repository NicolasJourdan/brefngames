package Launcher.Controller;

import Launcher.Model.LauncherModel;
import Launcher.View.LauncherView;
import Parameter.Model.Configurable;
import Parameter.Model.ParametersEnum;
import Scene.Controller.AbstractSceneManagerController;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.*;

/**
 * This is the MasterController (Its view is the window)
 */
public class LauncherController extends AbstractSceneManagerController {

    private LauncherModel launcherModel;

    private LauncherView launcherView;

    private Map<ParametersEnum, Configurable> configurations;

    public LauncherController(AbstractModel model, AbstractView view) {
        super(model, view);
    }

    // TODO switchScenes or something like that
}
