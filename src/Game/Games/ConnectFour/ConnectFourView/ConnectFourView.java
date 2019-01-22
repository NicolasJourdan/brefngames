package Game.Games.ConnectFour.ConnectFourView;

import Game.Games.Coord;
import Game.Games.DisplayPanel;
import Player.Player;
import Structure.ProxyObservable;
import Utils.UI.CustomPanel.CustomGameBackgroundPanel;

import java.awt.*;

public class ConnectFourView extends CustomGameBackgroundPanel {
    private static int INSET_SIZE = 10;
    private DisplayPanel firstPlayerDisplay;
    private Board board;
    private DisplayPanel secondPlayerDisplay;
    private DisplayPanel currentPlayer;
    private DisplayPanel otherPlayer;

    public ConnectFourView(int rows, int columns, Player[] players, int[] scores) {
        super(players, scores);
        this.setLayout(new GridBagLayout());
        this.firstPlayerDisplay = new DisplayPanel(players[0], true);
        this.board = new Board(rows, columns, this);
        this.secondPlayerDisplay = new DisplayPanel(players[1], false);
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridy = 0;
        constraint.gridx = 2;
        constraint.gridwidth = 2;
        this.add(this.scoreDisplay, constraint);
        constraint.gridy = 3;
        constraint.gridx = 0;
        constraint.gridwidth = 1;
        constraint.gridheight = 1;
        constraint.insets = new Insets(INSET_SIZE,INSET_SIZE,INSET_SIZE,INSET_SIZE);
        this.add(this.firstPlayerDisplay, constraint);
        constraint.gridy = 1;
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
    }

    public void setPawnView(Color color, Coord coord) {
        this.board.setPawnBoard(color, coord);
        this.revalidate();
        this.repaint();
    }

    public void updateCurrentPlayer(Player currentPlayer){
        if(currentPlayer != this.currentPlayer.getPlayer()){
            changePlayer();
        }
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
