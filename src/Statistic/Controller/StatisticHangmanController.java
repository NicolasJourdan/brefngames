package Statistic.Controller;

import Scene.Controller.AbstractSceneController;
import Statistic.Model.StatisticHangmanModel;
import Statistic.View.StatisticHangmanView;
import Structure.AbstractModel;
import Structure.AbstractView;

public class StatisticHangmanController extends AbstractSceneController {
    public StatisticHangmanController(AbstractModel model, AbstractView view) {
        super(model, view);
        // Not observer observable because the view is not created yet
        ((StatisticHangmanView) this.view).updateHangmanStatistics(
                ((StatisticHangmanModel) this.model).getAllHangmanStats());
    }
}
