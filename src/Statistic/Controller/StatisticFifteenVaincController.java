package Statistic.Controller;

import Scene.Controller.AbstractSceneController;
import Statistic.Model.StatisticFifteenVaincModel;
import Statistic.View.StatisticFifteenVaincView;
import Structure.AbstractModel;
import Structure.AbstractView;

public class StatisticFifteenVaincController extends AbstractSceneController {
    public StatisticFifteenVaincController(AbstractModel model, AbstractView view) {
        super(model, view);
        // Not observer observable because the view is not created yet
        ((StatisticFifteenVaincView) this.view).updateFifteenVaincStatistics(
                ((StatisticFifteenVaincModel) this.model).getAllFifteenVaincStats()
        );
    }
}
