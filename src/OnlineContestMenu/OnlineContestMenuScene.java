package OnlineContestMenu;

import Game.GameScene;
import OnlineContestMenu.Controller.OnlineContestMenuController;
import OnlineContestMenu.Model.OnlineContestMenuModel;
import OnlineContestMenu.View.OnlineContestMenuView;

public class OnlineContestMenuScene extends GameScene {
    public OnlineContestMenuScene() {
        this.model = new OnlineContestMenuModel();
        this.view = new OnlineContestMenuView();
        this.controller = new OnlineContestMenuController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
