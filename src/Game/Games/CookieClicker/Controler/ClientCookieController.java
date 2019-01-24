package Game.Games.CookieClicker.Controler;

import Contest.Interface.SocketObserverController;
import Contest.Model.ContestDataPersistor;
import Game.Games.CookieClicker.CookieClickerStatsEnum;
import Game.Games.CookieClicker.Model.CookieModel;
import Game.Games.CookieClicker.View.CookieView;
import Game.Games.DataObject.PlayerStatsDataObject;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Scene.Model.ActionEnum;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class ClientCookieController extends CookieController implements SocketObserverController {

    private final SocketCommunicatorService socketCommunicatorService;
    private final SocketReceptionObserver socketReceptionObserver;

    public ClientCookieController(CookieModel model, CookieView view, boolean isTraining, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, isTraining);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketReceptionObserver = new SocketReceptionObserver();
        this.socketCommunicatorService.addReceptionObserver(this.socketReceptionObserver);
    }

    @Override
    public void update(Observable o, Object arg) {
        ActionEnum actionEnum = (ActionEnum) arg;
        if (!this.validatePressedKey(actionEnum)) {
            return;
        }

        this.socketCommunicatorService.emit(new MessageDataObject(MessageType.COOKIE_ACTION, (ActionEnum) arg));
    }

    private boolean validatePressedKey(ActionEnum actionEnum) {
        return
                ActionEnum.COOKIE_PRESS_SECOND_PLAYER_KEY == actionEnum
                || ActionEnum.COOKIE_RELEASE_SECOND_PLAYER_KEY == actionEnum
                || ActionEnum.CHECK == actionEnum
        ;
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
                case COOKIE_CLICKER_SEND_GLOBAL_STATS:
                    ContestDataPersistor.updateCookieClicker((Map<CookieClickerStatsEnum, String>) messageDataObject.getData());
                    break;
                case COOKIE_CLICKER_SEND_PLAYER_STATS:
                    PlayerStatsDataObject playerStatsDataObject = (PlayerStatsDataObject) messageDataObject.getData();
                    ContestDataPersistor.updateDataPlayer(playerStatsDataObject.getPlayerId(), playerStatsDataObject.getStats());
                    break;
                case COOKIE_PRESS_FIRST_PLAYER_KEY:
                    ((CookieView) ClientCookieController.this.view).updatePlayerKey(true, true);
                    break;
                case COOKIE_RELEASE_FIRST_PLAYER_KEY:
                    ((CookieView) ClientCookieController.this.view).updatePlayerKey(true, false);
                    break;
                case COOKIE_PRESS_SECOND_PLAYER_KEY:
                    ((CookieView) ClientCookieController.this.view).updatePlayerKey(false, true);
                    break;
                case COOKIE_RELEASE_SECOND_PLAYER_KEY:
                    ((CookieView) ClientCookieController.this.view).updatePlayerKey(false, false);
                    break;
                case COOKIE_CLICKER_SEND_GOAL:
                    ((CookieView) ClientCookieController.this.view).setGoalScreen((int) ((MessageDataObject) arg).getData());
                    break;
            }
        }
    }

}
