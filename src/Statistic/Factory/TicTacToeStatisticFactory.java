package Statistic.Factory;

import Game.Games.TicTacToe.TicTacToeStatsEnum;

public class TicTacToeStatisticFactory {
    public static String getStringStat(TicTacToeStatsEnum stat) {
        switch (stat) {
            case TIC_TAC_TOE_NB_GAMES:
                return "Tic tac toe number of games";
            case TIC_TAC_TOE_NB_DRAW:
                return "Tic tac toe number of draws";
            case TIC_TAC_TOE_NB_PERFECT:
                return "Tic tac toe number of perfects";
            case TIC_TAC_TOE_NB_CROSS:
                return "Tic tac toe number of cross";
            case TIC_TAC_TOE_NB_CIRCLE:
                return "Tic tac toe number of circles";
            case TIC_TAC_TOE_NB_ALL_SIGNS:
                return "Tic tac toe number all signs";
            case TIC_TAC_TOE_AVERAGE_TIME:
                return "Tic tac toe average time";
            case TIC_TAC_TOE_TOTAL_TIME:
                return "Tic tac toe total time";
            case TIC_TAC_TOE_BEST_PLAYER:
                return "Tic tac toe best player";
            default:
                throw new RuntimeException("The statistic : " + stat.toString() + " is unknown");
        }
    }
}
