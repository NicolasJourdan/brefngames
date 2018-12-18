package Game.Games.ConnectFour.ConnectFourModel;

import Game.Games.Coord;
import Game.Model.Pawn;
import Player.Player;

public class RedPawn extends Pawn {

    public RedPawn(Player player, Coord coord) {
        super(player, coord);
    }

    @Override
    public String toString() {
        return "R";
    }
}
