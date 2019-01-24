package OnlineEnding.View;

import Scene.Model.ActionEnum;
import Utils.Image.ImageResizer;
import Utils.UI.CustomButton;
import Utils.UI.CustomLabel;
import Utils.UI.CustomPanel.CustomBackgroundPanel;
import Utils.UI.CustomPanel.CustomGreyPanel;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineEndingView extends CustomBackgroundPanel {

    private static final String TITLE = "What's next ?";
    private static final String QUIT = "Quit";
    private static final String PLAY_AGAIN = "Play again";
    private static final String WAITING = "Waiting ...";
    private static final String WAITING_OTHER_PLAYER = "Waiting for the other player decision";
    private static final String OTHER_PLAYER_CONTINUE = "The other player wants to play again";
    private static final String OTHER_PLAYER_QUIT = "The other player has quit the contest";

    private static final int PANEL_BORDER = 15;
    private static final int DEFAULT_GAME_IMAGE_WIDTH = 100;

    private static final int INSETS_TITLE_TOP = 20;

    private static final int INSETS_PANEL_TOP = 60;
    private static final int INSETS_PANEL_BOTTOM = 60;
    private static final int INSETS_PANEL_SIDE = 40;

    private static final int INSETS_BUTTON_TOP = 20;

    private final JButton quitButton;
    private final JButton continueButton;
    private final JLabel message;

    public OnlineEndingView() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.CENTER;

        // title
        JLabel title = new CustomLabel(OnlineEndingView.TITLE);
        title.setFont(title.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        constraints.insets = new Insets(
                OnlineEndingView.INSETS_TITLE_TOP,
                0,
                0,
                0
        );
        constraints.gridwidth = 2;
        this.add(title, constraints);

        // quit panel
        JPanel quitPanel = new CustomGreyPanel();
        quitPanel.setBorder(BorderFactory.createEmptyBorder(
                OnlineEndingView.PANEL_BORDER,
                OnlineEndingView.PANEL_BORDER,
                OnlineEndingView.PANEL_BORDER,
                OnlineEndingView.PANEL_BORDER
        ));
        quitPanel.setLayout(new GridBagLayout());
        GridBagConstraints quitPanelConstraint = new GridBagConstraints();

        quitPanel.add(
            new JLabel(ImageResizer.resizeImage(
                new ImageIcon(ImageIcon.class.getResource("/data/Images/red_cross.png")),
                OnlineEndingView.DEFAULT_GAME_IMAGE_WIDTH,
                OnlineEndingView.DEFAULT_GAME_IMAGE_WIDTH
            )),
            quitPanelConstraint
        );

        this.quitButton = new CustomButton(OnlineEndingView.QUIT);
        this.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnlineEndingView.this.observable.notifyObservers(ActionEnum.END_CONTEST);
            }
        });
        quitPanelConstraint.gridy = 1;
        quitPanelConstraint.insets = new Insets(
                OnlineEndingView.INSETS_BUTTON_TOP,
                0,
                0,
                0
        );
        quitPanel.add(this.quitButton, quitPanelConstraint);

        constraints.gridy = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(
                OnlineEndingView.INSETS_PANEL_TOP,
                OnlineEndingView.INSETS_PANEL_SIDE,
                OnlineEndingView.INSETS_PANEL_BOTTOM,
                OnlineEndingView.INSETS_PANEL_SIDE
        );
        this.add(quitPanel, constraints);

        // continue panel
        JPanel continuePanel = new CustomGreyPanel();
        continuePanel.setBorder(BorderFactory.createEmptyBorder(
                OnlineEndingView.PANEL_BORDER,
                OnlineEndingView.PANEL_BORDER,
                OnlineEndingView.PANEL_BORDER,
                OnlineEndingView.PANEL_BORDER
        ));
        continuePanel.setLayout(new GridBagLayout());
        GridBagConstraints continuePanelConstraint = new GridBagConstraints();

        continuePanel.add(
            new JLabel(ImageResizer.resizeImage(
                new ImageIcon(ImageIcon.class.getResource("/data/Images/sword.png")),
                OnlineEndingView.DEFAULT_GAME_IMAGE_WIDTH,
                OnlineEndingView.DEFAULT_GAME_IMAGE_WIDTH
            )),
            continuePanelConstraint
        );


        this.continueButton = new CustomButton(OnlineEndingView.PLAY_AGAIN);
        this.continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnlineEndingView.this.observable.notifyObservers(ActionEnum.ONLINE_ENDING_CONTINUE);
            }
        });
        continuePanelConstraint.gridy = 1;
        continuePanelConstraint.insets = new Insets(
                OnlineEndingView.INSETS_BUTTON_TOP,
                0,
                0,
                0
        );
        continuePanel.add(this.continueButton, continuePanelConstraint);

        constraints.gridx = 1;
        this.add(continuePanel, constraints);

        // message
        this.message = new CustomLabel("");

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0, 0, 0, 0);
        this.add(this.message, constraints);
    }

    public void setWaiting() {
        this.continueButton.setText(OnlineEndingView.WAITING);
        this.message.setText(OnlineEndingView.WAITING_OTHER_PLAYER);
    }

    public void setOtherPlayerPlayAgain() {
        this.message.setText(OnlineEndingView.OTHER_PLAYER_CONTINUE);
    }

    public void setOtherPlayerQuit() {
        this.message.setText(OnlineEndingView.OTHER_PLAYER_QUIT);
        this.continueButton.setEnabled(false);
    }
}
