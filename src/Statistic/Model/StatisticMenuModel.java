package Statistic.Model;

import Menu.Model.MenuModel;
import Scene.Model.ActionEnum;

import java.awt.*;

public class StatisticMenuModel extends MenuModel {
    private Object[][] donnees;
    private String[] entetes;
    public StatisticMenuModel() {
        // Recuper les infos du repo
        // Table for general statistic

        this.donnees = new Object[][]{
                {"Johnathan", "Sykes", Color.red, true},
                {"Nicolas", "Van de Kampf", Color.black, true},
                {"Damien", "Cuthbert", Color.cyan, true},
                {"Corinne", "Valance", Color.blue, false},
                {"Emilie", "Schrödinger", Color.magenta, false},
                {"Delphine", "Duke", Color.yellow, false},
                {"Eric", "Trump", Color.pink, true},
        };

        this.entetes = new String[]{"Prénom", "Nom", "Couleur favorite", "Homme"};
    }

    public Object[][] getGlobalStatisctic(){
        return this.donnees;
    }
    public String[] getHeaderTable(){
        return this.entetes;
    }
}
