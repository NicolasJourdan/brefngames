package Parameter.Model;

public enum ColorEnum {

    /*
     * Color
     */
    YELLOW_BACKGROUND("YELLOW_BACKGROUND"),
    BLUE_BACKGROUND("BLUE_BACKGROUND"),
    RED_BACKGROUND("RED_BACKGROUND"),
    GREEN_BACKGROUND("GREEN_BACKGROUND")
    ;

    private String name = "";

    /**
     * Create an color.
     *
     * @return the color
     */
    ColorEnum(String s)
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
