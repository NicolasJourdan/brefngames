package Game.Games.Runner;

public enum RunnerStatsEnum {
    /*
     * RUNNER
     */
    RUNNER_NB_GAMES("RUNNER_NB_GAMES"),
    RUNNER_NB_CLICKS("RUNNER_NB_CLICKS"),
    RUNNER_AVERAGE_TIME("RUNNER_AVERAGE_TIME"),
    RUNNER_AVERAGE_SPEED("RUNNER_AVERAGE_SPEED"),
    RUNNER_TOTAL_TIME("RUNNER_TOTAL_TIME"),
    RUNNER_BEST_PLAYER("RUNNER_BEST_PLAYER")
    ;

    private String name = "";

    RunnerStatsEnum(String s)
    {
        this.name = s;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
