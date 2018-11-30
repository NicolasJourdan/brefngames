package Game.Games.ConnectFour.ConnectFourModel;

import Game.Games.Coord;
import Game.Model.AbstractGameModel;
import Game.Model.Pawn;
import Player.Player;
import Statistic.Model.Statistic;

import java.util.List;

public class ConnectFourModel extends AbstractGameModel {
    private Board board;
    private Player currentPlayer;

    public ConnectFourModel(Player[] listPlayers, int rows, int columns) {
        super(listPlayers);
        this.currentPlayer = listPlayers[0];
        this.board = new Board(rows, columns);
    }

    public Player[] getPlayers() {
        return this.listPlayers;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public List<Statistic> getListStatistics() {
        return null;
    }

    public String isWinner() {
        return board.isWinner();
    }

    public Pawn setPawnModel(Coord coord) {
        Pawn pawn;
        if (this.currentPlayer.equals(this.listPlayers[0])) {
            pawn = new YellowPawn(this.currentPlayer, coord);
        } else {
            pawn = new RedPawn(this.currentPlayer, coord);
        }
        return board.setPawn(pawn);
    }

    public void changePlayer() {
        if (this.currentPlayer.equals(this.listPlayers[0])) {
            this.currentPlayer = this.listPlayers[1];
        } else {
            this.currentPlayer = this.listPlayers[0];
        }
    }

    public Boolean isDraw(){
        return this.board.isFill();
    }
}
