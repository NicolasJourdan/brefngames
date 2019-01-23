package Statistic.View;

import Scene.Model.ActionEnum;
import Utils.UI.CustomButton;
import Utils.UI.CustomLabel;
import Utils.UI.CustomTable.CustomTable;
import Utils.UI.CustomPanel.CustomBackgroundPanel;
import Utils.UI.Utils;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticMenuView extends CustomBackgroundPanel {

    private CustomButton backButton;
    private CustomButton playerStatistic;
    private CustomButton tttStatistic;
    private CustomButton runnerStatistic;
    private CustomButton cookieStatistic;
    private CustomButton connectStatistic;
    private CustomButton hangmanStatistic;
    private CustomLabel globalSettingsLabel;

    private JTable table;
    private DefaultTableModel model;
    private Object[][] dataTable;
    private GridBagConstraints constraints;


    public StatisticMenuView() {
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

        this.constraints.fill = GridBagConstraints.HORIZONTAL;

        this.globalSettingsLabel = new CustomLabel("Global Statistics");
        this.globalSettingsLabel.setHorizontalAlignment(JLabel.CENTER);
        this.globalSettingsLabel.setFont(this.globalSettingsLabel.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.constraints.gridx = 0;
        this.constraints.gridy = 0;
        this.constraints.gridwidth = 4;   // largeur 2 colonne
        this.add(this.globalSettingsLabel, this.constraints);

        this.updateTableView();

        this.playerStatistic = new CustomButton("Statistics by Player");
        this.constraints.gridx = 1;
        this.constraints.gridy = 3;
        this.constraints.gridwidth = 2;   // largeur 2 colonne
        this.add(this.playerStatistic, this.constraints);

        this.tttStatistic = new CustomButton("Tic Tac Toe");
        this.constraints.gridwidth = 1;   // Re init
        this.constraints.gridx = 0;
        this.constraints.gridy = 4;
        this.add(this.tttStatistic, this.constraints);

        this.runnerStatistic = new CustomButton("Runner");
        this.constraints.gridx = 1;
        this.constraints.gridy = 4;
        this.add(this.runnerStatistic, this.constraints);

        this.cookieStatistic = new CustomButton("Cookie Clicker");
        this.constraints.gridx = 2;
        this.constraints.gridy = 4;
        this.add(this.cookieStatistic, this.constraints);

        this.connectStatistic = new CustomButton("Connect Four");
        this.constraints.gridx = 3;
        this.constraints.gridy = 4;
        this.add(this.connectStatistic, this.constraints);

        this.hangmanStatistic = new CustomButton("Hangman");
        this.constraints.gridx = 1;
        this.constraints.gridy = 5;
        this.add(this.hangmanStatistic, this.constraints);

        this.backButton = new CustomButton("Back");
        this.constraints.gridx = 1;
        this.constraints.gridy = 6;
        this.constraints.gridwidth = 2;   // largeur 2 colonne
        this.add(this.backButton, this.constraints);

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
        this.cookieStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticMenuView.this.observable.notifyObservers(ActionEnum.STATISTIC_COOKIE_CLICKER);
            }
        });
        this.connectStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticMenuView.this.observable.notifyObservers(ActionEnum.STATISTIC_CONNECT_FOUR);
            }
        });
        this.hangmanStatistic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticMenuView.this.observable.notifyObservers(ActionEnum.STATISTIC_HANGMAN);
            }
        });
    }

    public void updateGlobalStatistics(Object[][] dataTable){
        this.dataTable = dataTable;
        this.updateTableView();
        this.table.revalidate();
        this.table.repaint();
        this.revalidate();
        this.repaint();
    }

    public void updateTableView(){
        this.model = new DefaultTableModel(this.dataTable, new String[]{"statistic", "numbers"});
        this.table = new CustomTable(this.model);
        this.constraints.gridx = 0;
        this.constraints.gridy = 2;
        this.constraints.gridwidth = 4;   // largeur 4 colonne
        this.add(this.table, this.constraints);
    }
}
