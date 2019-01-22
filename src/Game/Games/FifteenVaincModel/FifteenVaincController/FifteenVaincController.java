package Game.Games.FifteenVaincModel.FifteenVaincController;

import Contest.Model.ContestDataPersistor;
import Game.Controller.AbstractGameController;
import Game.Games.Coord;
import Game.Games.FifteenVaincModel.FifteenVaincModel.FifteenVaincModel;
import Game.Games.FifteenVaincModel.FifteenVaincStatsEnum;
import Game.Games.FifteenVaincModel.FifteenVaincView.FifteenVaincView;
import Repository.Player.PlayerStatsEnum;
import Scene.Model.ActionEnum;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class FifteenVaincController extends AbstractGameController {
    private int row;
    private int column;
    private int round;
    private long initTime;
    private long finalTime;
    private String totalTime;
    private Map<FifteenVaincStatsEnum, String> statsMap;
    private Map<PlayerStatsEnum, String> statsFirstPlayer;
    private Map<PlayerStatsEnum, String> statsSecondPlayer;

    public FifteenVaincController(FifteenVaincModel m, FifteenVaincView v, int row, int column, boolean isTraining) {
        super(m, v, isTraining);
        this.row = row;
        this.column = column;
        this.round = 0;
        this.initStats();
        this.initTime = System.currentTimeMillis();
    }

    @Override
    public void update(Observable o, Object arg) {
        Coord coord = (Coord) arg;
        // Return J1 or J2
        String status = ((FifteenVaincModel) this.model).setBoxModel(coord);
        if (!status.isEmpty()) {
            round += 1;
            Color color = ((FifteenVaincModel) this.model).getCurrentPlayer().getColor();
            ((FifteenVaincView) this.view).setPawnView(status, color, coord);
            if (((FifteenVaincModel) this.model).isWinner()) {
                this.setChanged();
                if (round<=6){
                    this.statsMap.put(FifteenVaincStatsEnum.FIFTEEN_VAINC_NB_PERFECT, "1");
                }
                if (((FifteenVaincModel) this.model).getCurrentPlayer().getName().equals(((FifteenVaincModel) this.model).getPlayers()[0].getName())) {
                    this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                    this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                    this.statsFirstPlayer.put(PlayerStatsEnum.FIFTEEN_VAINC_NB_WIN, "1");
                    this.sendStats();
                    this.notifyObservers(ActionEnum.FIRST_PLAYER_WON);
                    return;
                } else {
                    this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                    this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                    this.statsSecondPlayer.put(PlayerStatsEnum.FIFTEEN_VAINC_NB_WIN, "1");
                    this.sendStats();
                    this.notifyObservers(ActionEnum.SECOND_PLAYER_WON);
                    return;
                }
            }
            if (((FifteenVaincModel) this.model).isDraw()) {
                this.statsMap.put(FifteenVaincStatsEnum.FIFTEEN_VAINC_NB_DRAW, "1");
                this.sendStats();
                this.setChanged();
                this.notifyObservers(ActionEnum.DRAW);
                return;
            }
            ((FifteenVaincModel) this.model).changePlayer();
            ((FifteenVaincView) this.view).changePlayer();
        }
    }

    private void initStats(){
        this.statsMap = new HashMap<>();
        this.statsFirstPlayer = new HashMap<>();
        this.statsSecondPlayer = new HashMap<>();
        this.statsMap.put(FifteenVaincStatsEnum.FIFTEEN_VAINC_NB_PERFECT, "0");
        this.statsMap.put(FifteenVaincStatsEnum.FIFTEEN_VAINC_NB_DRAW, "0");
        this.statsMap.put(FifteenVaincStatsEnum.FIFTEEN_VAINC_NB_GAMES, "1");


        this.statsFirstPlayer.put(PlayerStatsEnum.FIFTEEN_VAINC_NB_GAME, "1");
        this.statsFirstPlayer.put(PlayerStatsEnum.FIFTEEN_VAINC_NB_WIN, "0");
        this.statsFirstPlayer.put(PlayerStatsEnum.FIFTEEN_VAINC_WIN_RATE, "0");
        this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");

        this.statsSecondPlayer.put(PlayerStatsEnum.FIFTEEN_VAINC_NB_GAME, "1");
        this.statsSecondPlayer.put(PlayerStatsEnum.FIFTEEN_VAINC_NB_WIN, "0");
        this.statsSecondPlayer.put(PlayerStatsEnum.FIFTEEN_VAINC_WIN_RATE, "0");
        this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");
    }

    private void sendStats(){
        if (this.isTraining) {
            return;
        }

        this.finalTime = System.currentTimeMillis();
        this.totalTime = Long.toString((finalTime - initTime)/1000);
        this.statsMap.put(FifteenVaincStatsEnum.FIFTEEN_VAINC_TOTAL_TIME, totalTime);
        ContestDataPersistor.updateFifteenVainc(this.statsMap);
        ContestDataPersistor.updateDataPlayer(((FifteenVaincModel) this.model).getPlayers()[0].getName(),this.statsFirstPlayer);
        ContestDataPersistor.updateDataPlayer(((FifteenVaincModel) this.model).getPlayers()[1].getName(),this.statsSecondPlayer);
    }
}
