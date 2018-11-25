package Parameter.Model;

public enum ThemeEnum {
    /*
     * Theme color
     */
    FIRST_COLOR("FIRST_COLOR"),
    SECOND_COLOR("SECOND_COLOR"),
    ;

    private String name = "";

    ThemeEnum(String s)
    {
        this.name = s;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

}
