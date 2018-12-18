package Statistic.Factory;

import Game.Games.GlobalStatisticsEnum;

public class GlobalStatisticFactory {
    public static String getStringStat(GlobalStatisticsEnum stat) {
        switch (stat) {
            case MOST_PLAYED_GAME:
                return "Most played game";
            case MOST_ADDICT_PLAYER:
                return "Most addicted player";
            case NB_TOTAL_GAMES:
                return "Number total of games";
            case BEST_PLAYER:
                return "Best player";
            default:
                throw new RuntimeException("The statistic : " + stat.toString() + " is unknown");
        }
    }
}
