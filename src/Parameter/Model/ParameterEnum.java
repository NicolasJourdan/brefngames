package Parameter.Model;

public enum ParameterEnum {

    /*
     * DefaultPlayer
     */
    PLAYER_1_ICON("PLAYER_1_ICON"),
    PLAYER_1_COLOR("PLAYER_1_COLOR"),
    PLAYER_2_ICON("PLAYER_2_ICON"),
    PLAYER_2_COLOR("PLAYER_2_COLOR"),

    /*
     * Sound & Music
     */
    SOUND("SOUND"),
    MUSIC("MUSIC"),

    /*
     * Theme
     */
    THEME_FIRST_COLOR("THEME_FIRST_COLOR"),
    THEME_SECOND_COLOR("THEME_SECOND_COLOR"),
    ;

    private String name = "";

    ParameterEnum(String s)
    {
        this.name = s;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

}
