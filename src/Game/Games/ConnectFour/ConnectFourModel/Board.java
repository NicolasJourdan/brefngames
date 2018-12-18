package Game.Games.ConnectFour.ConnectFourModel;

import Game.Games.Coord;
import Game.Model.AbstractBoard;
import Game.Model.Pawn;

public class Board extends AbstractBoard {

    public Board(int rows, int columns) {
        super(rows, columns);
    }

    @Override
    public Pawn setPawn(Pawn pawn) {
        Coord coordPawn = pawn.getCoord();
        int x = coordPawn.getX();
        if (x < this.columns && x >= 0 && this.grid.get(0).get(x) == null) {
            for (int y = this.rows - 1; y >= 0; y--) {
                if (this.grid.get(y).get(x) == null) {
                    pawn.setCoord(x, y);
                    this.grid.get(y).set(x, pawn);
                    if ((pawn.toString()).equals("Y")) {
                        return pawn;
                    } else if ((pawn.toString()).equals("R")) {
                        return pawn;
                    }
                }
            }
        }
        return null;
    }

    public String isWinner() {
        if (landscapeCheck()) {
            return "landscape";
        }
        if (verticalCheck()) {
            return "vertical";
        }
        if (diagonalLowerRightCheck() || diagonalLowerLeftCheck()) {
            return "diagonal";
        }
        return "";
    }

    private boolean landscapeCheck() {
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.columns - 3; col++) {
                if (grid.get(row).get(col) != null &&
                        grid.get(row).get(col + 1) != null &&
                        grid.get(row).get(col + 2) != null &&
                        grid.get(row).get(col + 3) != null) {
                    if (grid.get(row).get(col).toString() ==
                            grid.get(row).get(col + 1).toString() &&
                            grid.get(row).get(col).toString() ==
                                    grid.get(row).get(col + 2).toString() &&
                            grid.get(row).get(col).toString() ==
                                    grid.get(row).get(col + 3).toString()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean verticalCheck() {
        for (int row = 0; row < this.rows - 3; row++) {
            for (int col = 0; col < this.columns; col++) {
                if (grid.get(row).get(col) != null &&
                        grid.get(row + 1).get(col) != null &&
                        grid.get(row + 2).get(col) != null &&
                        grid.get(row + 3).get(col) != null) {
                    if (grid.get(row).get(col).toString() ==
                            grid.get(row + 1).get(col).toString() &&
                            grid.get(row).get(col).toString() ==
                                    grid.get(row + 2).get(col).toString() &&
                            grid.get(row).get(col).toString() ==
                                    grid.get(row + 3).get(col).toString()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean diagonalLowerRightCheck() {
        for (int row = 0; row < this.rows - 3; row++) {
            for (int col = 0; col < this.columns - 3; col++) {
                if (grid.get(row).get(col) != null &&
                        grid.get(row + 1).get(col + 1) != null &&
                        grid.get(row + 2).get(col + 2) != null &&
                        grid.get(row + 3).get(col + 3) != null) {
                    if (grid.get(row).get(col).toString() ==
                            grid.get(row + 1).get(col + 1).toString() &&
                            grid.get(row).get(col).toString() ==
                                    grid.get(row + 2).get(col + 2).toString() &&
                            grid.get(row).get(col).toString() ==
                                    grid.get(row + 3).get(col + 3).toString()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean diagonalLowerLeftCheck() {
        for (int row = 3; row < this.rows; row++) {
            for (int col = 0; col < this.columns - 3; col++) {
                if (grid.get(row).get(col) != null &&
                        grid.get(row - 1).get(col + 1) != null &&
                        grid.get(row - 2).get(col + 2) != null &&
                        grid.get(row - 3).get(col + 3) != null) {
                    if (grid.get(row).get(col).toString() ==
                            grid.get(row - 1).get(col + 1).toString() &&
                            grid.get(row).get(col).toString() ==
                                    grid.get(row - 2).get(col + 2).toString() &&
                            grid.get(row).get(col).toString() ==
                                    grid.get(row - 3).get(col + 3).toString()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
