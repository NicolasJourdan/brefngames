package Map.Controller;

import Map.Model.GameHistory;
import Map.Model.History;
import Map.Model.MapModel;
import Map.View.MapView;
import Scene.Controller.AbstractSceneController;
import Structure.AbstractModel;
import Structure.AbstractView;

public class MapController extends AbstractSceneController {

    private History history;

    public MapController(AbstractModel model, AbstractView view, History history) {
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
