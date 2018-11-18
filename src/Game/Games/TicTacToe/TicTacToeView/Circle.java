package Game.Games.TicTacToe.TicTacToeView;

public class Circle extends Pawn {

    @Override
    public String toString() {
        return ("o");
    }

    public Circle(int x, int y) {
        super(x, y);
        this.setText("O");
    }
}
