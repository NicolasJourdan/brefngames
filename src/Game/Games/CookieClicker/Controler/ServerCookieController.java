package Game.Games.CookieClicker.Controler;

import Game.Games.CookieClicker.Model.CookieModel;
import Game.Games.CookieClicker.View.CookieView;
import Game.Games.DataObject.PlayerStatsDataObject;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Scene.Model.ActionEnum;

import java.util.Observable;
import java.util.Observer;

public class ServerCookieController extends CookieController {

    private final SocketCommunicatorService socketCommunicatorService;

    public ServerCookieController(CookieModel model, CookieView view, boolean isTraining, SocketCommunicatorService socketCommunicatorService) {
        super(model, view, isTraining);

        this.socketCommunicatorService = socketCommunicatorService;
        this.socketCommunicatorService.addReceptionObserver(new SocketReceptionObserver());

        this.socketCommunicatorService.emit(new MessageDataObject(MessageType.COOKIE_CLICKER_SEND_GOAL, ((CookieModel) this.model).getGoal()));
    }

    public void play(ActionEnum actionEnum) {
        switch (actionEnum) {
            case ADD_COOKIE_FIRST_PLAYER:
                ((CookieModel) this.model).addPointFirstPlayer();
                break;
            case ADD_COOKIE_SECOND_PLAYER:
                ((CookieModel) this.model).addPointSecondPlayer();
                break;
            case COOKIE_PRESS_FIRST_PLAYER_KEY:
                ((CookieView) this.view).pressFirstPlayerKey();
                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.COOKIE_PRESS_FIRST_PLAYER_KEY));
                break;
            case COOKIE_RELEASE_FIRST_PLAYER_KEY:
                ((CookieView) this.view).releaseFirstPlayerKey();
                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.COOKIE_RELEASE_FIRST_PLAYER_KEY));
                break;
            case COOKIE_PRESS_SECOND_PLAYER_KEY:
                ((CookieView) this.view).pressSecondPlayerKey();
                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.COOKIE_PRESS_SECOND_PLAYER_KEY));
                break;
            case COOKIE_RELEASE_SECOND_PLAYER_KEY:
                ((CookieView) this.view).releaseSecondPlayerKey();
                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.COOKIE_RELEASE_SECOND_PLAYER_KEY));
                break;
            case CHECK:
                ((CookieModel) this.model).check();
                if (!this.isTraining) {
                    ((CookieModel) this.model).updateGlobalStats();
                    ((CookieModel) this.model).updatePlayerStats();
                    ((CookieModel) this.model).sendGlobalStats();
                    ((CookieModel) this.model).sendFirstPlayerStats();
                    this.socketCommunicatorService.emit(
                            new MessageDataObject(
                                    MessageType.COOKIE_CLICKER_SEND_GLOBAL_STATS,
                                    ((CookieModel) this.model).getStatsMap()
                            )
                    );
                    this.socketCommunicatorService.emit(
                            new MessageDataObject(
                                    MessageType.COOKIE_CLICKER_SEND_PLAYER_STATS,
                                    new PlayerStatsDataObject(
                                            ((CookieModel) this.model).getPlayers()[1].getName(),
                                            ((CookieModel) this.model).getSecondPlayerStats()
                                    )
                            )
                    );
                }
                //Notify the winner
                this.setChanged();
                this.notifyObservers(((CookieModel) this.model).getWinner());
                break;
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        ActionEnum actionEnum = (ActionEnum) arg;
        if (!this.validatePressedKey(actionEnum)) {
            return;
        }

        this.play((ActionEnum) arg);
    }

    private boolean validatePressedKey(ActionEnum actionEnum) {
        return
                ActionEnum.COOKIE_PRESS_FIRST_PLAYER_KEY == actionEnum
                ||ActionEnum.COOKIE_RELEASE_FIRST_PLAYER_KEY == actionEnum
                || ActionEnum.CHECK == actionEnum
                || ActionEnum.ADD_COOKIE_FIRST_PLAYER == actionEnum
                || ActionEnum.ADD_COOKIE_SECOND_PLAYER == actionEnum
        ;
    }

    private class SocketReceptionObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            MessageDataObject messageDataObject = (MessageDataObject) arg;
            ServerCookieController.this.play((ActionEnum) messageDataObject.getData());
        }
    }
}
