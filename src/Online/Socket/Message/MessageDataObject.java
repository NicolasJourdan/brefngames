package Online.Socket.Message;

import java.io.Serializable;

public class MessageDataObject implements Serializable {

    private MessageType type;
    private Object data;

    public MessageDataObject(MessageType type, Object data) {
        this.type = type;
        this.data = data;
    }

    public MessageType getType() {
        return type;
    }

    public Object getData() {
        return data;
    }
}
