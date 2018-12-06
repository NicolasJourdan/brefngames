package Statistic.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;
import Utils.UI.CustomeComboBox.CustomComboBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Scene.Model.ActionEnum.STATISTIC_PLAYER_CHANGE;

public class StatisticPlayerView extends AbstractView {
    private JButton backButton;

    private JTable tableau;
    private DefaultTableModel model;
    private GridBagConstraints c;
    private Object[][] dataTable;
    private JComboBox jcb;

    private String currentPlayer;


    public StatisticPlayerView() {
        super();

        this.currentPlayer = "";

        this.dataTable = new Object[][]{};
        this.setLayout(new GridBagLayout());
        this.c = new GridBagConstraints();

        this.c.fill = GridBagConstraints.HORIZONTAL;

        this.jcb  = new CustomComboBox();
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.c.gridwidth = 2;   // largeur 2 colonne
        this.add(jcb, c);

        this.updateTableView();

        this.backButton = new JButton("Back");
        this.c.gridx = 1;
        this.c.gridy = 5;
        this.c.gridwidth = 2;   // largeur 2 colonne
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
        this.model = new DefaultTableModel(this.dataTable, new String[]{"statistic", "numbers"});
        this.tableau = new JTable(this.model);
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.gridwidth = 4;   // largeur 4 colonne
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
