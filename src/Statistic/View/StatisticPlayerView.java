package Statistic.View;

import Scene.Model.ActionEnum;
import Utils.UI.CustomPanel.CustomBackgroundPanel;
import Utils.UI.CustomComboBox.CustomComboBox;
import Utils.UI.CustomButton;
import Utils.UI.CustomLabel;
import Utils.UI.CustomTable.CustomTable;
import Utils.UI.Utils;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static Scene.Model.ActionEnum.STATISTIC_PLAYER_CHANGE;

public class StatisticPlayerView extends CustomBackgroundPanel {

    private CustomButton backButton;
    private CustomComboBox jcb;
    private CustomLabel playerSettingsLabel;

    private JTable leftTable;
    private JTable rightTable;
    private DefaultTableModel model;
    private GridBagConstraints constraints;
    private Object[][] dataTable;

    private String currentPlayer;

    public StatisticPlayerView() {
        super();
        this.currentPlayer = "";

        this.dataTable = new Object[][]{};

        this.setLayout(new GridBagLayout());
        this.constraints = new GridBagConstraints();
        this.constraints.insets = new Insets(
                Utils.DEFAULT_BUTTON_PADDING_TOP,
                0,
                Utils.DEFAULT_BUTTON_PADDING_BOTTOM,
                0
        );

        this.playerSettingsLabel = new CustomLabel("Player Statistics");
        this.playerSettingsLabel.setFont(this.playerSettingsLabel.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.constraints.gridx = 0;
        this.constraints.gridy = 0;
        this.constraints.gridwidth = 2;
        this.add(this.playerSettingsLabel, this.constraints);
        this.constraints.gridwidth = 1;

        this.jcb  = new CustomComboBox();
        this.constraints.gridx = 0;
        this.constraints.gridy = 1;
        this.constraints.gridwidth = 2;
        this.add(this.jcb, this.constraints);
        this.constraints.gridwidth = 1;

        this.updateTableView();

        this.backButton = new CustomButton("Back");
        this.constraints.gridx = 0;
        this.constraints.gridy = 3;
        this.constraints.gridwidth = 2;
        this.add(this.backButton, this.constraints);
        this.constraints.gridwidth = 1;

        this.initButtonsActionListeners();

        this.revalidate();
        this.repaint();
    }

    public void initButtonsActionListeners(){
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticPlayerView.this.observable.notifyObservers(ActionEnum.STATISTIC_MENU);
            }
        });
        this.jcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticPlayerView.this.currentPlayer = jcb.getSelectedItem().toString();
                StatisticPlayerView.this.observable.notifyObservers(STATISTIC_PLAYER_CHANGE);
            }
        });
    }

    public void updateGlobalStatistics(Object[][] dataTable){
        this.dataTable = dataTable;
        this.remove(this.leftTable);
        this.remove(this.rightTable);
        this.updateTableView();
        this.leftTable.revalidate();
        this.leftTable.repaint();
        this.rightTable.revalidate();
        this.rightTable.repaint();
    }

    public void updateTableView(){
        this.constraints.fill = GridBagConstraints.HORIZONTAL;
        this.constraints.anchor = GridBagConstraints.NORTH;

        this.model = new DefaultTableModel(this.dataTable, new String[]{"statistic", "numbers"});

        // left table
        this.leftTable = new CustomTable(this.model, 0);
        this.constraints.gridx = 0;
        this.constraints.gridy = 2;
        this.constraints.insets.right = 5;
        this.add(this.leftTable, this.constraints);
        this.leftTable.setTableHeader(null);

        // right table
        this.rightTable = new CustomTable(this.model, 1);
        this.constraints.gridx = 1;
        this.constraints.gridy = 2;
        this.add(this.rightTable, this.constraints);
        this.rightTable.setTableHeader(null);

        this.constraints.fill = GridBagConstraints.CENTER;
        this.constraints.anchor = GridBagConstraints.CENTER;
    }

    public void updateJCBView(String[] players){
        this.jcb.removeAllItems();
        for (String playerName : players) {
            this.jcb.addItem(playerName);
        }
    }

    public String getCurrentPlayer() {
        return this.currentPlayer;
    }
}
