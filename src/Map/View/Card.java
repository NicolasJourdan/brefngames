package Map.View;

import Parameter.Model.ThemeEnum;
import Player.Player;
import Repository.Parameter.ThemeParameterRepository;
import Scene.Model.SceneEnum;
import Utils.Image.ImageResizer;
import Utils.UI.CustomLabel;
import Utils.UI.CustomPanel.CustomGreyPanel;
import Utils.UI.FileGetter;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;

public class Card extends CustomGreyPanel {

    public static final int DEFAULT_CARD_HEIGHT = 300;
    public static final int DEFAULT_CARD_WIDTH = MapView.DEFAULT_GAME_IMAGE_WIDTH + 10;

    public static final int DEFAULT_TOP_PADDING = 16;

    public Card(Player winner, String gameName) {
        super();
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(Card.DEFAULT_CARD_WIDTH, Card.DEFAULT_CARD_HEIGHT));

        GridBagConstraints constraints = new GridBagConstraints();

        WinnerPanel winnerPanel = new WinnerPanel(Card.DEFAULT_CARD_WIDTH, MapView.DEFAULT_PLAYER_ICON_SIZE);
        CustomLabel winnerNameLabel = new CustomLabel("");
        winnerNameLabel.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL_CARD));
        winnerNameLabel.setForeground((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());

        if (null == winner) {
            // Add draw icon
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.insets.bottom = 16;
            this.add(new JLabel(ImageResizer.resizeImage(
                    new ImageIcon(ImageIcon.class.getResource("/data/Images/sword.png")), MapView.DEFAULT_GAME_IMAGE_WIDTH, MapView.DEFAULT_GAME_IMAGE_WIDTH
            )), constraints);
            constraints.insets.bottom = 0;

            winnerNameLabel.setText("Draw");
            winnerPanel.add(winnerNameLabel);
            constraints.gridx = 0;
            constraints.gridy = 1;
        } else {
            // Add player win icon
            constraints.gridx = 0;
            constraints.gridy = 0;
            this.add(new JLabel(ImageResizer.resizeImage(
                    this.getWinnerImageIcon(winner.getIcon().getDescription()), MapView.DEFAULT_GAME_IMAGE_WIDTH, MapView.DEFAULT_GAME_IMAGE_HEIGHT
            )), constraints);

            winnerNameLabel.setText(winner.getName());
            winnerPanel.addName(winnerNameLabel);
            constraints.gridx = 0;
            constraints.gridy = 1;
        }

        this.add(winnerPanel, constraints);

        SceneEnum game = SceneEnum.valueOf(gameName);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets.top = DEFAULT_TOP_PADDING;
        this.add(new JLabel(ImageResizer.resizeImage(
                this.getGameImageIcon(game), MapView.DEFAULT_GAME_IMAGE_WIDTH, MapView.DEFAULT_GAME_IMAGE_WIDTH
        )), constraints);
    }

    public Card() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(Card.DEFAULT_CARD_WIDTH, Card.DEFAULT_CARD_HEIGHT));

        GridBagConstraints constraints = new GridBagConstraints();

        WinnerPanel winnerPanel = new WinnerPanel(Card.DEFAULT_CARD_WIDTH, MapView.DEFAULT_PLAYER_ICON_SIZE);
        CustomLabel winnerNameLabel = new CustomLabel("");
        winnerNameLabel.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL_CARD));
        winnerNameLabel.setForeground(Color.BLACK);

        winnerNameLabel.setText("???");
        winnerPanel.add(winnerNameLabel);
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.add(winnerPanel, constraints);
    }

    private ImageIcon getWinnerImageIcon(String name) {
        switch (name) {
            case "AQUAMAN":
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/aquaman_win.png"));
            case "SUPERMAN":
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/superman_win.png"));
            case "BATMAN":
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/batman_win.png"));
            case "FLASH":
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/flash_win.png"));
            default:
                throw new RuntimeException("Unknown super hero : " + name);
        }
    }

    private ImageIcon getGameImageIcon(SceneEnum game) {
        switch (game) {
            case COOKIE_CLICKER:
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/cookie_clicker.png"));
            case RUNNER:
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/runner.png"));
            case CONNECT_FOUR:
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/connect_four.png"));
            case TIC_TAC_TOE:
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/tic_tac_toe.png"));
            case HANGMAN:
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/hang0.gif"));
            case FIFTEEN_VAINC:
                return new ImageIcon(ImageIcon.class.getResource("/data/Images/fifteen_vainc.png"));
            default:
                throw new RuntimeException("Game : " + game + " is unknown");
        }
    }
}
