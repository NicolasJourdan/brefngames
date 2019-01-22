package ContestSettings;

import ContestSettings.Controller.ClientContestSettingsController;
import ContestSettings.Controller.ContestSettingsController;
import ContestSettings.Controller.ServerContestSettingsController;
import ContestSettings.DataObject.ContestSettingsDataObject;
import ContestSettings.Model.ContestSettingsModel;
import ContestSettings.Model.OnlineContestSettingsModel;
import ContestSettings.View.ContestSettingsView;
import Game.GameScene;
import Online.Socket.SocketCommunicatorService;

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

    public ContestSettingsScene(boolean isServer, SocketCommunicatorService socketCommunicatorService) {
        this.model = new OnlineContestSettingsModel();
        this.view = new ContestSettingsView();
        this.controller = isServer ? new ServerContestSettingsController(this.model, this.view, socketCommunicatorService) :
                new ClientContestSettingsController(this.model, this.view, socketCommunicatorService);
        this.controller.addObserver(this);
    }

    /**
     * @return ContestSettingsDataObject
     */
    public ContestSettingsDataObject getSettingsDataObject() {
        return ((ContestSettingsController) this.controller).getSettingsDataObject();
    }
}
