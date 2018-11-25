package Parameter.Model;

public enum  DefaultPlayerParameterEnum {

    /*
     * Players
     */
    PLAYER_1("PLAYER_1"),
    PLAYER_2("PLAYER_2"),
    ;

    private String name = "";

    DefaultPlayerParameterEnum(String s)
    {
        this.name = s;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

}
