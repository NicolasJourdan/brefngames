package Statistic.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;
import Utils.UI.CustomButton;
import Utils.UI.CustomLabel;
import Utils.UI.Utils;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticRunnerView extends AbstractView {

    private CustomButton backButton;
    private CustomLabel runnerSettingsLabel;

    private JTable tableau;
    private DefaultTableModel model;
    private GridBagConstraints c;
    private Object[][] dataTable;

    public StatisticRunnerView() {
        super();

        this.dataTable = new Object[][]{};
        this.setLayout(new GridBagLayout());
        this.c = new GridBagConstraints();

        this.c.insets = new Insets(
                Utils.DEFAULT_BUTTON_PADDING_TOP,
                Utils.DEFAULT_BUTTON_PADDING_LEFT,
                Utils.DEFAULT_BUTTON_PADDING_BOTTOM,
                Utils.DEFAULT_BUTTON_PADDING_RIGHT);
        this.c.gridwidth = GridBagConstraints.REMAINDER;

        this.c.fill = GridBagConstraints.CENTER;

        this.runnerSettingsLabel = new CustomLabel("Runner Statistic");
        this.runnerSettingsLabel.setHorizontalAlignment(JLabel.CENTER);
        this.runnerSettingsLabel.setFont(this.runnerSettingsLabel.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.add(this.runnerSettingsLabel, c);

        this.updateTableView();

        this.backButton = new CustomButton("Back");
        this.c.fill = GridBagConstraints.CENTER;
        this.c.gridx = 1;
        this.c.gridy = 5;
        this.add(this.backButton, c);

        this.initButtonsActionListeners();
    }

    public void initButtonsActionListeners(){
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticRunnerView.this.observable.notifyObservers(ActionEnum.STATISTIC_MENU);
            }
        });
    }

    public void updateRunnerStatistics(Object[][] dataTable){
        this.dataTable = dataTable;
        this.updateTableView();
        this.tableau.revalidate();
        this.tableau.repaint();
    }

    public void updateTableView(){
        this.model = new DefaultTableModel(this.dataTable, new String[]{"statistic", "numbers"});
        this.tableau = new JTable(this.model);
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.tableau, c);
        this.tableau.setTableHeader(null);
    }
}
