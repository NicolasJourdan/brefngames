package Game.Games.TicTacToe.TicTacToeModel;

import Game.Games.TicTacToe.TicTacToeView.Coord;
import Player.Player;

public class Cross extends Pawn {

    @Override
    public String toString() {
        return ("x");
    }

    public Cross(Player player, Coord coord) {
        super(player, coord);
    }
}
