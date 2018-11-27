package Map.Controller;

import Game.Controller.AbstractGameController;
import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Map.Model.GameHistory;
import Map.Model.History;
import Map.Model.MapModel;
import Map.View.MapView;

public class MapController extends AbstractGameController {

    private History history;

    public MapController(AbstractGameModel model, AbstractGameView view, History history) {
        super(model, view);

        this.history = history;
        if (!history.isTraining()) {
            ((MapView) this.view).addCurrentScore(this.history.getPlayers(), ((MapModel) this.model).getCurrentScore(this.history));
        } else {
            ((MapView) this.view).addTrainingTitle();
        }

        for (GameHistory gameHistory : this.history.getGameHistories()) {
            ((MapView) this.view).addGame(gameHistory.getWinner(), gameHistory.getGameName().toString());
        }

        for (int i = 0; i < history.getNbRemainingGames(); i++) {
            ((MapView) this.view).addNextGame();
        }

        if (history.isTraining() || ((MapModel) this.model).isFinish(this.history)) {
            ((MapView) this.view).setBackButton();
        }
    }
}
