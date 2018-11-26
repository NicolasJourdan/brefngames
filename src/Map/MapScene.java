package Map;

import Map.Controller.MapController;
import Map.Model.History;
import Map.Model.MapModel;
import Map.View.MapView;
import Scene.Model.Scene;

public class MapScene extends Scene {

    public MapScene(History history) {
        this.model = new MapModel();
        this.view = new MapView();
        this.controller = new MapController(this.model, this.view, history);
        this.controller.addObserver(this);
    }
}
