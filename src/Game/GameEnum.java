package Game;

/**
 * List of all game enum
 */
public enum GameEnum {

    TIC_TAC_TOE("TIC_TAC_TOE"),
    CONNECT_FOUR("CONNECT_FOUR"),
    RUNNER("RUNNER"),
    COOKIE_CLICKER("COOKIE_CLICKER"),
    ;

    private String name = "";

    /**
     * Create a game enum.
     */
    GameEnum(String s)
    {
        this.name = s;
    }

    /**
     * The method to display the name
     *
     * @return name is the name of the game enum
     */
    @Override public String toString()
    {
        return this.name;
    }

}
