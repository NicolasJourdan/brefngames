package Game.Games;

import Parameter.Model.ThemeEnum;
import Player.Player;
import Repository.Parameter.ThemeParameterRepository;
import Utils.Image.ImageResizer;
import Utils.UI.CustomLabel;
import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JLayeredPane {
    public static final int DEFAULT_INSETS_TOP = 40;
    public static final int DEFAULT_INSETS_LEFT = 5;

    public static final int WIDTH = 120;
    public static final int HEIGHT = 200;

    private static int ICON_SIZE = 100;
    private static int BORDER_SIZE = 5;

    private Player player;
    private JLabel name;
    private JLabel icon;
    private Color color;
    private Color defColor;

    public DisplayPanel(Player player, boolean visible) {
        super();
        this.defColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue();
        this.player = player;
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        GridBagConstraints constraints = new GridBagConstraints();
        String text = player.getName();
        ImageIcon playerIcon = player.getIcon();
        this.name = new CustomLabel(text);
        this.name.setHorizontalAlignment(JLabel.CENTER);
        this.name.setVerticalAlignment(JLabel.CENTER);
        this.setColor(visible);
        this.icon = new JLabel(ImageResizer.resizeImage(playerIcon, ICON_SIZE));

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets.top = DisplayPanel.DEFAULT_INSETS_TOP;
        constraints.insets.left = DisplayPanel.DEFAULT_INSETS_LEFT;
        this.add(this.name, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets.top = DisplayPanel.DEFAULT_INSETS_TOP;
        constraints.insets.left = 0;
        this.add(this.icon, constraints);

        this.setBorder(BorderFactory.createLineBorder(this.color, BORDER_SIZE, true));
        this.revalidate();
        this.repaint();
    }

    public void setFocus(boolean visible) {
        this.setColor(visible);
        this.setBorder(BorderFactory.createLineBorder(this.color, BORDER_SIZE, true));
        this.revalidate();
        this.repaint();
    }

    private void setColor(boolean visible){
        if (visible) {
            this.color = this.player.getColor();
        } else {
            this.color = this.defColor;
        }
    }

    public Player getPlayer(){
        return this.player;
    }
}
