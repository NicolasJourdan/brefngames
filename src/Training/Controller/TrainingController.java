package Training.Controller;

import Game.GameSceneFactory;
import Parameter.Factory.IconFactory;
import Player.*;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

import javax.swing.*;
import java.awt.*;

public class TrainingController extends AbstractSceneManagerController {

    private static final String DEFAULT_PLAYER_1_NAME = "Player1";
    private static final String DEFAULT_PLAYER_2_NAME = "Player2";
    private static final Color DEFAULT_PLAYER_1_COLOR = Color.BLUE;
    private static final Color DEFAULT_PLAYER_2_COLOR = Color.RED;
    private static final ImageIcon DEFAULT_PLAYER_1_ICON = IconFactory.getIcon("SUPERMAN");
    private static final ImageIcon DEFAULT_PLAYER_2_ICON = IconFactory.getIcon("BATMAN");

    public TrainingController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(
            model,
            view,
            new GameSceneFactory(
                new Player[]{
                    new LocalPlayer(DEFAULT_PLAYER_1_NAME, DEFAULT_PLAYER_1_COLOR, DEFAULT_PLAYER_1_ICON),
                    new LocalPlayer(DEFAULT_PLAYER_2_NAME, DEFAULT_PLAYER_2_COLOR, DEFAULT_PLAYER_2_ICON)
                }
            )
        );
        this.switchScene(SceneEnum.TRAINING_MENU);
    }

    @Override
    protected SceneEnum getNextScene(ActionEnum actionEnum) {
        switch (actionEnum) {

            case PLAYER_1_WON:
            case PLAYER_2_WON:
            case DRAW:
                // TODO: Need to replace by map
                return SceneEnum.TRAINING_MENU;
            case END_TRAINING:
                // Call the parent (TrainingScene), this parent will call its own parent (LauncherController)
                // to change the current scene and destroy this scene manager controller
                this.setChanged();
                this.notifyObservers(actionEnum);
                return SceneEnum.END_SCENE;
            case TIC_TAC_TOE:
                return SceneEnum.TIC_TAC_TOE;
            case RUNNER:
                return SceneEnum.RUNNER;
            case CONNECT_FOUR:
                return SceneEnum.CONNECT_FOUR;
            case COOKIE_CLICKER:
                return SceneEnum.COOKIE_CLICKER;
            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }
}
