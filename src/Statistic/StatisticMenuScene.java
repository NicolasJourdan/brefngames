package Statistic;

import Scene.Model.Scene;
import Statistic.Controller.StatisticMenuController;
import Statistic.Model.StatisticMenuModel;
import Statistic.View.StatisticMenuView;

public class StatisticMenuScene extends Scene {
    public StatisticMenuScene() {
        this.model = new StatisticMenuModel();
        this.view = new StatisticMenuView();
        this.controller = new StatisticMenuController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
