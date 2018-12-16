package Map.View;

import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;

public class CardList extends JPanel {

    private int nbItem;
    private GridBagConstraints constraints;

    public CardList() {
        super();
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        this.nbItem = 0;
        this.constraints = new GridBagConstraints();
        this.constraints.insets = new Insets(
                Utils.DEFAULT_COMPONENT_PADDING_TOP_MAP,
                Utils.DEFAULT_COMPONENT_PADDING_LEFT_MAP,
                Utils.DEFAULT_COMPONENT_PADDING_BOTTOM_MAP,
                Utils.DEFAULT_COMPONENT_PADDING_RIGHT_MAP
        );
    }

    @Override
    public void add(Component comp, Object constraints) {
        this.constraints.gridx = this.nbItem;
        this.constraints.gridy = 0;

        super.add(comp, this.constraints);

        this.nbItem++;
    }
}
