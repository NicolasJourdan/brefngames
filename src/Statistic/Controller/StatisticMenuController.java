package Statistic.Controller;

import Scene.Controller.AbstractSceneController;
import Statistic.Model.StatisticMenuModel;
import Statistic.View.StatisticMenuView;
import Structure.AbstractModel;
import Structure.AbstractView;

public class StatisticMenuController extends AbstractSceneController {

    public StatisticMenuController(AbstractModel model, AbstractView view) {
        super(model, view);
        // Not observer observable because the view is not created yet
        ((StatisticMenuView) this.view).updateGlobalStatistics(
                ((StatisticMenuModel) this.model).getGlobalStatisctic());
    }
}
