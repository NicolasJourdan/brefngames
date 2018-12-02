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
    private Map<ConnectFourStatsEnum, String> statsMap;
    private Map<PlayerStatsEnum, String> statsp1;
    private Map<PlayerStatsEnum, String> statsp2;


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
                    int cross = Integer.parseInt(this.statsMap.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS)) + 1;
                    this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS, Integer.toString(cross));
                } else {
                    int circle = Integer.parseInt(this.statsMap.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS)) + 1;
                    this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS, Integer.toString(circle));
                }
                Color color = ((ConnectFourModel) this.model).getCurrentPlayer().getColor();
                ((ConnectFourView) this.view).setPawnView(color, pawn.getCoord());
                String orient = ((ConnectFourModel) this.model).isWinner();
                if (!orient.isEmpty()) {
                    this.setChanged();
                    if (((ConnectFourModel) this.model).getCurrentPlayer().getName().equals(((ConnectFourModel) this.model).getPlayers()[0].getName())) {
                        this.statsp1.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                        this.statsp2.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                        this.statsp1.put(PlayerStatsEnum.CONNECT_FOUR_NB_WIN, "1");
                        sendStats(orient);
                        this.notifyObservers(ActionEnum.PLAYER_1_WON);
                        return;
                    } else {
                        this.statsp2.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                        this.statsp1.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                        this.statsp2.put(PlayerStatsEnum.CONNECT_FOUR_NB_WIN, "0");
                        sendStats(orient);
                        this.notifyObservers(ActionEnum.PLAYER_2_WON);
                        return;
                    }
                }
                if (((ConnectFourModel) this.model).isDraw()) {
                    this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_DRAW, "1");
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
        this.statsMap = new HashMap<>();
        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS, "0");
        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS, "0");
        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_ALL_PAWNS, "0");
        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_DRAW, "0");
        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_GAMES, "1");

        this.statsp1 = new HashMap<>();
        this.statsp1.put(PlayerStatsEnum.CONNECT_FOUR_NB_GAME, "1");
        this.statsp1.put(PlayerStatsEnum.CONNECT_FOUR_NB_WIN, "0");
        this.statsp1.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.statsp1.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.statsp1.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");

        this.statsp2 = new HashMap<>();
        this.statsp2.put(PlayerStatsEnum.CONNECT_FOUR_NB_GAME, "1");
        this.statsp2.put(PlayerStatsEnum.CONNECT_FOUR_NB_WIN, "0");
        this.statsp1.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.statsp1.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.statsp1.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");
    }

    private void sendStats(String orient){
        if (this.isTraining) {
            return;
        }
        if (orient.equals("vertical")) {
            this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_VERTICAL, "1");
        }
        else if (orient.equals("landscape")) {
            this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_LANDSCAPE, "1");
        }
        else if (orient.equals("diagonal")) {
            this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_DIAG, "1");
        }

        finalTime = System.currentTimeMillis();
        totalTime = Long.toString((finalTime - initTime)/1000);
        int yellowNb = Integer.parseInt(this.statsMap.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS));
        int redNb = Integer.parseInt(this.statsMap.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS));
        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_ALL_PAWNS, Integer.toString(yellowNb + redNb));
        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_TOTAL_TIME, totalTime);
        ContestDataPersistor.updateConnectFour(this.statsMap);
        ContestDataPersistor.updateDataPlayer(((ConnectFourModel) this.model).getPlayers()[0].getName(),this.statsp1);
        ContestDataPersistor.updateDataPlayer(((ConnectFourModel) this.model).getPlayers()[1].getName(),this.statsp2);
    }
}
