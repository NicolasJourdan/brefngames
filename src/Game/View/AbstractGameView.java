package Game.View;

import Game.Games.ScoreDisplay;
import Map.Model.History;
import Player.Player;
import Structure.AbstractView;

/**
 * The game views have to implement this view.
 */
public abstract class AbstractGameView extends AbstractView {
    protected ScoreDisplay scoreDisplay;
    public AbstractGameView(Player[] players, History history){
        this.scoreDisplay = new ScoreDisplay(players, history);
    }

    public void setScoreDisplay(boolean visible) {
        this.scoreDisplay.setVisible(visible);
    }
}
