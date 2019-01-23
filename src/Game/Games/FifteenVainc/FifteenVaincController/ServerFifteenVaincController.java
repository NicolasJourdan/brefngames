package Game.Games.FifteenVainc.FifteenVaincController;

import Contest.Interface.SocketObserverController;
import Game.Games.Coord;
import Game.Games.DataObject.PawnDataObject;
import Game.Games.DataObject.PlayerStatsDataObject;
import Game.Games.FifteenVainc.FifteenVaincModel.FifteenVaincModel;
import Game.Games.FifteenVainc.FifteenVaincView.FifteenVaincView;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;

import java.util.Observable;
import java.util.Observer;

public class ServerFifteenVaincController extends FifteenVaincController implements SocketObserverController {
    private final SocketCommunicatorService socketCommunicatorService;
    private final SocketReceptionObserver socketReceptionObserver;

    public ServerFifteenVaincController(FifteenVaincModel model, FifteenVaincView view, boolean isTraining, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, isTraining);
        this.socketCommunicatorService = socketCommunicatorService;
        this.socketReceptionObserver = new SocketReceptionObserver();
        this.socketCommunicatorService.addReceptionObserver(this.socketReceptionObserver);

        // Send current player to update player display panel
        this.socketCommunicatorService.emit(new MessageDataObject(
                MessageType.FIFTEEN_VAINC_SET_CURRENT_PLAYER,
                ((FifteenVaincModel) this.model).getCurrentPlayer()
        ));
    }

    private void play(Coord coord, boolean isFirstPlayer) {
        if (!this.isAllowedToPlay(isFirstPlayer)) {
            return;
        }

        PawnDataObject pawnDataObject = ((FifteenVaincModel) this.model).play(coord);

        // Check if move is allowed
        if (null != pawnDataObject) {
            // Set pawn on view
            ((FifteenVaincView) this.view).setPawnView(
                    pawnDataObject.getValue(),
                    pawnDataObject.getColor(),
                    pawnDataObject.getCoord()
            );
            this.socketCommunicatorService.emit(new MessageDataObject(MessageType.FIFTEEN_VAINC_SET_PAWN, pawnDataObject));

            // Check if game is finished
            if (((FifteenVaincModel) this.model).isFinished()) {
                // Send stats
                if (!this.isTraining) {
                    ((FifteenVaincModel) this.model).updatePlayerStats();
                    ((FifteenVaincModel) this.model).updateGlobalStats();
                    ((FifteenVaincModel) this.model).sendGlobalStats();
                    ((FifteenVaincModel) this.model).sendFirstPlayerStats();
                    this.socketCommunicatorService.emit(
                            new MessageDataObject(
                                    MessageType.FIFTEEN_VAINC_SEND_GLOBAL_STATS,
                                    ((FifteenVaincModel) this.model).getStatsMap()
                            )
                    );
                    this.socketCommunicatorService.emit(
                            new MessageDataObject(
                                    MessageType.FIFTEEN_VAINC_SEND_PLAYER_STATS,
                                    new PlayerStatsDataObject(
                                            ((FifteenVaincModel) this.model).getPlayers()[1].getName(),
                                            ((FifteenVaincModel) this.model).getStatsSecondPlayer()
                                    )
                            )
                    );
                }
                this.setChanged();
                this.notifyObservers(((FifteenVaincModel) this.model).getWinner());
                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.FIFTEEN_VAINC_WINNER, ((FifteenVaincModel) this.model).getWinner()));
            } else {
                ((FifteenVaincModel) this.model).changePlayer();
                ((FifteenVaincView) this.view).changePlayer();
                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.FIFTEEN_VAINC_CHANGE_PLAYER));
            }
        }
    }

    /**
     * The player is the current player
     * @param isFirstPlayer (true : Server | false : Client
     */
    private boolean isAllowedToPlay(boolean isFirstPlayer) {
        return
                (isFirstPlayer && ((FifteenVaincModel) this.model).getCurrentPlayer().equals(((FifteenVaincModel) this.model).getPlayers()[0])) ||
                        (!isFirstPlayer && ((FifteenVaincModel) this.model).getCurrentPlayer().equals(((FifteenVaincModel) this.model).getPlayers()[1]))
                ;
    }

    @Override
    public void update(Observable o, Object arg) {
        // The first player (server) played
        this.play((Coord) arg, true);
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
                case FIFTEEN_VAINC_COORDINATES:
                    // The second player (client) played
                    ServerFifteenVaincController.this.play((Coord) messageDataObject.getData(), false);
                    break;
            }
        }
    }
}
