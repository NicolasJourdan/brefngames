package Game.Games.Runner.RunnerView;

public enum ControlsTypeEnum {
    Q_S("Q_S"),
    L_M("L_M"),
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
