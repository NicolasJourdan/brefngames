package Game.Games.TicTacToe.TicTacToeModel;

public class TicTacToeModel {
    Board board;
    int size;

    public TicTacToeModel() {
        this.size = 3;
        this.board = new Board(this.size);
    }

    public boolean isWinner(int x, int y) {
        boolean status = new Boolean(false);
        int val, sumDiagonalLR, sumDiagonalRL, sumRows, sumColumns, toWin;
        toWin = getToWin(x,y);
        sumColumns = 0;
        sumRows = 0;
        for (int i = 0; i <= this.size - 1; i++) {
            sumColumns = 0;
            sumRows = 0;
            for (int j = 0; j <= this.size - 1; j++) {
                val = getVal(i, this.size - i);
                sumColumns += val;
                sumRows += val;

            }
            if(sumColumns == toWin || sumRows ==toWin){
                break;
            }
        }
        sumDiagonalLR = 0;
        sumDiagonalRL = 0;
        for (int i = 0; i <= this.size - 1; i++) {
            val = getVal(i,i);
            sumDiagonalLR += val;
        }
        for (int i = 0; i <= this.size - 1; i++) {
            val = getVal(i,this.size - 1 - i);
            sumDiagonalRL += val;
        }
        if (sumColumns == toWin || sumRows == toWin || sumDiagonalLR == toWin || sumDiagonalRL == toWin){
            status = true;
        }
        return status;
    }

    private int getVal(int i, int j){
        int val;
        if(board.grid[i][j] instanceof Cross){
            val = 1;
        }
        else if (board.grid[i][j] instanceof Circle){
            val = -1;
        }
        else{
            val = 0;
        }
        return val;
    }

    private int getToWin(int x, int y){
        int toWin = 0;
        if (board.grid[x][y] instanceof Cross){
            toWin = this.size;
        }
        else if (board.grid[x][y] instanceof Circle) {
            toWin = -this.size;
        }
        else {
            System.out.format("Error : Neither pawn in the box %d, %d", x,y);
            System.exit(1);
        }
        return toWin;
    }
    public void setPawn(Pawn pawn, int x, int y){
        board.setPawn(pawn);
    }
}
