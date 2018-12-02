package Statistic.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private DefaultTableModel model;

    private Object[][] dataTable;
    private GridBagConstraints c;


    public StatisticMenuView() {
        super();
        this.dataTable = new Object[][]{};

        this.setLayout(new GridBagLayout());
        this.c = new GridBagConstraints();

        this.c.fill = GridBagConstraints.HORIZONTAL;

        this.globalSettings = new javax.swing.JLabel("Global Statistic ", SwingConstants.CENTER);
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.c.gridwidth = 4;   // largeur 2 colonne
        this.add(this.globalSettings, c);

        this.updateTableView();

        this.playerStatistic = new JButton("Statistic by Player");
        this.c.gridx = 1;
        this.c.gridy = 3;
        this.c.gridwidth = 2;   // largeur 2 colonne
        this.add(this.playerStatistic, c);

        this.tttStatistic = new JButton("Tic Tac Toe");
        this.c.gridwidth = 1;   // Re init
        this.c.gridx = 0;
        this.c.gridy = 4;
        this.add(this.tttStatistic, c);

        this.runnerStatistic = new JButton("Runner");
        this.c.gridx = 1;
        this.c.gridy = 4;
        this.add(this.runnerStatistic, c);

        this.coockieStatistic = new JButton("Coockie Clicker");
        this.c.gridx = 2;
        this.c.gridy = 4;
        this.add(this.coockieStatistic, c);

        this.connectStatistic = new JButton("Connect Four");
        this.c.gridx = 3;
        this.c.gridy = 4;
        this.add(this.connectStatistic, c);

        this.backButton = new JButton("Back");
        this.c.gridx = 1;
        this.c.gridy = 5;
        this.c.gridwidth = 2;   // largeur 2 colonne
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
                StatisticMenuView.this.observable.notifyObservers(ActionEnum.STATISTIC_TTT);
            }
        });
        this.runnerStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticMenuView.this.observable.notifyObservers(ActionEnum.STATISTIC_RUNNER);
            }
        });
        this.coockieStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticMenuView.this.observable.notifyObservers(ActionEnum.STATISTIC_COOCKIE);
            }
        });
        this.connectStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticMenuView.this.observable.notifyObservers(ActionEnum.STATISTIC_CONNECT);
            }
        });
    }

    public void updateGlobalStatistic(Object[][] dataTable){
        this.dataTable = dataTable;
        this.updateTableView();
        this.tableau.revalidate();
        this.tableau.repaint();
        this.revalidate();
        this.repaint();
    }

    public void updateTableView(){
        this.model = new DefaultTableModel(this.dataTable, new String[]{"statistic", "numbers"});
        this.tableau = new JTable(this.model);
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.gridwidth = 4;   // largeur 4 colonne
        this.add(tableau, c);
    }
}
