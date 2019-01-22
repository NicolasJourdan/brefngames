package Game.Games.FifteenVaincModel.FifteenVaincModel;

import Game.Games.Coord;
import Game.Model.AbstractGameModel;
import Game.Model.Pawn;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class FifteenVaincModel extends AbstractGameModel {
    public final static int NB_COLUMN = 9;
    public final static int NB_ROWS = 1;
    public final static int NB_TO_WIN = 15;

    private Board board;
    private Player currentPlayer;

    public FifteenVaincModel(Player[] listPlayers) {
        super(listPlayers);
        this.currentPlayer = listPlayers[0];
        this.board = new Board(NB_ROWS,NB_COLUMN);
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public boolean isWinner() {
        List<Pawn> boxes = this.board.getGrid().get(0);
        String player;
        ArrayList<Integer> listNumbers = new ArrayList<>();

        int cpt = 0;
        if (this.currentPlayer.equals(listPlayers[0])) {
            player = "J1";
        } else {
            player = "J2";
        }
        // Count number of boxes selected
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i) != null && player == boxes.get(i).toString()) {
                listNumbers.add(i+1);
                cpt++;
            }
        }
        // At least 3 boxes should be added
        if (cpt < 3) {
            return false;
        }

        for (int x = 0; x < listNumbers.size()-2; x++) {
            for (int y = x+1; y < listNumbers.size()-1; y++) {
                for (int z = y+1; z < listNumbers.size(); z++) {
                    if ( listNumbers.get(x) + listNumbers.get(y) + listNumbers.get(z) == NB_TO_WIN) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public String setBoxModel(Coord coord) {
        Pawn pawn;
        Pawn status;
        if (this.currentPlayer.equals(listPlayers[0])) {
            pawn = new Box(this.currentPlayer, coord, "J1");
        } else { // listPlayers[1]
            pawn = new Box(this.currentPlayer, coord, "J2");
        }
        status = board.setPawn(pawn);
        return status != null ? status.toString() : "";
    }

    public void changePlayer() {
        this.currentPlayer = this.currentPlayer.equals(this.listPlayers[0]) ? this.listPlayers[1] : this.listPlayers[0];
    }

    public boolean isDraw(){
        return this.board.isFill();
    }
}

