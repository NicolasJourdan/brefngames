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
        this.setVisible(true);

        // get insest to set inner window size
        Insets insest = this.getInsets();
        this.setSize(
                new Dimension(
                        LauncherWindow.JFRAME_WIDTH + insest.left + insest.right,
                        LauncherWindow.JFRAME_HEIGHT + insest.top + insest.bottom
                )
        );
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
