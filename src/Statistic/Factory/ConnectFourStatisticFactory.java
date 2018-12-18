package Statistic.Factory;

import Game.Games.ConnectFour.ConnectFourStatsEnum;

public class ConnectFourStatisticFactory {
    public static String getStringStat(ConnectFourStatsEnum stat) {
        switch (stat) {
            case CONNECT_FOUR_NB_GAMES:
                return "Connect Four number of games";
            case CONNECT_FOUR_NB_DRAW:
                return "Connect Four number of draws";
            case CONNECT_FOUR_NB_YELLOW_PAWNS:
                return "Connect Four number of yellow pawns";
            case CONNECT_FOUR_NB_RED_PAWNS:
                return "Connect Four number of red pawns";
            case CONNECT_FOUR_NB_ALL_PAWNS:
                return "Connect Four number of all pawns";
            case CONNECT_FOUR_NB_WIN_VERTICAL:
                return "Connect Four number of vertical wins";
            case CONNECT_FOUR_NB_WIN_LANDSCAPE:
                return "Connect Four number of landscape wins";
            case CONNECT_FOUR_NB_WIN_DIAG:
                return "Connect Four number of diagonal wins";
            case CONNECT_FOUR_AVERAGE_TIME:
                return "Connect Four average time";
            case CONNECT_FOUR_TOTAL_TIME:
                return "Connect Four total time";
            case CONNECT_FOUR_BEST_PLAYER:
                return "Connect Four best player";
            default:
                throw new RuntimeException("The statistic : " + stat.toString() + " is unknown");
        }
    }
}
