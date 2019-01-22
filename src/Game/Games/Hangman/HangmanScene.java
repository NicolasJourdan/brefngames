package Game.Games.Hangman;

import Game.GameScene;
import Game.Games.Hangman.Controller.HangmanController;
import Game.Games.Hangman.Model.HangmanModel;
import Game.Games.Hangman.View.HangmanView;
import Player.Player;

public class HangmanScene extends GameScene {
    public HangmanScene(Player[] listPlayers, boolean isTraining, int[] scores) {
        this.model = new HangmanModel(listPlayers);
        this.view = new HangmanView(listPlayers, scores);
        this.controller = new HangmanController((HangmanModel) this.model, (HangmanView) this.view, isTraining);
        this.controller.addObserver(this);
    }

}
