package Training;

import Game.GameScene;
import Training.Controller.TrainingMenuController;
import Training.Model.TrainingMenuModel;
import Training.View.TrainingMenuView;

public class TrainingMenuScene extends GameScene {

    public TrainingMenuScene() {
        this.model = new TrainingMenuModel();
        this.view = new TrainingMenuView();
        this.controller = new TrainingMenuController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
