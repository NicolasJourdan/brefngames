package Contest.Controller;

import Contest.Model.AbstractContest;
import ContestSettings.ContestSettingsScene;
import ContestSettings.DataObject.ContestSettingsDataObject;
import Game.GameSceneFactory;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

public class ContestController extends AbstractSceneManagerController {

    private ContestSettingsDataObject contestSettingsDataObject;

    public ContestController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(model, view, new GameSceneFactory(((AbstractContest) model).getPlayerList(), false));

        this.switchScene(SceneEnum.CONTEST_MENU);
    }

    @Override
    protected SceneEnum getNextScene(ActionEnum actionEnum) {
        switch (actionEnum) {
            case START_CONTEST:
                ((AbstractContest) this.model).setSettingsDataObject(
                    ((ContestSettingsScene) this.currentScene).getSettingsDataObject()
                );
                // TODO: switch scene here
                throw new RuntimeException("Unable to switch scene: contest logic not implemented yet");
            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }
}
