package Game.Games.TicTacToe.TicTacToeController;

import Contest.Model.ContestDataPersistor;
import Game.Controller.AbstractGameController;
import Game.Games.TicTacToe.TicTacToeModel.*;
import Game.Games.TicTacToe.TicTacToeStatsEnum;
import Game.Games.TicTacToe.TicTacToeView.Coord;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;
import Repository.Player.PlayerStatsEnum;
import Scene.Model.ActionEnum;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class TicTacToeController extends AbstractGameController {
    private int size;
    private int round;
    private long initTime;
    private long finalTime;
    private String totalTime;
    private Map<TicTacToeStatsEnum, String> statsMap;
    private Map<PlayerStatsEnum, String> statsFirstPlayer;
    private Map<PlayerStatsEnum, String> statsSecondPlayer;


    public TicTacToeController(TicTacToeModel m, TicTacToeView v, int size, boolean isTraining) {
        super(m, v, isTraining);
        this.size = size;
        this.round = 0;
        initStats();
        initTime = System.currentTimeMillis();
    }

    @Override
    public void update(Observable o, Object arg) {
        Coord coord = (Coord) arg;
        String status = ((TicTacToeModel) this.model).setPawnModel(coord);
        if (status != null) {
            round += 1;
            if (status.equals("x")){
                int cross = Integer.parseInt(this.statsMap.get(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CROSS)) + 1;
                this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CROSS, Integer.toString(cross));
            }
            else{
                int circle = Integer.parseInt(this.statsMap.get(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CIRCLE)) + 1;
                this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CIRCLE, Integer.toString(circle));
            }
            Color color = ((TicTacToeModel) this.model).getCurrentPlayer().getColor();
            ((TicTacToeView) this.view).setPawnView(status, color, coord);
            if (((TicTacToeModel) this.model).isWinner()) {
                this.setChanged();
                if (round<=6){
                    this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_PERFECT, "1");
                }
                if (((TicTacToeModel) this.model).getCurrentPlayer().getName().equals(((TicTacToeModel) this.model).getPlayers()[0].getName())) {
                    this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                    this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                    this.statsFirstPlayer.put(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN, "1");
                    sendStats();
                    this.notifyObservers(ActionEnum.PLAYER_1_WON);
                    return;
                } else {
                    this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                    this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                    this.statsSecondPlayer.put(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN, "1");
                    sendStats();
                    this.notifyObservers(ActionEnum.PLAYER_2_WON);
                    return;
                }
            }
            if (((TicTacToeModel) this.model).isDraw()) {
                this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_DRAW, "1");
                sendStats();
                this.setChanged();
                this.notifyObservers(ActionEnum.DRAW);
                return;
            }
            ((TicTacToeModel) this.model).changePlayer();
        }
    }

    private void initStats(){
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

    private void sendStats(){
        if (this.isTraining) {
            return;
        }

        finalTime = System.currentTimeMillis();
        totalTime = Long.toString((finalTime - initTime)/1000);
        int crossNb = Integer.parseInt(this.statsMap.get(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CIRCLE));
        int circleNb = Integer.parseInt(this.statsMap.get(TicTacToeStatsEnum.TIC_TAC_TOE_NB_CROSS));
        this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_ALL_SIGNS, Integer.toString(crossNb + circleNb));
        this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_TOTAL_TIME, totalTime);
        ContestDataPersistor.updateTicTacToe(this.statsMap);
        ContestDataPersistor.updateDataPlayer(((TicTacToeModel) this.model).getPlayers()[0].getName(),this.statsFirstPlayer);
        ContestDataPersistor.updateDataPlayer(((TicTacToeModel) this.model).getPlayers()[1].getName(),this.statsSecondPlayer);
    }
}
