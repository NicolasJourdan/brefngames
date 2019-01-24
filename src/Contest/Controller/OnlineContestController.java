package Contest.Controller;

import Contest.Interface.SocketObserverController;
import Contest.Model.AbstractContest;
import Contest.Model.OnlineContest;
import ContestSettings.ContestSettingsScene;
import Game.GameSceneFactory;
import Game.OnlineGameSceneFactory;
import Map.Model.History;
import Online.Client.ClientScene;
import Online.Server.ServerScene;
import Online.Socket.Message.MessageDataObject;
import Online.Socket.Message.MessageType;
import Online.Socket.SocketCommunicatorService;
import Player.Player;
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
                ((OnlineContest) this.model).savePlayers(((OnlineContest) this.model).getPlayersList());
                this.socketCommunicatorService.emit(new MessageDataObject(MessageType.SETTINGS_SAVE_PLAYER, ((OnlineContest) this.model).getPlayersList()));

                // update gameSceneFactory values
                ((OnlineGameSceneFactory) this.sceneFactory).updatePlayersList(((AbstractContest) this.model).getPlayersList());
                ((OnlineGameSceneFactory) this.sceneFactory).updateHistory(((AbstractContest) this.model).getHistory());
                this.socketCommunicatorService.emit(new MessageDataObject(
                        MessageType.SETTINGS_PLAYERS_LIST,
                        ((AbstractContest) this.model).getPlayersList()
                ));
                this.socketCommunicatorService.emit(new MessageDataObject(
                        MessageType.SETTINGS_HISTORY,
                        ((AbstractContest) this.model).getHistory()
                ));

                return this.loadNextScene();
            /**
             * Quit
             */
            case END_ONLINE_CONTEST:
                System.out.println("quit !");
                this.setChanged();
                this.notifyObservers(actionEnum);
                return SceneEnum.END_SCENE;

            /**
             * Game finished
             */
            case FIRST_PLAYER_WON:
            case SECOND_PLAYER_WON:
            case DRAW:
                if (this.isServer) {
                    ((AbstractContest) this.model).setWinner(actionEnum);

                    ((GameSceneFactory) this.sceneFactory).updateHistory(((AbstractContest) this.model).getHistory());

                    this.socketCommunicatorService.emit(new MessageDataObject(
                            MessageType.CONTEST_UPDATE_HISTORY,
                            ((AbstractContest) this.model).getHistory()
                    ));
                }

            /**
             * Map
             */
            case END_MAP:
                return this.loadNextScene();

            /**
             * Start new contest
             */
            case ONLINE_ENDING_START_NEW_CONTEST:
                this.socketCommunicatorService.emit(new MessageDataObject(
                        MessageType.CONTEST_NEXT_SCENE,
                        SceneEnum.CONTEST_MENU
                ));

                return SceneEnum.CONTEST_MENU;
            case ONLINE_CONTEST_MENU:
                return SceneEnum.ONLINE_CONTEST_MENU;

            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }

    private SceneEnum loadNextScene() {
        SceneEnum nextGameScene = ((AbstractContest) this.model).getNextGameScene();

        // communicate the next scene to the client before returning it
        this.socketCommunicatorService.emit(new MessageDataObject(
                MessageType.CONTEST_NEXT_SCENE,
                nextGameScene
        ));

        return nextGameScene;
    }

    private void setupContestConnection(boolean isServer, Socket socket) {
        this.isServer = isServer;
        ((OnlineContest) this.model).setServer(this.isServer);
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
                case CONTEST_UPDATE_HISTORY:
                    // new history received from the server, it will be used when the map is displayed
                    ((OnlineGameSceneFactory) OnlineContestController.this.sceneFactory).updateHistory(
                            (History) messageDataObject.getData()
                    );
                    break;
                case SETTINGS_PLAYERS_LIST:
                    ((OnlineGameSceneFactory) OnlineContestController.this.sceneFactory).updatePlayersList(
                            (Player[]) messageDataObject.getData()
                    );
                    break;
                case SETTINGS_HISTORY:
                    ((OnlineGameSceneFactory) OnlineContestController.this.sceneFactory).updateHistory(
                            (History) messageDataObject.getData()
                    );
                    break;
                case SETTINGS_SAVE_PLAYER:
                    ((OnlineContest) OnlineContestController.this.model).savePlayers((Player[]) messageDataObject.getData());
                    break;
            }
        }
    }

    /**
     * When changing the current scene, the old scene should stop observing the socket message receiver thread
     *
     * @param sceneEnum
     */
    @Override
    protected void switchScene(SceneEnum sceneEnum) {
        if (null != this.currentScene) {
            Object currentController = this.currentScene.getController();
            if (currentController instanceof SocketObserverController) {
                ((SocketObserverController) currentController).stopObserver();
            }
        }

        super.switchScene(sceneEnum);
    }
}
