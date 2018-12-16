package Game.Games.CookieClicker;

import Game.GameScene;
import Game.Games.CookieClicker.Controler.CookieController;
import Game.Games.CookieClicker.Model.CookieModel;
import Game.Games.CookieClicker.View.CookieView;
import Map.Model.History;
import Player.Player;


public class CookieClickerScene extends GameScene {

    public CookieClickerScene(Player[] players, boolean isTraining, History history) {
        this.model = new CookieModel(players);
        this.view = new CookieView(players, history);
        this.controller = new CookieController((CookieModel) this.model, (CookieView) this.view, isTraining);
        this.controller.addObserver(this);

    }
}
