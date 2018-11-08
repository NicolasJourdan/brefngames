package Launcher.View;

import Structure.AbstractView;

import javax.swing.*;

public class LauncherView extends AbstractView {

    protected JPanel currentPanel;

    public LauncherView() {
        super();
    }

    public void changeCurrentPanel(JPanel jPanel) {
        this.currentPanel.removeAll();
        this.currentPanel.add(jPanel);
        this.repaint();
        this.revalidate();
    }
}
