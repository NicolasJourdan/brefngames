package Statistic;

import Scene.Model.Scene;
import Statistic.Controller.StatisticCFController;
import Statistic.Model.StatisticCFModel;
import Statistic.View.StatisticCFView;

public class StatisticCFScene extends Scene {
    public StatisticCFScene() {
        this.model = new StatisticCFModel();
        this.view = new StatisticCFView();
        this.controller = new StatisticCFController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
