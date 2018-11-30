package Game.Games.Runner.RunnerView;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import java.awt.*;

public class Track extends JPanel
{

    public static int WIDTH = 50;
    public static int HEIGHT = 250;
    public static int STROKE_WIDTH = 10;

    public Track() {
        this.setPreferredSize(
            new Dimension(Track.WIDTH, Track.HEIGHT)
        );
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

        // TODO: paint player icon
    }
}
