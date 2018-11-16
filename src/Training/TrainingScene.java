package Training;

import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.Scene;
import Scene.View.AbstractSceneManagerView;
import Training.Controller.TrainingController;
import Training.Model.TrainingModel;
import Training.View.TrainingView;

public class TrainingScene extends Scene {

    public TrainingScene() {
        this.model = new TrainingModel();
        this.view = new TrainingView();
        this.controller = new TrainingController((AbstractSceneManagerModel) this.model, (AbstractSceneManagerView) this.view);
        this.controller.addObserver(this);

    }
}
