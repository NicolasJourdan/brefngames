package Training.View;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;
import Scene.Model.ActionEnum;
import Structure.AbstractView;
import Utils.UI.*;

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
    private final CustomLabel title;

    public TrainingMenuView() {
        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        this.backButton = new CustomButton("Back");
        this.ticTacToeButton = new CustomTrainingButton("tic_tac_toe.png");
        this.runnerButton = new CustomTrainingButton("runner.png");
        this.connectFourButton = new CustomTrainingButton("connect_four.png");
        this.cookieClickerButton = new CustomTrainingButton("cookie_clicker.png");

        this.title = new CustomLabel("Training");
        this.title.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_TITLE_LABEL));
        this.title.setForeground((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());

        this.initButtonsActionListeners();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        this.add(this.title, constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        this.add(this.ticTacToeButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        this.add(this.cookieClickerButton, constraints);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        this.add(this.connectFourButton, constraints);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        this.add(this.runnerButton, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        this.add(this.backButton, constraints);
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
