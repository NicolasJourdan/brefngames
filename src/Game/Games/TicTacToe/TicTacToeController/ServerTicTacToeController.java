package Game.Games.TicTacToe.TicTacToeController;

import Game.Games.Coord;
import Game.Games.DataObject.PawnDataObject;
import Game.Games.DataObject.PlayerStatsDataObject;
import Game.Games.TicTacToe.TicTacToeModel.TicTacToeModel;
import Game.Games.TicTacToe.TicTacToeView.TicTacToeView;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import java.util.Observable;
import java.util.Observer;

public class ServerTicTacToeController extends TicTacToeController {
    private final SocketCommunicatorService socketCommunicatorService;

    public ServerTicTacToeController(TicTacToeModel model, TicTacToeView view, boolean isTraining, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, isTraining);
        this.socketCommunicatorService = socketCommunicatorService;
        this.socketCommunicatorService.addReceptionObserver(new SocketReceptionObserver());

        // Send current player to update player display panel
        this.socketCommunicatorService.emit(new MessageDataObject(
                MessageType.TIC_TAC_TOE_SET_CURRENT_PLAYER,
                ((TicTacToeModel) this.model).getCurrentPlayer()
        ));
    }

    private void play(Coord coord, boolean isFirstPlayer) {
        if (!this.isAllowedToPlay(isFirstPlayer)) {
            return;
        }

        PawnDataObject pawnDataObject = ((TicTacToeModel) this.model).play(coord);

        // Check if move is allowed
        if (null != pawnDataObject) {
            // Set pawn on view
            ((TicTacToeView) this.view).setPawnView(
                    pawnDataObject.getValue(),
                    pawnDataObject.getColor(),
                    pawnDataObject.getCoord()
            );
            this.socketCommunicatorService.emit(new MessageDataObject(MessageType.TIC_TAC_TOE_SET_PAWN, pawnDataObject));

            // Check if game is finished
            if (((TicTacToeModel) this.model).isFinished()) {
                // Send stats
                if (!this.isTraining) {
                    ((TicTacToeModel) this.model).updatePlayerStats();
                    ((TicTacToeModel) this.model).updateGlobalStats();
                    ((TicTacToeModel) this.model).sendGlobalStats();
                    ((TicTacToeModel) this.model).sendFirstPlayerStats();
                    this.socketCommunicatorService.emit(
                            new MessageDataObject(
                                    MessageType.TIC_TAC_TOE_SEND_GLOBAL_STATS,
                                    ((TicTacToeModel) this.model).getStatsMap()
                            )
                    );
                    this.socketCommunicatorService.emit(
                            new MessageDataObject(
                                    MessageType.TIC_TAC_TOE_SEND_PLAYER_STATS,
                                    new PlayerStatsDataObject(
                                            ((TicTacToeModel) this.model).getPlayers()[1].getName(),
                                            ((TicTacToeModel) this.model).getStatsSecondPlayer()
                                    )
                            )
                    );
                }
                this.setChanged();
                this.notifyObservers(((TicTacToeModel) this.model).getWinner());
                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.TIC_TAC_TOE_WINNER, ((TicTacToeModel) this.model).getWinner()));
            } else {
                ((TicTacToeModel) this.model).changePlayer();
                ((TicTacToeView) this.view).changePlayer();
                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.TIC_TAC_TOE_CHANGE_PLAYER));
            }
        }
    }

    /**
     * The player is the current player
     * @param isFirstPlayer (true : Server | false : Client
     */
    private boolean isAllowedToPlay(boolean isFirstPlayer) {
        return
                (isFirstPlayer && ((TicTacToeModel) this.model).getCurrentPlayer().equals(((TicTacToeModel) this.model).getPlayers()[0])) ||
                (!isFirstPlayer && ((TicTacToeModel) this.model).getCurrentPlayer().equals(((TicTacToeModel) this.model).getPlayers()[1]))
        ;
    }

    @Override
    public void update(Observable o, Object arg) {
        // The first player (server) played
        this.play((Coord) arg, true);
    }

    private class SocketReceptionObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            MessageDataObject messageDataObject = (MessageDataObject) arg;
            switch (messageDataObject.getType()) {
                case TIC_TAC_TOE_COORDINATES:
                    // The second player (client) played
                    ServerTicTacToeController.this.play((Coord) messageDataObject.getData(), false);
                    break;
            }
        }
    }
}
