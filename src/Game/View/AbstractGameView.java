package Game.View;

import Game.Games.ScoreDisplay;
import Player.Player;
import Structure.AbstractView;

/**
 * The game views have to implement this view.
 */
public abstract class AbstractGameView extends AbstractView {
    protected ScoreDisplay scoreDisplay;
    public AbstractGameView(Player[] players, int[] scores){
        this.scoreDisplay = new ScoreDisplay(players, scores);
    }

    public void setScoreDisplay(boolean visible) {
        if (visible) {
            this.scoreDisplay.setVisible(true);
        } else {
            this.scoreDisplay.hideScore();
        }
    }
}
