package Statistic;

import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.Scene;
import Scene.View.AbstractSceneManagerView;
import Statistic.Controller.StatisticController;
import Statistic.Model.StatisticModel;
import Statistic.View.StatisticView;

public class StatisticScene extends Scene {
    public StatisticScene() {
        this.model = new StatisticModel();
        this.view = new StatisticView();
        this.controller = new StatisticController((AbstractSceneManagerModel) this.model, (AbstractSceneManagerView) this.view);
        this.controller.addObserver(this);
    }
}
