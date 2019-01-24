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
                this.setChanged();
                this.notifyObservers(actionEnum);
                return SceneEnum.END_SCENE;
            case STATISTIC_PLAYER:
                return SceneEnum.STATISTIC_PLAYER;
            case STATISTIC_CONNECT_FOUR:
                return SceneEnum.STATISTIC_CONNECT_FOUR;
            case STATISTIC_RUNNER:
                return SceneEnum.STATISTIC_RUNNER;
            case STATISTIC_COOKIE_CLICKER:
                return SceneEnum.STATISTIC_COOKIE_CLICKER;
            case STATISTIC_TICTACTOE:
                return SceneEnum.STATISTIC_TICTACTOE;
            case STATISTIC_HANGMAN:
                return SceneEnum.STATISTIC_HANGMAN;
            case STATISTIC_FIFTEEN_VAINC:
                return SceneEnum.STATISTIC_FIFTEEN_VAINC;
            case STATISTIC_MENU:
                return SceneEnum.STATISTIC_MENU;
            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }
}
