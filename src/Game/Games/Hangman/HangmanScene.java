package Game.Games.Hangman;

import Game.GameScene;
import Game.Games.Hangman.Controller.ClientHangmanController;
import Game.Games.Hangman.Controller.HangmanController;
import Game.Games.Hangman.Controller.ServerHangmanController;
import Game.Games.Hangman.Model.HangmanModel;
import Game.Games.Hangman.View.HangmanView;
import Online.Socket.SocketCommunicatorService;
import Player.Player;

public class HangmanScene extends GameScene {
    public HangmanScene(Player[] listPlayers, boolean isTraining, int[] scores) {
        this.model = new HangmanModel(listPlayers);
        this.view = new HangmanView(listPlayers, scores);
        this.controller = new HangmanController((HangmanModel) this.model, (HangmanView) this.view, isTraining);
        this.controller.addObserver(this);
    }

    public HangmanScene(Player[] listPlayers, boolean isTraining, int[] scores, boolean isServer, SocketCommunicatorService socketCommunicatorService) {
        this.model = new HangmanModel(listPlayers);
        this.view = new HangmanView(listPlayers, scores);
        this.controller = isServer ?
                new ServerHangmanController((HangmanModel) this.model, (HangmanView) this.view, isTraining, socketCommunicatorService) :
                new ClientHangmanController((HangmanModel) this.model, (HangmanView) this.view, isTraining, socketCommunicatorService)
        ;
        this.controller.addObserver(this);
    }
}
