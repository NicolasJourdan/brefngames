package Game.Games.TicTacToe.TicTacToeModel;

public class Cross extends Pawn {

    @Override
    public String toString() {
        return ("x");
    }

    public Cross(TTTPlayer player, int x, int y) {
        super(player, x, y);
    }
}
