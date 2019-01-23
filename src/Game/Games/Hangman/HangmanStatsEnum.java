package Game.Games.Hangman;

public enum HangmanStatsEnum {
    /*
     * Hangman
     */
    HANGMAN_NB_GAMES("HANGMAN_NB_GAMES"),
    HANGMAN_NB_CORRECT_LETTERS("HANGMAN_NB_CORRECT_LETTERS"),
    HANGMAN_NB_WRONG_LETTERS("HANGMAN_NB_WRONG_LETTERS"),
    HANGMAN_NB_LETTERS("HANGMAN_NB_LETTERS"),
    HANGMAN_BEST_PLAYER("HANGMAN_BEST_PLAYER"),
    HANGMAN_NB_PERFECT("HANGMAN_NB_PERFECT"),
    HANGMAN_AVERAGE_TIME("HANGMAN_AVERAGE_TIME"),
    HANGMAN_TOTAL_TIME("HANGMAN_TOTAL_TIME")
    ;

    private String name = "";

    HangmanStatsEnum(String s)
    {
        this.name = s;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
