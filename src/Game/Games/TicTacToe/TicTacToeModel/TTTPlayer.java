package Game.Games.TicTacToe.TicTacToeModel;


public class TTTPlayer implements Player.Player {
    String color;
    String name;

    public TTTPlayer(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
