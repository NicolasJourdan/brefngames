package ContestSettings;

import ContestSettings.Controller.ContestSettingsController;
import ContestSettings.Model.ContestSettingsModel;
import ContestSettings.View.ContestSettingsView;
import Game.GameScene;

public class ContestSettingsScene extends GameScene {

    public ContestSettingsScene() {
        this.model = new ContestSettingsModel();
        this.view = new ContestSettingsView();
        this.controller = new ContestSettingsController(
            this.model,
            this.view
        );
        this.controller.addObserver(this);
    }
}
