package Utils.UI.CustomPanel;

import Parameter.Factory.ColorFactory;
import Utils.UI.FileGetter;

import java.awt.*;

public class CustomGreyPanel extends AbstractCustomPanel {
    public CustomGreyPanel() {
        super();
        this.setBackgroundImage(FileGetter.getGreyImage("_panel.png"));
    }

    @Override
    public void add(Component comp, Object constraints) {
        comp.setForeground(ColorFactory.getDarkerSecondColorColorVersion());
        super.add(comp, constraints);
    }

    @Override
    public Component add(Component comp) {
        comp.setForeground(ColorFactory.getDarkerSecondColorColorVersion());
        return super.add(comp);
    }
}
