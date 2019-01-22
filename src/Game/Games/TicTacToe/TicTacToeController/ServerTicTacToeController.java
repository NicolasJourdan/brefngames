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
import Repository.Player.PlayerStatsEnum;
import Scene.Model.ActionEnum;

import java.awt.*;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class ServerTicTacToeController extends TicTacToeController {
    private final SocketCommunicatorService socketCommunicatorService;

    public ServerTicTacToeController(TicTacToeModel model, TicTacToeView view, int size, boolean isTraining, Socket socket) {
        super(model, view, size, isTraining);
        this.socketCommunicatorService = new SocketCommunicatorService(socket, new SocketReceptionObserver());
    }

    private void play(Coord coord, boolean isFirstPlayer) {
        if (!this.isAllowedToPlay(isFirstPlayer)) {
            return;
        }

        String status = ((TicTacToeModel) this.model).setPawnModel(coord);
        if (!status.isEmpty()) {
            this.round += 1;
            this.updateSignStats(status);
            Color color = ((TicTacToeModel) this.model).getCurrentPlayer().getColor();
            ((TicTacToeView) this.view).setPawnView(status, color, coord);
            this.socketCommunicatorService.emit(new MessageDataObject(MessageType.TIC_TAC_TOE_SET_PAWN, new PawnDataObject(status, color, coord)));
            if (((TicTacToeModel) this.model).isWinner()) {
                this.setChanged();
                if (this.round <= 6) {
                    this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_PERFECT, "1");
                }
                if (((TicTacToeModel) this.model).getCurrentPlayer().getName().equals(((TicTacToeModel) this.model).getPlayers()[0].getName())) {
                    this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                    this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                    this.statsFirstPlayer.put(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN, "1");
                    this.sendFirstPlayerStats();
                    this.sendSecondPlayerStats();
                    this.notifyObservers(ActionEnum.FIRST_PLAYER_WON);
                    this.socketCommunicatorService.emit(MessageType.TIC_TAC_TOE_FIRST_PLAYER_WON);
                    return;
                } else {
                    this.statsSecondPlayer.put(PlayerStatsEnum.TOTAL_NB_WIN, "1");
                    this.statsFirstPlayer.put(PlayerStatsEnum.TOTAL_NB_LOOSE, "1");
                    this.statsSecondPlayer.put(PlayerStatsEnum.TIC_TAC_TOE_NB_WIN, "1");
                    this.sendFirstPlayerStats();
                    this.sendSecondPlayerStats();
                    this.notifyObservers(ActionEnum.SECOND_PLAYER_WON);
                    this.socketCommunicatorService.emit(MessageType.TIC_TAC_TOE_SECOND_PLAYER_WON);
                    return;
                }
            }
            if (((TicTacToeModel) this.model).isDraw()) {
                this.statsMap.put(TicTacToeStatsEnum.TIC_TAC_TOE_NB_DRAW, "1");
                this.sendFirstPlayerStats();
                this.sendSecondPlayerStats();
                this.setChanged();
                this.notifyObservers(ActionEnum.DRAW);
                this.socketCommunicatorService.emit(MessageType.TIC_TAC_TOE_DRAW);
                return;
            }
            ((TicTacToeModel) this.model).changePlayer();
            ((TicTacToeView) this.view).changePlayer();
            this.socketCommunicatorService.emit(new MessageDataObject(MessageType.TIC_TAC_TOE_CHANGE_PLAYER, null));
        }
    }

    private void sendFirstPlayerStats() {
        this.updateGlobalStats();
        ContestDataPersistor.updateTicTacToe(this.statsMap);
        ContestDataPersistor.updateDataPlayer(((TicTacToeModel) this.model).getPlayers()[0].getName(),this.statsFirstPlayer);
    }

    private void sendSecondPlayerStats() {
        this.updateGlobalStats();
        this.socketCommunicatorService.emit(new MessageDataObject(MessageType.TIC_TAC_TOE_SEND_GLOBAL_STATS, this.statsMap));
        this.socketCommunicatorService.emit(
                new MessageDataObject(
                        MessageType.TIC_TAC_TOE_SEND_PLAYER_STATS,
                        new PlayerStatsDataObject(
                                ((TicTacToeModel) this.model).getPlayers()[1].getName(),
                                this.statsSecondPlayer
                        )
                )
        );
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
