package Game.Games.FifteenVainc;

import Game.GameScene;
import Game.Games.FifteenVainc.FifteenVaincController.ClientFifteenVaincController;
import Game.Games.FifteenVainc.FifteenVaincController.FifteenVaincController;
import Game.Games.FifteenVainc.FifteenVaincController.ServerFifteenVaincController;
import Game.Games.FifteenVainc.FifteenVaincModel.FifteenVaincModel;
import Game.Games.FifteenVainc.FifteenVaincView.FifteenVaincView;
import Online.Socket.SocketCommunicatorService;
import Player.Player;

public class FifteenVaincScene extends GameScene{
    private final static int DEFAULT_SIZE_ROW = 1;
    private final static int DEFAULT_SIZE_COLUMN = 9;

    public FifteenVaincScene(Player[] listPlayers, boolean isTraining, int[] scores) {
        this.model = new FifteenVaincModel(listPlayers);
        this.view = new FifteenVaincView(DEFAULT_SIZE_ROW, DEFAULT_SIZE_COLUMN, listPlayers, scores);
        this.controller = new FifteenVaincController((FifteenVaincModel) this.model, (FifteenVaincView) this.view, isTraining);
        this.controller.addObserver(this);
    }

    public FifteenVaincScene(Player[] listPlayers, boolean isTraining, int[] scores, boolean isServer, SocketCommunicatorService socketCommunicatorService) {
        this.model = new FifteenVaincModel(listPlayers);
        this.view = new FifteenVaincView(DEFAULT_SIZE_ROW, DEFAULT_SIZE_COLUMN, listPlayers, scores);
        this.controller = isServer ?
                new ServerFifteenVaincController((FifteenVaincModel) this.model, (FifteenVaincView) this.view, isTraining, socketCommunicatorService) :
                new ClientFifteenVaincController((FifteenVaincModel) this.model, (FifteenVaincView) this.view, isTraining, socketCommunicatorService)
        ;
        this.controller.addObserver(this);
    }
}
