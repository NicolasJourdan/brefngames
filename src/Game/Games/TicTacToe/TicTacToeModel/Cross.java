package Game.Games.TicTacToe.TicTacToeModel;

public class Cross extends Pawn {

    @Override
    public String toString() {
        return ("x");
    }

    public Cross(Player player, int x, int y) {
        super(player, x, y);
    }
}
