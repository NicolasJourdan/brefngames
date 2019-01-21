package Online.Client.View;

import Online.Client.SocketConnection.AddressDataObject;
import Scene.Model.ActionEnum;
import Utils.UI.CustomButton;
import Utils.UI.CustomPanel.CustomBackgroundPanel;
import Utils.UI.CustomTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientView extends CustomBackgroundPanel {
    private final CustomTextField addressTextField;
    private final CustomTextField portTextField;
    private final CustomButton joinButton;

    public ClientView() {
        this.addressTextField = new CustomTextField("");
        this.add(this.addressTextField);

        this.portTextField = new CustomTextField("");
        this.add(this.portTextField);

        this.joinButton = new CustomButton("Join server");
        this.add(this.joinButton);

        this.joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientView.this.observable.notifyObservers(ActionEnum.JOIN_SERVER);
            }
        });
    }

    public AddressDataObject getAddressDataObject() {
        return new AddressDataObject(
            this.addressTextField.getText(),
            this.portTextField.getText()
        );
    }
}
