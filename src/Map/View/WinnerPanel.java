package Map.View;

import Utils.UI.CustomPanel.CustomColoredPanel;

import javax.swing.*;
import java.awt.*;

public class WinnerPanel extends CustomColoredPanel {
    public static final int DEFAULT_OFFSET_WIDTH = 4;
    public static final int DEFAULT_OFFSET_HEIGHT = 10;
    private GridBagConstraints constraints;

    public WinnerPanel(int width, int height) {
        super();
        this.setLayout(new GridBagLayout());
        this.constraints = new GridBagConstraints();
        this.setPreferredSize(new Dimension(width - WinnerPanel.DEFAULT_OFFSET_WIDTH, height + WinnerPanel.DEFAULT_OFFSET_HEIGHT));
    }

    public void addIcon(JLabel icon) {
        this.constraints.anchor = GridBagConstraints.WEST;
        this.constraints.gridx = 0;
        this.constraints.gridy = 0;
        this.add(icon, this.constraints);
    }

    public void addName(JLabel name) {
        this.constraints.anchor = GridBagConstraints.EAST;
        this.constraints.gridx = 1;
        this.constraints.gridy = 0;
        this.add(name, this.constraints);
    }
}
