package Repository.Player;

public enum PlayerStatsEnum {
    /*
     * Tic tac toe
     */
    TIC_TAC_TOE_NB_GAME("TIC_TAC_TOE_NB_GAME"),
    TIC_TAC_TOE_NB_WIN("TIC_TAC_TOE_NB_WIN"),
    TIC_TAC_TOE_WIN_POURCENT("TIC_TAC_TOE_WIN_POURCENT"),

    /*
     * Connect four
     */
    CONNECT_FOUR_NB_GAME("CONNECT_FOUR_NB_GAME"),
    CONNECT_FOUR_NB_WIN("CONNECT_FOUR_NB_WIN"),
    CONNECT_FOUR_WIN_RATE("CONNECT_FOUR_WIN_RATE"),

    /*
     * Runner
     */
    RUNNER_NB_GAME("RUNNER_NB_GAME"),
    RUNNER_NB_WIN("RUNNER_NB_WIN"),
    RUNNER_WIN_RATE("RUNNER_WIN_RATE"),

    /*
     * Cookie clicker
     */
    COOKIE_CLICKER_NB_GAME("COOKIE_CLICKER_NB_GAME"),
    COOKIE_CLICKER_NB_WIN("COOKIE_CLICKER_NB_WIN"),
    COOKIE_CLICKER_WIN_RATE("COOKIE_CLICKER_WIN_RATE"),

    /*
     * General stats
     */
    MOST_PLAYED_GAME("MOST_PLAYED_GAME"),
    TOTAL_NB_GAME("TOTAL_NB_GAME"),
    TOTAL_NB_WIN("TOTAL_NB_WIN"),
    TOTAL_NB_LOOSE("TOTAL_NB_LOOSE"),
    WIN_RATE("WIN_RATE"),
    ;

    private String name = "";

    PlayerStatsEnum(String s)
    {
        this.name = s;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}
