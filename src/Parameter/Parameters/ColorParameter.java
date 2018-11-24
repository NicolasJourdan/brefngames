package Parameter.Parameters;

import java.awt.*;

/**
 * @author BrefNGames
 */
public class ColorParameter extends AbstractParameter {

    private String color;

    public ColorParameter(Color color, String stringColor) {
        this.value = color;
        this.color = stringColor;
    }

    public String getStringColor() {
        return this.color;
    }
}
