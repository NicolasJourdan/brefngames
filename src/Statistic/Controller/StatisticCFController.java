package Statistic.Controller;

import Scene.Controller.AbstractSceneController;
import Statistic.Model.StatisticCFModel;
import Statistic.View.StatisticCFView;
import Structure.AbstractModel;
import Structure.AbstractView;

public class StatisticCFController extends AbstractSceneController {
    public StatisticCFController(AbstractModel model, AbstractView view) {
        super(model, view);
        // Not observer observable because the view is not created yet
        ((StatisticCFView) this.view).updateCFStatistic(
                ((StatisticCFModel) this.model).getAllCFStat());
    }
}
