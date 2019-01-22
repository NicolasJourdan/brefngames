package Game.Games.FifteenVaincModel.FifteenVaincModel;

import Game.Games.Coord;
import Game.Model.Pawn;
import Player.Player;

public class Circle extends Pawn {
    private Player player;
    private String joueur;

    public Circle(Player player, Coord coord, String joueur) {
        super(player, coord);
        this.player = player;
        this.joueur = joueur;
    }

    @Override
    public String toString() {
        if (this.joueur.equals("J1")){
            return ("J1");
        } else if (this.joueur.equals("J2")){
            return ("J2");
        }
        return "";
    }
}
