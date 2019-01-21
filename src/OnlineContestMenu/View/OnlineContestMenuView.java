package OnlineContestMenu.View;

import Scene.Model.ActionEnum;
import Utils.UI.CustomButton;
import Utils.UI.CustomPanel.CustomBackgroundPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineContestMenuView extends CustomBackgroundPanel {

    private final CustomButton createServerButton;
    private final CustomButton joinServerButton;
    private final CustomButton backButton;

    public OnlineContestMenuView() {
        this.setLayout(new GridBagLayout());

        // reusable grid bag constraint
        GridBagConstraints constraint = new GridBagConstraints();

        constraint.gridy = 0;
        constraint.gridx = 0;
        this.createServerButton = new CustomButton("Create a server");
        this.add(this.createServerButton, constraint);

        constraint.gridy = 1;
        this.joinServerButton = new CustomButton("Join a server");
        this.add(this.joinServerButton, constraint);

        constraint.gridy = 2;
        this.backButton = new CustomButton("Back");
        this.add(this.backButton, constraint);

        this.createServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnlineContestMenuView.this.observable.notifyObservers(ActionEnum.CREATE_SERVER);
            }
        });

        this.joinServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnlineContestMenuView.this.observable.notifyObservers(ActionEnum.JOIN_SERVER);
            }
        });

        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnlineContestMenuView.this.observable.notifyObservers(ActionEnum.END_ONLINE_CONTEST);
            }
        });
    }
}
