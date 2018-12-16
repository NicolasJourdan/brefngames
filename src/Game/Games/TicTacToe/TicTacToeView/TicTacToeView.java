package Game.Games.TicTacToe.TicTacToeView;

import Game.Games.Coord;
import Game.Games.DisplayPanel;
import Game.Games.ScoreDisplay;
import Game.View.AbstractGameView;
import Map.Model.History;
import Player.Player;
import Structure.ProxyObservable;
import Utils.UI.CustomPanel.CustomGameBackgroundPanel;
import Utils.UI.SoundPlayer;
import Utils.UI.Utils;

import java.awt.*;

public class TicTacToeView extends CustomGameBackgroundPanel {

    private static int INSET_SIZE = 10;
    private DisplayPanel firstPlayerDisplay;
    private Board board;
    private DisplayPanel secondPlayerDisplay;
    private int size;
    private DisplayPanel currentPlayer;
    private DisplayPanel otherPlayer;
    private ScoreDisplay scoreDisplay;


    public TicTacToeView(int size, Player[] players, History history) {
        this.size = size;
        this.setLayout(new GridBagLayout());
        this.scoreDisplay = new ScoreDisplay(players, history);
        this.firstPlayerDisplay = new DisplayPanel(players[0], true);
        this.board = new Board(this.size, this);
        this.secondPlayerDisplay = new DisplayPanel(players[1], false);
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridy = 0;
        constraint.gridx = 2;
        constraint.gridwidth = 2;
        constraint.gridheight = 1;
        this.add(this.scoreDisplay, constraint);
        constraint.gridy = 3;
        constraint.gridx = 0;
        constraint.gridwidth = 1;
        constraint.gridheight = 1;
        constraint.insets = new Insets(INSET_SIZE,INSET_SIZE,INSET_SIZE,INSET_SIZE);
        this.add(this.firstPlayerDisplay, constraint);
        constraint.gridy = 3;
        constraint.gridx = 1;
        constraint.gridwidth = 3;
        constraint.gridheight = 3;
        this.add(this.board, constraint);
        constraint.gridy = 3;
        constraint.gridx = 4;
        constraint.gridwidth = 2;
        constraint.gridheight = 1;
        constraint.insets = new Insets(INSET_SIZE,INSET_SIZE,INSET_SIZE,INSET_SIZE);
        this.add(this.secondPlayerDisplay, constraint);
        this.currentPlayer = this.firstPlayerDisplay;
        this.otherPlayer = this.secondPlayerDisplay;
        this.revalidate();
        this.repaint();
    }

    public void setPawnView(String text, Color color, Coord coord) {
        this.board.setPawnBoard(text, color, coord);
        this.revalidate();
        this.repaint();
        SoundPlayer.playSound(Utils.DEFAULT_CLICK_SOUND);
    }

    public void changePlayer(){
        DisplayPanel tmp = this.currentPlayer;
        this.currentPlayer = this.otherPlayer;
        this.otherPlayer = tmp;
        this.currentPlayer.setFocus(true);
        this.otherPlayer.setFocus(false);
    }

    public ProxyObservable getObservable() {
        return this.observable;
    }
}
