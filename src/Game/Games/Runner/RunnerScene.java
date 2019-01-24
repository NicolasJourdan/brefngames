package Game.Games.Runner;

import Game.GameScene;
import Game.Games.Runner.RunnerController.ClientRunnerController;
import Game.Games.Runner.RunnerController.RunnerController;
import Game.Games.Runner.RunnerController.ServerRunnerController;
import Game.Games.Runner.RunnerModel.ClientRunnerModel;
import Game.Games.Runner.RunnerModel.RunnerModel;
import Game.Games.Runner.RunnerModel.ServerRunnerModel;
import Game.Games.Runner.RunnerView.RunnerView;
import Map.Model.History;
import Online.Socket.SocketCommunicatorService;
import Player.Player;

public class RunnerScene extends GameScene {

    public RunnerScene(Player[] listPlayers, boolean isTraining, int[] scores) {
        this.model = new RunnerModel(listPlayers);
        this.view = new RunnerView(listPlayers, scores);
        this.controller = new RunnerController((RunnerModel) this.model, (RunnerView) this.view, isTraining);
        this.controller.addObserver(this);
    }

    public RunnerScene(Player[] listPlayers, boolean isTraining, int[] scores, boolean isServer, SocketCommunicatorService socketCommunicatorService) {
        this.model = isServer ?
                new ServerRunnerModel(listPlayers) :
                new ClientRunnerModel(listPlayers);
        this.view = new RunnerView(listPlayers, scores);
        this.controller = isServer ?
                new ServerRunnerController((RunnerModel) this.model, (RunnerView) this.view, isTraining, socketCommunicatorService) :
                new ClientRunnerController((RunnerModel) this.model, (RunnerView) this.view, isTraining, socketCommunicatorService)
        ;
        this.controller.addObserver(this);
    }
}
