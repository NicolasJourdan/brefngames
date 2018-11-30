package Statistic.Controller;

import Scene.Controller.AbstractSceneController;
import Scene.Model.ActionEnum;
import Statistic.Model.StatisticPlayerModel;
import Statistic.View.StatisticPlayerView;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.Observable;

public class StatisticPlayerController extends AbstractSceneController {

    public StatisticPlayerController(AbstractModel model, AbstractView view) {
        super(model, view);
        // Not observer observable because the view is not created yet
        ((StatisticPlayerView) this.view).updateGlobalStatistic(
                ((StatisticPlayerModel) this.model).getGlobalStatisctic());
        ((StatisticPlayerView) this.view).updateJCBView(
                ((StatisticPlayerModel) this.model).getAllPlayers());
    }

    @Override
    public void update(Observable o, Object arg) {
//        super.update(o, arg);
        switch ((ActionEnum)arg){
            case STATISTIC_PLAYER_CHANGE :
                String p = ((StatisticPlayerView) this.view).getCurrentPlayer();

                ((StatisticPlayerView) this.view).updateGlobalStatistic(
                    ((StatisticPlayerModel) this.model).getStatById(p));
        }
    }
}
