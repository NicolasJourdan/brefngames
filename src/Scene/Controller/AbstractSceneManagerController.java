package Scene.Controller;

import Scene.Model.*;
import Scene.View.*;
import Structure.AbstractController;

import java.util.Observable;

/**
 * Controllers extending this controller manage scenes
 */
public abstract class AbstractSceneManagerController extends AbstractController {

    protected SceneFactoryInterface sceneFactory;
    protected Scene currentScene;

    public AbstractSceneManagerController(AbstractSceneManagerModel model, AbstractSceneManagerView view, SceneFactoryInterface sceneFactory) {
        super(model, view);
        this.sceneFactory = sceneFactory;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.switchScene(this.getNextScene((ActionEnum) arg));
    }

    protected abstract SceneEnum getNextScene(ActionEnum arg);

    protected void switchScene(SceneEnum sceneEnum) {
        this.currentScene = this.sceneFactory.createScene(sceneEnum);
        this.currentScene.addObserver(this);
        ((AbstractSceneManagerView) this.view).changeCurrentPanel(this.currentScene.getView());
    };
}
