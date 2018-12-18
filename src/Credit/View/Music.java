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
        CustomLabel patrickLabel = new CustomLabel("Produced by Patrick de Arteaga");
        patrickLabel.setFont(patrickLabel.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(patrickLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        CustomLabel humbleMatch = new CustomLabel("Humble Match");
        humbleMatch.setFont(humbleMatch.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(humbleMatch, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        CustomLabel prorrogaDeTiempoC = new CustomLabel("Prorroga de Tiempo C");
        prorrogaDeTiempoC.setFont(prorrogaDeTiempoC.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(prorrogaDeTiempoC, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        CustomLabel solveThePuzzle = new CustomLabel("Solve The Puzzle");
        solveThePuzzle.setFont(solveThePuzzle.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(solveThePuzzle, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        CustomLabel suTurno = new CustomLabel("Su Turno");
        suTurno.setFont(suTurno.getFont().deriveFont(Utils.CREDIT_SIZE_LABEL));
        this.add(suTurno, constraints);


    }
}
