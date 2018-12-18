package Credit.View;

import Utils.UI.CustomLabel;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;

public class Programming extends JPanel {
    public Programming() {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets.top = Utils.DEFAULT_BUTTON_PADDING_CUSTOM_SMALL_TOP;
        CustomLabel programming = new CustomLabel("Programming");
        programming.setFont(programming.getFont().deriveFont(Utils.CREDIT_TITLE_LABEL));
        this.add(programming, constraints);
        constraints.insets.top = 0;

        constraints.gridx = 0;
        constraints.gridy = 1;
        CustomLabel team = new CustomLabel(Utils.BREFNGAMES);
        team.setFont(team.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(team, constraints);
    }
}
