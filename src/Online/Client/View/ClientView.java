package Online.Client.View;

import Online.Client.SocketConnection.AddressDataObject;
import Scene.Model.ActionEnum;
import Utils.Image.ImageResizer;
import Utils.UI.*;
import Utils.UI.CustomPanel.CustomBackgroundPanel;
import Utils.UI.CustomPanel.CustomGreyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientView extends CustomBackgroundPanel {
    private static final int ICON_SIZE = 150;
    private static final int TOP_PADDING = 10;

    private final CustomTextField addressTextField;
    private final CustomTextField portTextField;
    private final JLabel title;
    private final CustomButton joinButton;
    private final JButton backButton;
    private JLabel warningLabel;

    public ClientView() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        this.title = new CustomLabel("Join a contest");
        this.title.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.joinButton = new CustomButton("Join a contest");
        this.backButton = new CustomButton("Back");
        this.addressTextField = new CustomTextField("");
        this.portTextField = new CustomTextField("");
        this.warningLabel = new WarningLabel(" "); // Fill with a space helps to avoid the bug on the vertical alignment
        this.warningLabel.setHorizontalAlignment(JLabel.CENTER);

        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(this.title, constraints);

        constraints.insets = new Insets(
                Utils.DEFAULT_PADDING,
                Utils.DEFAULT_PADDING,
                Utils.DEFAULT_PADDING,
                Utils.DEFAULT_PADDING
        );

        // Create panel
        JPanel createPanel = new CustomGreyPanel();
        createPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        Utils.PANEL_BORDER,
                        Utils.PANEL_BORDER,
                        Utils.PANEL_BORDER,
                        Utils.PANEL_BORDER
                )
        );
        createPanel.setLayout(new GridBagLayout());
        GridBagConstraints createConstraints = new GridBagConstraints();
        createConstraints.anchor = GridBagConstraints.CENTER;

        // Create icon
        JLabel createIcon = new JLabel(
                ImageResizer.resizeImage(
                        Utils.JOIN_ICON,
                        ClientView.ICON_SIZE
                )
        );
        createIcon.setFocusable(false);
        createIcon.setOpaque(false);

        createConstraints.gridx = 0;
        createConstraints.gridy = 0;
        createConstraints.gridheight = 5;
        createConstraints.insets.right = Utils.DEFAULT_ICON_PADDING;
        createPanel.add(createIcon, createConstraints);
        createConstraints.gridheight = 1;

        JLabel contestIpLabel = new CustomLabel("Contest address");
        contestIpLabel.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL));

        createConstraints.gridx = 1;
        createPanel.add(contestIpLabel, createConstraints);

        createConstraints.gridy = 1;
        createPanel.add(this.addressTextField, createConstraints);

        JLabel contestPortLabel = new CustomLabel("Contest Number");
        contestIpLabel.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL));

        createConstraints.gridy = 2;
        createPanel.add(contestPortLabel, createConstraints);

        createConstraints.gridy = 3;
        createPanel.add(this.portTextField, createConstraints);

        // Create button
        createConstraints.gridy = 4;
        createConstraints.insets.top = ClientView.TOP_PADDING;
        createPanel.add(this.joinButton, createConstraints);

        constraints.gridy = 1;
        constraints.insets.bottom = 0;
        this.add(createPanel, constraints);

        constraints.gridy = 2;
        this.add(this.warningLabel, constraints);

        constraints.gridy = 3;
        this.add(this.backButton, constraints);

        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientView.this.observable.notifyObservers(ActionEnum.ONLINE_CONTEST_MENU);
            }
        });

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

    public void setWarningLabel(String message) {
        this.warningLabel.setText(message);
        this.revalidate();
        this.repaint();
    }
}
