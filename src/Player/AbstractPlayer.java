package Player;

import Entity.PlayerEntity;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractPlayer extends PlayerEntity implements Player {
    protected String name;
    protected Color color;
    protected ImageIcon icon;

    public AbstractPlayer(String name, Color color, ImageIcon icon) {
        this.name = name;
        this.color = color;
        this.icon = icon;
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

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
