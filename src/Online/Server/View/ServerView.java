package Online.Server.View;

import Scene.Model.ActionEnum;
import Utils.Image.ImageResizer;
import Utils.UI.CustomButton;
import Utils.UI.CustomLabel;
import Utils.UI.CustomPanel.CustomBackgroundPanel;
import Utils.UI.CustomPanel.CustomGreyPanel;
import Utils.UI.FileGetter;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerView extends CustomBackgroundPanel {
    private static final int ICON_SIZE = 150;

    private final CustomButton createButton;
    private final JLabel title;
    private final JButton backButton;
    private JLabel contestIp;
    private JLabel contestPort;

    public ServerView() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        this.title = new CustomLabel("Create a contest");
        this.title.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.createButton = new CustomButton("Create a contest");
        this.backButton = new CustomButton("Back");
        this.contestIp = new CustomLabel("-");
        this.contestIp.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL));
        this.contestPort = new CustomLabel("-");
        this.contestPort.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL));

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
                        Utils.CONTEST_ICON,
                        ServerView.ICON_SIZE
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

        JLabel contestIpLabel = new CustomLabel("Contest address :");
        contestIpLabel.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL));

        createConstraints.gridx = 1;
        createPanel.add(contestIpLabel, createConstraints);

        createConstraints.gridy = 1;
        createPanel.add(this.contestIp, createConstraints);

        JLabel contestPortLabel = new CustomLabel("Contest Number :");
        contestIpLabel.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL));

        createConstraints.gridy = 2;
        createPanel.add(contestPortLabel, createConstraints);

        createConstraints.gridy = 3;
        createPanel.add(this.contestPort, createConstraints);

        // Create button
        createConstraints.gridy = 4;
        createPanel.add(this.createButton, createConstraints);

        constraints.gridy = 1;
        this.add(createPanel, constraints);

        constraints.gridy = 2;
        this.add(this.backButton, constraints);

        this.createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServerView.this.observable.notifyObservers(ActionEnum.LAUNCH_SERVER);
            }
        });

        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServerView.this.observable.notifyObservers(ActionEnum.ONLINE_CONTEST_MENU);
            }
        });
    }

    public void setContestIp(String contestIp) {
        this.contestIp.setText(contestIp);
        this.revalidate();
        this.repaint();
    }

    public void setContestPort(String contestPort) {
        this.contestPort.setText(contestPort);
        this.revalidate();
        this.repaint();
    }

    public void toggleCreateContestButton() {
        this.createButton.setEnabled(!this.createButton.isEnabled());
    }
}
