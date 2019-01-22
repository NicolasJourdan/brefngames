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
}
