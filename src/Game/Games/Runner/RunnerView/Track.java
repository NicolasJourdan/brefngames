package Game.Games.Runner.RunnerView;

import Parameter.Model.ThemeEnum;
import Player.Player;
import Repository.Parameter.ThemeParameterRepository;
import Utils.Image.ImageResizer;

import javax.swing.*;
import java.awt.*;

public class Track extends JPanel
{

    public final static int WIDTH = 80;
    public final static int HEIGHT = 250;
    public final static int STROKE_WIDTH = 10;
    public final static int ICON_SIZE = 25;

    private final ImageIcon firstPlayerImage;
    private final ImageIcon secondPlayerImage;

    private int stepsAmount;
    private int firstPlayerRemainingSteps;
    private int secondPlayerRemainingSteps;

    public Track(Player[] players) {
        this.firstPlayerImage = ImageResizer.resizeImage(players[0].getIcon(), Track.ICON_SIZE);
        this.secondPlayerImage = ImageResizer.resizeImage(players[1].getIcon(), Track.ICON_SIZE);

        this.setOpaque(false);
        this.setPreferredSize(
            new Dimension(Track.WIDTH, Track.HEIGHT)
        );

        this.firstPlayerRemainingSteps = 0;
        this.secondPlayerRemainingSteps = 0;
    }

    public void setStepsAmount(int stepsAmount) {
        this.stepsAmount = stepsAmount;
    }

    public void updateFirstPlayerPosition(int remainingSteps) {
        this.firstPlayerRemainingSteps = remainingSteps;
        this.revalidate();
        this.repaint();
    }

    public void updateSecondPlayerPosition(int remainingSteps) {
        this.secondPlayerRemainingSteps = remainingSteps;
        this.revalidate();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;

        // color and thickness
        g2d.setColor(
            (Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue()
        );
        g2d.setStroke(
            new BasicStroke(STROKE_WIDTH)
        );

        // track
        g.drawLine(
            Track.WIDTH / 2,
            STROKE_WIDTH / 2,
            Track.WIDTH / 2,
            Track.HEIGHT - STROKE_WIDTH / 2
        );

        // color
        g2d.setColor(
                (Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue()
        );

        // starting line
        g.drawLine(
            0,
            Track.HEIGHT - STROKE_WIDTH / 2,
            Track.WIDTH,
            Track.HEIGHT - STROKE_WIDTH / 2
        );

        // finish line
        g.drawLine(
            0,
            STROKE_WIDTH / 2,
            Track.WIDTH,
            STROKE_WIDTH / 2
        );

        // players
        g2d.drawImage(
            this.firstPlayerImage.getImage(),
            (Track.WIDTH - Track.STROKE_WIDTH) / 2 - Track.ICON_SIZE,
            (int) (((float) this.firstPlayerRemainingSteps / this.stepsAmount) * (Track.HEIGHT - Track.ICON_SIZE)),
            this
        );

        g2d.drawImage(
            this.secondPlayerImage.getImage(),
            (Track.WIDTH + Track.STROKE_WIDTH) / 2,
            (int) (((float) this.secondPlayerRemainingSteps / this.stepsAmount) * (Track.HEIGHT - Track.ICON_SIZE)),
            this
        );
    }
}
