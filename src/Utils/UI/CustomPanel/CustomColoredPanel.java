package Utils.UI.CustomPanel;

import Utils.UI.FileGetter;

public class CustomColoredPanel extends AbstractCustomPanel{
    public CustomColoredPanel() {
        super();
        this.setBackgroundImage(FileGetter.getImage("_panel.png"));
    }
}
