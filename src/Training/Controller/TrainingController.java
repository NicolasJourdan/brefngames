package Training.Controller;

import Game.GameSceneFactory;
import Map.Model.GameHistory;
import Map.Model.History;
import Parameter.Factory.IconFactory;
import Player.*;
import Scene.Controller.AbstractSceneManagerController;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.ActionEnum;
import Scene.Model.SceneEnum;
import Scene.View.AbstractSceneManagerView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TrainingController extends AbstractSceneManagerController {

    private static final String DEFAULT_PLAYER_1_NAME = "Player1";
    private static final String DEFAULT_PLAYER_2_NAME = "Player2";
    private static final Color DEFAULT_PLAYER_1_COLOR = Color.BLUE;
    private static final Color DEFAULT_PLAYER_2_COLOR = Color.RED;
    private static final ImageIcon DEFAULT_PLAYER_1_ICON = IconFactory.getIcon("SUPERMAN");
    private static final ImageIcon DEFAULT_PLAYER_2_ICON = IconFactory.getIcon("BATMAN");

    private History history;
    private static final Player[] DEFAULT_PLAYERS = {
            new LocalPlayer(DEFAULT_PLAYER_1_NAME, DEFAULT_PLAYER_1_COLOR, DEFAULT_PLAYER_1_ICON, null),
            new LocalPlayer(DEFAULT_PLAYER_2_NAME, DEFAULT_PLAYER_2_COLOR, DEFAULT_PLAYER_2_ICON, null)
    };
    private static final GameSceneFactory DEFAULT_GAME_FACTORY = new GameSceneFactory(DEFAULT_PLAYERS, true);

    public TrainingController(AbstractSceneManagerModel model, AbstractSceneManagerView view) {
        super(model, view, DEFAULT_GAME_FACTORY );
        this.history = null;
        this.switchScene(SceneEnum.TRAINING_MENU);
    }

    @Override
    protected SceneEnum getNextScene(ActionEnum actionEnum) {
        switch (actionEnum) {
            case PLAYER_1_WON:
                this.updateWinnerInHistory(DEFAULT_PLAYERS[0]);
                return SceneEnum.MAP;
            case PLAYER_2_WON:
                this.updateWinnerInHistory(DEFAULT_PLAYERS[1]);
                return SceneEnum.MAP;
            case DRAW:
                this.updateWinnerInHistory(null);
                return SceneEnum.MAP;
            case END_MAP:
                // Reset history
                this.history = null;
                DEFAULT_GAME_FACTORY.updateHistory(this.history);
                return SceneEnum.TRAINING_MENU;
            case END_TRAINING:
                // Call the parent (TrainingScene), this parent will call its own parent (LauncherController)
                // to change the current scene and destroy this scene manager controller
                this.setChanged();
                this.notifyObservers(actionEnum);
                return SceneEnum.END_SCENE;
            case TIC_TAC_TOE:
                this.setHistoryToGameFactory(SceneEnum.TIC_TAC_TOE);
                return SceneEnum.TIC_TAC_TOE;
            case RUNNER:
                this.setHistoryToGameFactory(SceneEnum.RUNNER);
                return SceneEnum.RUNNER;
            case CONNECT_FOUR:
                this.setHistoryToGameFactory(SceneEnum.CONNECT_FOUR);
                return SceneEnum.CONNECT_FOUR;
            case COOKIE_CLICKER:
                this.setHistoryToGameFactory(SceneEnum.COOKIE_CLICKER);
                return SceneEnum.COOKIE_CLICKER;
            default:
                throw new RuntimeException("Unable to find : " + actionEnum);
        }
    }

    private void setHistoryToGameFactory(SceneEnum sceneEnum) {
        List<GameHistory> gameHistories = new ArrayList<>();
        gameHistories.add(new GameHistory(sceneEnum, DEFAULT_PLAYERS, ActionEnum.UNDEFINED));
        this.history = new History(
                DEFAULT_PLAYERS,
                gameHistories,
                1,
                true
        );
        DEFAULT_GAME_FACTORY.updateHistory(this.history);
    }

    private void updateWinnerInHistory(Player player) {
        this.history.getGameHistories().get(0).setWinner(player);
        DEFAULT_GAME_FACTORY.updateHistory(this.history);
    }
}
