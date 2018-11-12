package Scene.Model;

public enum SceneEnum {

    MENU("MENU"),
    TRAINING("TRAINING"),
    CONTEST("CONTEST"),
    STATISTICS("STATISTICS"),
    PARAMETERS("PARAMETERS"),
    QUIT("QUIT"),
    ERROR("ERROR"),
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