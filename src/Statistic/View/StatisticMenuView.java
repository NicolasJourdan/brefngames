package Statistic.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticMenuView extends AbstractView {
    private JButton backButton;
    private JButton playerStatistic;
    private JButton tttStatistic;
    private JButton runnerStatistic;
    private JButton coockieStatistic;
    private JButton connectStatistic;
    private javax.swing.JLabel globalSettings;
    private JTable tableau;
    private Object[][] dataTable;
    private String[] headerTable;
    private GridBagConstraints c;


    public StatisticMenuView() {
        super();
        dataTable = new Object[][]{};
        headerTable = new String[]{};


        this.setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;

        this.globalSettings = new javax.swing.JLabel("Global Statistic ", SwingConstants.CENTER);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;   // largeur 2 colonne
        this.add(this.globalSettings, c);

        this.updateTableView();

        this.playerStatistic = new JButton("Statistic by Player");
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 2;   // largeur 2 colonne
        this.add(this.playerStatistic, c);

        this.tttStatistic = new JButton("Tic Tac Toe");
        c.gridwidth = 1;   // Re init
        c.gridx = 0;
        c.gridy = 4;
        this.add(this.tttStatistic, c);

        this.runnerStatistic = new JButton("Runner");
        c.gridx = 1;
        c.gridy = 4;
        this.add(this.runnerStatistic, c);

        this.coockieStatistic = new JButton("Coockie Cliquer");
        c.gridx = 2;
        c.gridy = 4;
        this.add(this.coockieStatistic, c);

        this.connectStatistic = new JButton("Connect Four");
        c.gridx = 3;
        c.gridy = 4;
        this.add(this.connectStatistic, c);

        this.backButton = new JButton("Back");
        c.gridx = 1;
        c.gridy = 5;
        c.gridwidth = 2;   // largeur 2 colonne
        this.add(this.backButton, c);

        this.initButtonsActionListeners();
    }
    private void initButtonsActionListeners() {
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticMenuView.this.observable.notifyObservers(ActionEnum.END_STATISTIC);
            }
        });
        this.playerStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticMenuView.this.observable.notifyObservers(ActionEnum.STATISTIC_PLAYER);
            }
        });
        this.tttStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.runnerStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.coockieStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.connectStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void updateGlobalStatistic(Object[][] dataTable, String[] headerTable){
        this.dataTable = dataTable;
        this.headerTable = headerTable;
        this.updateTableView();
        this.tableau.revalidate();
        this.tableau.repaint();
        this.revalidate();
        this.repaint();
    }

    public void updateTableView(){
        tableau = new JTable(dataTable, headerTable);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;   // largeur 4 colonne
        this.add(tableau.getTableHeader(), c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 4;   // largeur 4 colonne
        this.add(tableau, c);
    }
}
