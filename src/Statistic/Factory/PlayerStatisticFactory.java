package Statistic.Factory;

import Repository.Player.PlayerStatsEnum;

public class PlayerStatisticFactory {
    public static String getStringStat(PlayerStatsEnum stat) {
        switch (stat) {
            case TIC_TAC_TOE_NB_GAME:
                return "Tic Tac Toe number of games";
            case TIC_TAC_TOE_NB_WIN:
                return "Tic Tac Toe number of wins";
            case TIC_TAC_TOE_WIN_RATE:
                return "Tic Tac Toe percent of wins";
            case CONNECT_FOUR_NB_GAME:
                return "Connect Four number of games";
            case CONNECT_FOUR_NB_WIN:
                return "Connect Four number of wins";
            case CONNECT_FOUR_WIN_RATE:
                return "Connect Four percent of wins";
            case RUNNER_NB_GAME:
                return "Runner number of games";
            case RUNNER_NB_WIN:
                return "Runner number of wins";
            case RUNNER_WIN_RATE:
                return "Runner percent of wins";
            case COOKIE_CLICKER_NB_GAME:
                return "Cookie Clicker number of games";
            case COOKIE_CLICKER_NB_WIN:
                return "Cookie Clicker number of wins";
            case COOKIE_CLICKER_WIN_RATE:
                return "Cookie Clicker percent of wins";
            case MOST_PLAYED_GAME:
                return "Most played game";
            case TOTAL_NB_GAME:
                return "Number total of games";
            case TOTAL_NB_WIN:
                return "Number of win games";
            case TOTAL_NB_LOOSE:
                return "Number of loose games";
            case WIN_RATE:
                return "Win rate";
            default:
                throw new RuntimeException("The statistic : " + stat.toString() + " is unknown");
        }
    }
}
