package Game.Games.FifteenVaincModel.FifteenVaincModel;

import Contest.Model.ContestDataPersistor;
import Game.Games.Coord;
import Game.Games.DataObject.PawnDataObject;
import Game.Games.FifteenVaincModel.FifteenVaincStatsEnum;
import Game.Model.AbstractGameModel;
import Game.Model.Pawn;
import Player.Player;
import Repository.Player.PlayerStatsEnum;
import Scene.Model.ActionEnum;
import Utils.Chronometer.Chronometer;

import java.awt.*;
import java.util.*;
import java.util.List;

public class FifteenVaincModel extends AbstractGameModel {
    private final static int NB_COLUMN = 9;
    private final static int NB_ROWS = 1;
    private final static int NB_TO_WIN = 15;
    private static int DEFAULT_NB_PLAYERS = 2;

    private Board board;
    private Player currentPlayer;

    private Chronometer chronometer;
    private int round;
    private Map<FifteenVaincStatsEnum, String> statsMap;
    private Map<PlayerStatsEnum, String> statsFirstPlayer;
    private Map<PlayerStatsEnum, String> statsSecondPlayer;
    private Chronometer chrono;

    public FifteenVaincModel(Player[] listPlayers) {
        super(listPlayers);
        Random random = new Random();
        this.currentPlayer = listPlayers[random.nextInt(FifteenVaincModel.DEFAULT_NB_PLAYERS)];
        this.board = new Board(NB_ROWS,NB_COLUMN);
        this.round = 0;
        this.initStats();
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public boolean isWinner() {
        List<Pawn> boxes = this.board.getGrid().get(0);
        String player;
        ArrayList<Integer> listNumbers = new ArrayList<>();

        int cpt = 0;
        if (this.currentPlayer.equals(listPlayers[0])) {
            player = "J1";
        } else {
            player = "J2";
        }
        // Count number of boxes selected
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i) != null && player == boxes.get(i).toString()) {
                listNumbers.add(i+1);
                cpt++;
            }
        }
        // At least 3 boxes should be added
        if (cpt < 3) {
            return false;
        }

        for (int x = 0; x < listNumbers.size()-2; x++) {
            for (int y = x+1; y < listNumbers.size()-1; y++) {
                for (int z = y+1; z < listNumbers.size(); z++) {
                    if ( listNumbers.get(x) + listNumbers.get(y) + listNumbers.get(z) == NB_TO_WIN) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public String setBoxModel(Coord coord) {
        Pawn pawn;
        Pawn status;
        if (this.currentPlayer.equals(listPlayers[0])) {
            pawn = new Box(this.currentPlayer, coord, "J1");
        } else { // listPlayers[1]
            pawn = new Box(this.currentPlayer, coord, "J2");
        }
        status = board.setPawn(pawn);
        return status != null ? status.toString() : "";
    }

    public void changePlayer() {
        this.currentPlayer = this.currentPlayer.equals(this.listPlayers[0]) ? this.listPlayers[1] : this.listPlayers[0];
    }

    public boolean isDraw(){
        return this.board.isFill();
    }

    public void updatePlayerStats() {
        if (this.isWinner()) {
            if (this.round<=6){
                this.statsMap.put(FifteenVaincStatsEnum.FIFTEEN_VAINC_NB_PERFECT, "1");
            }
            if (this.getCurrentPlayer().getName().equals(this.getPlayers()[0].getName())) {
                this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                this.statsFirstPlayer.put(PlayerStatsEnum.FIFTEEN_VAINC_NB_WIN, "1");
            } else {
                this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                this.statsSecondPlayer.put(PlayerStatsEnum.FIFTEEN_VAINC_NB_WIN, "1");
            }
        } else {
            // If no winner => Draw
            this.statsMap.put(FifteenVaincStatsEnum.FIFTEEN_VAINC_NB_DRAW, "1");
        }
    }

    public PawnDataObject play(Coord coord) {
        String status = this.setBoxModel(coord);
        if (!status.isEmpty()) {
            this.round += 1;
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

    public void sendStats(){
        this.statsMap.put(FifteenVaincStatsEnum.FIFTEEN_VAINC_TOTAL_TIME, Long.toString(this.chrono.getDuration()));
        ContestDataPersistor.updateFifteenVainc(this.statsMap);
        ContestDataPersistor.updateDataPlayer(this.getPlayers()[0].getName(),this.statsFirstPlayer);
        ContestDataPersistor.updateDataPlayer(this.getPlayers()[1].getName(),this.statsSecondPlayer);
    }
}

