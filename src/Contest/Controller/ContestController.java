package Contest.Controller;

import Contest.Model.AbstractContest;
import Game.GameSceneFactory;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

public class ContestController extends AbstractSceneManagerController {

    public ContestController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(model, view, new GameSceneFactory(((AbstractContest) model).getPlayerList()));

        this.switchScene(SceneEnum.CONTEST_MENU);
    }

    @Override
    protected SceneEnum getNextScene(ActionEnum actionEnum) {
        switch (actionEnum) {
            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }
}
