package Game.Model;

public enum GameEnum {
    /*
     * Games
     */
    TIC_TAC_TOE("TIC_TAC_TOE"),
    CONNECT_FOUR("CONNECT_FOUR"),
    COOKIE_CLICKER("COOKIE_CLICKER"),
    RUNNER("RUNNER"),
    FIFTEEN_VAINC("FIFTEEN_VAINC"),
    HANGMAN("HANGMAN")
    ;

    private String name = "";

    /**
     * Create a game.
     *
     * @return the game
     */
    GameEnum(String s)
    {
        this.name = s;
    }

    /**
     * The method to display the name
     *
     * @return name is the name of the game
     */
    @Override public String toString()
    {
        return this.name;
    }
}
