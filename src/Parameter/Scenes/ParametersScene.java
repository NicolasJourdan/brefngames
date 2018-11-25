package Parameter.Scenes;

import Parameter.Controller.ParametersController;
import Parameter.Model.ParametersModel;
import Parameter.View.ParametersView;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.Scene;
import Scene.View.AbstractSceneManagerView;

public class ParametersScene extends Scene {

    public ParametersScene() {
        this.model = new ParametersModel();
        this.view = new ParametersView();
        this.controller = new ParametersController((AbstractSceneManagerModel) this.model, (AbstractSceneManagerView) this.view);
        this.controller.addObserver(this);
    }
}
