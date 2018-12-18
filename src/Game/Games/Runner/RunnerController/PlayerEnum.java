package Game.Games.Runner.RunnerController;

public enum PlayerEnum {
    FIRST_PLAYER("FIRST_PLAYER"),
    SECOND_PLAYER("SECOND_PLAYER"),
    ;

    private String name = "";

    /**
     * Create a player.
     *
     * @return the player
     */
    PlayerEnum(String s)
    {
        this.name = s;
    }

    /**
     * The method to display the name
     *
     * @return name is the name of the player
     */
    @Override public String toString()
    {
        return this.name;
    }
}
