package Scene.View;

import Structure.AbstractView;

import javax.swing.*;

public class AbstractSceneManagerView extends AbstractView {

    public void changeCurrentPanel(JPanel jPanel) {
        this.removeAll();
        this.add(jPanel);
        this.repaint();
        this.revalidate();
    }
}
