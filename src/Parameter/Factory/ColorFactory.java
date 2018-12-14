package Parameter.Factory;

import Parameter.Model.ColorEnum;

import java.awt.*;

public class ColorFactory {

    public static Color getColor(String color) {
        switch (color) {
            case "FIRST_COLOR_BLUE":
            case "COLOR_FIRST_PLAYER_BLUE":
            case "COLOR_SECOND_PLAYER_BLUE":
            case "BLUE":
                return Color.decode("#1EA7E1");
            case "FIRST_COLOR_RED":
            case "COLOR_FIRST_PLAYER_RED":
            case "COLOR_SECOND_PLAYER_RED":
            case "RED":
                return Color.decode("#E86A17");
            case "FIRST_COLOR_YELLOW":
            case "COLOR_FIRST_PLAYER_YELLOW":
            case "COLOR_SECOND_PLAYER_YELLOW":
            case "YELLOW":
                return Color.decode("#FFCC00");
            case "FIRST_COLOR_GREEN":
            case "COLOR_FIRST_PLAYER_GREEN":
            case "COLOR_SECOND_PLAYER_GREEN":
            case "GREEN":
                return Color.decode("#73CD4B");
            case "WHITE":
            case "SECOND_COLOR_WHITE":
                return Color.WHITE;
            case "LIGHT GRAY":
            case "SECOND_COLOR_LIGHT_GRAY":
                return Color.LIGHT_GRAY;
            case "DARK GRAY":
            case "SECOND_COLOR_DARK_GRAY":
                return Color.DARK_GRAY;
            case "BLACK":
            case "SECOND_COLOR_BLACK":
                return Color.BLACK;
            case "BLUE_BACKGROUND":
                return Color.decode("#95C7F0");
            case "RED_BACKGROUND":
                return Color.decode("#DAAB94");
            case "YELLOW_BACKGROUND":
                return Color.decode("#F5E096");
            case "GREEN_BACKGROUND":
                return Color.decode("#BFFB9B");
            default:
                throw new RuntimeException("The color : " + color + " is unknown");
        }
    }
    public static String getStringColor(Color color) {
        if (color.equals(Color.decode("#1EA7E1"))) {
            return "BLUE";
        } else if (color.equals(Color.decode("#E86A17"))) {
            return "RED";
        } else if (color.equals(Color.decode("#FFCC00"))) {
            return "YELLOW";
        } else if (color.equals(Color.decode("#73CD4B"))) {
            return "GREEN";
        } else {
            throw new RuntimeException("The string : " + color + " corresponding with no color");
        }
    }

    public static Color getBackgroundColor(Color color) {
        if (color.equals(Color.decode("#1EA7E1"))) {
            return ColorFactory.getColor(ColorEnum.BLUE_BACKGROUND.toString());
        }

        if (color.equals(Color.decode("#E86A17"))) {
            return ColorFactory.getColor(ColorEnum.RED_BACKGROUND.toString());
        }

        if (color.equals(Color.decode("#FFCC00"))) {
            return ColorFactory.getColor(ColorEnum.YELLOW_BACKGROUND.toString());
        }

        if (color.equals(Color.decode("#73CD4B"))) {
            return ColorFactory.getColor(ColorEnum.GREEN_BACKGROUND.toString());
        }

        throw new RuntimeException("Color : " + color.toString() + " is unknown");
    }
}
