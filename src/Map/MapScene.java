package Map;

import Game.GameScene;
import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Map.Controller.MapController;
import Map.Model.History;
import Map.Model.MapModel;
import Map.View.MapView;

public class MapScene extends GameScene {

    public MapScene(History history) {
        this.model = new MapModel(history.getPlayers());
        this.view = new MapView(history.getPlayers(), history);
        this.controller = new MapController((AbstractGameModel) this.model, (AbstractGameView) this.view, history);
        this.controller.addObserver(this);
    }
}
