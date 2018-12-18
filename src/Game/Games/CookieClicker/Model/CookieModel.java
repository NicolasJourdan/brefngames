package Game.Games.CookieClicker.Model;

import Game.Model.AbstractGameModel;
import Player.Player;

public class CookieModel extends AbstractGameModel{

    private static int DEFAULT_MAX_NUMBER = 40;
    private int goal;
    private int totFirstPlayer;
    private int totSecondPlayer;
    private int diffFirstPlayer;
    private int diffSecondPlayer;

    public CookieModel(Player[] players) {
        super(players);
        this.totFirstPlayer =0;
        this.totSecondPlayer =0;
        this.diffFirstPlayer =0;
        this.diffSecondPlayer =0;
        this.goal = (int) ((Math.random()*DEFAULT_MAX_NUMBER) + 1);
    }

    public int getTotFirstPlayer() {
        return totFirstPlayer;
    }

    public int getTotSecondPlayer() {
        return totSecondPlayer;
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
}
