package Online.Socket.Message;

public enum MessageType {
    /**
     * Contest
     */
    CONTEST_NEXT_SCENE,
    CONTEST_UPDATE_HISTORY,

    /**
     * Settings
     */
    SETTINGS_DEFAULT_VALUES,
    SETTINGS_VALUES_CHANGED,
    SETTINGS_IS_READY,
    SETTINGS_WARNING_MESSAGE,
    SETTINGS_PLAYERS_LIST,
    SETTINGS_HISTORY,
    SETTINGS_SAVE_PLAYER,

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

    /**
     * Runner
     */
    RUNNER_KEY_PRESSED,
    RUNNER_UPDATE_FIRST_PLAYER_CONTROLS,
    RUNNER_UPDATE_SECOND_PLAYER_CONTROLS,
    RUNNER_SEND_PLAYER_STATS,
    RUNNER_SEND_GLOBAL_STATS,

    /**
     * Hangman
     */
    HANGMAN_CHARACTER,
    HANGMAN_CHANGE_PLAYER,
    HANGMAN_SET_DISABLED,
    HANGMAN_SEND_PLAYER_STATS,
    HANGMAN_MAKE_GUESS,
    HANGMAN_WINNER,
    HANGMAN_SEND_GLOBAL_STATS,
    HANGMAN_SET_CURRENT_PLAYER,

    /**
     * Fifteen Vainc
     */
    FIFTEEN_VAINC_COORDINATES,
    FIFTEEN_VAINC_SET_PAWN,
    FIFTEEN_VAINC_CHANGE_PLAYER,
    FIFTEEN_VAINC_WINNER,
    FIFTEEN_VAINC_SEND_PLAYER_STATS,
    FIFTEEN_VAINC_SEND_GLOBAL_STATS,
    FIFTEEN_VAINC_SET_CURRENT_PLAYER,

    /**
     * Connect four
     */
    CONNECT_FOUR_COORDINATES,
    CONNECT_FOUR_SET_CURRENT_PLAYER,
    CONNECT_FOUR_SET_PAWN,
    CONNECT_FOUR_SEND_GLOBAL_STATS,
    CONNECT_FOUR_SEND_PLAYER_STATS,
    CONNECT_FOUR_CHANGE_PLAYER,

    /**
     * Cookie clicker
     */
    COOKIE_CLICKER_SEND_GLOBAL_STATS,
    COOKIE_CLICKER_SEND_PLAYER_STATS,
    COOKIE_PRESS_FIRST_PLAYER_KEY,
    COOKIE_RELEASE_FIRST_PLAYER_KEY,
    COOKIE_PRESS_SECOND_PLAYER_KEY,
    COOKIE_RELEASE_SECOND_PLAYER_KEY,
    COOKIE_ACTION,
    COOKIE_CLICKER_SEND_GOAL,
    ;
}
