package Game.Games.TicTacToe;

import Game.Games.TicTacToe.TicTacToeModel.*;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;

public class TicTacToeController {
    TicTacToeModel model;
    TicTacToeView view;
    Player players[] = new Player[2];

    public TicTacToeController(TicTacToeModel m, TicTacToeView v) {
        this.model = m;
        this.view = v;
        players[0] = new Player("NicoLeBg", "Blue");
        players[1] = new Player("RayaneLaMenace", "Red");

    }

//
//    public void play(int x, int y){
//        boolean finish = new Boolean(false);
//        boolean status = new Boolean(false);
//        boolean player = new Boolean(false);
//        while(!finish) {
//            if (player) {
//                status = this.model.setPawn(new Circle(players[0], x, y));
//                if (status) {
//                    finish = this.model.isWinner(x, y);
//                    player = !player;
//                }
//            }
//            else {
//                status = this.model.setPawn(new Cross(players[1], x, y));
//                if(status) {
//                    finish = this.model.isWinner(x, y);
//                    player = !player;
//                }
//            }
//        }
//        System.out.print("The winner is the player named" + player.name);
//        System.exit(0);
//    }
}
