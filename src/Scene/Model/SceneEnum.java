package Scene.Model;

public enum SceneEnum {

    /*
     * Games
     */
    TIC_TAC_TOE("TIC_TAC_TOE"),
    CONNECT_FOUR("CONNECT_FOUR"),
    RUNNER("RUNNER"),
    COOKIE_CLICKER("COOKIE_CLICKER"),
    TRAINING_MENU("TRAINING_MENU"),

    /*
     * Map
     */
    MAP("MAP"),

    /*
     * Parameters
     */
    PARAMETERS_MENU("PARAMETERS_MENU"),
    THEME_SOUND_PARAMETERS("THEME_SOUND_PARAMETERS"),
    PLAYER_PARAMETERS("PLAYER_PARAMETERS"),

    /*
     * Contest
     */
    CONTEST_MENU("CONTEST_MENU"),
    CONTEST_FINISHED("CONTEST_FINISHED"),

    /*
     * Screens
     */
    MENU("MENU"),
    TRAINING("TRAINING"),
    CONTEST("CONTEST"),
    STATISTICS("STATISTICS"),
    PARAMETERS("PARAMETERS"),
    CREDITS("CREDITS"),
    QUIT("QUIT"),

    /*
     * Actions Statisctic Menu
     */
    STATISTIC_MENU("STATISTIC_MENU"),
    STATISTIC_TICTACTOE("STATISTIC_TICTACTOE"),
    STATISTIC_RUNNER("STATISTIC_RUNNER"),
    STATISTIC_COOKIE_CLICKER("STATISTIC_COOKIE_CLICKER"),
    STATISTIC_CONNECT_FOUR("STATISTIC_CONNECT_FOUR"),
    STATISTIC_PLAYER("STATISTIC_PLAYER"),

    END_SCENE("END_SCENE"),
    ;

    private String name = "";

    /**
     * Create an scene.
     *
     * @return the dialogue asked
     */
    SceneEnum(String s)
    {
        this.name = s;
    }

    /**
     * The method to display the name
     *
     * @return name is the name of the scene
     */
    @Override public String toString()
    {
        return this.name;
    }
}
