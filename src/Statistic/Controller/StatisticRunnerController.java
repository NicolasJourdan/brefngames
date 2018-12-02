package Statistic.Controller;

import Scene.Controller.AbstractSceneController;
import Statistic.Model.StatisticRunnerModel;
import Statistic.View.StatisticRunnerView;
import Structure.AbstractModel;
import Structure.AbstractView;

public class StatisticRunnerController extends AbstractSceneController {
    public StatisticRunnerController(AbstractModel model, AbstractView view) {
        super(model, view);
        // Not observer observable because the view is not created yet
        ((StatisticRunnerView) this.view).updateRunnerStatistic(
                ((StatisticRunnerModel) this.model).getAllRunnerStat());
    }
}
