package Game.Games.Runner.RunnerController;

public enum ControlEnum {
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    ;

    private String name = "";

    /**
     * Create a control.
     *
     * @return the control
     */
    ControlEnum(String s)
    {
        this.name = s;
    }

    /**
     * The method to display the name
     *
     * @return name is the name of the control
     */
    @Override public String toString()
    {
        return this.name;
    }

}
