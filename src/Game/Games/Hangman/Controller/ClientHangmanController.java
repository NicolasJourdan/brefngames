package Game.Games.Hangman.Controller;

import Contest.Interface.SocketObserverController;
import Contest.Model.ContestDataPersistor;
import Game.Games.DataObject.HangmanDataObject;
import Game.Games.DataObject.PlayerStatsDataObject;
import Game.Games.Hangman.HangmanStatsEnum;
import Game.Games.Hangman.Model.HangmanModel;
import Game.Games.Hangman.View.HangmanView;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Player.Player;
import Scene.Model.ActionEnum;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ClientHangmanController extends HangmanController implements SocketObserverController {

    private final SocketCommunicatorService socketCommunicatorService;
    private final SocketReceptionObserver socketReceptionObserver;

    public ClientHangmanController(HangmanModel model, HangmanView view, boolean isTraining, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, isTraining);
        this.socketCommunicatorService = socketCommunicatorService;
        this.socketReceptionObserver = new SocketReceptionObserver();
        this.socketCommunicatorService.addReceptionObserver(this.socketReceptionObserver);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.socketCommunicatorService.emit(new MessageDataObject(MessageType.HANGMAN_CHARACTER, (Character) arg));
    }

    @Override
    public void stopObserver() {
        this.socketCommunicatorService.deleteReceptionObserver(this.socketReceptionObserver);
    }

    /**
     * Reception from the socket (messages sent by the server)
     */
    private class SocketReceptionObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            MessageDataObject messageDataObject = (MessageDataObject) arg;
            switch (messageDataObject.getType()) {
                case HANGMAN_CHANGE_PLAYER:
                    Player curentPlayer = (Player) messageDataObject.getData();
                    ((HangmanView) ClientHangmanController.this.view).updateCurrentPlayer(curentPlayer);
                    break;
                case HANGMAN_SET_DISABLED:
                    Character c = (Character) messageDataObject.getData();
                    ((HangmanView) ClientHangmanController.this.view).setDisabled(c);
                    break;
                case HANGMAN_SEND_PLAYER_STATS:
                    PlayerStatsDataObject playerStatsDataObject = (PlayerStatsDataObject) messageDataObject.getData();
                    ContestDataPersistor.updateDataPlayer(playerStatsDataObject.getPlayerId(), playerStatsDataObject.getStats());
                    break;
                case HANGMAN_MAKE_GUESS:
                    HangmanDataObject hangmanDataObject = (HangmanDataObject) messageDataObject.getData();
                    ClientHangmanController.this.updateGame(hangmanDataObject);
                    break;
                case HANGMAN_SEND_GLOBAL_STATS:
                    ContestDataPersistor.updateHangman((Map<HangmanStatsEnum, String>) messageDataObject.getData());
                    break;
                case HANGMAN_SET_CURRENT_PLAYER:
                    ((HangmanView) ClientHangmanController.this.view).updateCurrentPlayer(
                            (Player) messageDataObject.getData()
                    );
                    break;
            }
        }
    }
}
