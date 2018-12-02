package Game.Games.CookieClicker.Controler;

import Contest.Model.ContestDataPersistor;
import Game.Controller.AbstractGameController;
import Game.Games.CookieClicker.CookieClickerStatsEnum;
import Game.Games.CookieClicker.Model.CookieModel;
import Game.Games.CookieClicker.View.CookieView;
import Scene.Model.ActionEnum;
import java.util.Observable;
import java.util.HashMap;
import java.util.Map;

public class CookieController extends AbstractGameController {

    private Map <CookieClickerStatsEnum, String> statsMap;
    private long initTime;
    private long finalTime;
    private String totalTime;

    public CookieController(CookieModel model, CookieView view, boolean isTraining){
        super(model,view, isTraining);
        initStats();
        initTime = System.currentTimeMillis();
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
                ((CookieModel) this.model).check();     //Check difference of clicks for each players
                this.updateStats();                     //update my Map
                //Notify the winner
                this.setChanged();
                if (((CookieModel) this.model).getDiffFirstPlayer()<((CookieModel) this.model).getDiffSecondPlayer()){
                    this.notifyObservers(ActionEnum.FIRST_PLAYER_WON);
                } else if (((CookieModel) this.model).getDiffFirstPlayer()>((CookieModel) this.model).getDiffSecondPlayer()){
                    this.notifyObservers(ActionEnum.SECOND_PLAYER_WON);
                } else {
                    this.notifyObservers(ActionEnum.DRAW);
                }
                if (!this.isTraining) {
                    ContestDataPersistor.updateCookieCliker(this.statsMap);
                }
                break;
        }
    }

    private void initStats() {
        this.statsMap = new HashMap<>();
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_NB_GAMES, "1");
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_NB_CLICS, "0");
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_NB_PERFECT, "0");
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_REQUIRED_CLIC, "0");
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_FAULT, "0");
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_TIME, "0");
    }

    private void updateStats(){
        //Add nb clicks
        int nbClicks = Integer.parseInt(this.statsMap.get(CookieClickerStatsEnum.COOKIE_CLICKER_NB_CLICS))
                + ((CookieModel) this.model).getTotFirstPlayer() + ((CookieModel) this.model).getTotSecondPlayer();
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_NB_CLICS, Integer.toString(nbClicks));
        //Add total required clicks
        int requiredClicks = Integer.parseInt(this.statsMap.get(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_REQUIRED_CLIC))
                + ((CookieModel) this.model).getGoal();
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_REQUIRED_CLIC, Integer.toString(requiredClicks));
        //Add total fault
        int totalFault = Integer.parseInt(this.statsMap.get(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_FAULT))
                + ((CookieModel) this.model).getDiffFirstPlayer() + ((CookieModel) this.model).getDiffSecondPlayer();
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_FAULT, Integer.toString(totalFault));
        //Add nb perfect
        if (0 == ((CookieModel) this.model).getDiffFirstPlayer() | 0 == ((CookieModel) this.model).getDiffSecondPlayer()){
            int nbPerfect = Integer.parseInt(this.statsMap.get(CookieClickerStatsEnum.COOKIE_CLICKER_NB_PERFECT)+1);
            this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_NB_PERFECT, Integer.toString(nbPerfect));
        }
        //Total Time
        finalTime = System.currentTimeMillis();
        totalTime = Long.toString((finalTime - initTime)/1000);
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_TIME, totalTime);
    }
}
