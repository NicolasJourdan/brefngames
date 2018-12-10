package Utils.UI.CustomPanel;

import Utils.UI.FileGetter;

public class CustomGreyPanel extends AbstractCustomPanel {
    public CustomGreyPanel() {
        super();
        this.setBackgroundImage(FileGetter.getGreyImage("_panel.png"));
    }
}
