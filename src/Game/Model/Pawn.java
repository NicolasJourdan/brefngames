package Game.Model;

import Game.Games.Coord;
import Player.Player;

import java.awt.*;

public class Pawn {
    private Coord coord;
    private Color color;

    public Pawn(Player player, Coord coord) {
        this.color = player.getColor();
        this.coord = coord;
    }

    public Coord getCoord() {
        return this.coord;
    }

    public Color getColor() {
        return color;
    }

    public void setCoord(int x, int y) {
        this.coord = new Coord(x, y);
    }
}
