package Game.Games.CookieClicker.Model;

import Game.Model.AbstractGameModel;
import Player.Player;

public class CookieModel extends AbstractGameModel{

    private static int DEFAULT_MAX_NUMBER = 40;
    private int goal;
    private int totJ1;
    private int totJ2;
    private int diffJ1;
    private int diffJ2;

    public CookieModel(Player[] players) {
        super(players);
        this.totJ1=0;
        this.totJ2=0;
        this.diffJ1=0;
        this.diffJ2=0;
        this.goal = (int) ((Math.random()*DEFAULT_MAX_NUMBER) + 1);
    }

    public int getTotJ1() {
        return totJ1;
    }

    public int getTotJ2() {
        return totJ2;
    }

    public int getGoal() {
        return this.goal;
    }

    public int getDiffJ1() {
        return this.diffJ1;
    }

    public int getDiffJ2() {
        return this.diffJ2;
    }

    public void addJ1() {
        this.totJ1++;
    }

    public void addJ2() {
        this.totJ2++;
    }

    public void check() {
        this.diffJ1 = Math.abs(this.totJ1 - this.goal);
        this.diffJ2 = Math.abs(this.totJ2 - this.goal);
    }
}
