package Game.Games.TicTacToe.TicTacToeView;

import Player.Player;
import Utils.Image.ImageResizer;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JLayeredPane {
    private JLabel name;
    private JLabel icon;
    private JLabel score;

    public DisplayPanel(Player player, boolean withScore) {
        super();
        this.setLayout(new GridLayout(3, 1));
        String text = player.getName();
        ImageIcon playerIcon = player.getIcon();
        Font myFont = new Font("myFont", Font.ROMAN_BASELINE, 30);
        this.name = new JLabel(text);
        this.name.setFont(myFont);
        this.name.setHorizontalAlignment(JLabel.CENTER);
        this.name.setVerticalAlignment(JLabel.CENTER);
        this.name.setVisible(true);
        this.name.setOpaque(true);
        this.icon = new JLabel(ImageResizer.resizeImage(playerIcon, 70));
        this.icon.setVisible(true);
        this.icon.setOpaque(true);
        this.score = new JLabel("0");
        this.score.setFont(myFont);
        this.score.setHorizontalAlignment(JLabel.CENTER);
        this.score.setVerticalAlignment(JLabel.CENTER);
        this.score.setVisible(withScore);
        this.score.setOpaque(withScore);
        this.add(this.name);
        this.add(this.icon);
        this.add(this.score);
        this.setVisible(true);
        this.setOpaque(true);
        this.revalidate();
        this.repaint();
    }

    public void setScore(String score){
        this.score.setText(score);
        this.revalidate();
        this.repaint();
    }

    public void setFocus(boolean visible) {
        // TODO: do it
        this.revalidate();
        this.repaint();
    }


}
