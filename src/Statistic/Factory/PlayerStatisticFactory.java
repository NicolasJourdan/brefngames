package Statistic.Factory;

import Repository.Player.PlayerStatsEnum;

public class PlayerStatisticFactory {
    public static String getStringStat(PlayerStatsEnum stat) {
        switch (stat) {
            case TIC_TAC_TOE_NB_GAME:
                return "TicTacToe Number of games";
            case TIC_TAC_TOE_NB_WIN:
                return "TicTacToe Number of win";
            case TIC_TAC_TOE_WIN_POURCENT:
                return "TicTacToe pourcent of win";
            case CONNECT_FOUR_NB_GAME:
                return "Connect Four Number of games";
            case CONNECT_FOUR_NB_WIN:
                return "Connect Four Number of win";
            case CONNECT_FOUR_WIN_RATE:
                return "Connect Four pourcent of win";
            case RUNNER_NB_GAME:
                return "Runner Number of games";
            case RUNNER_NB_WIN:
                return "Runner Number of wins";
            case RUNNER_WIN_RATE:
                return "Runner pourcent of win";
            case COOKIE_CLICKER_NB_GAME:
                return "Cookie Clicker Number of games";
            case COOKIE_CLICKER_NB_WIN:
                return "Cookie Clicker Number of win";
            case COOKIE_CLICKER_WIN_RATE:
                return "Cookie Clicker pourcent of win";
            case MOST_PLAYED_GAME:
                return "Most played Game";
            case TOTAL_NB_GAME:
                return "Number total of game";
            case TOTAL_NB_WIN:
                return "Number of win game";
            case TOTAL_NB_LOOSE:
                return "Number of loose game";
            case WIN_RATE:
                return "Win Rate";
            default:
                throw new RuntimeException("The statistic : " + stat.toString() + " is unknown");
        }
    }
}
