package Parameter.Scenes;

import Parameter.Controller.ParametersDefaultPlayerController;
import Parameter.Model.ParametersDefaultPlayerModel;
import Parameter.View.ParametersDefaultPlayerView;
import Scene.Model.Scene;

public class ParametersDefaultPlayerScene extends Scene {

    public ParametersDefaultPlayerScene() {
        this.model = new ParametersDefaultPlayerModel();
        this.view = new ParametersDefaultPlayerView();
        this.controller = new ParametersDefaultPlayerController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
