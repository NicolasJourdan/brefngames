package Statistic.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticCookieClickerView extends AbstractView {

    private JButton backButton;

    private JTable tableau;
    private DefaultTableModel model;
    private GridBagConstraints c;
    private Object[][] dataTable;

    public StatisticCookieClickerView() {
        super();

        this.dataTable = new Object[][]{};
        this.setLayout(new GridBagLayout());
        this.c = new GridBagConstraints();

        this.c.fill = GridBagConstraints.HORIZONTAL;

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
                StatisticCookieClickerView.this.observable.notifyObservers(ActionEnum.STATISTIC_MENU);
            }
        });
    }

    public void updateCookieClickerStatistics(Object[][] dataTable){
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
}
