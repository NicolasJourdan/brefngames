package ContestSettings.DataObject;

import Game.Model.GameEnum;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

public class ContestSettingsDataObject implements Serializable {

    private final int numberOfMatches;
    private final List<GameEnum> selectedGameTypes;
    private final String firstPlayerName;
    private final ImageIcon firstPlayerIcon;
    private final String firstPlayerIconName;
    private final Color firstPlayerColor;
    private final String secondPlayerName;
    private final ImageIcon secondPlayerIcon;
    private final String secondPlayerIconName;
    private final Color secondPlayerColor;

    public ContestSettingsDataObject(
            int numberOfMatches,
            List<GameEnum> selectedGameTypes,
            String firstPlayerName,
            ImageIcon firstPlayerIcon,
            String firstPlayerIconName,
            Color firstPlayerColor,
            String secondPlayerName,
            ImageIcon secondPlayerIcon,
            String secondPlayerIconName,
            Color secondPlayerColor
    ) {
        this.numberOfMatches = numberOfMatches;
        this.selectedGameTypes = selectedGameTypes;
        this.firstPlayerName = firstPlayerName;
        this.firstPlayerIcon = firstPlayerIcon;
        this.firstPlayerIconName = firstPlayerIconName;
        this.firstPlayerColor = firstPlayerColor;
        this.secondPlayerName = secondPlayerName;
        this.secondPlayerIcon = secondPlayerIcon;
        this.secondPlayerIconName = secondPlayerIconName;
        this.secondPlayerColor = secondPlayerColor;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public List<GameEnum> getSelectedGameTypes() {
        return selectedGameTypes;
    }

    public String getFirstPlayerName() {
        return this.firstPlayerName;
    }

    public ImageIcon getFirstPlayerIcon() {
        return this.firstPlayerIcon;
    }

    public String getFirstPlayerIconName() {
        return this.firstPlayerIconName;
    }

    public Color getFirstPlayerColor() {
        return this.firstPlayerColor;
    }

    public String getSecondPlayerName() {
        return this.secondPlayerName;
    }

    public ImageIcon getSecondPlayerIcon() {
        return this.secondPlayerIcon;
    }

    public Color getSecondPlayerColor() {
        return this.secondPlayerColor;
    }

    public String getSecondPlayerIconName() {
        return this.secondPlayerIconName;
    }

    @Override
    public String toString() {
        return "ContestSettingsDataObject{" +
                "numberOfMatches=" + numberOfMatches +
                ", selectedGameTypes=" + selectedGameTypes +
                ", firstPlayerName='" + firstPlayerName + '\'' +
                ", firstPlayerIcon=" + firstPlayerIcon +
                ", firstPlayerIconName='" + firstPlayerIconName + '\'' +
                ", firstPlayerColor=" + firstPlayerColor +
                ", secondPlayerName='" + secondPlayerName + '\'' +
                ", secondPlayerIcon=" + secondPlayerIcon +
                ", secondPlayerIconName='" + secondPlayerIconName + '\'' +
                ", secondPlayerColor=" + secondPlayerColor +
                '}';
    }
}
