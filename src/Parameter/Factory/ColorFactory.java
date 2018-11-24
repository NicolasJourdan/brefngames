package Parameter.Factory;

import java.awt.*;

public class ColorFactory {

    public static Color getColor(String color) {
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
}
