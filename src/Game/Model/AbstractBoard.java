package Game.Model;

import java.util.ArrayList;
import java.util.List;

public class AbstractBoard {
    protected List<List<Pawn>> grid;
    protected int rows;
    protected int columns;

    public AbstractBoard(int rows , int columns) {
        this.grid = new ArrayList();
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < this.rows; i++) {
            List<Pawn> subList = new ArrayList<Pawn>();
            for (int j = 0; j < this.columns; j++) {
                subList.add(null);
            }
            this.grid.add(subList);
        }
        return;
    }

    public AbstractBoard(int size){
        this(size, size);
    }

    public List<List<Pawn>> getGrid() {
        return this.grid;
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
