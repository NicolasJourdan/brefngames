package Statistic;

import Scene.Model.Scene;
import Statistic.Controller.StatisticConnectFourController;
import Statistic.Model.StatisticConnectFourModel;
import Statistic.View.StatisticConnectFourView;

public class StatisticConnectFourScene extends Scene {
    public StatisticConnectFourScene() {
        this.model = new StatisticConnectFourModel();
        this.view = new StatisticConnectFourView();
        this.controller = new StatisticConnectFourController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
