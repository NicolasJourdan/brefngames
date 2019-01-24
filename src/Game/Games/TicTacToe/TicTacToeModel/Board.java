package Game.Games.TicTacToe.TicTacToeModel;

import Game.Games.Coord;
import Game.Model.AbstractBoard;
import Game.Model.Pawn;

public class Board extends AbstractBoard {

    public Board(int size) {
        super(size);
    }

    @Override
    public Pawn setPawn(Pawn pawn) {
        Coord coordPawn = pawn.getCoord();
        int x = coordPawn.getX();
        int y = coordPawn.getY();
        if (x < this.rows && x >= 0 && y < this.columns && y >= 0) {
            if (this.grid.get(x).get(y) != null) {
                System.out.print("Error: this box already contain a pawn\n");
                return null;
            } else {
                this.grid.get(x).set(y, pawn);
                if ((pawn.toString()).equals("x")) {
                    return pawn;
                } else if ((pawn.toString()).equals("o")) {
                    return pawn;
                }
            }
        }
        return null;
    }
}
