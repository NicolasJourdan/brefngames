package Menu.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends AbstractView {

    private final JButton trainingButton;
    private final JButton contestButton;
    private final JButton parametersButton;
    private final JButton statisticsButton;
    private final JButton quitButton;

    public MenuView() {
        super();
        this.setLayout(new GridLayout());

        this.trainingButton = new JButton("Training");
        this.contestButton = new JButton("Contest");
        this.parametersButton = new JButton("Parameters");
        this.statisticsButton = new JButton("Statistics");
        this.quitButton = new JButton("Quit");

        this.initButtonsActionListeners();

        this.add(this.trainingButton);
        this.add(this.contestButton);
        this.add(this.parametersButton);
        this.add(this.statisticsButton);
        this.add(this.quitButton);
    }

    private void initButtonsActionListeners() {
        this.trainingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView.this.observable.notifyObservers(ActionEnum.TRAINING);
            }
        });

        this.contestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView.this.observable.notifyObservers(ActionEnum.CONTEST);
            }
        });

        this.parametersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView.this.observable.notifyObservers(ActionEnum.PARAMETERS);
            }
        });

        this.statisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView.this.observable.notifyObservers(ActionEnum.STATISTICS);
            }
        });

        this.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuView.this.observable.notifyObservers(ActionEnum.QUIT);
            }
        });
    }
}
