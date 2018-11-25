package Parameter.Scenes;

import Parameter.Controller.ParametersMenuController;
import Parameter.Model.ParametersMenuModel;
import Parameter.View.ParametersMenuView;
import Scene.Model.Scene;

public class ParametersMenuScene extends Scene {

    public ParametersMenuScene() {
        this.model = new ParametersMenuModel();
        this.view = new ParametersMenuView();
        this.controller = new ParametersMenuController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
