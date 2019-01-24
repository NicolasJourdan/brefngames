package Map.Controller;

import Game.Controller.AbstractGameController;
import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Map.Model.GameHistory;
import Map.Model.History;
import Map.Model.MapModel;
import Map.View.MapView;

public class MapController extends AbstractGameController {

    private static final String BACK_BUTTON_TEXT = "back";
    protected History history;

    public MapController(AbstractGameModel model, AbstractGameView view, History history) {
        super(model, view, history.isTraining());

        this.history = history;

        if (this.isTraining) {
            ((MapView) this.view).addTrainingTitle();
        }

        for (GameHistory gameHistory : this.history.getGameHistories()) {
            ((MapView) this.view).addGame(gameHistory.getWinner(), gameHistory.getGameName().toString());
        }

        for (int i = 0; i < history.getNbRemainingGames(); i++) {
            ((MapView) this.view).addNextGame();
        }

        this.setBackButton();
    }

    protected void setBackButton() {
        if (this.isTraining || ((MapModel) this.model).isFinish(this.history)) {
            ((MapView) this.view).setBackButton(MapController.BACK_BUTTON_TEXT);
        }
    }
}
