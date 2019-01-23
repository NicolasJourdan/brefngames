package Map;

import Game.GameScene;
import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Map.Controller.ClientMapController;
import Map.Controller.MapController;
import Map.Controller.ServerMapController;
import Map.Model.History;
import Map.Model.MapModel;
import Map.Model.OnlineMapModel;
import Map.View.MapView;
import Online.Socket.SocketCommunicatorService;

public class MapScene extends GameScene {

    public MapScene(History history) {
        this.model = new MapModel(history.getPlayers());
        this.view = new MapView(history.getPlayers(), history.getCurrentScore());
        this.controller = new MapController((AbstractGameModel) this.model, (AbstractGameView) this.view, history);
        this.controller.addObserver(this);
    }

    public MapScene(History history, boolean isServer, SocketCommunicatorService socketCommunicatorService) {
        this.model = new OnlineMapModel(history.getPlayers());
        this.view = new MapView(history.getPlayers(), history.getCurrentScore());
        this.controller = isServer ?
                new ServerMapController((OnlineMapModel) this.model, (MapView) this.view, history, socketCommunicatorService) :
                new ClientMapController((OnlineMapModel) this.model, (MapView) this.view, history, socketCommunicatorService)
        ;
        this.controller.addObserver(this);
    }
}
