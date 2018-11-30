package Statistic;

import Scene.Model.Scene;
import Statistic.Controller.StatisticPlayerController;
import Statistic.Model.StatisticPlayerModel;
import Statistic.View.StatisticPlayerView;

public class StatisticPlayerScene extends Scene {
    public StatisticPlayerScene() {
        this.model = new StatisticPlayerModel();
        this.view = new StatisticPlayerView();
        this.controller = new StatisticPlayerController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
