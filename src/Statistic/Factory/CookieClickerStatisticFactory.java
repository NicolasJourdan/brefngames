package Statistic.Factory;

import Game.Games.CookieClicker.CookieClickerStatsEnum;

public class CookieClickerStatisticFactory {
    public static String getStringStat(CookieClickerStatsEnum stat) {
        switch (stat) {
            case COOKIE_CLICKER_NB_GAMES:
                return "Cookie Clicker number of games";
            case COOKIE_CLICKER_NB_CLICKS:
                return "Cookie Clicker number of clicks";
            case COOKIE_CLICKER_NB_PERFECT:
                return "Cookie Clicker number of perfects";
            case COOKIE_CLICKER_TOTAL_REQUIRED_CLICKS:
                return "Cookie Clicker number of click required";
            case COOKIE_CLICKER_AVERAGE_REQUIRED_CLICKS:
                return "Cookie Clicker number of average click required";
            case COOKIE_CLICKER_TOTAL_FAULT:
                return "Cookie Clicker number of faults";
            case COOKIE_CLICKER_AVERAGE_FAULT:
                return "Cookie Clicker average faults";
            case COOKIE_CLICKER_TOTAL_TIME:
                return "Cookie Clicker total time";
            case COOKIE_CLICKER_BEST_PLAYER:
                return "Cookie Clicker best player";
            default:
                throw new RuntimeException("The statistic : " + stat.toString() + " is unknown");
        }
    }
}
