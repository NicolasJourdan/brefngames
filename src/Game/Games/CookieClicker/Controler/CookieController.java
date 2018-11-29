package Game.Games.CookieClicker.Controler;

import Game.Controller.AbstractGameController;
import Game.Games.CookieClicker.Model.CookieModel;
import Game.Games.CookieClicker.View.CookieView;
import Scene.Model.ActionEnum;
import java.util.Observable;

public class CookieController extends AbstractGameController {

    public CookieController(CookieModel model, CookieView view, boolean isTraining){
        super(model,view, isTraining);
    }

    @Override
    public void update(Observable o, Object arg) {
        ActionEnum actionEnum = (ActionEnum) arg;
        switch (actionEnum) {
            case ADD_COOKIE_P1:
                ((CookieModel) this.model).addJ1();
                break;
            case ADD_COOKIE_P2:
                ((CookieModel) this.model).addJ2();
                break;
            case CHECK:
                ((CookieModel) this.model).check();
                if (((CookieModel) this.model).getDiffJ1()<((CookieModel) this.model).getDiffJ2()){
                    this.notifyObservers(ActionEnum.PLAYER_1_WON);
                } else if (((CookieModel) this.model).getDiffJ1()>((CookieModel) this.model).getDiffJ2()){
                    this.notifyObservers(ActionEnum.PLAYER_2_WON);
                } else {
                    this.notifyObservers(ActionEnum.DRAW);
                }
                break;
            case GET_GOAL:
                ((CookieView) this.view).setGoalScreen(((CookieModel) this.model).getGoal());
                break;
        }
    }
}
