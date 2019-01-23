package Statistic.View;

import Scene.Model.ActionEnum;
import Utils.UI.CustomButton;
import Utils.UI.CustomLabel;
import Utils.UI.CustomPanel.CustomBackgroundPanel;
import Utils.UI.CustomTable.CustomTable;
import Utils.UI.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticHangmanView extends CustomBackgroundPanel {

    private CustomButton backButton;
    private CustomLabel hangmanSettingsLabel;

    private JTable table;
    private DefaultTableModel model;
    private GridBagConstraints constraints;
    private Object[][] dataTable;

    public StatisticHangmanView() {
        super();

        this.dataTable = new Object[][]{};
        this.setLayout(new GridBagLayout());
        this.constraints = new GridBagConstraints();

        this.constraints.insets = new Insets(
                Utils.DEFAULT_BUTTON_PADDING_TOP,
                Utils.DEFAULT_BUTTON_PADDING_LEFT,
                Utils.DEFAULT_BUTTON_PADDING_BOTTOM,
                Utils.DEFAULT_BUTTON_PADDING_RIGHT);
        this.constraints.gridwidth = GridBagConstraints.REMAINDER;

        this.constraints.fill = GridBagConstraints.CENTER;

        this.hangmanSettingsLabel = new CustomLabel("Connect Four Statistics");
        this.hangmanSettingsLabel.setHorizontalAlignment(JLabel.CENTER);
        this.hangmanSettingsLabel.setFont(this.hangmanSettingsLabel.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.constraints.gridx = 0;
        this.constraints.gridy = 0;
        this.add(this.hangmanSettingsLabel, this.constraints);

        this.updateTableView();

        this.backButton = new CustomButton("Back");
        this.constraints.fill = GridBagConstraints.CENTER;
        this.constraints.gridx = 1;
        this.constraints.gridy = 5;
        this.add(this.backButton, this.constraints);

        this.initButtonsActionListeners();
    }

    public void initButtonsActionListeners(){
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticHangmanView.this.observable.notifyObservers(ActionEnum.STATISTIC_MENU);
            }
        });
    }

    public void updateHangmanStatistics(Object[][] dataTable){
        this.dataTable = dataTable;
        this.updateTableView();
        this.table.revalidate();
        this.table.repaint();
    }

    public void updateTableView(){
        this.model = new DefaultTableModel(this.dataTable, new String[]{"statistic", "numbers"});
        this.table = new CustomTable(this.model);
        this.constraints.gridx = 0;
        this.constraints.gridy = 2;
        this.constraints.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.table, this.constraints);
        this.table.setTableHeader(null);
    }
}
