package Utils.UI.CustomPanel;

import Game.View.AbstractGameView;
import Map.Model.History;
import Player.Player;

public class CustomGameBackgroundPanel extends AbstractGameView {
    public CustomGameBackgroundPanel(Player[] players, History history) {
        super(players, history);
        this.setOpaque(false);
    }
}
