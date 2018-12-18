package Game.Games.ConnectFour.ConnectFourModel;

import Game.Games.Coord;
import Game.Model.Pawn;
import Player.Player;

public class YellowPawn extends Pawn {

    public YellowPawn(Player player, Coord coord) {
        super(player, coord);
    }

    @Override
    public String toString() {
        return "Y";
    }
}
