package Menu.View;

import Launcher.LauncherWindow;
import Scene.Model.ActionEnum;
import Utils.UI.CustomButton;
import Utils.UI.CustomPanel.CustomBackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends CustomBackgroundPanel {

    private final JButton trainingButton;
    private final JButton contestButton;
    private final JButton parametersButton;
    private final JButton statisticsButton;
    private final JButton quitButton;

    public MenuView() {
        super();

        this.setPreferredSize(new Dimension(LauncherWindow.JFRAME_WIDTH, LauncherWindow.JFRAME_HEIGHT));
        this.setLayout(new GridBagLayout());

        this.trainingButton = new CustomButton("Training");
        this.contestButton = new CustomButton("Contest");
        this.parametersButton = new CustomButton("Parameters");
        this.statisticsButton = new CustomButton("Statistics");
        this.quitButton = new CustomButton("Quit");

        this.initButtonsActionListeners();

        // reusable GridBagConstraint to place every needed components
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.fill = GridBagConstraints.VERTICAL;

        int verticalPadding = (LauncherWindow.JFRAME_HEIGHT / 6) / 4;
        constraint.insets = new Insets(verticalPadding,0,verticalPadding,0);

        this.add(this.trainingButton, constraint);
        constraint.gridy = 1;
        this.add(this.contestButton, constraint);
        constraint.gridy = 2;
        this.add(this.parametersButton, constraint);
        constraint.gridy = 3;
        this.add(this.statisticsButton, constraint);
        constraint.gridy = 4;
        this.add(this.quitButton, constraint);
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
