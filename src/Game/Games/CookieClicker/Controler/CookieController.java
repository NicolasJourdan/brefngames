package Game.Games.CookieClicker.Controler;

import Game.Controller.AbstractGameController;
import Game.Games.CookieClicker.Model.CookieModel;
import Game.Games.CookieClicker.View.CookieView;
import Scene.Model.ActionEnum;
import java.util.Observable;

public class CookieController extends AbstractGameController {

    public CookieController(CookieModel model, CookieView view, boolean isTraining) {
        super(model, view, isTraining);
        ((CookieView) this.view).setGoalScreen(((CookieModel) this.model).getGoal());
    }

    @Override
    public void update(Observable o, Object arg) {
        ActionEnum actionEnum = (ActionEnum) arg;
        switch (actionEnum) {
            case ADD_COOKIE_FIRST_PLAYER:
                ((CookieModel) this.model).addPointFirstPlayer();
                break;
            case ADD_COOKIE_SECOND_PLAYER:
                ((CookieModel) this.model).addPointSecondPlayer();
                break;
            case CHECK:
                ((CookieModel) this.model).check();
                if (!this.isTraining) {
                    ((CookieModel) this.model).updateGlobalStats();
                    ((CookieModel) this.model).updatePlayerStats();
                    ((CookieModel) this.model).sendGlobalStats();
                    ((CookieModel) this.model).sendFirstPlayerStats();
                    ((CookieModel) this.model).sendSecondPlayerStats();
                }
                //Notify the winner
                this.setChanged();
                this.notifyObservers(((CookieModel) this.model).getWinner());
                break;
        }
    }
}
