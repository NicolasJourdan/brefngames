package Scene.Model;

public enum ActionEnum {

    /*
     * GameScene
     */
    PLAYER_1_WON("PLAYER_1_WON"),
    PLAYER_2_WON("PLAYER_2_WON"),

    /*
     * Menu
     */
    TRAINING("TRAINING"),
    END_TRAINING("END_TRAINING"),
    CONTEST("CONTEST"),
    STATISTICS("STATISTICS"),
    PARAMETERS("PARAMETERS"),
    QUIT("QUIT"),
    ;

    private String name = "";

    /**
     * Create an action.
     *
     * @return the action
     */
    ActionEnum(String s)
    {
        this.name = s;
    }

    /**
     * The method to display the name
     *
     * @return name is the name of the action
     */
    @Override public String toString()
    {
        return this.name;
    }

}
