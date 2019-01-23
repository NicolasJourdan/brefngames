package Game.Games.ConnectFour.ConnectFourController;

import Contest.Model.ContestDataPersistor;
import Game.Games.ConnectFour.ConnectFourModel.ConnectFourModel;
import Game.Games.ConnectFour.ConnectFourStatsEnum;
import Game.Games.ConnectFour.ConnectFourView.ConnectFourView;
import Game.Games.Coord;
import Game.Games.DataObject.PawnDataObject;
import Game.Games.DataObject.PlayerStatsDataObject;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Player.Player;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ClientConnectFourController extends ConnectFourController {

    private final SocketCommunicatorService socketCommunicatorService;

    public ClientConnectFourController(ConnectFourModel m, ConnectFourView v, boolean isTraining, SocketCommunicatorService socketCommunicatorService) {
        super(m, v, isTraining);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketCommunicatorService.addReceptionObserver(new SocketReceptionObserver());
    }

    @Override
    public void update(Observable o, Object arg) {
        this.socketCommunicatorService.emit(new MessageDataObject(MessageType.CONNECT_FOUR_COORDINATES, (Coord) arg));
    }

    /**
     * Reception from the socket (messages sent by the server)
     */
    private class SocketReceptionObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            MessageDataObject messageDataObject = (MessageDataObject) arg;
            switch (messageDataObject.getType()) {
                case CONNECT_FOUR_SET_PAWN:
                    PawnDataObject pawnDataObject = (PawnDataObject) messageDataObject.getData();
                    ((ConnectFourView) ClientConnectFourController.this.view).setPawnView(
                            pawnDataObject.getColor(),
                            pawnDataObject.getCoord()
                    );
                    break;
                case CONNECT_FOUR_CHANGE_PLAYER:
                    ((ConnectFourView) ClientConnectFourController.this.view).changePlayer();
                    break;
                case CONNECT_FOUR_SEND_GLOBAL_STATS:
                    ContestDataPersistor.updateConnectFour((Map< ConnectFourStatsEnum, String>) messageDataObject.getData());
                    break;
                case CONNECT_FOUR_SEND_PLAYER_STATS:
                    PlayerStatsDataObject playerStatsDataObject = (PlayerStatsDataObject) messageDataObject.getData();
                    ContestDataPersistor.updateDataPlayer(playerStatsDataObject.getPlayerId(), playerStatsDataObject.getStats());
                    break;
                case CONNECT_FOUR_SET_CURRENT_PLAYER:
                    ((ConnectFourView) ClientConnectFourController.this.view).updateCurrentPlayer(
                            (Player) messageDataObject.getData()
                    );
                    break;
            }
        }
    }
}
