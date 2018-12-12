package Game.Games;

import Player.Player;
import Utils.Image.ImageResizer;
import Utils.UI.CustomLabel;
import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JLayeredPane {
    private static final Color DEFAULT_COLOR = Color.GRAY;
    private Player player;
    private JLabel name;
    private JLabel icon;
    private Color color;

    public DisplayPanel(Player player, boolean visible) {
        super();
        this.player = player;
        this.setLayout(new GridLayout(2, 1, 0, 0));
        String text = player.getName();
        ImageIcon playerIcon = player.getIcon();
        this.name = new CustomLabel(text);
        this.name.setHorizontalAlignment(JLabel.CENTER);
        this.name.setVerticalAlignment(JLabel.CENTER);
        if (visible) {
            this.color = this.player.getColor();
        } else {
            this.color = DEFAULT_COLOR;
        }
        this.icon = new JLabel(ImageResizer.resizeImage(playerIcon, 100));
        this.add(this.name);
        this.add(this.icon);
        this.setBorder(BorderFactory.createLineBorder(this.color, 5, true));
        this.revalidate();
        this.repaint();
    }

    public void setFocus(boolean visible) {
        if (visible) {
            this.color = this.player.getColor();
        } else {
            this.color = DEFAULT_COLOR;
        }
        this.setBorder(BorderFactory.createLineBorder(this.color, 5, true));
        this.revalidate();
        this.repaint();
    }
}
