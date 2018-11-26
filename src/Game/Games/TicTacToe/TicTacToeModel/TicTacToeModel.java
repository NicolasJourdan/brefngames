package Game.Games.TicTacToe.TicTacToeModel;
import Game.Games.TicTacToe.TicTacToeView.Coord;
import Game.Model.AbstractGameModel;
import Player.Player;
import Statistic.Model.Statistic;
import java.util.List;

public class TicTacToeModel extends AbstractGameModel {
    private Board board;
    private int size;
    private Player currentPlayer;

    public TicTacToeModel(Player[] listPlayers, int size) {
        super(listPlayers);
        this.currentPlayer = listPlayers[0];
        this.size = size;
        this.board = new Board(this.size);
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

    public boolean isWinner() {
        boolean status = false;
        int val, sumDiagonalLR, sumDiagonalRL, sumRows, sumColumns, toWin;
        if (this.currentPlayer == listPlayers[0]){
            toWin = -this.size;
        }
        else {
            toWin = this.size;
        }
        sumColumns = 0;
        sumRows = 0;
        for (int i = 0; i < this.size; i++) {
            sumColumns = 0;
            sumRows = 0;
            for (int j = 0; j < this.size; j++) {
                val = getVal(i, j);
                sumColumns += val;
                val = getVal(j, i);
                sumRows += val;

            }
            if(sumColumns == toWin || sumRows == toWin){
                break;
            }
        }
        sumDiagonalLR = 0;
        sumDiagonalRL = 0;
        for (int i = 0; i < this.size; i++) {
            val = getVal(i,i);
            sumDiagonalLR += val;
        }
        for (int i = 0; i < this.size; i++) {
            val = getVal(i,this.size - 1 - i);
            sumDiagonalRL += val;
        }
        if (sumColumns == toWin || sumRows == toWin || sumDiagonalLR == toWin || sumDiagonalRL == toWin){
            status = true;
        }
        return status;
    }

    private int getVal(int i, int j){
        int val;
        if(board.grid.get(i).get(j) instanceof Cross){
            val = 1;
        }
        else if (board.grid.get(i).get(j) instanceof Circle){
            val = -1;
        }
        else{
            val = 0;
        }
        return val;
    }

    public String setPawnModel(Coord coord){
        Pawn pawn;
        if(this.currentPlayer.equals(this.listPlayers[0])){
            pawn = new Circle(this.currentPlayer, coord);
        }
        else{
            pawn = new Cross(this.currentPlayer, coord);
        }
        String status = board.setPawn(pawn);
        return status;
    }

    public Player changePlayer(){
        if(this.currentPlayer.equals(this.listPlayers[0])){
            this.currentPlayer = this.listPlayers[1];
        }
        else{
            this.currentPlayer = this.listPlayers[0];
        }
        return this.currentPlayer;
    }
}
