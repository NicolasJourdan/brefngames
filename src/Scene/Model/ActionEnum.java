package Scene.Model;

public enum ActionEnum {

    /*
     * GameScene
     */
    PLAYER_1_WON("PLAYER_1_WON"),
    PLAYER_2_WON("PLAYER_2_WON"),

    TIC_TAC_TOE("TIC_TAC_TOE"),
    CONNECT_FOUR("CONNECT_FOUR"),
    RUNNER("RUNNER"),
    COOKIE_CLICKER("COOKIE_CLICKER"),
    TRAINING_MENU("TRAINING_MENU"),

    /*
     * Parameters
     */
    PARAMETERS_MENU("PARAMETERS_MENU"),
    THEME_SOUND_PARAMETERS("THEME_SOUND_PARAMETERS"),
    PLAYER_PARAMETERS("PLAYER_PARAMETERS"),

    /*
     * Menu
     */
    TRAINING("TRAINING"),
    END_TRAINING("END_TRAINING"),
    END_PARAMETERS("END_PARAMETERS"),
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
