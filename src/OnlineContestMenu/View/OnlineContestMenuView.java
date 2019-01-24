package OnlineContestMenu.View;

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

public class OnlineContestMenuView extends CustomBackgroundPanel {

    private static final int ICON_SIZE = 150;
    private static final int PANEL_BORDER = 15;

    private final CustomButton createContestButton;
    private final CustomButton joinContestButton;
    private final CustomButton backButton;
    private final JLabel title;

    public OnlineContestMenuView() {
        this.setLayout(new GridBagLayout());

        // reusable grid bag constraint
        GridBagConstraints constraint = new GridBagConstraints();

        this.title = new CustomLabel("Online Menu");
        this.title.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.createContestButton = new CustomButton("Create a contest");
        this.joinContestButton = new CustomButton("Join a contest");

        constraint.gridy = 0;
        constraint.gridx = 0;
        constraint.gridwidth = 2;
        this.add(this.title, constraint);

        constraint.gridx = 0;
        constraint.gridy = 1;
        constraint.gridwidth = 1;
        constraint.insets = new Insets(
                Utils.DEFAULT_PADDING,
                Utils.DEFAULT_PADDING,
                Utils.DEFAULT_PADDING,
                Utils.DEFAULT_PADDING
        );
        this.add(this.createGreyPanel(true), constraint);

        constraint.gridx = 1;
        constraint.gridy = 1;
        this.add(this.createGreyPanel(false), constraint);

        constraint.gridx = 0;
        constraint.gridy = 2;
        constraint.gridwidth = 2;
        this.backButton = new CustomButton("Back");
        constraint.insets.top = 0;
        this.add(this.backButton, constraint);

        this.createContestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnlineContestMenuView.this.observable.notifyObservers(ActionEnum.CREATE_SERVER);
            }
        });

        this.joinContestButton.addActionListener(new ActionListener() {
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

    private JPanel createGreyPanel(boolean isCreateContest) {
        // Create panel
        JPanel createPanel = new CustomGreyPanel();
        createPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        OnlineContestMenuView.PANEL_BORDER,
                        OnlineContestMenuView.PANEL_BORDER,
                        OnlineContestMenuView.PANEL_BORDER,
                        OnlineContestMenuView.PANEL_BORDER
                )
        );
        createPanel.setLayout(new GridBagLayout());
        GridBagConstraints createConstraints = new GridBagConstraints();
        createConstraints.anchor = GridBagConstraints.CENTER;

        // Create icon
        JLabel createIcon = new JLabel(
                ImageResizer.resizeImage(
                        isCreateContest ? Utils.CONTEST_ICON : Utils.JOIN_ICON,
                        OnlineContestMenuView.ICON_SIZE
                )
        );
        createIcon.setFocusable(false);
        createIcon.setOpaque(false);

        createConstraints.gridx = 0;
        createConstraints.gridy = 0;
        createPanel.add(createIcon, createConstraints);

        // Create button
        createConstraints.gridy = 1;
        createConstraints.insets.top = 20;
        createPanel.add(
                isCreateContest ? this.createContestButton : this.joinContestButton,
                createConstraints
        );

        return createPanel;
    }
}
