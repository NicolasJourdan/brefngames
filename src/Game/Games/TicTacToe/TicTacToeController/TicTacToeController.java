package Game.Games.TicTacToe.TicTacToeController;

import Game.Controller.AbstractGameController;
import Game.Games.TicTacToe.TicTacToeModel.*;
import Game.Games.TicTacToe.TicTacToeView.Coord;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;
import Parameter.Model.ParameterEnum;


import javax.swing.*;

import java.util.List;
import java.util.Observable;

public class TicTacToeController extends AbstractGameController {
    private TicTacToeModel model;
    private TicTacToeView view;
    private int size;


    public TicTacToeController(TicTacToeModel m, TicTacToeView v, int size) {
        super(m, v);
        this.size=size;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    @Override
    public List<ParameterEnum> getNeededParams() {
        return null;
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
    private Coord translatePixelToCoord(JPanel board, JPanel box){

        // recheche de l'indice du carré sur le damier
        int parentSquareNumber = board.getComponentZOrder(box);
        //calcul des coordonnées du carré en mode Coord(x, y)
        int x = parentSquareNumber % this.size;
        int y = parentSquareNumber / this.size;
        Coord coord = new Coord(x, y);
        return coord;
    }
}
