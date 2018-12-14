package Map.View;

import Player.Player;
import Scene.Model.ActionEnum;
import Utils.Image.ImageResizer;
import Utils.UI.CustomPanel.CustomGameBackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapView extends CustomGameBackgroundPanel {

    private JPanel gameListView;
    private JPanel score;
    private JButton button;

    public MapView() {
        super();
        this.setLayout(new GridLayout(3, 1));

        this.score = new JPanel();
        this.score.setLayout(new GridLayout(1, 1));
        this.add(this.score);

        this.gameListView = new JPanel();
        this.gameListView.setLayout(new GridLayout(1, 7));
        this.add(this.gameListView);

        this.button = new JButton("Next");
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapView.this.observable.notifyObservers(ActionEnum.END_MAP);
            }
        });

        this.add(this.button);

        revalidate();
        repaint();
    }

    public void addGame(Player winner, String gameName) {
        JPanel current = new JPanel();
        current.setLayout(new GridLayout(3, 1));
        if (null == winner) {
            current.add(new JLabel("Draw"));
            current.add(new JLabel("Draw"));
        } else {
            current.add(new JLabel(ImageResizer.resizeImage(winner.getIcon(), 64, 64)));
            current.add(new JLabel(winner.getName()));
        }

        current.add(new JLabel(gameName));

        this.gameListView.add(current);
        revalidate();
        repaint();
    }

    public void addNextGame() {
        JPanel currentPanel = new JPanel();
        currentPanel.setLayout(new GridLayout(3, 1));
        currentPanel.add(new JLabel("???"));
        currentPanel.add(new JLabel("???"));
        currentPanel.add(new JLabel("???"));
        this.gameListView.add(currentPanel);
        revalidate();
        repaint();
    }

    public void addCurrentScore(Player[] players, int[] scores) {
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1, 3));

        JPanel firstPlayerPanel = new JPanel();
        firstPlayerPanel.setLayout(new GridLayout(2, 1));
        firstPlayerPanel.add(new JLabel(ImageResizer.resizeImage(players[0].getIcon(), 64)));
        firstPlayerPanel.add(new JLabel(players[0].getName()));
        scorePanel.add(firstPlayerPanel);

        scorePanel.add(new JLabel(String.valueOf(scores[0]) + " - " + String.valueOf(scores[1])));

        JPanel secondPlayerPanel = new JPanel();
        secondPlayerPanel.setLayout(new GridLayout(2, 1));
        secondPlayerPanel.add(new JLabel(ImageResizer.resizeImage(players[1].getIcon(), 64)));
        secondPlayerPanel.add(new JLabel(players[1].getName()));
        scorePanel.add(secondPlayerPanel);

        this.score.add(scorePanel);
        revalidate();
        repaint();
    }

    public void addTrainingTitle() {
        this.score.add(new JLabel("Training"));
        revalidate();
        repaint();
    }

    public void setBackButton() {
        this.button.setText("Back");
    }
}
