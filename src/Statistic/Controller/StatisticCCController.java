package Statistic.Controller;

import Scene.Controller.AbstractSceneController;
import Statistic.Model.StatisticCCModel;
import Statistic.View.StatisticCCView;
import Structure.AbstractModel;
import Structure.AbstractView;

public class StatisticCCController extends AbstractSceneController {
    public StatisticCCController(AbstractModel model, AbstractView view) {
        super(model, view);
        // Not observer observable because the view is not created yet
        ((StatisticCCView) this.view).updateCCStatistic(
                ((StatisticCCModel) this.model).getAllCCStat());
    }
}
