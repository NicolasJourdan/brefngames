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
     * Screens
     */
    MENU("MENU"),
    TRAINING("TRAINING"),
    CONTEST("CONTEST"),
    STATISTICS("STATISTICS"),
    PARAMETERS("PARAMETERS"),
    QUIT("QUIT"),

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
