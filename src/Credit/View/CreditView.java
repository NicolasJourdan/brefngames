package Credit.View;

import Scene.Model.ActionEnum;
import Utils.UI.CustomButton;
import Utils.UI.CustomLabel;
import Utils.UI.CustomPanel.CustomBackgroundPanel;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditView extends CustomBackgroundPanel {

    private final JButton backButton;
    private GridBagConstraints constraints;
    private final JLabel title;

    public CreditView() {
        super();
        this.setLayout(new GridBagLayout());
        this.constraints = new GridBagConstraints();

        this.constraints.gridx = 0;
        this.constraints.gridy = 0;
        this.constraints.insets.top = Utils.DEFAULT_BUTTON_PADDING_CUSTOM_SMALL_TOP;
        this.title = new CustomLabel("Developed by BREF'N'GAMES");
        this.title.setFont(this.title.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.add(this.title, this.constraints);
        this.constraints.insets.top = 0;

        this.constraints.gridx = 0;
        this.constraints.gridy = 1;
        this.add(new Developers(), this.constraints);

        this.constraints.gridx = 0;
        this.constraints.gridy = 2;
        this.add(new Programming(), this.constraints);

        this.constraints.gridx = 0;
        this.constraints.gridy = 3;
        this.add(new Design(), this.constraints);

        this.constraints.gridx = 0;
        this.constraints.gridy = 4;
        this.add(new Music(), this.constraints);

        this.constraints.gridx = 0;
        this.constraints.gridy = 5;
        this.constraints.insets.top = Utils.DEFAULT_BUTTON_PADDING_CUSTOM_SMALL_TOP;
        this.backButton = new CustomButton("Back");
        this.add(this.backButton, this.constraints);
        this.constraints.insets.top = 0;

        this.initButtonsActionListeners();
    }

    private void initButtonsActionListeners() {
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreditView.this.observable.notifyObservers(ActionEnum.END_CREDITS);
            }
        });
    }
}
