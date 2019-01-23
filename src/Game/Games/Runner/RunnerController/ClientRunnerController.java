package Game.Games.Runner.RunnerController;

import Game.Games.Runner.RunnerModel.ClientRunnerModel;
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

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ClientRunnerController extends RunnerController {

    private final SocketCommunicatorService socketCommunicatorService;

    public ClientRunnerController(AbstractGameModel model, AbstractGameView view, boolean isTraining, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, isTraining);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketCommunicatorService.addReceptionObserver(new SocketReceptionObserver());
    }

    @Override
    public void update(Observable o, Object action) {
        switch ((ActionEnum) action) {
            case KEY_PRESS_R:
                this.socketCommunicatorService.emit(new MessageDataObject(
                        MessageType.RUNNER_KEY_PRESSED,
                        ControlEnum.LEFT
                ));
                break;
            case KEY_PRESS_T:
                this.socketCommunicatorService.emit(new MessageDataObject(
                        MessageType.RUNNER_KEY_PRESSED,
                        ControlEnum.RIGHT
                ));
                break;
            case KEY_PRESS_A:
            case KEY_PRESS_Z:
                // do nothing for the other player controls
                break;
            default:
                throw new RuntimeException("Unable to find : " + action);
        }
    }

    private class SocketReceptionObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            MessageDataObject messageDataObject = (MessageDataObject) arg;

            switch (messageDataObject.getType()) {
                case RUNNER_UPDATE_FIRST_PLAYER_CONTROLS:
                    ((RunnerView) ClientRunnerController.this.view).updateFirstPlayerPosition(
                            ((RunnerControlsDataObject) messageDataObject.getData()).getStepsAmount()
                    );
                    ((RunnerView) ClientRunnerController.this.view).updateFirstPlayerNextKey(
                            ((RunnerControlsDataObject) messageDataObject.getData()).isNextKeyLeft()
                    );
                    break;

                case RUNNER_UPDATE_SECOND_PLAYER_CONTROLS:
                    ((RunnerView) ClientRunnerController.this.view).updateSecondPlayerPosition(
                            ((RunnerControlsDataObject) messageDataObject.getData()).getStepsAmount()
                    );
                    ((RunnerView) ClientRunnerController.this.view).updateSecondPlayerNextKey(
                            ((RunnerControlsDataObject) messageDataObject.getData()).isNextKeyLeft()
                    );
                    break;

                case RUNNER_SEND_GLOBAL_STATS:
                    ((ClientRunnerModel) ClientRunnerController.this.model).saveLocalStatistics(
                            (Map) messageDataObject.getData()
                    );
                    break;

                case RUNNER_SEND_PLAYER_STATS:
                    ((ClientRunnerModel) ClientRunnerController.this.model).saveLocalPlayerStatistcs(
                            (Map) messageDataObject.getData()
                    );
                    break;
            }
        }
    }
}
