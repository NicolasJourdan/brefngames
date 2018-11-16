package Training.View;

import Scene.Model.ActionEnum;
import Structure.AbstractView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrainingMenuView extends AbstractView {
    private final JButton backButton;
    private final JButton ticTacToeButton;
    private final JButton runnerButton;
    private final JButton connectFourButton;
    private final JButton cookieClickerButton;

    public TrainingMenuView() {
        super();
        this.setLayout(new GridLayout());

        this.backButton = new JButton("Back");
        this.ticTacToeButton = new JButton("Tic Tac Toe");
        this.runnerButton = new JButton("Runner");
        this.connectFourButton = new JButton("Connect four");
        this.cookieClickerButton = new JButton("Cookie Clicker");

        this.initButtonsActionListeners();

        this.add(this.backButton);
        this.add(this.ticTacToeButton);
        this.add(this.runnerButton);
        this.add(this.connectFourButton);
        this.add(this.cookieClickerButton);
    }

    private void initButtonsActionListeners() {
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainingMenuView.this.observable.notifyObservers(ActionEnum.END_TRAINING);
            }
        });

        this.ticTacToeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainingMenuView.this.observable.notifyObservers(ActionEnum.TIC_TAC_TOE);
            }
        });

        this.runnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainingMenuView.this.observable.notifyObservers(ActionEnum.RUNNER);
            }
        });

        this.connectFourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainingMenuView.this.observable.notifyObservers(ActionEnum.CONNECT_FOUR);
            }
        });

        this.cookieClickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainingMenuView.this.observable.notifyObservers(ActionEnum.COOKIE_CLICKER);
            }
        });
    }
}
