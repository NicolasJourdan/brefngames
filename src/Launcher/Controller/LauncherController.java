package Launcher.Controller;

import Launcher.LauncherFactory;
import Parameter.Model.Configurable;
import Parameter.Model.ParameterEnum;
import Scene.Controller.AbstractSceneManagerController;
import Menu.MenuScene;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

import java.util.*;

/**
 * This is the MasterController (Its view is the window)
 */
public class LauncherController extends AbstractSceneManagerController {

    private Map<ParameterEnum, Configurable> configurations;

    public LauncherController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(model, view, new LauncherFactory());

        this.switchScene(SceneEnum.MENU);
    }

    @Override
    protected SceneEnum getNextScene(ActionEnum actionEnum) {
        switch (actionEnum) {
            case TRAINING:
                return SceneEnum.TRAINING;
            case CONTEST:
                return SceneEnum.CONTEST;
            case STATISTICS:
                return SceneEnum.STATISTICS;
            case PARAMETERS:
                return SceneEnum.PARAMETERS;
            case END_TRAINING:
                return SceneEnum.MENU;
            case QUIT:
                return SceneEnum.QUIT;
            default:
                return SceneEnum.ERROR;
        }
    }
}
