package Game.Games;

import Map.Model.History;
import Parameter.Model.ThemeEnum;
import Player.Player;
import Repository.Parameter.ThemeParameterRepository;
import Utils.Image.ImageResizer;
import Utils.UI.CustomLabel;
import javax.swing.*;
import java.awt.*;

public class ScoreDisplay extends JLayeredPane {
    private static int ICON_SIZE = 50;
    private static int BORDER_SIZE = 5;
    private JLabel score;
    private JLabel fIcon;
    private JLabel sIcon;

    public ScoreDisplay(Player[] players, History history) {
        super();
        Color color = (Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue();
        this.setBorder(BorderFactory.createLineBorder(color, BORDER_SIZE, true));
        this.setLayout(new GridLayout(1, 5));
        int[] scores = history.getCurrentScore();
        ImageIcon playerIcon = players[0].getIcon();
        this.fIcon = new JLabel(ImageResizer.resizeImage(playerIcon, ICON_SIZE));
        String text = String.valueOf(scores[0]) + " - " + String.valueOf(scores[1]);
        this.score = new CustomLabel(text);
        this.score.setHorizontalAlignment(JLabel.CENTER);
        this.score.setVerticalAlignment(JLabel.CENTER);
        playerIcon = players[1].getIcon();
        this.sIcon = new JLabel(ImageResizer.resizeImage(playerIcon, ICON_SIZE));
        this.add(this.fIcon);
        this.add(this.score);
        this.add(this.sIcon);
        this.revalidate();
        this.repaint();
    }
}
