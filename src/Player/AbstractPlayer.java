package Player;

import Entity.PlayerEntity;

import java.awt.*;

public abstract class AbstractPlayer extends PlayerEntity implements Player {
    protected String name;
    protected Color color;

    public AbstractPlayer(String name, Color color){
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
