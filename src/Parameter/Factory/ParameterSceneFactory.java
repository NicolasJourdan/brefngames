package Parameter.Factory;

import Parameter.Scenes.ParametersDefaultPlayerScene;
import Parameter.Scenes.ParametersMenuScene;
import Parameter.Scenes.ParametersThemeSoundScene;
import Scene.Model.Scene;
import Scene.Model.SceneEnum;
import Scene.Model.SceneFactoryInterface;

public class ParameterSceneFactory implements SceneFactoryInterface {

    @Override
    public Scene createScene(SceneEnum sceneEnum) {
        switch (sceneEnum) {
            case PARAMETERS_MENU:
                return new ParametersMenuScene();
            case THEME_SOUND_PARAMETERS:
                return new ParametersThemeSoundScene();
            case PLAYER_PARAMETERS:
                return new ParametersDefaultPlayerScene();
            default:
                throw new RuntimeException("ParametersScene (" + sceneEnum + ") is unknown");
        }
    }
}
