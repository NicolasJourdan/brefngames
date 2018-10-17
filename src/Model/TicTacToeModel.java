package Model;

public class TicTacToeModel extends Model {

    int[][] board = new int[3][3];
    public int movesCounter;

    public TicTacToeModel(int[][] board) {
        this.board = board;
        this.movesCounter = 0;
    }

    public TicTacToeModel() {
        this.movesCounter = 0;
    }

    public void setChoice(Integer field, Value value) {
        Integer matrixValue = null;
        if (value == Value.X) {
            matrixValue = -1;
        } else if (value == Value.O) {
            matrixValue = 1;
        }
        board[field % 3][field / 3] = matrixValue;
        movesCounter++;
    }

    public boolean checkBoard() {
        int sumDiagonalLR = 0;
        int sumDiagonalRL = 0;
        int sumColumns = 0;
        int sumVerses = 0;

        for (int i = 0; i <= 2; i++) {
            sumDiagonalLR += board[i][i];
        }
        for (int i = 0; i <= 2; i++) {
            sumDiagonalRL += board[i][2 - i];
        }
        if (Math.abs(sumDiagonalLR) == 3 || Math.abs(sumDiagonalRL) == 3) {
            return true;
        }
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                sumColumns += board[j][i];
                sumVerses += board[i][j];

            }
            if (Math.abs(sumColumns) == 3 || Math.abs(sumVerses) == 3) {
                return true;
            } else {
                sumColumns = 0;
                sumVerses = 0;
            }
        }
        return false;
    }
}
