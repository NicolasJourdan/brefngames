package Game.Games.Runner.RunnerView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VirtualKey extends JLabel
{
    public VirtualKey(String text, Color activeControlBackground, Color activeControlTextColor) {
        super(text);

        this.setOpaque(true);
        this.setBackground(activeControlBackground);
        this.setForeground(activeControlTextColor);
        this.setFont(
            new Font(
                this.getFont().getName(),
                Font.PLAIN,
                14
            )
        );
        this.setBorder(
            new EmptyBorder(10, 10, 10, 10)
        );
    }
}
