package Online.Socket.Message;

public enum MessageType {
    /**
     * Contest
     */
    CONTEST_NEXT_SCENE,

    /**
     * Settings
     */
    SETTINGS_DEFAULT_VALUES,
    SETTINGS_VALUES_CHANGED,
    SETTINGS_IS_READY,
    SETTINGS_WARNING_MESSAGE,
    SETTINGS_PLAYERS_LIST,
    SETTINGS_HISTORY,

    /**
     * Map
     */
    MAP_NEXT,

    /**
     * Tic Tac Toe
     */
    TIC_TAC_TOE_COORDINATES,
    TIC_TAC_TOE_SET_PAWN,
    TIC_TAC_TOE_CHANGE_PLAYER,
    TIC_TAC_TOE_WINNER,
    TIC_TAC_TOE_SEND_PLAYER_STATS,
    TIC_TAC_TOE_SEND_GLOBAL_STATS,
    TIC_TAC_TOE_SET_CURRENT_PLAYER,
    ;
}
