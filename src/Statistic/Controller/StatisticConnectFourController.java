package Statistic.Controller;

import Scene.Controller.AbstractSceneController;
import Statistic.Model.StatisticConnectFourModel;
import Statistic.View.StatisticConnectFourView;
import Structure.AbstractModel;
import Structure.AbstractView;

public class StatisticConnectFourController extends AbstractSceneController {
    public StatisticConnectFourController(AbstractModel model, AbstractView view) {
        super(model, view);
        // Not observer observable because the view is not created yet
        ((StatisticConnectFourView) this.view).updateCFStatistic(
                ((StatisticConnectFourModel) this.model).getAllCFStat());
    }
}
