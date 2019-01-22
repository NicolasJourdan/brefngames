package Contest.Controller;

import Contest.Model.AbstractContest;
import ContestSettings.ContestSettingsScene;
import Game.OnlineGameSceneFactory;
import Online.Client.ClientScene;
import Online.Server.ServerScene;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

public class OnlineContestController extends AbstractSceneManagerController {

    private boolean isServer;
    private SocketCommunicatorService socketCommunicatorService;

    /**
     * @param model
     * @param view
     */
    public OnlineContestController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(model, view, new OnlineGameSceneFactory(((AbstractContest) model).getPlayersList(), false));

        this.switchScene(SceneEnum.ONLINE_CONTEST_MENU);
    }

    @Override
    protected SceneEnum getNextScene(ActionEnum actionEnum) {
        switch (actionEnum) {
            /**
             * Create server
             */
            case CREATE_SERVER:
                return SceneEnum.CREATE_SERVER_SCENE;

            /**
             * Join server
             */
            case JOIN_SERVER:
                return SceneEnum.JOIN_SERVER_SCENE;

            /**
             * Client connected
             */
            case CLIENT_CONNECTED:
                this.setupContestConnection(
                    true,
                    ((ServerScene) this.currentScene).getSocket()
                );
                return SceneEnum.CONTEST_MENU;

            /**
             * Connected to server
             */
            case CONNECTED_TO_SERVER:
                this.setupContestConnection(
                        false,
                        ((ClientScene) this.currentScene).getSocket()
                );
                return SceneEnum.CONTEST_MENU;

            /**
             * Start contest (only received by the server)
             */
            case START_CONTEST:
                ((AbstractContest) this.model).setUpContest(
                        ((ContestSettingsScene) this.currentScene).getSettingsDataObject()
                );

                // update gameSceneFactory values
                ((OnlineGameSceneFactory) this.sceneFactory).updatePlayersList(((AbstractContest) this.model).getPlayersList());
                ((OnlineGameSceneFactory) this.sceneFactory).updateHistory(((AbstractContest) this.model).getHistory());

                SceneEnum nextGameScene = ((AbstractContest) this.model).getNextGameScene();

                // communicate the next scene to the client before returning it
                this.socketCommunicatorService.emit(new MessageDataObject(
                        MessageType.CONTEST_NEXT_SCENE,
                        nextGameScene
                ));

                return nextGameScene;

            /**
             * Quit
             */
            case END_ONLINE_CONTEST:
                this.setChanged();
                this.notifyObservers(actionEnum);
                return SceneEnum.END_SCENE;

            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }

    private void setupContestConnection(boolean isServer, Socket socket) {
        this.isServer = isServer;
        this.socketCommunicatorService = new SocketCommunicatorService(socket);

        this.socketCommunicatorService.addReceptionObserver(new ReceptionObserver());

        ((OnlineGameSceneFactory) this.sceneFactory).setIsServer(this.isServer);
        ((OnlineGameSceneFactory) this.sceneFactory).setSocketCommunicatorService(this.socketCommunicatorService);
    }

    private class ReceptionObserver implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            MessageDataObject messageDataObject = (MessageDataObject) arg;

            switch (messageDataObject.getType()) {
                case CONTEST_NEXT_SCENE:
                    // next scene received from the server, update current one
                    OnlineContestController.this.switchScene((SceneEnum) messageDataObject.getData());
                    break;
            }
        }
    }
}
