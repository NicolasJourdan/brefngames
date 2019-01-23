package Game.Games.FifteenVainc.FifteenVaincController;

import Contest.Model.ContestDataPersistor;
import Game.Games.Coord;
import Game.Games.DataObject.PawnDataObject;
import Game.Games.DataObject.PlayerStatsDataObject;
import Game.Games.FifteenVainc.FifteenVaincModel.FifteenVaincModel;
import Game.Games.FifteenVainc.FifteenVaincStatsEnum;
import Game.Games.FifteenVainc.FifteenVaincView.FifteenVaincView;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Player.Player;
import Scene.Model.ActionEnum;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ClientFifteenVaincController extends FifteenVaincController {
    private final SocketCommunicatorService socketCommunicatorService;

    public ClientFifteenVaincController(FifteenVaincModel model, FifteenVaincView view, boolean isTraining, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, isTraining);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketCommunicatorService.addReceptionObserver(new SocketReceptionObserver());
    }

    @Override
    public void update(Observable o, Object arg) {
        this.socketCommunicatorService.emit(new MessageDataObject(MessageType.FIFTEEN_VAINC_COORDINATES, (Coord) arg));
    }

    /**
     * Reception from the socket (messages sent by the server)
     */
    private class SocketReceptionObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            MessageDataObject messageDataObject = (MessageDataObject) arg;
            switch (messageDataObject.getType()) {
                case FIFTEEN_VAINC_SET_PAWN:
                    PawnDataObject pawnDataObject = (PawnDataObject) messageDataObject.getData();
                    ((FifteenVaincView) ClientFifteenVaincController.this.view).setPawnView(
                            pawnDataObject.getValue(),
                            pawnDataObject.getColor(),
                            pawnDataObject.getCoord()
                    );
                    break;
                case FIFTEEN_VAINC_CHANGE_PLAYER:
                    ((FifteenVaincView) ClientFifteenVaincController.this.view).changePlayer();
                    break;
                case FIFTEEN_VAINC_WINNER:
                    ClientFifteenVaincController.this.setChanged();
                    ClientFifteenVaincController.this.notifyObservers((ActionEnum) messageDataObject.getData());
                    break;
                case FIFTEEN_VAINC_SEND_GLOBAL_STATS:
                    ContestDataPersistor.updateFifteenVainc((Map<FifteenVaincStatsEnum, String>) messageDataObject.getData());
                    break;
                case FIFTEEN_VAINC_SEND_PLAYER_STATS:
                    PlayerStatsDataObject playerStatsDataObject = (PlayerStatsDataObject) messageDataObject.getData();
                    ContestDataPersistor.updateDataPlayer(playerStatsDataObject.getPlayerId(), playerStatsDataObject.getStats());
                    break;
                case FIFTEEN_VAINC_SET_CURRENT_PLAYER:
                    ((FifteenVaincView) ClientFifteenVaincController.this.view).updateCurrentPlayer(
                            (Player) messageDataObject.getData()
                    );
                    break;
            }
        }
    }
}
