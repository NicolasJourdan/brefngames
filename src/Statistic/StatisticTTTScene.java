package Statistic;

import Scene.Model.Scene;
import Statistic.Controller.StatisticTTTController;
import Statistic.Model.StatisticTTTModel;
import Statistic.View.StatisticTTTView;

public class StatisticTTTScene extends Scene {
    public StatisticTTTScene() {
        this.model = new StatisticTTTModel();
        this.view = new StatisticTTTView();
        this.controller = new StatisticTTTController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
