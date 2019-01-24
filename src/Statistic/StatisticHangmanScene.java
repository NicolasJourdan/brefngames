package Statistic;

import Scene.Model.Scene;
import Statistic.Controller.StatisticHangmanController;
import Statistic.Model.StatisticHangmanModel;
import Statistic.View.StatisticHangmanView;

public class StatisticHangmanScene extends Scene {
    public StatisticHangmanScene() {
        this.model = new StatisticHangmanModel();
        this.view = new StatisticHangmanView();
        this.controller = new StatisticHangmanController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
