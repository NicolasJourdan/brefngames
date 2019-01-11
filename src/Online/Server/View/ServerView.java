package Online.Server.View;

import Scene.Model.ActionEnum;
import Utils.UI.CustomButton;
import Utils.UI.CustomPanel.CustomBackgroundPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerView extends CustomBackgroundPanel {
    private final JButton createButton;

    public ServerView() {
        this.createButton = new CustomButton("Create a server");

        this.add(this.createButton);

        this.createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServerView.this.observable.notifyObservers(ActionEnum.LAUNCH_SERVER);
            }
        });
    }
}
