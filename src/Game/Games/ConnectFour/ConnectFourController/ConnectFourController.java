//package Game.Games.ConnectFour.ConnectFourController;
//
//import Contest.Model.ContestDataPersistor;
//import Game.Controller.AbstractGameController;
//import Game.Games.ConnectFour.ConnectFourModel.ConnectFourModel;
//import Game.Games.ConnectFour.ConnectFourStatsEnum;
//import Game.Games.ConnectFour.ConnectFourView.ConnectFourView;
//import Game.Games.TicTacToe.TicTacToeView.Coord;
//import Scene.Model.ActionEnum;
//
//import java.awt.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Observable;
//
//public class ConnectFourController extends AbstractGameController {
//    private int row;
//    private int column;
//    private int round;
//    private long initTime;
//    private long finalTime;
//    private String totalTime;
//    private Map<ConnectFourStatsEnum, String> statsMap;
//
//
//    public ConnectFourController(ConnectFourModel m, ConnectFourView v, int row, int column, boolean isTraining) {
//        super(m, v, isTraining);
//        this.row = row;
//        this.column = column;
//        this.round = 0;
//        initStats();
//        initTime = System.currentTimeMillis();
//    }
//
//    @Override
//    public void update(Observable o, Object arg) {
//        Coord coord = (Coord) arg;
//        String status = ((ConnectFourModel) this.model).setPawnModel(coord);
//        if (status != null) {
//            round += 1;
//            if (status.equals("x")){
//                int cross = Integer.parseInt(this.statsMap.get(ConnectFourStatsEnum.TIC_TAC_TOE_NB_CROSS)) + 1;
//                this.statsMap.put(ConnectFourStatsEnum.TIC_TAC_TOE_NB_CROSS, Integer.toString(cross));
//            }
//            else{
//                int circle = Integer.parseInt(this.statsMap.get(ConnectFourStatsEnum.TIC_TAC_TOE_NB_CIRCLE)) + 1;
//                this.statsMap.put(ConnectFourStatsEnum.TIC_TAC_TOE_NB_CIRCLE, Integer.toString(circle));
//            }
//            Color color = ((ConnectFourModel) this.model).getCurrentPlayer().getColor();
//            ((ConnectFourView) this.view).setPawnView(status, color, coord);
//            if (((ConnectFourModel) this.model).isWinner()) {
//                this.setChanged();
//                if (round<=6){
//                    this.statsMap.put(ConnectFourStatsEnum.TIC_TAC_TOE_NB_PERFECT, "1");
//                }
//                sendStats();
//                if (((ConnectFourModel) this.model).getCurrentPlayer().getName().equals(((ConnectFourModel) this.model).getPlayers()[0].getName())) {
//                    this.notifyObservers(ActionEnum.PLAYER_1_WON);
//                } else {
//                    this.notifyObservers(ActionEnum.PLAYER_2_WON);
//                }
//            }
//            if (((ConnectFourModel) this.model).isDraw()) {
//                this.statsMap.put(ConnectFourStatsEnum.TIC_TAC_TOE_NB_DRAW, "1");
//                sendStats();
//                this.setChanged();
//                this.notifyObservers(ActionEnum.DRAW);
//            }
//            ((ConnectFourModel) this.model).changePlayer();
//        }
//    }
//
//    private void initStats(){
//        this.statsMap = new HashMap<>();
//        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS, "0");
//        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS, "0");
//        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_ALL_PAWNS, "0");
//        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_DRAW, "0");
//        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_GAMES, "1");
//    }
//
//    private void sendStats(String orient){
//        if (this.isTraining) {
//            return;
//        }
//        if (orient.equals("vertical")) {
//            this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_VERTICAL, "1");
//        }
//        else if (orient.equals("landscape")) {
//            this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_LANDSCAPE, "1");
//        }
//        else if (orient.equals("diagonal")) {
//            this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_WIN_DIAG, "1");
//        }
//
//        finalTime = System.currentTimeMillis();
//        totalTime = Long.toString((finalTime - initTime)/1000);
//        int yellowNb = Integer.parseInt(this.statsMap.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_YELLOW_PAWNS));
//        int redNb = Integer.parseInt(this.statsMap.get(ConnectFourStatsEnum.CONNECT_FOUR_NB_RED_PAWNS));
//        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_NB_ALL_PAWNS, Integer.toString(yellowNb + redNb));
//        this.statsMap.put(ConnectFourStatsEnum.CONNECT_FOUR_TOTAL_TIME, totalTime);
//        ContestDataPersistor.updateConnectFour(this.statsMap);
//    }
//}
