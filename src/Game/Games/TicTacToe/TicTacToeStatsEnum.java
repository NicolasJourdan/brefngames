package Game.Games.TicTacToe;

public enum TicTacToeStatsEnum {
    /*
     * TIC TAC TOE
     */
    TIC_TAC_TOE_NB_GAMES("TIC_TAC_TOE_NB_GAMES"),
    TIC_TAC_TOE_NB_DRAW("TIC_TAC_TOE_NB_DRAW"),
    TIC_TAC_TOE_NB_PERFECT("TIC_TAC_TOE_NB_PERFECT"),
    TIC_TAC_TOE_NB_CROSS("TIC_TAC_TOE_NB_CROSS"),
    TIC_TAC_TOE_NB_CIRCLE("TIC_TAC_TOE_NB_CIRCLE"),
    TIC_TAC_TOE_NB_ALL_SIGNS("TIC_TAC_TOE_NB_ALL_SIGNS"),
    TIC_TAC_TOE_AVERAGE_TIME("TIC_TAC_TOE_AVERAGE_TIME"),
    TIC_TAC_TOE_TOTAL_TIME("TIC_TAC_TOE_TOTAL_TIME"),
    TIC_TAC_TOE_BEST_PLAYER("TIC_TAC_TOE_BEST_PLAYER")
    ;

    private String name = "";

    TicTacToeStatsEnum(String s)
    {
        this.name = s;
    }

    @Override
    public String toString()
    {
        return this.name;
    }

}
