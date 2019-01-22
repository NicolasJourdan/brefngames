package Game.Games.ConnectFour.ConnectFourModel;

import Contest.Model.ContestDataPersistor;
import Game.Games.ConnectFour.ConnectFourStatsEnum;
import Game.Games.Coord;
import Game.Games.DataObject.PawnDataObject;
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

public class ConnectFourModel extends AbstractGameModel {
    private final static int DEFAULT_ROW = 6;
    private final static int DEFAULT_COLUMN = 7;
    private final static int DEFAULT_NB_PLAYERS = 2;
    private Board board;
    private Player currentPlayer;

    private Chronometer chronometer;

    private Map<ConnectFourStatsEnum, String> gameStats;
    private Map<PlayerStatsEnum, String> firstPlayerStats;
    private Map<PlayerStatsEnum, String> secondPlayerStats;


    public ConnectFourModel(Player[] listPlayers) {
        super(listPlayers);
        Random random = new Random();
        this.currentPlayer = listPlayers[random.nextInt(ConnectFourModel.DEFAULT_NB_PLAYERS)];
        this.board = new Board(ConnectFourModel.DEFAULT_ROW, ConnectFourModel.DEFAULT_COLUMN);

        this.initStats();
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String isWinner() {
        return this.board.isWinner();
    }

    public Pawn setPawnModel(Coord coord) {
        Pawn pawn;
        if (this.currentPlayer.equals(this.listPlayers[0])) {
            pawn = new YellowPawn(this.currentPlayer, coord);
        } else {
            pawn = new RedPawn(this.currentPlayer, coord);
        }
        return this.board.setPawn(pawn);
    }

    public void changePlayer() {
        if (this.currentPlayer.equals(this.listPlayers[0])) {
            this.currentPlayer = this.listPlayers[1];
        } else {
            this.currentPlayer = this.listPlayers[0];
        }
    }

    public boolean isDraw() {
        return this.board.isFill();
    }

    public PawnDataObject play(Coord coord) {
        Pawn pawn = this.setPawnModel(coord);
        if (null != pawn) {
            String status = pawn.toString();
            if (!status.isEmpty()) {
                if (status.equals("R")) {
                    int cross = Integer.parseInt(this.gameStats.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS)) + 1;
                    this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS, Integer.toString(cross));
                } else {
                    int circle = Integer.parseInt(this.gameStats.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS)) + 1;
                    this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS, Integer.toString(circle));
                }
                Color color = this.getCurrentPlayer().getColor();
                this.changePlayer();

                return new PawnDataObject(null, color, pawn.getCoord());
            }
        }

        return null;
    }

    public boolean isFinished() {
        return !this.isWinner().isEmpty() || this.isDraw();
    }

    public ActionEnum getWinner() {
        if (!this.isWinner().isEmpty()) {
            return !this.getCurrentPlayer().getName().equals(this.getPlayers()[0].getName()) ?
                    ActionEnum.FIRST_PLAYER_WON : ActionEnum.SECOND_PLAYER_WON;
        }

        return ActionEnum.DRAW;
    }

    /**
     * Get win orientation (can be empty)
     */
    public String getOrientation() {
        return this.isWinner();
    }


    private void initStats() {
        this.chronometer = new Chronometer();

        //Game Stats
        this.gameStats = new HashMap<>();
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS, "0");
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS, "0");
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_ALL_PAWNS, "0");
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_DRAW, "0");
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_GAMES, "1");
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_LANDSCAPE, "0");
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_VERTICAL, "0");
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_DIAG, "0");

        //First Player Stats
        this.firstPlayerStats = new HashMap<>();
        this.firstPlayerStats.put(PlayerStatsEnum.CONNECT_FOUR_NB_GAME, "1");
        this.firstPlayerStats.put(PlayerStatsEnum.CONNECT_FOUR_NB_WIN, "0");
        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");
        //Second Player Stats
        this.secondPlayerStats = new HashMap<>();
        this.secondPlayerStats.put(PlayerStatsEnum.CONNECT_FOUR_NB_GAME, "1");
        this.secondPlayerStats.put(PlayerStatsEnum.CONNECT_FOUR_NB_WIN, "0");
        this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");
    }

    public void sendStats(String orient) {
        if (orient.equals("vertical")) {
            this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_VERTICAL, "1");
        } else if (orient.equals("landscape")) {
            this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_LANDSCAPE, "1");
        } else if (orient.equals("diagonal")) {
            this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_DIAG, "1");
        }

        int yellowNb = Integer.parseInt(this.gameStats.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS));
        int redNb = Integer.parseInt(this.gameStats.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS));
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_ALL_PAWNS, Integer.toString(yellowNb + redNb));
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_TOTAL_TIME, Integer.toString(this.chronometer.getDuration()));
        ContestDataPersistor.updateDataPlayer(this.getPlayers()[0].getName(), this.firstPlayerStats);
        ContestDataPersistor.updateDataPlayer(this.getPlayers()[1].getName(), this.secondPlayerStats);
        ContestDataPersistor.updateConnectFour(this.gameStats);
    }

    public void updatePlayerStats() {
        String orient = this.isWinner();
        if (!orient.isEmpty()) {
            if (this.getCurrentPlayer().getName().equals(this.getPlayers()[0].getName())) {
                this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                this.firstPlayerStats.put(PlayerStatsEnum.CONNECT_FOUR_NB_WIN, "1");
            } else {
                this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                this.secondPlayerStats.put(PlayerStatsEnum.CONNECT_FOUR_NB_WIN, "0");
            }
        } else {
            // If no winner => Draw
            this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_DRAW, "1");
        }
    }
}
