package Game.Games.TicTacToe.TicTacToeView;

public class Cross extends Pawn {

    @Override
    public String toString() {
        return ("x");
    }

    public Cross(int x, int y) {
        super(x, y);
        this.setText("X");
    }
}
