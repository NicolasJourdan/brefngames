package Game.Games.FifteenVainc.FifteenVaincModel;

import Game.Games.Coord;
import Game.Model.AbstractBoard;
import Game.Model.Pawn;

public class Board extends AbstractBoard {
    public Board(int rows, int columns) {
        super(rows, columns);
    }
    public Board(int size) {
        super(size);
    }

    @Override
    protected Pawn setPawn(Pawn pawn) {
        Coord coordPawn = pawn.getCoord();
        int x = coordPawn.getX();
        int y = coordPawn.getY();
        // Check if it's inside our table
        if (x < this.rows && x >= 0 && y < this.columns && y >= 0) {
            if (this.grid.get(x).get(y) != null) {
                return null;
            } else {
                this.grid.get(x).set(y, pawn);
                return pawn;
            }
        }
        return null;
    }
}
