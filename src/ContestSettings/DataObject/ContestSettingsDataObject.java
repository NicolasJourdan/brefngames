package ContestSettings.DataObject;

import Game.Model.GameEnum;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ContestSettingsDataObject {

    private final int numberOfMatches;
    private final List<GameEnum> selectedGameTypes;
    private final String firstPlayerName;
    private final ImageIcon firstPlayerIcon;
    private final Color firstPlayerColor;
    private final String secondPlayerName;
    private final ImageIcon secondPlayerIcon;
    private final Color secondPlayerColor;

    public ContestSettingsDataObject(
            int numberOfMatches,
            List<GameEnum> selectedGameTypes,
            String firstPlayerName,
            ImageIcon firstPlayerIcon,
            Color firstPlayerColor,
            String secondPlayerName,
            ImageIcon secondPlayerIcon,
            Color secondPlayerColor
    ) {
        this.numberOfMatches = numberOfMatches;
        this.selectedGameTypes = selectedGameTypes;
        this.firstPlayerName = firstPlayerName;
        this.firstPlayerIcon = firstPlayerIcon;
        this.firstPlayerColor = firstPlayerColor;
        this.secondPlayerName = secondPlayerName;
        this.secondPlayerIcon = secondPlayerIcon;
        this.secondPlayerColor = secondPlayerColor;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public List<GameEnum> getSelectedGameTypes() {
        return selectedGameTypes;
    }

    public String getFirstPlayerName() {
        return firstPlayerName;
    }

    public ImageIcon getFirstPlayerIcon() {
        return firstPlayerIcon;
    }

    public Color getFirstPlayerColor() {
        return firstPlayerColor;
    }

    public String getSecondPlayerName() {
        return secondPlayerName;
    }

    public ImageIcon getSecondPlayerIcon() {
        return secondPlayerIcon;
    }

    public Color getSecondPlayerColor() {
        return secondPlayerColor;
    }

    @Override
    public String toString() {
        return "ContestSettingsDataObject{" +
                "numberOfMatches=" + numberOfMatches +
                ", selectedGameTypes=" + selectedGameTypes +
                ", firstPlayerName='" + firstPlayerName + '\'' +
                ", firstPlayerIcon=" + firstPlayerIcon +
                ", firstPlayerColor=" + firstPlayerColor +
                ", secondPlayerName='" + secondPlayerName + '\'' +
                ", secondPlayerIcon=" + secondPlayerIcon +
                ", secondPlayerColor=" + secondPlayerColor +
                '}';
    }
}
