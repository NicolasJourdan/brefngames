package Parameter.Controller;

import Parameter.ParameterSceneFactory;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

public class ParametersController extends AbstractSceneManagerController {

    public ParametersController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(model, view, new ParameterSceneFactory());

        this.switchScene(SceneEnum.PARAMETERS_MENU);
    }

    @Override
    protected SceneEnum getNextScene(ActionEnum actionEnum) {
        switch (actionEnum) {
            case END_PARAMETERS:
                // Call the parent (TrainingScene), this parent will call its own parent (LauncherController)
                // to change the current scene and destroy this scene manager controller
                this.setChanged();
                this.notifyObservers(actionEnum);
                return SceneEnum.END_SCENE;
            case THEME_SOUND_PARAMETERS:
                return SceneEnum.THEME_SOUND_PARAMETERS;
            case PLAYER_PARAMETERS:
                return SceneEnum.PLAYER_PARAMETERS;
            case PARAMETERS_MENU:
                return SceneEnum.PARAMETERS_MENU;
            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }
}
