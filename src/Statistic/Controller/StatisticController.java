package Statistic.Controller;

import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.*;
import Scene.View.AbstractSceneManagerView;
import Statistic.StatisticSceneFactory;

public class StatisticController extends AbstractSceneManagerController {
    /**
     * The constructor for the root scene manager controller (LauncherController)
     *
     * @param model
     * @param view
     */
    public StatisticController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(  model,
                view,
                new StatisticSceneFactory()
                );
        this.switchScene(SceneEnum.STATISTIC_MENU);
    }

    @Override
    protected SceneEnum getNextScene(ActionEnum actionEnum) {
        switch (actionEnum) {
            case END_STATISTIC:
                // Call the parent (ParametersScene), this parent will call its own parent (LauncherController)
                // to change the current scene and destroy this scene manager controller
                this.setChanged();
                this.notifyObservers(actionEnum);
                return SceneEnum.END_SCENE;
            case STATISTIC_PLAYER:
                return SceneEnum.STATISTIC_PLAYER;
            case STATISTIC_CONNECT:
                return SceneEnum.STATISTIC_CONNECT;
            case STATISTIC_RUNNER:
                return SceneEnum.STATISTIC_RUNNER;
            case STATISTIC_COOCKIE:
                return SceneEnum.STATISTIC_COOCKIE;
            case STATISTIC_TTT:
                return SceneEnum.STATISTIC_TTT;
            case STATISTIC_MENU:
                return SceneEnum.STATISTIC_MENU;
            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }
}
