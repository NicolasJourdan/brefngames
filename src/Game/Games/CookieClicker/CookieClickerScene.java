package Game.Games.CookieClicker;

import Game.GameScene;
import Game.Games.CookieClicker.Controler.CookieController;
import Game.Games.CookieClicker.Model.CookieModel;
import Game.Games.CookieClicker.View.CookieView;
import Player.Player;


public class CookieClickerScene extends GameScene {

    public CookieClickerScene(Player[] players) {
        this.model = new CookieModel(players);
        this.view = new CookieView();
        this.controller = new CookieController((CookieModel) this.model, (CookieView) this.view);
        this.controller.addObserver(this);

    }
}
