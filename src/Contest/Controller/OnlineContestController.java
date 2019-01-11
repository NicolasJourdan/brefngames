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
    protected SceneEnum getNextScene(ActionEnum arg) {
        return null;
    }
}
