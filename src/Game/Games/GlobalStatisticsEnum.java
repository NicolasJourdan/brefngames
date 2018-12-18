package Game.Games;

public enum GlobalStatisticsEnum {
    /*
     * TIC TAC TOE
     */
    MOST_PLAYED_GAME("MOST_PLAYED_GAME"),
    MOST_ADDICT_PLAYER("MOST_ADDICT_PLAYER"),
    NB_TOTAL_GAMES("NB_TOTAL_GAMES"),
    BEST_PLAYER("BEST_PLAYER"),
    ;

    private String name = "";

    GlobalStatisticsEnum(String s)
    {
        this.name = s;
    }

    @Override
    public String toString()
    {
        return this.name;
    }


}
