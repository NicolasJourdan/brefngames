package Launcher.Controller;

import Launcher.LauncherFactory;
import Parameter.Model.Parameters;
import Parameter.Parameters.Configurable;
import Parameter.Model.ParameterEnum;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

import java.util.*;

/**
 * This is the MasterController (Its view is the window)
 */
public class LauncherController extends AbstractSceneManagerController {

    private static Map<ParameterEnum, Configurable> configuration = Parameters.getConfiguration();

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
            case ONLINE_CONTEST:
                return SceneEnum.ONLINE_CONTEST;
            case STATISTICS:
                return SceneEnum.STATISTICS;
            case PARAMETERS:
                return SceneEnum.PARAMETERS;
            case CREDITS:
                return SceneEnum.CREDITS;
            case END_STATISTIC:
            case END_PARAMETERS:
            case END_CONTEST:
            case END_ONLINE_CONTEST:
            case END_TRAINING:
            case END_CREDITS:
                return SceneEnum.MENU;
            case QUIT:
                return SceneEnum.QUIT;
            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }

    public static Map<ParameterEnum, Configurable> getConfiguration() {
        return configuration;
    }

    public static void reloadConfiguration() {
        LauncherController.configuration = Parameters.getConfiguration();
    }
}
