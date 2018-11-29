//package Game.Games.ConnectFour.ConnectFourView;
//
//import Game.View.AbstractGameView;
//import Structure.ProxyObservable;
//
//import java.awt.*;
//
//public class ConnectFourView extends AbstractGameView {
//    private Board board;
//    private int size;
//
//    public ConnectFourView(int size) {
//        this.size = size;
//        this.board = new Board(this.size, this);
//        this.add(this.board);
//    }
//
//    public void setPawnView(String text, Color color, Coord coord) {
//        this.board.setPawnBoard(text, color, coord);
//        this.revalidate();
//        this.repaint();
//    }
//
//    public ProxyObservable getObservable() {
//        return this.observable;
//    }
//
//}
