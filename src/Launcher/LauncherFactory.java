package Launcher;

import Menu.MenuScene;
import Scene.Model.Scene;
import Scene.Model.SceneEnum;
import Scene.Model.SceneFactoryInterface;
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
            case STATISTICS:
            case PARAMETERS:
            case QUIT:
            default:
                // TODO
                return new MenuScene();
        }
    }
}
