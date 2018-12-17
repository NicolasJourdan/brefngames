package Utils.UI;

import java.awt.*;

public class Utils {
    public final static float DEFAULT_SIZE_LABEL = 15f;
    public final static float DEFAULT_SIZE_LABEL_PLAYER = 23f;
    public final static float DEFAULT_SIZE_TITLE_LABEL = 25f;
    public final static float DEFAULT_GOAL_SIZE_LABEL = 45f;
    public final static float DEFAULT_SIZE_BUTTON_TEXT = 18f;
    public final static float DEFAULT_SIZE_LABEL_CARD = 11f;
    public final static float DEFAULT_SIZE_SMALL_CONTEST = 13f;

    public final static float CREDIT_TITLE_LABEL = 22f;
    public final static float CREDIT_SIZE_LABEL = 17f;

    public final static int DEFAULT_BUTTON_PADDING_TOP = 5;
    public final static int DEFAULT_BUTTON_PADDING_BOTTOM = 5;
    public final static int DEFAULT_BUTTON_PADDING_LEFT = 2;
    public final static int DEFAULT_BUTTON_PADDING_RIGHT = 2;

    public final static int DEFAULT_COMPONENT_PADDING_TOP_MAP = 15;
    public final static int DEFAULT_COMPONENT_PADDING_BOTTOM_MAP = 15;
    public final static int DEFAULT_COMPONENT_PADDING_LEFT_MAP = 4;
    public final static int DEFAULT_COMPONENT_PADDING_RIGHT_MAP = 4;

    public final static int DEFAULT_BUTTON_PADDING_CUSTOM_TOP = 27;
    public final static int DEFAULT_BUTTON_PADDING_CUSTOM_SMALL_TOP = 12;

    public final static int DEFAULT_BUTTON_SIZE = 500;

    public final static String COLOR_BLUE = "BLUE";
    public final static String COLOR_RED = "RED";
    public final static String COLOR_YELLOW = "YELLOW";
    public final static String COLOR_GREEN = "GREEN";

    public final static String COLOR_WHITE = "WHITE";
    public final static String COLOR_LIGHT_GRAY = "LIGHT GRAY";
    public final static String COLOR_DARK_GRAY = "DARK GRAY";
    public final static String COLOR_BLACK = "BLACK";

    public final static String BATMAN = "BATMAN";
    public final static String SUPERMAN = "SUPERMAN";
    public final static String FLASH = "FLASH";
    public final static String AQUAMAN = "AQUAMAN";

    public final static String BREFNGAMES = "BREF'N'Games";

    public final static String DEFAULT_CLICK_SOUND = "click1.wav";

    public static Insets getCustomTopInsets(int padding) {
        return new Insets(
                padding,
                Utils.DEFAULT_BUTTON_PADDING_LEFT,
                Utils.DEFAULT_BUTTON_PADDING_BOTTOM,
                Utils.DEFAULT_BUTTON_PADDING_RIGHT
        );
    }
}
