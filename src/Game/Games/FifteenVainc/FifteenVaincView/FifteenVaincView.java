package Game.Games.FifteenVainc.FifteenVaincView;

import Game.Games.Coord;
import Game.Games.DisplayPanel;
import Player.Player;
import Structure.ProxyObservable;
import Utils.UI.CustomPanel.CustomGameBackgroundPanel;

import java.awt.*;

public class FifteenVaincView extends CustomGameBackgroundPanel {
    private static int INSET_SIZE = 1;
    private DisplayPanel firstPlayerDisplay;
    private Board board;
    private DisplayPanel secondPlayerDisplay;
    private int row;
    private int column;
    private DisplayPanel currentPlayer;
    private DisplayPanel otherPlayer;


    public FifteenVaincView(int row, int column,Player[] players, int[] scores) {
        super(players, scores);
        // Number of row and column -> static
        this.row = row;
        this.column = column;

        this.setLayout(new GridBagLayout());
        this.firstPlayerDisplay = new DisplayPanel(players[0], true);
        this.board = new Board(this.row, this.column, this);
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
    }

    public void changePlayer(){
        DisplayPanel tmp = this.currentPlayer;
        this.currentPlayer = this.otherPlayer;
        this.otherPlayer = tmp;
        this.currentPlayer.setFocus(true);
        this.otherPlayer.setFocus(false);
    }

    public void updateCurrentPlayer(Player currentPlayer) {
        if (!currentPlayer.getName().equals(this.currentPlayer.getPlayer().getName())) {
            this.changePlayer();
        }
    }

    public ProxyObservable getObservable() {
        return this.observable;
    }
}
