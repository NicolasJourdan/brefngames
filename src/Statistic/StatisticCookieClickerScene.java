package Statistic;

import Scene.Model.Scene;
import Statistic.Controller.StatisticCookieClickerController;
import Statistic.Model.StatisticCookieClickerModel;
import Statistic.View.StatisticCookieClickerView;

public class StatisticCookieClickerScene extends Scene {
    public StatisticCookieClickerScene() {
        this.model = new StatisticCookieClickerModel();
        this.view = new StatisticCookieClickerView();
        this.controller = new StatisticCookieClickerController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
