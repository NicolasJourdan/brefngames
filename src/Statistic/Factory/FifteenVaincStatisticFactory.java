package Statistic.Factory;

import Game.Games.FifteenVainc.FifteenVaincStatsEnum;

public class FifteenVaincStatisticFactory {
    public static String getStringStat(FifteenVaincStatsEnum stat) {
        switch (stat) {
            case FIFTEEN_VAINC_NB_GAMES:
                return "Tic tac toe number of games";
            case FIFTEEN_VAINC_NB_DRAW:
                return "Tic tac toe number of draws";
            case FIFTEEN_VAINC_NB_PERFECT:
                return "Tic tac toe number of perfects";
            case FIFTEEN_VAINC_TOTAL_TIME:
                return "Tic tac toe total time";
            case FIFTEEN_VAINC_BEST_PLAYER:
                return "Tic tac toe best player";
            default:
                throw new RuntimeException("The statistic : " + stat.toString() + " is unknown");
        }
    }
}
