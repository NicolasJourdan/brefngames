package Menu.View;

import Structure.AbstractView;

import java.awt.*;

public class MenuView extends AbstractView {

    public MenuView() {
        this.setLayout(new GridLayout());
        this.add(new Button("toto"));
        this.add(new Button("toto"));
        this.add(new Button("toto"));
    }
}
