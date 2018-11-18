package Game.Games.TicTacToe.TicTacToeModel;

public class Board {
    Pawn[][] grid;
    int size;
    public Board(int size) {
        this.size = size;
        Pawn[][] grid = new Pawn[this.size][this.size];
    }

    public boolean setPawn(Pawn pawn){
        boolean status = new Boolean(false);
        if (pawn.x < this.size && pawn.x > 0 && pawn.y < this.size && pawn.y > 0){
            if (this.grid[pawn.x][pawn.y] != null){
                //Error: this case already contain a pawn
                System.out.print("Error: this case already contain a pawn");
            }
            else{
                this.grid[pawn.x][pawn.y] = pawn;
                status = true;
            }
        }
        return status;
    }
}
