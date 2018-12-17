package Credit.View;

import Utils.UI.CustomLabel;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;

public class Developers extends JPanel {
    public Developers() {
        this.setOpaque(false);
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        CustomLabel bastien = new CustomLabel("Bastien Plaza ");
        bastien.setFont(bastien.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(bastien, constraints);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 1;
        constraints.gridy = 0;
        CustomLabel bastienRole = new CustomLabel(" Project Manager");
        bastienRole.setFont(bastienRole.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(bastienRole, constraints);

        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx = 0;
        constraints.gridy = 1;
        CustomLabel rayane = new CustomLabel("Rayane Hajam ");
        rayane.setFont(rayane.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(rayane, constraints);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 1;
        constraints.gridy = 1;
        CustomLabel rayaneRole = new CustomLabel(" Developer");
        rayaneRole.setFont(rayaneRole.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(rayaneRole, constraints);

        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx = 0;
        constraints.gridy = 2;
        CustomLabel elias = new CustomLabel("Elias Boulharts ");
        elias.setFont(elias.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(elias, constraints);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 1;
        constraints.gridy = 2;
        CustomLabel eliasRole = new CustomLabel(" Developer");
        eliasRole.setFont(eliasRole.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(eliasRole, constraints);

        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx = 0;
        constraints.gridy = 3;
        CustomLabel florian = new CustomLabel("Florian Merle ");
        florian.setFont(florian.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(florian, constraints);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 1;
        constraints.gridy = 3;
        CustomLabel florianRole = new CustomLabel(" Lead Developer");
        florianRole.setFont(florianRole.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(florianRole, constraints);

        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx = 0;
        constraints.gridy = 4;
        CustomLabel nicolas = new CustomLabel("Nicolas Jourdan ");
        nicolas.setFont(nicolas.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(nicolas, constraints);
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 1;
        constraints.gridy = 4;
        CustomLabel nicolasRole = new CustomLabel(" Lead Developer");
        nicolasRole.setFont(nicolasRole.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(nicolasRole, constraints);
    }
}
