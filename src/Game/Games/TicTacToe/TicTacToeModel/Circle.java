package Game.Games.TicTacToe.TicTacToeModel;

import Game.Games.Coord;
import Game.Model.Pawn;
import Player.Player;

public class Circle extends Pawn {

    public Circle(Player player, Coord coord) {
        super(player, coord);
    }

    @Override
    public String toString() {
        return ("o");
    }
}
