package Game.Games.TicTacToe.TicTacToeModel;

import Contest.Model.ContestDataPersistor;
import Game.Games.Coord;
import Game.Games.DataObject.PawnDataObject;
import Game.Games.TicTacToe.TicTacToeStatsEnum;
import Game.Model.AbstractGameModel;
import Game.Model.Pawn;
import Player.Player;
import Repository.Player.PlayerStatsEnum;
import Scene.Model.ActionEnum;
import Utils.Chronometer.Chronometer;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TicTacToeModel extends AbstractGameModel {
    private static int DEFAULT_NB_PLAYERS = 2;
    private static int DEFAULT_SIZE = 3;
    private Board board;
    private int size;
    private Player currentPlayer;

    private Chronometer chronometer;
    private int round;
    private Map<TicTacToeStatsEnum, String> statsMap;
    private Map<PlayerStatsEnum, String> statsFirstPlayer;
    private Map<PlayerStatsEnum, String> statsSecondPlayer;

    public TicTacToeModel(Player[] listPlayers) {
        super(listPlayers);
        Random random = new Random();
        this.currentPlayer = listPlayers[random.nextInt(TicTacToeModel.DEFAULT_NB_PLAYERS)];
        this.size = TicTacToeModel.DEFAULT_SIZE;
        this.board = new Board(this.size);
        this.round = 0;
        this.initStats();
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    private boolean isWinner() {
        int val, sumDiagonalLR, sumDiagonalRL, sumRows, sumColumns, toWin;
        if (this.currentPlayer == this.listPlayers[0]) {
            toWin = -this.size;
        } else {
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
            if (sumColumns == toWin || sumRows == toWin) {
                return true;
            }
        }
        sumDiagonalLR = 0;
        sumDiagonalRL = 0;
        for (int i = 0; i < this.size; i++) {
            val = getVal(i, i);
            sumDiagonalLR += val;
        }
        for (int i = 0; i < this.size; i++) {
            val = getVal(i, this.size - 1 - i);
            sumDiagonalRL += val;
        }
        return sumColumns == toWin || sumRows == toWin || sumDiagonalLR == toWin || sumDiagonalRL == toWin;
    }

    public boolean isDraw() {
        return this.board.isFill();
    }

    private int getVal(int i, int j) {
        if (board.getGrid().get(i).get(j) instanceof Cross) {
            return 1;
        } else if (board.getGrid().get(i).get(j) instanceof Circle) {
            return -1;
        } else {
            return 0;
        }
    }

    private String setPawnModel(Coord coord) {
        Pawn pawn;
        Pawn status;
        if (this.currentPlayer.equals(this.listPlayers[0])) {
            pawn = new Circle(this.currentPlayer, coord);
        } else {
            pawn = new Cross(this.currentPlayer, coord);
        }
        status = board.setPawn(pawn);
        return status != null ? status.toString() : "";
    }

    public void changePlayer() {
        if (this.currentPlayer.equals(this.listPlayers[0])) {
            this.currentPlayer = this.listPlayers[1];
        } else {
            this.currentPlayer = this.listPlayers[0];
        }
    }

    private void initStats() {
        this.chronometer = new Chronometer();

        this.statsMap = new HashMap<>();
        this.statsFirstPlayer = new HashMap<>();
        this.statsSecondPlayer = new HashMap<>();
        this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CROSS, "0");
        this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CIRCLE, "0");
        this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_ALL_SIGNS, "0");
        this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_PERFECT, "0");
        this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_DRAW, "0");
        this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_GAMES, "1");

        this.statsFirstPlayer.put(PlayerStatsEnum.TIC_TAC_TOE_NB_GAME, "1");
        this.statsFirstPlayer.put(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN, "0");
        this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");

        this.statsSecondPlayer.put(PlayerStatsEnum.TIC_TAC_TOE_NB_GAME, "1");
        this.statsSecondPlayer.put(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN, "0");
        this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");
    }

    public PawnDataObject play(Coord coord) {
        String status = this.setPawnModel(coord);
        if (!status.isEmpty()) {
            this.round += 1;
            if (status.equals("x")) {
                int cross = Integer.parseInt(this.statsMap.get(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CROSS)) + 1;
                this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CROSS, Integer.toString(cross));
            } else {
                int circle = Integer.parseInt(this.statsMap.get(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CIRCLE)) + 1;
                this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CIRCLE, Integer.toString(circle));
            }
            Color color = this.getCurrentPlayer().getColor();

            return new PawnDataObject(status, color, coord);
        }

        return null;
    }

    public boolean isFinished() {
        return isWinner() || this.isDraw();
    }

    public ActionEnum getWinner() {
        if (this.isWinner()) {
            return this.getCurrentPlayer().getName().equals(this.getPlayers()[0].getName()) ?
                    ActionEnum.FIRST_PLAYER_WON : ActionEnum.SECOND_PLAYER_WON;
        }

        return ActionEnum.DRAW;
    }

    public void updatePlayerStats() {
        if (this.isWinner()) {
            if (this.round <= 6) {
                this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_PERFECT, "1");
            }
            if (this.getCurrentPlayer().getName().equals(this.getPlayers()[0].getName())) {
                this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                this.statsFirstPlayer.put(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN, "1");
            } else {
                this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                this.statsSecondPlayer.put(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN, "1");
            }
        } else {
            // If no winner => Draw
            this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_DRAW, "1");
        }
    }

    public void sendStats() {
        int crossNb = Integer.parseInt(this.statsMap.get(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CIRCLE));
        int circleNb = Integer.parseInt(this.statsMap.get(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CROSS));
        this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_ALL_SIGNS, Integer.toString(crossNb + circleNb));
        this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_TOTAL_TIME, Integer.toString(this.chronometer.getDuration()));
        ContestDataPersistor.updateTicTacToe(this.statsMap);
        ContestDataPersistor.updateDataPlayer(this.getPlayers()[0].getName(), this.statsFirstPlayer);
        ContestDataPersistor.updateDataPlayer(this.getPlayers()[1].getName(), this.statsSecondPlayer);
    }
}
