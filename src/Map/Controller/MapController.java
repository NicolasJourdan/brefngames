package Map.Controller;

import Map.Model.GameHistory;
import Map.Model.History;
import Map.View.MapView;
import Scene.Controller.AbstractSceneController;
import Structure.AbstractModel;
import Structure.AbstractView;

public class MapController extends AbstractSceneController {

    private History history;

    public MapController(AbstractModel model, AbstractView view, History history) {
        super(model, view);

        for (GameHistory gameHistory : history.getGameHistories()) {
            ((MapView) this.view).addGame(gameHistory.getWinner(), gameHistory.getGameName().toString());
        }
    }
}
