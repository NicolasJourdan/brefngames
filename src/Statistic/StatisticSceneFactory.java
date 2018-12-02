package Statistic;

import Scene.Model.Scene;
import Scene.Model.SceneEnum;
import Scene.Model.SceneFactoryInterface;

public class StatisticSceneFactory implements SceneFactoryInterface {
    @Override
    public Scene createScene(SceneEnum sceneEnum) {
        switch (sceneEnum) {
            case STATISTIC_MENU :
                return new StatisticMenuScene();
            case STATISTIC_PLAYER:
                return new StatisticPlayerScene();
            case STATISTIC_TTT:
                return new StatisticTTTScene();
            case STATISTIC_RUNNER:
                return new StatisticRunnerScene();
            case STATISTIC_COOCKIE:
                return new StatisticCCScene();
            case STATISTIC_CONNECT:
                return new StatisticCFScene();
            default:
                throw new RuntimeException("ParametersScene (" + sceneEnum + ") is unknown");
        }
    }
}
