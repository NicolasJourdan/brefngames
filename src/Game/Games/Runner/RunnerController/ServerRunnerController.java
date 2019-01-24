package Game.Games.Runner.RunnerController;

import Contest.Interface.SocketObserverController;
import Game.Games.Runner.RunnerModel.RunnerControlsDataObject;
import Game.Games.Runner.RunnerModel.RunnerModel;
import Game.Games.Runner.RunnerModel.ServerRunnerModel;
import Game.Games.Runner.RunnerView.RunnerView;
import Game.Model.AbstractGameModel;
import Game.View.AbstractGameView;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Scene.Model.ActionEnum;

import java.util.Observable;
import java.util.Observer;

public class ServerRunnerController extends RunnerController implements SocketObserverController {

    private final SocketCommunicatorService socketCommunicatorService;
    private final SocketReceptionObserver socketReceptionObserver;
    private boolean isGameFinished;

    public ServerRunnerController(AbstractGameModel model, AbstractGameView view, boolean isTraining, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, isTraining);

        this.isGameFinished = false;

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketReceptionObserver = new SocketReceptionObserver();
        this.socketCommunicatorService.addReceptionObserver(this.socketReceptionObserver);
    }

    @Override
    public void update(Observable o, Object action) {
        switch ((ActionEnum) action) {
            case KEY_PRESS_A:
                this.keyPressedAction(ControlEnum.LEFT, PlayerEnum.FIRST_PLAYER);
                break;
            case KEY_PRESS_Z:
                this.keyPressedAction(ControlEnum.RIGHT, PlayerEnum.FIRST_PLAYER);
                break;
            case KEY_PRESS_R:
            case KEY_PRESS_T:
                // do nothing for the other player controls
                break;
            default:
                throw new RuntimeException("Unable to find : " + action);
        }
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
                case RUNNER_KEY_PRESSED:
                    // key received from the client
                    ServerRunnerController.this.keyPressedAction((ControlEnum) messageDataObject.getData(), PlayerEnum.SECOND_PLAYER);
                    break;
            }
        }
    }

    private void keyPressedAction(ControlEnum controlEnum, PlayerEnum playerEnum) {
        // update model
        ((RunnerModel) this.model).keyPressed(
                controlEnum,
                playerEnum
        );

        // Update view
        int position = ((RunnerModel) this.model).getRemainingSteps(playerEnum);
        boolean isNextKeyLeft = ((RunnerModel) this.model).isNextKeyLeft(playerEnum);

        if (playerEnum.equals(PlayerEnum.FIRST_PLAYER)) {
            ((RunnerView) this.view).updateFirstPlayerPosition(position);
            ((RunnerView) this.view).updateFirstPlayerNextKey(isNextKeyLeft);

            this.socketCommunicatorService.emit(new MessageDataObject(
                    MessageType.RUNNER_UPDATE_FIRST_PLAYER_CONTROLS,
                    new RunnerControlsDataObject(isNextKeyLeft, position)
            ));
        } else {
            ((RunnerView) this.view).updateSecondPlayerPosition(position);
            ((RunnerView) this.view).updateSecondPlayerNextKey(isNextKeyLeft);

            this.socketCommunicatorService.emit(new MessageDataObject(
                    MessageType.RUNNER_UPDATE_SECOND_PLAYER_CONTROLS,
                    new RunnerControlsDataObject(isNextKeyLeft, position)
            ));
        }

        // check winner
        if (((RunnerModel) this.model).isGameFinished()) {
            this.endGame();
        }
    }

    private synchronized void endGame() {
        // this function should not be run again otherwise the stats will be saved two times and a bug with
        // the file reader will occur
        if (this.isGameFinished) {
            return;
        }

        this.isGameFinished = true;

        // save stats
        if (!this.isTraining) {
            ((ServerRunnerModel) this.model).saveLocalStatistics();

            this.socketCommunicatorService.emit(new MessageDataObject(
                    MessageType.RUNNER_SEND_PLAYER_STATS,
                    ((ServerRunnerModel) this.model).getOnlinePlayerStatistics()
            ));

            this.socketCommunicatorService.emit(new MessageDataObject(
                    MessageType.RUNNER_SEND_GLOBAL_STATS,
                    ((ServerRunnerModel) this.model).getStatistics()
            ));
        }

        // change scene
        this.setChanged();
        this.notifyObservers(
                ((RunnerModel) this.model).isFirstPlayerWinner() ? ActionEnum.FIRST_PLAYER_WON : ActionEnum.SECOND_PLAYER_WON
        );
    }
}
