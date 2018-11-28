package Game.Games.CookieClicker.Model;

import Game.Model.AbstractGameModel;
import Player.Player;
import Statistic.Model.Statistic;
import java.util.List;


public class CookieModel extends AbstractGameModel{

    private static int DEFAULT_MAX_NUMBER = 20;
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
        this.diffJ1 = (this.totJ1 < this.goal) ? (this.goal - this.totJ1) : (this.totJ1 - this.goal);
        this.diffJ2 = (this.totJ2 < this.goal) ? (this.goal - this.totJ2) : (this.totJ2 - this.goal);
    }

    @Override
    public List<Statistic> getListStatistics() {
        return null;
    }
}

