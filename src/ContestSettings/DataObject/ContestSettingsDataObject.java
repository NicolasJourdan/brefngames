package ContestSettings.DataObject;

import Game.Model.GameEnum;
import Parameter.Parameters.ColorParameter;
import Parameter.Parameters.IconParameter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContestSettingsDataObject {

    private final int numberOfMatches;
    private final ArrayList<GameEnum> selectedGameTypes;
    private final String player1Name;
    private final ImageIcon player1Icon;
    private final Color player1Color;
    private final String player2Name;
    private final ImageIcon player2Icon;
    private final Color player2Color;

    public ContestSettingsDataObject(
            int numberOfMatches,
            ArrayList<GameEnum> selectedGameTypes,
            String player1Name,
            ImageIcon player1Icon,
            Color player1Color,
            String player2Name,
            ImageIcon player2Icon,
            Color player2Color
    ) {
        this.numberOfMatches = numberOfMatches;
        this.selectedGameTypes = selectedGameTypes;
        this.player1Name = player1Name;
        this.player1Icon = player1Icon;
        this.player1Color = player1Color;
        this.player2Name = player2Name;
        this.player2Icon = player2Icon;
        this.player2Color = player2Color;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public ArrayList<GameEnum> getSelectedGameTypes() {
        return selectedGameTypes;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public ImageIcon getPlayer1Icon() {
        return player1Icon;
    }

    public Color getPlayer1Color() {
        return player1Color;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public ImageIcon getPlayer2Icon() {
        return player2Icon;
    }

    public Color getPlayer2Color() {
        return player2Color;
    }

    @Override
    public String toString() {
        return "ContestSettingsDataObject{" +
                "numberOfMatches=" + numberOfMatches +
                ", selectedGameTypes=" + selectedGameTypes +
                ", player1Name='" + player1Name + '\'' +
                ", player1Icon=" + player1Icon +
                ", player1Color=" + player1Color +
                ", player2Name='" + player2Name + '\'' +
                ", player2Icon=" + player2Icon +
                ", player2Color=" + player2Color +
                '}';
    }
}
