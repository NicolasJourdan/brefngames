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

public class StatisticMenuView extends AbstractView {
    private CustomButton backButton;
    private CustomButton playerStatistic;
    private CustomButton tttStatistic;
    private CustomButton runnerStatistic;
    private CustomButton coockieStatistic;
    private CustomButton connectStatistic;
    private CustomLabel globalSettings;
    private JTable tableau;
    private DefaultTableModel model;

    private Object[][] dataTable;
    private GridBagConstraints c;


    public StatisticMenuView() {
        super();
        this.dataTable = new Object[][]{};

        this.setLayout(new GridBagLayout());
        this.c = new GridBagConstraints();
        this.c.insets = new Insets(5, 2, 5, 2);
        this.c.gridwidth = GridBagConstraints.REMAINDER;

        this.c.fill = GridBagConstraints.HORIZONTAL;

        this.globalSettings = new CustomLabel("Global Statistic");
        this.globalSettings.setHorizontalAlignment(JLabel.CENTER);
        this.globalSettings.setFont(this.globalSettings.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.c.gridwidth = 4;   // largeur 2 colonne
        this.add(this.globalSettings, c);

        this.updateTableView();

        this.playerStatistic = new CustomButton("Statistic by Player");
        this.c.gridx = 1;
        this.c.gridy = 3;
        this.c.gridwidth = 2;   // largeur 2 colonne
        this.add(this.playerStatistic, c);

        this.tttStatistic = new CustomButton("Tic Tac Toe");
        this.c.gridwidth = 1;   // Re init
        this.c.gridx = 0;
        this.c.gridy = 4;
        this.add(this.tttStatistic, c);

        this.runnerStatistic = new CustomButton("Runner");
        this.c.gridx = 1;
        this.c.gridy = 4;
        this.add(this.runnerStatistic, c);

        this.coockieStatistic = new CustomButton("Coockie Clicker");
        this.c.gridx = 2;
        this.c.gridy = 4;
        this.add(this.coockieStatistic, c);

        this.connectStatistic = new CustomButton("Connect Four");
        this.c.gridx = 3;
        this.c.gridy = 4;
        this.add(this.connectStatistic, c);

        this.backButton = new CustomButton("Back");
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
                StatisticMenuView.this.observable.notifyObservers(ActionEnum.STATISTIC_TICTACTOE);
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
                StatisticMenuView.this.observable.notifyObservers(ActionEnum.STATISTIC_COOCKIE_CLICKER);
            }
        });
        this.connectStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticMenuView.this.observable.notifyObservers(ActionEnum.STATISTIC_CONNECT_FOUR);
            }
        });
    }

    public void updateGlobalStatistics(Object[][] dataTable){
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
