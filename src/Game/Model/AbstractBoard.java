package Game.Model;

import java.util.ArrayList;
import java.util.List;

public class AbstractBoard {
    protected ArrayList<List<Pawn>> grid = new ArrayList();
    protected int rows;
    protected int columns;

    public AbstractBoard(int rows , int columns) {
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < this.rows; i++) {
            List<Pawn> subList = new ArrayList<Pawn>();
            for (int j = 0; j < this.columns; j++) {
                subList.add(null);
            }
            grid.add(subList);
        }
        return;
    }

    public AbstractBoard(int size){
        this(size, size);
    }

    public ArrayList<List<Pawn>> getGrid() {
        return grid;
    }

    public Boolean isFill(){
        Boolean status = true;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (this.grid.get(i).get(j) == null) {
                    return false;
                }
            }
        }
        return status;
    }
    public Pawn setPawn(Pawn pawn) {
        return null;
    }

    }
