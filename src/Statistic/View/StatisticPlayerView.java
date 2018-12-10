package Statistic.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;
import Utils.UI.CustomeComboBox.CustomComboBox;
import Utils.UI.CustomButton;
import Utils.UI.CustomLabel;
import Utils.UI.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Scene.Model.ActionEnum.STATISTIC_PLAYER_CHANGE;

public class StatisticPlayerView extends AbstractView {
    private CustomButton backButton;

    private JTable tableau;
    private DefaultTableModel model;
    private GridBagConstraints c;
    private Object[][] dataTable;
    private CustomComboBox jcb;
    private CustomLabel playerSettings;


    private String currentPlayer;


    public StatisticPlayerView() {
        super();
        this.currentPlayer = "";

        this.dataTable = new Object[][]{};

        this.setLayout(new GridBagLayout());
        this.c = new GridBagConstraints();
        this.c.insets = new Insets(5, 0, 5, 0);

        this.c.fill = GridBagConstraints.HORIZONTAL;

        this.playerSettings = new CustomLabel("Player Statistic");
        this.playerSettings.setFont(playerSettings.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));

        this.c.gridx = 0;
        this.c.gridy = 0;
        this.add(this.playerSettings, c);

        this.jcb  = new CustomComboBox();
        this.c.gridx = 0;
        this.c.gridy = 1;
        this.add(jcb, c);

        this.updateTableView();

        this.backButton = new CustomButton("Back");
        this.c.gridx = 0;
        this.c.gridy = 5;
        this.add(this.backButton, c);

        this.initButtonsActionListeners();
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
        this.updateTableView();
        this.tableau.revalidate();
        this.tableau.repaint();
    }

    public void updateTableView(){
        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.model = new DefaultTableModel(this.dataTable, new String[]{"statistic", "numbers"});
        this.tableau = new JTable(this.model);
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.add(this.tableau, c);
        this.tableau.setTableHeader(null);
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
