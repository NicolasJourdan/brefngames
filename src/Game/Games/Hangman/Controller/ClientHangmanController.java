package Game.Games.Hangman.Controller;

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

public class ClientHangmanController extends HangmanController {

    private final SocketCommunicatorService socketCommunicatorService;

    public ClientHangmanController(HangmanModel model, HangmanView view, boolean isTraining, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, isTraining);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketCommunicatorService.addReceptionObserver(new SocketReceptionObserver());
    }

    private void updateGame(HangmanDataObject hangmanDataObject) {
        ((HangmanView) this.view).setNumGuesses(hangmanDataObject.getResult());
        ((HangmanView) this.view).setCurrentWord(hangmanDataObject.getWord());
        ((HangmanView) this.view).setNumGuesses(hangmanDataObject.getNbGuess());
        this.updateHangmanImage(hangmanDataObject.getGuessLeft());
    }

    private void updateHangmanImage(int guessLeft) {

        if (guessLeft > 7) {
            ((HangmanView) this.view).setImageIcon("/hw3/hang7.gif");
        } else {
            switch (guessLeft) {

                case 7:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang7.gif");
                    break;
                case 6:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang6.gif");
                    break;
                case 5:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang5.gif");
                    break;
                case 4:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang4.gif");
                    break;
                case 3:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang3.gif");
                    break;
                case 2:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang2.gif");
                    break;
                case 1:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang1.gif");
                    break;
                case 0:
                    ((HangmanView) this.view).setImageIcon("/data/Images/hang0.gif");
                    break;
                default:
                    break;

            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        this.socketCommunicatorService.emit(new MessageDataObject(MessageType.HANGMAN_CHARACTER, (Character) arg));
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
                case HANGMAN_WINNER:
                    ClientHangmanController.this.setChanged();
                    ClientHangmanController.this.notifyObservers((ActionEnum) messageDataObject.getData());
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
