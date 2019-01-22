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

    /**
     * Tic Tac Toe
     */
    TIC_TAC_TOE_COORDINATES,
    TIC_TAC_TOE_SET_PAWN,
    TIC_TAC_TOE_CHANGE_PLAYER,
    TIC_TAC_TOE_FIRST_PLAYER_WON,
    TIC_TAC_TOE_SECOND_PLAYER_WON,
    TIC_TAC_TOE_DRAW,
    TIC_TAC_TOE_SEND_PLAYER_STATS,
    TIC_TAC_TOE_SEND_GLOBAL_STATS,
    ;
}
