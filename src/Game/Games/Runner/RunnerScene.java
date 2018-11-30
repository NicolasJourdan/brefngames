package Game.Games.Runner;

import Game.GameScene;
import Game.Games.Runner.RunnerController.RunnerController;
import Game.Games.Runner.RunnerModel.RunnerModel;
import Game.Games.Runner.RunnerView.RunnerView;
import Player.Player;

public class RunnerScene extends GameScene {

    public RunnerScene(Player[] listPlayers, boolean isTraining) {
        this.model = new RunnerModel(listPlayers);
        this.view = new RunnerView();
        this.controller = new RunnerController((RunnerModel) this.model, (RunnerView) this.view, isTraining);
        this.controller.addObserver(this);
    }
}
