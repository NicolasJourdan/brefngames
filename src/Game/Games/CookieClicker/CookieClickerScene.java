package Game.Games.CookieClicker;

import Game.GameScene;
import Game.Games.CookieClicker.Controler.ClientCookieController;
import Game.Games.CookieClicker.Controler.CookieController;
import Game.Games.CookieClicker.Controler.ServerCookieController;
import Game.Games.CookieClicker.Model.CookieModel;
import Game.Games.CookieClicker.View.CookieView;
import Online.Socket.SocketCommunicatorService;
import Player.Player;


public class CookieClickerScene extends GameScene {

    public CookieClickerScene(Player[] players, boolean isTraining, int[] scores) {
        this.model = new CookieModel(players);
        this.view = new CookieView(players, scores);
        this.controller = new CookieController((CookieModel) this.model, (CookieView) this.view, isTraining);
        this.controller.addObserver(this);
    }

    public CookieClickerScene(Player[] players, boolean isTraining, int[] scores, boolean isServer, SocketCommunicatorService socketCommunicatorService) {
        this.model = new CookieModel(players);
        this.view = new CookieView(players, scores);
        this.controller = isServer ?
                new ServerCookieController((CookieModel) this.model, (CookieView) this.view, isTraining, socketCommunicatorService) :
                new ClientCookieController((CookieModel) this.model, (CookieView) this.view, isTraining, socketCommunicatorService)
        ;
        this.controller.addObserver(this);
    }
}
