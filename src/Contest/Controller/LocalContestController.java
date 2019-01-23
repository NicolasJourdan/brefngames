package Contest.Controller;

import Contest.Model.AbstractContest;
import ContestSettings.ContestSettingsScene;
import Game.GameSceneFactory;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

public class LocalContestController extends AbstractSceneManagerController {

    public LocalContestController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(model, view, new GameSceneFactory(((AbstractContest) model).getPlayersList(), false));

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
                ((AbstractContest) this.model).savePlayers(((AbstractContest) this.model).getPlayersList());

                // update gameSceneFactory values
                ((GameSceneFactory) this.sceneFactory).updatePlayersList(((AbstractContest) this.model).getPlayersList());
                ((GameSceneFactory) this.sceneFactory).updateHistory(((AbstractContest) this.model).getHistory());

                return ((AbstractContest) this.model).getNextGameScene();
            /**
             * Game finished
             */
            case FIRST_PLAYER_WON:
            case SECOND_PLAYER_WON:
            case DRAW:
                ((AbstractContest) this.model).setWinner(actionEnum);
                ((GameSceneFactory) this.sceneFactory).updateHistory(((AbstractContest) this.model).getHistory());

            case END_MAP:
                SceneEnum nextScene = ((AbstractContest) this.model).getNextGameScene();
                if (SceneEnum.CONTEST_FINISHED == nextScene) {
                    this.setChanged();
                    this.notifyObservers(actionEnum.END_CONTEST);
                    return SceneEnum.END_SCENE;
                }

                return nextScene;

            /**
             * Back button
             */
            case END_CONTEST:
                this.setChanged();
                this.notifyObservers(actionEnum.END_CONTEST);
                return SceneEnum.END_SCENE;

            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }
}
