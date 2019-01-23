package Statistic.Factory;

import Game.Games.Hangman.HangmanStatsEnum;

public class HangmanStatisticFactory {
    public static String getStringStat(HangmanStatsEnum stat) {
        switch (stat) {
            case HANGMAN_NB_GAMES:
                return "Hangman number of games";
            case HANGMAN_NB_CORRECT_LETTERS:
                return "Hangman number of letters found";
            case HANGMAN_NB_WRONG_LETTERS:
                return "Hangman number of mistakes";
            case HANGMAN_NB_LETTERS:
                return "Hangman number of letters selected";
            case HANGMAN_NB_PERFECT:
                return "Hangman number of perfect wins";
            case HANGMAN_AVERAGE_TIME:
                return "Hangman average time";
            case HANGMAN_TOTAL_TIME:
                return "Hangman total time";
            case HANGMAN_BEST_PLAYER:
                return "Hangman best player";
            default:
                throw new RuntimeException("The statistic : " + stat.toString() + " is unknown");
        }
    }
}
