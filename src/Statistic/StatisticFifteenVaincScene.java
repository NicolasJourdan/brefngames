package Statistic;

import Scene.Model.Scene;
import Statistic.Controller.StatisticFifteenVaincController;
import Statistic.Model.StatisticFifteenVaincModel;
import Statistic.View.StatisticFifteenVaincView;

public class StatisticFifteenVaincScene extends Scene {
    public StatisticFifteenVaincScene() {
        this.model = new StatisticFifteenVaincModel();
        this.view = new StatisticFifteenVaincView();
        this.controller = new StatisticFifteenVaincController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
