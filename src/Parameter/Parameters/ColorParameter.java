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

    public static Color getColorFromString(String color) {
        switch (color) {
            case "FIRST_COLOR_BLUE":
            case "COLOR_FIRST_PLAYER_BLUE":
            case "COLOR_SECOND_PLAYER_BLUE":
            case "BLUE":
                return Color.BLUE;
            case "FIRST_COLOR_RED":
            case "COLOR_FIRST_PLAYER_RED":
            case "COLOR_SECOND_PLAYER_RED":
            case "RED":
                return Color.RED;
            case "FIRST_COLOR_YELLOW":
            case "COLOR_FIRST_PLAYER_YELLOW":
            case "COLOR_SECOND_PLAYER_YELLOW":
            case "YELLOW":
                return Color.YELLOW;
            case "FIRST_COLOR_GREEN":
            case "COLOR_FIRST_PLAYER_GREEN":
            case "COLOR_SECOND_PLAYER_GREEN":
            case "GREEN":
                return Color.GREEN;
            case "SECOND_COLOR_WHITE":
                return Color.WHITE;
            case "SECOND_COLOR_LIGHT_GRAY":
                return Color.LIGHT_GRAY;
            case "SECOND_COLOR_DARK_GRAY":
                return Color.DARK_GRAY;
            case "SECOND_COLOR_BLACK":
                return Color.BLACK;
            default:
                throw new RuntimeException("The color : " + color + " is unknown");
        }
    }

    public String getStringColor() {
        return this.color;
    }
}
