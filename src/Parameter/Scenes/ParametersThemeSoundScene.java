package Parameter.Scenes;

import Parameter.Controller.ParametersThemeSoundController;
import Parameter.Model.ParametersThemeSoundModel;
import Parameter.View.ParametersThemeSoundView;
import Scene.Model.Scene;

public class ParametersThemeSoundScene extends Scene {

    public ParametersThemeSoundScene() {
        this.model = new ParametersThemeSoundModel();
        this.view = new ParametersThemeSoundView();
        this.controller = new ParametersThemeSoundController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
