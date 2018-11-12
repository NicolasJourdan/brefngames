package Training;

import Scene.Model.Scene;
import Training.Controller.TrainingController;
import Training.Model.TrainingModel;
import Training.View.TrainingView;

public class TrainingScene extends Scene {

    public TrainingScene() {
        this.model = new TrainingModel();
        this.view = new TrainingView();
        this.controller = new TrainingController(this.model, this.view, this);
    }
}
