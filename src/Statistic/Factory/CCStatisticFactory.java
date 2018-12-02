package Statistic.Factory;

import Game.Games.CookieClicker.CookieClickerStatsEnum;

public class CCStatisticFactory {
    public static String getStringStat(CookieClickerStatsEnum stat) {
        switch (stat) {
            case COOKIE_CLICKER_NB_GAMES:
                return "Cookie Clicker Number of games";
            case COOKIE_CLICKER_NB_CLICS:
                return "Cookie Clicker Number of click";
            case COOKIE_CLICKER_NB_PERFECT:
                return "Cookie Clicker Number of perfect";
            case COOKIE_CLICKER_TOTAL_REQUIRED_CLIC:
                return "Cookie Clicker Number of click required";
            case COOKIE_CLICKER_AVERAGE_REQUIRED_CLIC:
                return "Cookie Clicker Number of average click required";
            case COOKIE_CLICKER_TOTAL_FAULT:
                return "Cookie Clicker Number of fault";
            case COOKIE_CLICKER_AVERAGE_FAULT:
                return "Cookie Clicker average fault";
            case COOKIE_CLICKER_TOTAL_TIME:
                return "Cookie Clicker total time";
            case COOKIE_CLICKER_BEST_PLAYER:
                return "Cookie Clicker best player";
            default:
                throw new RuntimeException("The statistic : " + stat.toString() + " is unknown");
        }
    }
}
