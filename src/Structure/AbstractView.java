package Structure;

import javax.swing.*;

public abstract class AbstractView extends JPanel {
    protected JPanel currentPanel;

    public void changeCurrentPanel(JPanel jPanel) {
        this.currentPanel.removeAll();
        this.currentPanel.add(jPanel);
        this.repaint();
        this.revalidate();
    }
}
