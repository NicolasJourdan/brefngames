package Game.Games.TicTacToe;

import Game.GameScene;
import Game.Games.TicTacToe.TicTacToeController.ClientTicTacToeController;
import Game.Games.TicTacToe.TicTacToeController.ServerTicTacToeController;
import Game.Games.TicTacToe.TicTacToeController.TicTacToeController;

import Player.Player;
import Game.Games.TicTacToe.TicTacToeModel.TicTacToeModel;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;

import java.net.Socket;

public class TicTacToeScene extends GameScene {
    public TicTacToeScene(Player[] listPlayers, boolean isTraining, int[] scores) {
        this.model = new TicTacToeModel(listPlayers);
        this.view = new TicTacToeView(listPlayers, scores);
        this.controller = new TicTacToeController((TicTacToeModel) this.model, (TicTacToeView) this.view, isTraining);
        this.controller.addObserver(this);
    }

    public TicTacToeScene(Player[] listPlayers, boolean isTraining, int[] scores, boolean isServer, Socket socket) {
        this.model = new TicTacToeModel(listPlayers, DEFAULT_SIZE);
        this.view = new TicTacToeView(DEFAULT_SIZE, listPlayers, scores);
        this.controller = isServer ?
                new ServerTicTacToeController((TicTacToeModel) this.model, (TicTacToeView) this.view, DEFAULT_SIZE, isTraining, socket) :
                new ClientTicTacToeController((TicTacToeModel) this.model, (TicTacToeView) this.view, DEFAULT_SIZE, isTraining, socket)
        ;
        this.controller.addObserver(this);
    }
}
