package View.Launcher;

import Model.Launcher.Scene.Scene;
import View.View;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LauncherView extends View {

    private final JFrame frame;
    private final JPanel panel;

    public LauncherView() {
        this.frame = new JFrame("BREF'N'Games Demo");
        
        this.panel = new JPanel();
        this.frame.add(this.panel);
        
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }
    
    private void setScene(Scene scene) {
        this.panel.removeAll();
        this.panel.add(
            scene.getView()
        );
    }
    
}
