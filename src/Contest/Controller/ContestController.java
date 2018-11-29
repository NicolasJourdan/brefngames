package Contest.Controller;

import Contest.Model.AbstractContest;
import ContestSettings.ContestSettingsScene;
import Game.GameSceneFactory;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

public class ContestController extends AbstractSceneManagerController {

    public ContestController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(model, view, new GameSceneFactory(((AbstractContest) model).getPlayerList(), false));

        this.switchScene(SceneEnum.CONTEST_MENU);
    }

    @Override
    protected SceneEnum getNextScene(ActionEnum actionEnum) {
        switch (actionEnum) {
            /**
             * Start of the contest
             */
            case START_CONTEST:
                ((AbstractContest) this.model).setUpContest(
                    ((ContestSettingsScene) this.currentScene).getSettingsDataObject()
                );

                // update gameSceneFactory values
                ((GameSceneFactory) this.sceneFactory).updateListPlayers(((AbstractContest) this.model).getPlayerList());
                ((GameSceneFactory) this.sceneFactory).updateHistory(((AbstractContest) this.model).getHistory());

                return ((AbstractContest) this.model).getNextGameScene();
            /**
             * Game finished
             */
            case PLAYER_1_WON:
            case PLAYER_2_WON:
            case DRAW:
                ((AbstractContest) this.model).setWinner(actionEnum);
                ((GameSceneFactory) this.sceneFactory).updateHistory(((AbstractContest) this.model).getHistory());

            case END_MAP:
                SceneEnum nextScene = ((AbstractContest) this.model).getNextGameScene();
                if (SceneEnum.CONTEST_FINISHED == nextScene) {
                    // Call the parent (ParametersScene), this parent will call its own parent (LauncherController)
                    // to change the current scene and destroy this scene manager controller
                    this.setChanged();
                    this.notifyObservers(actionEnum.END_CONTEST);
                    return SceneEnum.END_SCENE;
                }

                return nextScene;

            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }
}
