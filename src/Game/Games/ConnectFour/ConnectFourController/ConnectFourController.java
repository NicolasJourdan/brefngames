package Game.Games.ConnectFour.ConnectFourController;

import Contest.Model.ContestDataPersistor;
import Game.Controller.AbstractGameController;
import Game.Games.ConnectFour.ConnectFourModel.ConnectFourModel;
import Game.Games.ConnectFour.ConnectFourStatsEnum;
import Game.Games.ConnectFour.ConnectFourView.ConnectFourView;
import Game.Games.Coord;
import Game.Model.Pawn;
import Repository.Player.PlayerStatsEnum;
import Scene.Model.ActionEnum;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class ConnectFourController extends AbstractGameController {
    private int rows;
    private int columns;
    private int round;
    private long initTime;
    private long finalTime;
    private String totalTime;
    private Map<ConnectFourStatsEnum, String> gameStats;
    private Map<PlayerStatsEnum, String> firstPlayerStats;
    private Map<PlayerStatsEnum, String> secondPlayerStats;


    public ConnectFourController(ConnectFourModel m, ConnectFourView v, int rows, int columns, boolean isTraining) {
        super(m, v, isTraining);
        this.rows = rows;
        this.columns = columns;
        this.round = 0;
        initStats();
        initTime = System.currentTimeMillis();
    }

    @Override
    public void update(Observable o, Object arg) {
        Coord coord = (Coord) arg;
        Pawn pawn = ((ConnectFourModel) this.model).setPawnModel(coord);
        if (pawn != null) {
            String status = pawn.toString();
            if (!status.isEmpty()) {
                round += 1;
                if (status.equals("R")) {
                    int cross = Integer.parseInt(this.gameStats.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS)) + 1;
                    this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS, Integer.toString(cross));
                } else {
                    int circle = Integer.parseInt(this.gameStats.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS)) + 1;
                    this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS, Integer.toString(circle));
                }
                Color color = ((ConnectFourModel) this.model).getCurrentPlayer().getColor();
                ((ConnectFourView) this.view).setPawnView(color, pawn.getCoord());
                String orient = ((ConnectFourModel) this.model).isWinner();
                if (!orient.isEmpty()) {
                    this.setChanged();
                    if (((ConnectFourModel) this.model).getCurrentPlayer().getName().equals(((ConnectFourModel) this.model).getPlayers()[0].getName())) {
                        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                        this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                        this.firstPlayerStats.put(PlayerStatsEnum.CONNECT_FOUR_NB_WIN, "1");
                        sendStats(orient);
                        this.notifyObservers(ActionEnum.FIRST_PLAYER_WON);
                        return;
                    } else {
                        this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                        this.secondPlayerStats.put(PlayerStatsEnum.CONNECT_FOUR_NB_WIN, "0");
                        sendStats(orient);
                        this.notifyObservers(ActionEnum.SECOND_PLAYER_WON);
                        return;
                    }
                }
                if (((ConnectFourModel) this.model).isDraw()) {
                    this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_DRAW, "1");
                    sendStats(orient);
                    this.setChanged();
                    this.notifyObservers(ActionEnum.DRAW);
                    return;
                }
                ((ConnectFourModel) this.model).changePlayer();
            }
        }
    }

    private void initStats(){
        //Game Stats
        this.gameStats = new HashMap<>();
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS, "0");
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS, "0");
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_ALL_PAWNS, "0");
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_DRAW, "0");
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_GAMES, "1");
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
        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");
    }

    private void sendStats(String orient){
        if (this.isTraining) {
            return;
        }
        if (orient.equals("vertical")) {
            this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_VERTICAL, "1");
        }
        else if (orient.equals("landscape")) {
            this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_LANDSCAPE, "1");
        }
        else if (orient.equals("diagonal")) {
            this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_DIAG, "1");
        }

        finalTime = System.currentTimeMillis();
        totalTime = Long.toString((finalTime - initTime)/1000);
        int yellowNb = Integer.parseInt(this.gameStats.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS));
        int redNb = Integer.parseInt(this.gameStats.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS));
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_ALL_PAWNS, Integer.toString(yellowNb + redNb));
        this.gameStats.put(ConnectFourStatsEnum.CONNECT_FOUR_TOTAL_TIME, totalTime);
        ContestDataPersistor.updateConnectFour(this.gameStats);
        ContestDataPersistor.updateDataPlayer(((ConnectFourModel) this.model).getPlayers()[0].getName(),this.firstPlayerStats);
        ContestDataPersistor.updateDataPlayer(((ConnectFourModel) this.model).getPlayers()[1].getName(),this.secondPlayerStats);
    }
}
