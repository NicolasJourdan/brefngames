package Launcher;

import javax.swing.*;
import java.awt.*;

public class LauncherWindow extends JFrame {

    public static final String TITLE = "BREF'N'Games";
    public static final int JFRAME_WIDTH = 800;
    public static final int JFRAME_HEIGHT = 500;

    public LauncherWindow() {
        this.setTitle(LauncherWindow.TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);

        // dimensions and location
        this.setSize(new Dimension(LauncherWindow.JFRAME_WIDTH, LauncherWindow.JFRAME_HEIGHT));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
