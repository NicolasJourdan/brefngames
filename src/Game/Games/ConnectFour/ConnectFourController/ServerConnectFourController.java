package Game.Games.ConnectFour.ConnectFourController;

import Game.Games.ConnectFour.ConnectFourModel.ConnectFourModel;
import Game.Games.ConnectFour.ConnectFourView.ConnectFourView;
import Game.Games.Coord;
import Game.Games.DataObject.PawnDataObject;
import Game.Games.DataObject.PlayerStatsDataObject;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;

import java.util.Observable;
import java.util.Observer;

public class ServerConnectFourController extends ConnectFourController {

    private final SocketCommunicatorService socketCommunicatorService;

    public ServerConnectFourController(ConnectFourModel m, ConnectFourView v, boolean isTraining, SocketCommunicatorService socketCommunicatorService) {
        super(m, v, isTraining);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketCommunicatorService.addReceptionObserver(new SocketReceptionObserver());

        // Send current player to update player display panel
        this.socketCommunicatorService.emit(new MessageDataObject(
                MessageType.CONNECT_FOUR_SET_CURRENT_PLAYER,
                ((ConnectFourModel) this.model).getCurrentPlayer()
        ));
    }

    private void play(Coord coord, boolean isFirstPlayer) {
        if (!this.isAllowedToPlay(isFirstPlayer)) {
            return;
        }

        PawnDataObject pawnDataObject = ((ConnectFourModel) this.model).play(coord);
        if (null != pawnDataObject) {
            // Set pawn on view
            ((ConnectFourView) this.view).setPawnView(
                    pawnDataObject.getColor(),
                    pawnDataObject.getCoord()
            );
            this.socketCommunicatorService.emit(new MessageDataObject(MessageType.CONNECT_FOUR_SET_PAWN, pawnDataObject));

            // Check if game is finished
            if (((ConnectFourModel) this.model).isFinished()) {
                if (!this.isTraining) {
                    ((ConnectFourModel) this.model).updatePlayerStats();
                    ((ConnectFourModel) this.model).updateGlobalStats();
                    ((ConnectFourModel) this.model).sendGlobalStats();
                    ((ConnectFourModel) this.model).sendFirstPlayerStats();
                    this.socketCommunicatorService.emit(
                            new MessageDataObject(
                                    MessageType.CONNECT_FOUR_SEND_GLOBAL_STATS,
                                    ((ConnectFourModel) this.model).getGameStats()
                            )
                    );
                    this.socketCommunicatorService.emit(
                            new MessageDataObject(
                                    MessageType.CONNECT_FOUR_SEND_PLAYER_STATS,
                                    new PlayerStatsDataObject(
                                            ((ConnectFourModel) this.model).getPlayers()[1].getName(),
                                            ((ConnectFourModel) this.model).getSecondPlayerStats()
                                    )
                            )
                    );
                }
                this.setChanged();
                this.notifyObservers(((ConnectFourModel) this.model).getWinner());
            } else {
                ((ConnectFourView) this.view).changePlayer();
                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.CONNECT_FOUR_CHANGE_PLAYER));
            }
        }


    }

    /**
     * The player is the current player
     * @param isFirstPlayer (true : Server | false : Client
     */
    private boolean isAllowedToPlay(boolean isFirstPlayer) {
        return
                (isFirstPlayer && ((ConnectFourModel) this.model).getCurrentPlayer().equals(((ConnectFourModel) this.model).getPlayers()[0])) ||
                (!isFirstPlayer && ((ConnectFourModel) this.model).getCurrentPlayer().equals(((ConnectFourModel) this.model).getPlayers()[1]))
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
                case CONNECT_FOUR_COORDINATES:
                    // The second player (client) played
                    ServerConnectFourController.this.play((Coord) messageDataObject.getData(), false);
                    break;
            }
        }
    }

}
