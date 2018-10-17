package View;

import javax.swing.JComponent;

public abstract class View {

    private final JComponent component;
    
    public View() {
        this.component = null;
    }

    public View(JComponent component) {
        this.component = component;
    }
    
    public JComponent getComponent() {
        return this.component;
    }
}
