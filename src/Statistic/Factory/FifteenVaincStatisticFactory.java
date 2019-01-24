package Statistic.Factory;

import Game.Games.FifteenVainc.FifteenVaincStatsEnum;

public class FifteenVaincStatisticFactory {
    public static String getStringStat(FifteenVaincStatsEnum stat) {
        switch (stat) {
            case FIFTEEN_VAINC_NB_GAMES:
                return "Fifteen Vainc number of games";
            case FIFTEEN_VAINC_NB_DRAW:
                return "Fifteen Vainc number of draws";
            case FIFTEEN_VAINC_NB_PERFECT:
                return "Fifteen Vainc number of perfects";
            case FIFTEEN_VAINC_TOTAL_TIME:
                return "Fifteen Vainc total time";
            case FIFTEEN_VAINC_BEST_PLAYER:
                return "Fifteen Vainc best player";
            default:
                throw new RuntimeException("The statistic : " + stat.toString() + " is unknown");
        }
    }
}
