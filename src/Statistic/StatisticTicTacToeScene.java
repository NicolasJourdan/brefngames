package Statistic;

import Scene.Model.Scene;
import Statistic.Controller.StatisticTicTacToeController;
import Statistic.Model.StatisticTicTacToeModel;
import Statistic.View.StatisticTicTacToeView;

public class StatisticTicTacToeScene extends Scene {
    public StatisticTicTacToeScene() {
        this.model = new StatisticTicTacToeModel();
        this.view = new StatisticTicTacToeView();
        this.controller = new StatisticTicTacToeController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
