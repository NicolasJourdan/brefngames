package Statistic.Controller;

import Scene.Controller.AbstractSceneController;
import Statistic.Model.StatisticTicTacToeModel;
import Statistic.View.StatisticTicTacToeView;
import Structure.AbstractModel;
import Structure.AbstractView;

public class StatisticTicTacToeController extends AbstractSceneController {
    public StatisticTicTacToeController(AbstractModel model, AbstractView view) {
        super(model, view);
        // Not observer observable because the view is not created yet
        ((StatisticTicTacToeView) this.view).updateTTTStatistic(
                ((StatisticTicTacToeModel) this.model).getAllTTTStat());
    }
}
