package Scene.Model;

public enum ActionEnum {

    /*
     * GameScene
     */
    PLAYER_1_WON("PLAYER_1_WON"),
    PLAYER_2_WON("PLAYER_2_WON"),
    DRAW("DRAW"),
    UNDEFINED("UNDEFINED"),

    TIC_TAC_TOE("TIC_TAC_TOE"),
    CONNECT_FOUR("CONNECT_FOUR"),
    RUNNER("RUNNER"),
    COOKIE_CLICKER("COOKIE_CLICKER"),
    TRAINING_MENU("TRAINING_MENU"),

    /*
     * Contest
     */
    START_CONTEST("START_CONTEST"),

    /*
     * Parameters
     */
    PARAMETERS_MENU("PARAMETERS_MENU"),
    THEME_SOUND_PARAMETERS("THEME_SOUND_PARAMETERS"),
    PLAYER_PARAMETERS("PLAYER_PARAMETERS"),

    // Theme sound
    SOUND_ON("SOUND_ON"),
    SOUND_OFF("SOUND_OFF"),

    FIRST_COLOR_RED("FIRST_COLOR_RED"),
    FIRST_COLOR_BLUE("FIRST_COLOR_BLUE"),
    FIRST_COLOR_GREEN("FIRST_COLOR_GREEN"),
    FIRST_COLOR_YELLOW("FIRST_COLOR_YELLOW"),

    SECOND_COLOR_WHITE("SECOND_COLOR_WHITE"),
    SECOND_COLOR_LIGHT_GRAY("SECOND_COLOR_LIGHT_GRAY"),
    SECOND_COLOR_DARK_GRAY("SECOND_COLOR_DARK_GRAY"),
    SECOND_COLOR_BLACK("SECOND_COLOR_BLACK"),

    // Default player
    SUPERMAN_1("SUPERMAN_1"),
    BATMAN_1("BATMAN_1"),
    FLASH_1("FLASH_1"),
    AQUAMAN_1("AQUAMAN_1"),

    SUPERMAN_2("SUPERMAN_2"),
    BATMAN_2("BATMAN_2"),
    FLASH_2("FLASH_2"),
    AQUAMAN_2("AQUAMAN_2"),

    COLOR_FIRST_PLAYER_RED("COLOR_FIRST_PLAYER_RED"),
    COLOR_FIRST_PLAYER_BLUE("COLOR_FIRST_PLAYER_BLUE"),
    COLOR_FIRST_PLAYER_GREEN("COLOR_FIRST_PLAYER_GREEN"),
    COLOR_FIRST_PLAYER_YELLOW("COLOR_FIRST_PLAYER_YELLOW"),

    COLOR_SECOND_PLAYER_RED("COLOR_SECOND_PLAYER_RED"),
    COLOR_SECOND_PLAYER_BLUE("COLOR_SECOND_PLAYER_BLUE"),
    COLOR_SECOND_PLAYER_GREEN("COLOR_SECOND_PLAYER_GREEN"),
    COLOR_SECOND_PLAYER_YELLOW("COLOR_SECOND_PLAYER_YELLOW"),

    /*
     * Menu
     */
    TRAINING("TRAINING"),
    END_CONTEST("END_CONTEST"),
    END_TRAINING("END_TRAINING"),
    END_PARAMETERS("END_PARAMETERS"),
    CONTEST("CONTEST"),
    STATISTICS("STATISTICS"),
    PARAMETERS("PARAMETERS"),
    QUIT("QUIT"),

    /*
     * Map
     */
    END_MAP("END_MAP"),

    /*
     * CookieView Clicker
     */
    ADD_COOKIE_P1("ADD_COOKIE_P1"),
    ADD_COOKIE_P2("ADD_COOKIE_P2"),
    GET_GOAL("GET_GOAL"),
    CHECK("CHECK");

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
