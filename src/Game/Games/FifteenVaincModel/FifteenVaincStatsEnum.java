package Game.Games.FifteenVaincModel;

public enum FifteenVaincStatsEnum {
    /*
        Fifteen Vainc
     */
    FIFTEEN_VAINC_NB_GAMES("FIFTEEN_VAINC_NB_GAMES"),
    FIFTEEN_VAINC_NB_DRAW("FIFTEEN_VAINC_NB_DRAW"),
    FIFTEEN_VAINC_NB_PERFECT("FIFTEEN_VAINC_NB_PERFECT"),  // Victory in 3 turns
    FIFTEEN_VAINC_TOTAL_TIME("FIFTEEN_VAINC_TOTAL_TIME"),
    FIFTEEN_VAINC_BEST_PLAYER("FIFTEEN_VAINC_BEST_PLAYER");

    private String name = "";

    FifteenVaincStatsEnum(String s)
    {
        this.name = s;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
