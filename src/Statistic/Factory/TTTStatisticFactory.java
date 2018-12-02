package Statistic.Factory;

import Game.Games.TicTacToe.TicTacToeStatsEnum;

public class TTTStatisticFactory {
    public static String getStringStat(TicTacToeStatsEnum stat) {
        switch (stat) {
            case TIC_TAC_TOE_NB_GAMES:
                return "TicTacToe Number of games";
            case TIC_TAC_TOE_NB_DRAW:
                return "TicTacToe Number of draw";
            case TIC_TAC_TOE_NB_PERFECT:
                return "TicTacToe Number of perfect";
            case TIC_TAC_TOE_NB_CROSS:
                return "TicTacToe Number Cross";
            case TIC_TAC_TOE_NB_CIRCLE:
                return "TicTacToe Number of circle";
            case TIC_TAC_TOE_NB_ALL_SIGNS:
                return "TicTacToe Number all signs";
            case TIC_TAC_TOE_AVERAGE_TIME:
                return "TicTacToe average tile";
            case TIC_TAC_TOE_TOTAL_TIME:
                return "TicTacToe total time";
            case TIC_TAC_TOE_BEST_PLAYER:
                return "TicTacToe best player";
            default:
                throw new RuntimeException("The statistic : " + stat.toString() + " is unknown");
        }
    }
}
