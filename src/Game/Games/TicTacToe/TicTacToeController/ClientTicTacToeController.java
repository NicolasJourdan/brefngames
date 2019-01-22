package Game.Games.TicTacToe.TicTacToeController;

import Contest.Model.ContestDataPersistor;
import Game.Games.Coord;
import Game.Games.TicTacToe.DataObject.PawnDataObject;
import Game.Games.TicTacToe.DataObject.PlayerStatsDataObject;
import Game.Games.TicTacToe.TicTacToeModel.TicTacToeModel;
import Game.Games.TicTacToe.TicTacToeStatsEnum;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Scene.Model.ActionEnum;

import java.net.Socket;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ClientTicTacToeController extends TicTacToeController {

    private final SocketCommunicatorService socketCommunicatorService;

    public ClientTicTacToeController(TicTacToeModel model, TicTacToeView view, int size, boolean isTraining, Socket socket) {
        super(model, view, size, isTraining);

        this.socketCommunicatorService = new SocketCommunicatorService(socket, new SocketReceptionObserver());
    }

    @Override
    public void update(Observable o, Object arg) {
        this.socketCommunicatorService.emit(new MessageDataObject(MessageType.TIC_TAC_TOE_COORDINATES, (Coord) arg));
    }

    /**
     * Reception from the socket (messages sent by the server)
     */
    private class SocketReceptionObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            MessageDataObject messageDataObject = (MessageDataObject) arg;
            switch (messageDataObject.getType()) {
                case TIC_TAC_TOE_SET_PAWN:
                    PawnDataObject pawnDataObject = (PawnDataObject) messageDataObject.getData();
                    ((TicTacToeView) ClientTicTacToeController.this.view).setPawnView(
                            pawnDataObject.getValue(),
                            pawnDataObject.getColor(),
                            pawnDataObject.getCoord()
                    );
                    break;
                case TIC_TAC_TOE_CHANGE_PLAYER:
                    ((TicTacToeView) ClientTicTacToeController.this.view).changePlayer();
                    break;
                case TIC_TAC_TOE_FIRST_PLAYER_WON:
                    ClientTicTacToeController.this.setChanged();
                    ClientTicTacToeController.this.notifyObservers(ActionEnum.FIRST_PLAYER_WON);
                    break;
                case TIC_TAC_TOE_SECOND_PLAYER_WON:
                    ClientTicTacToeController.this.setChanged();
                    ClientTicTacToeController.this.notifyObservers(ActionEnum.SECOND_PLAYER_WON);
                    break;
                case TIC_TAC_TOE_DRAW:
                    ClientTicTacToeController.this.setChanged();
                    ClientTicTacToeController.this.notifyObservers(ActionEnum.DRAW);
                    break;
                case TIC_TAC_TOE_SEND_GLOBAL_STATS:
                    ContestDataPersistor.updateTicTacToe((Map<TicTacToeStatsEnum, String>) messageDataObject.getData());
                    break;
                case TIC_TAC_TOE_SEND_PLAYER_STATS:
                    PlayerStatsDataObject playerStatsDataObject = (PlayerStatsDataObject) messageDataObject.getData();
                    ContestDataPersistor.updateDataPlayer(playerStatsDataObject.getPlayerId(), playerStatsDataObject.getStats());
                    break;
            }
        }
    }
}
