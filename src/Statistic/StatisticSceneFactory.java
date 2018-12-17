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
            case STATISTIC_TICTACTOE:
                return new StatisticTicTacToeScene();
            case STATISTIC_RUNNER:
                return new StatisticRunnerScene();
            case STATISTIC_COOKIE_CLICKER:
                return new StatisticCookieClickerScene();
            case STATISTIC_CONNECT_FOUR:
                return new StatisticConnectFourScene();
            default:
                throw new RuntimeException("ParametersScene (" + sceneEnum + ") is unknown");
        }
    }
}
