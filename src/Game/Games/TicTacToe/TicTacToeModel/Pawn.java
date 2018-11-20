package Game.Games.TicTacToe.TicTacToeModel;

public class Pawn {
    int x;
    int y;
    String color;


    public Pawn(Player player, int x, int y) {
        this.color = player.color;
        this.x = x;
        this.y = y;
    }
}