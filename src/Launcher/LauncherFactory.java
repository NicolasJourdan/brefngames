package Launcher;

import Contest.LocalContestScene;
import Contest.OnlineContestScene;
import Credit.CreditScene;
import Menu.MenuScene;
import Parameter.Scenes.ParametersScene;
import Scene.Model.Scene;
import Scene.Model.SceneEnum;
import Scene.Model.SceneFactoryInterface;
import Statistic.StatisticScene;
import Training.TrainingScene;

public class LauncherFactory implements SceneFactoryInterface {

    @Override
    public Scene createScene(SceneEnum sceneEnum) {
        switch (sceneEnum) {
            case MENU:
                return new MenuScene();
            case TRAINING:
                return new TrainingScene();
            case CONTEST:
                return new LocalContestScene();
            case ONLINE_CONTEST:
                return new OnlineContestScene();
            case STATISTICS:
                return new StatisticScene();
            case PARAMETERS:
                return new ParametersScene();
            case CREDITS:
                return new CreditScene();
            case QUIT:
                System.exit(0);
            default:
                throw new RuntimeException("Unexpected scene : " + sceneEnum);
        }
    }
}
