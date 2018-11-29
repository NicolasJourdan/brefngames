//package Game.Games.ConnectFour.ConnectFourModel;
//
//import Game.Model.AbstractGameModel;
//import Player.Player;
//import Statistic.Model.Statistic;
//
//import java.util.List;
//
//public class ConnectFourModel extends AbstractGameModel {
//    private Board board;
//    private int row;
//    private int column;
//    private Player currentPlayer;
//
//    public ConnectFourModel(Player[] listPlayers, int row, int column) {
//        super(listPlayers);
//        this.currentPlayer = listPlayers[0];
//        this.row = row;
//        this.board = new Board(this.row, this.column);
//    }
//
//    public Player[] getPlayers() {
//        return this.listPlayers;
//    }
//
//    public Player getCurrentPlayer() {
//        return currentPlayer;
//    }
//
//    @Override
//    public List<Statistic> getListStatistics() {
//        return null;
//    }
//
//    public boolean isWinner() {
//        int val, sumDiagonalLR, sumDiagonalRL, sumRows, sumColumns, toWin;
//        if (this.currentPlayer == listPlayers[0]) {
//            toWin = -this.size;
//        } else {
//            toWin = this.size;
//        }
//        sumColumns = 0;
//        sumRows = 0;
//        for (int i = 0; i < this.size; i++) {
//            sumColumns = 0;
//            sumRows = 0;
//            for (int j = 0; j < this.size; j++) {
//                val = getVal(i, j);
//                sumColumns += val;
//                val = getVal(j, i);
//                sumRows += val;
//
//            }
//            if (sumColumns == toWin || sumRows == toWin) {
//                return true;
//            }
//        }
//        sumDiagonalLR = 0;
//        sumDiagonalRL = 0;
//        for (int i = 0; i < this.size; i++) {
//            val = getVal(i, i);
//            sumDiagonalLR += val;
//        }
//        for (int i = 0; i < this.size; i++) {
//            val = getVal(i, this.size - 1 - i);
//            sumDiagonalRL += val;
//        }
//        if (sumColumns == toWin || sumRows == toWin || sumDiagonalLR == toWin || sumDiagonalRL == toWin) {
//            return true;
//        }
//        return false;
//    }
//
//    private int getVal(int i, int j) {
//        if (board.grid.get(i).get(j) instanceof Cross) {
//            return 1;
//        } else if (board.grid.get(i).get(j) instanceof Circle) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
//
//    public String setPawnModel(Coord coord) {
//        Pawn pawn;
//        if (this.currentPlayer.equals(this.listPlayers[0])) {
//            pawn = new Circle(this.currentPlayer, coord);
//        } else {
//            pawn = new Cross(this.currentPlayer, coord);
//        }
//        return board.setPawn(pawn);
//    }
//
//    public void changePlayer() {
//        if (this.currentPlayer.equals(this.listPlayers[0])) {
//            this.currentPlayer = this.listPlayers[1];
//        } else {
//            this.currentPlayer = this.listPlayers[0];
//        }
//    }
//
//    public Boolean isDraw(){
//        return this.board.isFill();
//    }
//}
