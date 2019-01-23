package Map.View;

import Map.Model.History;
import Player.Player;
import Scene.Model.ActionEnum;
import Utils.UI.CustomButton;
import Utils.UI.CustomLabel;
import Utils.UI.CustomPanel.CustomGameBackgroundPanel;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapView extends CustomGameBackgroundPanel {

    public static final int DEFAULT_GAME_IMAGE_WIDTH = 96;
    public static final int DEFAULT_GAME_IMAGE_HEIGHT = 113;
    public static final int DEFAULT_PLAYER_ICON_SIZE = 32;
    private static final String WAITING = "Waiting...";

    private JPanel gameListView;
    private JButton button;
    private JLabel title;
    private GridBagConstraints constraints;

    public MapView(Player[] players, int[] scores) {
        super(players, scores);
        this.setLayout(new GridBagLayout());
        this.constraints = new GridBagConstraints();

        this.constraints.gridx = 0;
        this.constraints.gridy = 0;

        this.title = new CustomLabel("Contest");
        this.title.setFont(this.title.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.add(this.title, this.constraints);

        this.constraints.gridy = 1;
        this.constraints.gridwidth = 2;
        this.add(this.scoreDisplay, constraints);

        this.constraints.gridx = 0;
        this.constraints.gridy = 2;
        this.constraints.gridwidth = 1;
        this.gameListView = new CardList();
        this.add(this.gameListView, this.constraints);

        this.constraints.gridx = 0;
        this.constraints.gridy = 3;
        this.button = new CustomButton("Next");
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapView.this.observable.notifyObservers(ActionEnum.END_MAP);
            }
        });

        this.constraints.insets = new Insets(
                Utils.DEFAULT_COMPONENT_PADDING_TOP_MAP,
                Utils.DEFAULT_COMPONENT_PADDING_LEFT_MAP,
                Utils.DEFAULT_COMPONENT_PADDING_BOTTOM_MAP,
                Utils.DEFAULT_COMPONENT_PADDING_RIGHT_MAP
        );

        this.add(this.button, this.constraints);

        revalidate();
        repaint();
    }

    public void addGame(Player winner, String gameName) {
        this.gameListView.add(new Card(winner, gameName), this.constraints);
        revalidate();
        repaint();
    }

    public void addNextGame() {
        this.gameListView.add(new Card(), this.constraints);
        revalidate();
        repaint();
    }

    public void addTrainingTitle() {
        this.title.setText("Training");
        revalidate();
        repaint();
    }

    public void setWaitingButton() {
        this.button.setText(MapView.WAITING);
    }

    public void setBackButton() {
        this.button.setText("Back");
    }

    public void setContinueButton() {
        this.button.setText("Continue");
    }
}
