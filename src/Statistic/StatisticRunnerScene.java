package Statistic;

import Scene.Model.Scene;
import Statistic.Controller.StatisticRunnerController;
import Statistic.Model.StatisticRunnerModel;
import Statistic.View.StatisticRunnerView;

public class StatisticRunnerScene extends Scene {
    public StatisticRunnerScene() {
        this.model = new StatisticRunnerModel();
        this.view = new StatisticRunnerView();
        this.controller = new StatisticRunnerController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
