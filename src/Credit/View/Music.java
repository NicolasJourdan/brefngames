package Credit.View;

import Utils.UI.CustomLabel;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;

public class Music extends JPanel {
    public Music() {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets.top = Utils.DEFAULT_BUTTON_PADDING_CUSTOM_SMALL_TOP;
        CustomLabel programming = new CustomLabel("Musics");
        programming.setFont(programming.getFont().deriveFont(Utils.CREDIT_TITLE_LABEL));
        this.add(programming, constraints);
        constraints.insets.top = 0;

        constraints.gridx = 0;
        constraints.gridy = 1;
        CustomLabel zeldaShop = new CustomLabel("Zelda - Shop");
        zeldaShop.setFont(zeldaShop.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(zeldaShop, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        CustomLabel zeldaDragon = new CustomLabel("Zelda - Dragon Roost Island");
        zeldaDragon.setFont(zeldaDragon.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(zeldaDragon, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        CustomLabel zeldaOutset = new CustomLabel("Zelda - Outset Island");
        zeldaOutset.setFont(zeldaOutset.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(zeldaOutset, constraints);


    }
}
