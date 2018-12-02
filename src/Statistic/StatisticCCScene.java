package Statistic;

import Scene.Model.Scene;
import Statistic.Controller.StatisticCCController;
import Statistic.Model.StatisticCCModel;
import Statistic.View.StatisticCCView;

public class StatisticCCScene extends Scene {
    public StatisticCCScene() {
        this.model = new StatisticCCModel();
        this.view = new StatisticCCView();
        this.controller = new StatisticCCController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
