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

    public Color getColor(){
        return this.color;
    }

    public String getName(){
        return this.name;
    }

}
