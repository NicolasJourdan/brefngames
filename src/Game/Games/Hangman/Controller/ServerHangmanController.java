package Game.Games.Hangman.Controller;

import Contest.Interface.SocketObserverController;
import Game.Games.DataObject.HangmanDataObject;
import Game.Games.DataObject.PlayerStatsDataObject;
import Game.Games.Hangman.Model.HangmanModel;
import Game.Games.Hangman.View.HangmanView;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;

import java.util.Observable;
import java.util.Observer;

public class ServerHangmanController extends HangmanController implements SocketObserverController {
    private final SocketCommunicatorService socketCommunicatorService;
    private final SocketReceptionObserver socketReceptionObserver;

    public ServerHangmanController(HangmanModel model, HangmanView view, boolean isTraining, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, isTraining);
        this.socketCommunicatorService = socketCommunicatorService;
        this.socketReceptionObserver = new SocketReceptionObserver();
        this.socketCommunicatorService.addReceptionObserver(this.socketReceptionObserver);
        // Send current player to update player display panel
        this.socketCommunicatorService.emit(new MessageDataObject(
                MessageType.HANGMAN_SET_CURRENT_PLAYER,
                ((HangmanModel) this.model).getCurrentPlayer()
        ));
    }

    private void play(Character arg, boolean isFirstPlayer) {
        if (!this.isAllowedToPlay(isFirstPlayer)) {
            return;
        }
        if (!((HangmanModel) this.model).isFinished()) {
            String result = ((HangmanModel) this.model).makeGuess((Character) arg);
            ((HangmanView) this.view).setDisabled((Character) arg);
            this.socketCommunicatorService.emit(
                    new MessageDataObject(MessageType.HANGMAN_SET_DISABLED, (Character) arg)
            );
            HangmanDataObject hangmanDataObject = new HangmanDataObject(
                    result,
                    ((HangmanModel) this.model).updateCurrentWord(),
                    ((HangmanModel) this.model).updateNumGuesses(),
                    ((HangmanModel) this.model).getNumGuessesLeft()
            );
            ServerHangmanController.this.updateGame(hangmanDataObject);
            this.socketCommunicatorService.emit(
                    new MessageDataObject(MessageType.HANGMAN_MAKE_GUESS, hangmanDataObject)
            );
        }
        if (((HangmanModel) this.model).isFinished()) {
            if (!this.isTraining) {
                ((HangmanModel) this.model).updatePlayerStats();
                ((HangmanModel) this.model).updateGlobalStats();
                ((HangmanModel) this.model).sendGlobalStats();
                ((HangmanModel) this.model).sendFirstPlayerStats();
                ((HangmanModel) this.model).sendSecondPlayerStats();
                this.socketCommunicatorService.emit(
                        new MessageDataObject(
                                MessageType.HANGMAN_SEND_GLOBAL_STATS,
                                ((HangmanModel) this.model).getGameStats()
                        )
                );
                this.socketCommunicatorService.emit(
                        new MessageDataObject(
                                MessageType.HANGMAN_SEND_PLAYER_STATS,
                                new PlayerStatsDataObject(
                                        ((HangmanModel) this.model).getPlayers()[1].getName(),
                                        ((HangmanModel) this.model).getSecondPlayerStats()
                                )
                        )
                );
            }
            this.setChanged();
            this.notifyObservers(((HangmanModel) this.model).getWinner());
        } else {
            ((HangmanModel) this.model).changePlayer();
            ((HangmanView) this.view).updateCurrentPlayer(
                    ((HangmanModel) this.model).getCurrentPlayer()
            );
            this.socketCommunicatorService.emit(
                    new MessageDataObject(
                            MessageType.HANGMAN_CHANGE_PLAYER,
                            ((HangmanModel) this.model).getCurrentPlayer()
                    )
            );
        }
    }

    /**
     * The player is the current player
     * @param isFirstPlayer (true : Server | false : Client
     */
    private boolean isAllowedToPlay(boolean isFirstPlayer) {
        return
                (isFirstPlayer && ((HangmanModel) this.model).getCurrentPlayer().equals(((HangmanModel) this.model).getPlayers()[0])) ||
                (!isFirstPlayer && ((HangmanModel) this.model).getCurrentPlayer().equals(((HangmanModel) this.model).getPlayers()[1]))
        ;
    }

    @Override
    public void update(Observable o, Object arg) {
        // The first player (server) played
        this.play((Character) arg, true);
    }

    @Override
    public void stopObserver() {
        this.socketCommunicatorService.deleteReceptionObserver(this.socketReceptionObserver);
    }

    private class SocketReceptionObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            MessageDataObject messageDataObject = (MessageDataObject) arg;
            switch (messageDataObject.getType()) {
                case HANGMAN_CHARACTER:
                    // The second player (client) played
                    ServerHangmanController.this.play((Character) messageDataObject.getData(), false);
                    break;
            }
        }
    }
}
