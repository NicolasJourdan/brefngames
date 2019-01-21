package Contest.Controller;

import Contest.Model.AbstractContest;
import Game.GameSceneFactory;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

public class OnlineContestController extends AbstractSceneManagerController {

    /**
     * @param model
     * @param view
     */
    public OnlineContestController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(model, view, new GameSceneFactory(((AbstractContest) model).getPlayersList(), false));

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
}
