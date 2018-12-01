package Game.Games.Runner.RunnerView;

public enum ControlsTypeEnum {
    A_Z("A_Z"),
    R_T("R_T"),
    ;

    private String name = "";

    /**
     * Create a control type.
     *
     * @return the control type
     */
    ControlsTypeEnum(String s)
    {
        this.name = s;
    }

    /**
     * The method to display the name
     *
     * @return name is the name of the control type
     */
    @Override public String toString()
    {
        return this.name;
    }
}
