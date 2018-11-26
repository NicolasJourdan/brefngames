package Game.Games.TicTacToe.TicTacToeModel;

import Game.Games.TicTacToe.TicTacToeView.Coord;
import java.util.ArrayList;
import java.util.List;

public class Board {
    protected ArrayList<List<Pawn>> grid = new ArrayList();
    private int size;

    public Board(int size) {
        this.size = size;
        for (int i = 0; i < this.size; i++) {
            List<Pawn> subList = new ArrayList<Pawn>();
            for (int j = 0; j < this.size; j++) {
                subList.add(null);
            }
            grid.add(subList);
        }
    }

    public Boolean isFill(){
        Boolean status = true;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.grid.get(i).get(j) == null) {
                    return false;
                }
            }
        }
        return status;
    }

    public String setPawn(Pawn pawn) {
        Coord coordPawn = pawn.getCoord();
        int x = coordPawn.getX();
        int y = coordPawn.getY();
        if (x < this.size && x >= 0 && y < this.size && y >= 0) {
            if (this.grid.get(x).get(y) != null) {
                System.out.print("Error: this case already contain a pawn\n");
                return null;
            } else {
                this.grid.get(x).set(y, pawn);
                if ((pawn.toString()).equals("x")) {
                    return "x";
                } else if ((pawn.toString()).equals("o")) {
                    return "o";
                }
            }
        }
        return null;
    }
}
