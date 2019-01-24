package Map.Model;

import Player.Player;

public class OnlineMapModel extends MapModel {

    private boolean firstPlayerValidation;
    private boolean secondPlayerValidation;

    public OnlineMapModel(Player[] listPlayers) {
        super(listPlayers);

        this.firstPlayerValidation = false;
        this.secondPlayerValidation = false;
    }

    public void firstPlayerValidate() {
        this.firstPlayerValidation = true;
    }

    public void secondPlayerValidate() {
        this.secondPlayerValidation = true;
    }

    public boolean canStartScene() {
        return this.firstPlayerValidation && this.secondPlayerValidation;
    }
}
