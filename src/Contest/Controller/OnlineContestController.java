package Contest.Controller;

import Contest.Model.AbstractContest;
import Game.GameSceneFactory;
import Game.OnlineGameSceneFactory;
import Online.Client.ClientScene;
import Online.Server.ServerScene;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

import java.net.Socket;

public class OnlineContestController extends AbstractSceneManagerController {

    private boolean isServer;
    private Socket socket;

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
                this.isServer = true;
                this.socket = ((ServerScene) this.currentScene).getSocket();
                this.updateFactory();
                return SceneEnum.CONTEST_MENU;

            /**
             * Connected to server
             */
            case CONNECTED_TO_SERVER:
                this.isServer = false;
                this.socket = ((ClientScene) this.currentScene).getSocket();
                this.updateFactory();
                return SceneEnum.CONTEST_MENU;

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

    private void updateFactory() {
        ((OnlineGameSceneFactory) this.sceneFactory).setIsServer(this.isServer);
        ((OnlineGameSceneFactory) this.sceneFactory).setSocket(this.socket);
    }
}
