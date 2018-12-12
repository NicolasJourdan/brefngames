package Game.Games.ConnectFour.ConnectFourView;

import Game.Games.Coord;
import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import java.awt.*;


public class Box extends JButton {
    private static int BOARD_SHADOW_X = 0;
    private static int BOARD_SHADOW_Y = 0;
    private static int BOARD_SHADOW_DX = 5;
    private static int BOARD_SHADOW_DY = 5;
    private static int HOLE_X = 3;
    private static int HOLE_Y = 3;
    private static int HOLE_DX = 5;
    private static int HOLE_DY = 5;
    private static int PAWN_SHADOW_X = 6;
    private static int PAWN_SHADOW_Y = 6;
    private static int PAWN_SHADOW_DX = 11;
    private static int PAWN_SHADOW_DY = 11;
    private static int PAWN_X = 4;
    private static int PAWN_Y = 4;
    private static int PAWN_DX = 11;
    private static int PAWN_DY = 11;
    private static int PAWN_STRIPE_X = 11;
    private static int PAWN_STRIPE_Y = 11;
    private static int PAWN_STRIPE_DX = 25;
    private static int PAWN_STRIPE_DY = 25;
    private static int PAWN_MIDDLE_X = 13;
    private static int PAWN_MIDDLE_Y = 13;
    private static int PAWN_MIDDLE_DX = 29;
    private static int PAWN_MIDDLE_DY = 29;
    private final Coord coord;
    private Color backgroundColor;
    private Color emptyColor;
    private Color color;
    private Color borderColor;
    private Color opositeColor;

    public Box(Coord coord) {
        this.coord = coord;
        this.setPreferredSize(new Dimension(75, 75));
        this.setLayout(new BorderLayout());
        setOpaque(true);
        backgroundColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue();
        this.emptyColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue();
        this.color = (Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue();
        this.borderColor = (Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue();
        this.opositeColor = Color.BLACK;
        if(ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue().equals(Color.BLACK)){
            this.opositeColor = Color.WHITE;
        }
    }

    @Override
    public void paint(Graphics g){
        g.setColor(this.backgroundColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        //board shadow
        g.setColor(this.opositeColor);
        g.fillOval(BOARD_SHADOW_X, BOARD_SHADOW_Y, this.getWidth() - BOARD_SHADOW_DX, this.getHeight() - BOARD_SHADOW_DY);
        //hole
        g.setColor(this.emptyColor);
        g.fillOval(HOLE_X, HOLE_Y, this.getWidth() - HOLE_DX, this.getHeight() - HOLE_DY);
        //pawn shadow
        g.setColor(this.borderColor);
        g.fillOval(PAWN_SHADOW_X, PAWN_SHADOW_Y, this.getWidth() - PAWN_SHADOW_DX, this.getHeight() - PAWN_SHADOW_DY);
        //pawn
        g.setColor(this.color);
        g.fillOval(PAWN_X, PAWN_Y, this.getWidth() - PAWN_DX, this.getHeight() - PAWN_DY);
        //pawn stripe
        g.setColor(this.borderColor);
        g.fillOval(PAWN_STRIPE_X, PAWN_STRIPE_Y, this.getWidth() - PAWN_STRIPE_DX, this.getHeight() - PAWN_STRIPE_DY);
        //center of pawn
        g.setColor(this.color);
        g.fillOval(PAWN_MIDDLE_X, PAWN_MIDDLE_Y, this.getWidth() - PAWN_MIDDLE_DX, this.getHeight() - PAWN_MIDDLE_DY);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void setPawn(Color color) {
        this.color = color;
        this.borderColor = opositeColor;
        this.revalidate();
        this.repaint();
    }

    public Coord getCoord() {
        return this.coord;
    }
}
