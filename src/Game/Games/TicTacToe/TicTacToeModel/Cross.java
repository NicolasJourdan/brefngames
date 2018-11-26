package Game.Games.TicTacToe.TicTacToeModel;

import Game.Games.TicTacToe.TicTacToeView.Coord;
import Player.Player;

public class Cross extends Pawn {

    public Cross(Player player, Coord coord) {
        super(player, coord);
    }

    @Override
    public String toString() {
        return ("x");
    }
}
