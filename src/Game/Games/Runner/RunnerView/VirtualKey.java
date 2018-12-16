package Game.Games.Runner.RunnerView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VirtualKey extends JLabel
{
    private final static Color ACTIVE_CONTROL_BACKGROUND = Color.DARK_GRAY;
    private final static Color ACTIVE_CONTROL_TEXT_COLOR = Color.WHITE;
    private final static Color INACTIVE_CONTROL_BACKGROUND = Color.LIGHT_GRAY;
    private final static Color INACTIVE_CONTROL_TEXT_COLOR = Color.BLACK;

    private static final int BORDER = 10;

    public VirtualKey(String text, boolean highlight) {
        super(text);

        this.setOpaque(true);
        this.highlight(highlight);
        this.setFont(
            new Font(
                this.getFont().getName(),
                Font.PLAIN,
                14
            )
        );
        this.setBorder(
            new EmptyBorder(
                    VirtualKey.BORDER,
                    VirtualKey.BORDER,
                    VirtualKey.BORDER,
                    VirtualKey.BORDER
                )
        );
    }

    public void highlight(boolean highlight) {
        this.setBackground(
            highlight ? VirtualKey.ACTIVE_CONTROL_BACKGROUND : VirtualKey.INACTIVE_CONTROL_BACKGROUND
        );
        this.setForeground(
            highlight ? VirtualKey.ACTIVE_CONTROL_TEXT_COLOR : VirtualKey.INACTIVE_CONTROL_TEXT_COLOR
        );
    }
}
