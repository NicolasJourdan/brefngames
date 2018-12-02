package Statistic.Controller;

import Scene.Controller.AbstractSceneController;
import Statistic.Model.StatisticTTTModel;
import Statistic.View.StatisticTTTView;
import Structure.AbstractModel;
import Structure.AbstractView;

public class StatisticTTTController extends AbstractSceneController {
    public StatisticTTTController(AbstractModel model, AbstractView view) {
        super(model, view);
        // Not observer observable because the view is not created yet
        ((StatisticTTTView) this.view).updateTTTStatistic(
                ((StatisticTTTModel) this.model).getAllTTTStat());
    }
}
