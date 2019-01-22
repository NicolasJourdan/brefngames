package Game.Games.DataObject;

import Game.Games.Coord;

import java.awt.*;

public class PawnDataObject {

    private String value;
    private Color color;
    private Coord coord;

    public PawnDataObject(String value, Color color, Coord coord) {
        this.value = value;
        this.color = color;
        this.coord = coord;
    }

    public String getValue() {
        return this.value;
    }

    public Color getColor() {
        return this.color;
    }

    public Coord getCoord() {
        return this.coord;
    }
}
