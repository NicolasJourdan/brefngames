package Statistic.Controller;

import Scene.Controller.AbstractSceneController;
import Statistic.Model.StatisticCookieClickerModel;
import Statistic.View.StatisticCookieClickerView;
import Structure.AbstractModel;
import Structure.AbstractView;

public class StatisticCookieClickerController extends AbstractSceneController {
    public StatisticCookieClickerController(AbstractModel model, AbstractView view) {
        super(model, view);
        // Not observer observable because the view is not created yet
        ((StatisticCookieClickerView) this.view).updateCCStatistic(
                ((StatisticCookieClickerModel) this.model).getAllCCStat());
    }
}
