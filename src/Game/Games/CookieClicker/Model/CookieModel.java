package Game.Games.CookieClicker.Model;

import Contest.Model.ContestDataPersistor;
import Game.Games.CookieClicker.CookieClickerStatsEnum;
import Game.Model.AbstractGameModel;
import Player.Player;
import Repository.Player.PlayerStatsEnum;
import Scene.Model.ActionEnum;
import Utils.Chronometer.Chronometer;

import java.util.HashMap;
import java.util.Map;

public class CookieModel extends AbstractGameModel{

    private static int DEFAULT_MAX_NUMBER = 40;
    private int goal;
    private int totFirstPlayer;
    private int totSecondPlayer;
    private int diffFirstPlayer;
    private int diffSecondPlayer;
    private Map<CookieClickerStatsEnum, String> statsMap;
    private Map<PlayerStatsEnum, String> firstPlayerStats;
    private Map<PlayerStatsEnum, String> secondPlayerStats;
    private Chronometer chronometer;

    public CookieModel(Player[] players) {
        super(players);
        this.totFirstPlayer = 0;
        this.totSecondPlayer = 0;
        this.diffFirstPlayer = 0;
        this.diffSecondPlayer = 0;
        this.goal = (int) ((Math.random()* CookieModel.DEFAULT_MAX_NUMBER) + 1);
        this.initStats();
    }

    public int getTotFirstPlayer() {
        return this.totFirstPlayer;
    }

    public int getTotSecondPlayer() {
        return this.totSecondPlayer;
    }

    public int getGoal() {
        return this.goal;
    }

    public int getDiffFirstPlayer() {
        return this.diffFirstPlayer;
    }

    public int getDiffSecondPlayer() {
        return this.diffSecondPlayer;
    }

    public void addPointFirstPlayer() {
        this.totFirstPlayer++;
    }

    public void addPointSecondPlayer() {
        this.totSecondPlayer++;
    }

    public void check() {
        this.diffFirstPlayer = Math.abs(this.totFirstPlayer - this.goal);
        this.diffSecondPlayer = Math.abs(this.totSecondPlayer - this.goal);
    }

    private void initStats() {
        this.chronometer = new Chronometer();

        this.statsMap = new HashMap<>();
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_NB_GAMES, "1");
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_NB_CLICKS, "0");
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_NB_PERFECT, "0");
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_REQUIRED_CLICKS, "0");
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_FAULT, "0");
        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_TIME, "0");

        this.firstPlayerStats = new HashMap<>();
        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");
        this.firstPlayerStats.put(PlayerStatsEnum.COOKIE_CLICKER_NB_GAME, "1");
        this.firstPlayerStats.put(PlayerStatsEnum.COOKIE_CLICKER_NB_WIN, "0");

        this.secondPlayerStats = new HashMap<>();
        this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_GAME, "1");
        this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "0");
        this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "0");
        this.secondPlayerStats.put(PlayerStatsEnum.COOKIE_CLICKER_NB_GAME, "1");
        this.secondPlayerStats.put(PlayerStatsEnum.COOKIE_CLICKER_NB_WIN, "0");
    }

    public ActionEnum getWinner() {
        if (this.getDiffFirstPlayer() < this.getDiffSecondPlayer()) {
            return ActionEnum.FIRST_PLAYER_WON;
        } else if (this.getDiffFirstPlayer() > this.getDiffSecondPlayer()) {
            return ActionEnum.SECOND_PLAYER_WON;
        } else {
            return ActionEnum.DRAW;
        }
    }

    public void updatePlayerStats() {
        if (this.getDiffFirstPlayer() < this.getDiffSecondPlayer()) {
            this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
            this.firstPlayerStats.put(PlayerStatsEnum.COOKIE_CLICKER_NB_WIN, "1");
            this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
        } else if (this.getDiffFirstPlayer() > this.getDiffSecondPlayer()) {
            this.secondPlayerStats.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
            this.secondPlayerStats.put(PlayerStatsEnum.COOKIE_CLICKER_NB_WIN, "1");
            this.firstPlayerStats.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
        }
    }

    public void updateGlobalStats() {
        //Add nb clicks
        int nbClicks = Integer.parseInt(this.statsMap.get(CookieClickerStatsEnum.COOKIE_CLICKER_NB_CLICKS))
                + this.getTotFirstPlayer() + this.getTotSecondPlayer();

        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_NB_CLICKS, Integer.toString(nbClicks));

        //Add total required clicks
        int requiredClicks = Integer.parseInt(this.statsMap.get(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_REQUIRED_CLICKS))
                + this.getGoal();

        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_REQUIRED_CLICKS, Integer.toString(requiredClicks));

        //Add total fault
        int totalFault = Integer.parseInt(this.statsMap.get(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_FAULT))
                + this.getDiffFirstPlayer() + this.getDiffSecondPlayer();

        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_FAULT, Integer.toString(totalFault));

        //Add nb perfect
        if (0 == this.getDiffFirstPlayer() || 0 == this.getDiffSecondPlayer()) {
            int nbPerfect = Integer.parseInt(this.statsMap.get(CookieClickerStatsEnum.COOKIE_CLICKER_NB_PERFECT) + 1);
            this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_NB_PERFECT, Integer.toString(nbPerfect));
        }

        this.statsMap.put(CookieClickerStatsEnum.COOKIE_CLICKER_TOTAL_TIME, Integer.toString(this.chronometer.getDuration()));
    }

    public void sendGlobalStats() {
        ContestDataPersistor.updateCookieClicker(this.getStatsMap());
    }

    public void sendFirstPlayerStats() {
        ContestDataPersistor.updateDataPlayer(this.getPlayers()[0].getName(), this.getFirstPlayerStats());
    }

    public void sendSecondPlayerStats() {
        ContestDataPersistor.updateDataPlayer(this.getPlayers()[1].getName(), this.getSecondPlayerStats());
    }

    public Map<CookieClickerStatsEnum, String> getStatsMap() {
        return this.statsMap;
    }

    public Map<PlayerStatsEnum, String> getFirstPlayerStats() {
        return this.firstPlayerStats;
    }

    public Map<PlayerStatsEnum, String> getSecondPlayerStats() {
        return this.secondPlayerStats;
    }
}
