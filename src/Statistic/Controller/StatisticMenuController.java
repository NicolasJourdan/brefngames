package Statistic.Controller;

import Scene.Controller.AbstractSceneController;
import Scene.Model.ActionEnum;
import Statistic.Model.StatisticMenuModel;
import Statistic.View.StatisticMenuView;
import Structure.AbstractModel;
import Structure.AbstractView;

public class StatisticMenuController extends AbstractSceneController {

    public StatisticMenuController(AbstractModel model, AbstractView view) {
        super(model, view);
        // Not observer observable because the view is not created yet
        ((StatisticMenuView) this.view).updateGlobalStatistic(
                ((StatisticMenuModel) this.model).getGlobalStatisctic(),
                ((StatisticMenuModel) this.model).getHeaderTable());
    }
}
