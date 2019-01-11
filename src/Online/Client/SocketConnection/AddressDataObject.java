package Online.Client.SocketConnection;

public class AddressDataObject {

    private String address;
    private String port;

    public AddressDataObject(String address, String port) {
        this.address = address;
        this.port = port;
    }

    public String getAddress() {
        return address;
    }

    public String getPort() {
        return port;
    }
}
