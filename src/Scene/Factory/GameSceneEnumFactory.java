package Scene.Factory;

import Game.Model.GameEnum;
import Scene.Model.SceneEnum;

public class GameSceneEnumFactory {
    public static SceneEnum createSceneEnum(GameEnum gameEnum) {
        switch (gameEnum) {
            case RUNNER:
                return SceneEnum.RUNNER;
            case CONNECT_FOUR:
                return SceneEnum.CONNECT_FOUR;
            case COOKIE_CLICKER:
                return SceneEnum.COOKIE_CLICKER;
            case TIC_TAC_TOE:
                return SceneEnum.TIC_TAC_TOE;
            case HANGMAN:
                return SceneEnum.HANGMAN;
            default:
                throw new RuntimeException("GameEnum (" + gameEnum + ") is unknown");
        }
    }
}
