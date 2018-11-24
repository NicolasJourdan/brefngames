package Parameter.Controller;

import Parameter.Model.ParameterEnum;
import Parameter.Model.Parameters;
import Parameter.Model.ParametersDefaultPlayerModel;
import Parameter.Parameters.ColorParameter;
import Parameter.Parameters.Configurable;
import Parameter.Parameters.IconParameter;
import Parameter.View.ParametersDefaultPlayerView;
import Scene.Controller.AbstractSceneController;
import Scene.Model.ActionEnum;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.Map;
import java.util.Observable;

public class ParametersDefaultPlayerController extends AbstractSceneController {

    public ParametersDefaultPlayerController(AbstractModel model, AbstractView view) {
        super(model, view);
        Map<ParameterEnum, Configurable> conf = ((ParametersDefaultPlayerModel) this.model).getConfigurations();

        String colorFirstPlayer = ((ColorParameter) conf.get(ParameterEnum.PLAYER_1_COLOR)).getStringColor();
        ((ParametersDefaultPlayerView) this.view).initColorFirstPlayer(ActionEnum.valueOf(colorFirstPlayer));

        String colorSecondPlayer = ((ColorParameter) conf.get(ParameterEnum.PLAYER_2_COLOR)).getStringColor();
        ((ParametersDefaultPlayerView) this.view).initColorSecondPlayer(ActionEnum.valueOf(colorSecondPlayer));

        String iconNameFirstPlayer = ((IconParameter) conf.get(ParameterEnum.PLAYER_1_ICON)).getName();
        ((ParametersDefaultPlayerView) this.view).initIconFirstPlayer(ActionEnum.valueOf(iconNameFirstPlayer));

        String iconNameSecondPlayer = ((IconParameter) conf.get(ParameterEnum.PLAYER_2_ICON)).getName();
        ((ParametersDefaultPlayerView) this.view).initIconSecondPlayer(ActionEnum.valueOf(iconNameSecondPlayer));
    }

    @Override
    public void update(Observable o, Object arg) {
        switch ((ActionEnum) arg) {
            // Color first player
            case COLOR_FIRST_PLAYER_RED:
                ((ParametersDefaultPlayerModel) this.model).setPlayerColor(ParameterEnum.PLAYER_1_COLOR, ActionEnum.COLOR_FIRST_PLAYER_RED.toString());
                break;
            case COLOR_FIRST_PLAYER_BLUE:
                ((ParametersDefaultPlayerModel) this.model).setPlayerColor(ParameterEnum.PLAYER_1_COLOR, ActionEnum.COLOR_FIRST_PLAYER_BLUE.toString());
                break;
            case COLOR_FIRST_PLAYER_GREEN:
                ((ParametersDefaultPlayerModel) this.model).setPlayerColor(ParameterEnum.PLAYER_1_COLOR, ActionEnum.COLOR_FIRST_PLAYER_GREEN.toString());
                break;
            case COLOR_FIRST_PLAYER_YELLOW:
                ((ParametersDefaultPlayerModel) this.model).setPlayerColor(ParameterEnum.PLAYER_1_COLOR, ActionEnum.COLOR_FIRST_PLAYER_YELLOW.toString());
                break;

            // Color second player
            case COLOR_SECOND_PLAYER_RED:
                ((ParametersDefaultPlayerModel) this.model).setPlayerColor(ParameterEnum.PLAYER_2_COLOR, ActionEnum.COLOR_SECOND_PLAYER_RED.toString());
                break;
            case COLOR_SECOND_PLAYER_BLUE:
                ((ParametersDefaultPlayerModel) this.model).setPlayerColor(ParameterEnum.PLAYER_2_COLOR, ActionEnum.COLOR_SECOND_PLAYER_BLUE.toString());
                break;
            case COLOR_SECOND_PLAYER_GREEN:
                ((ParametersDefaultPlayerModel) this.model).setPlayerColor(ParameterEnum.PLAYER_2_COLOR, ActionEnum.COLOR_SECOND_PLAYER_GREEN.toString());
                break;
            case COLOR_SECOND_PLAYER_YELLOW:
                ((ParametersDefaultPlayerModel) this.model).setPlayerColor(ParameterEnum.PLAYER_2_COLOR, ActionEnum.COLOR_SECOND_PLAYER_YELLOW.toString());
                break;

            // Icon first player
            case SUPERMAN_1:
                ((ParametersDefaultPlayerModel) this.model).setPlayerIcon(ParameterEnum.PLAYER_1_ICON, ActionEnum.SUPERMAN_1.toString());
                break;
            case BATMAN_1:
                ((ParametersDefaultPlayerModel) this.model).setPlayerIcon(ParameterEnum.PLAYER_1_ICON, ActionEnum.BATMAN_1.toString());
                break;
            case FLASH_1:
                ((ParametersDefaultPlayerModel) this.model).setPlayerIcon(ParameterEnum.PLAYER_1_ICON, ActionEnum.FLASH_1.toString());
                break;
            case AQUAMAN_1:
                ((ParametersDefaultPlayerModel) this.model).setPlayerIcon(ParameterEnum.PLAYER_1_ICON, ActionEnum.AQUAMAN_1.toString());
                break;

            // Icon first player
            case SUPERMAN_2:
                ((ParametersDefaultPlayerModel) this.model).setPlayerIcon(ParameterEnum.PLAYER_2_ICON, ActionEnum.SUPERMAN_2.toString());
                break;
            case BATMAN_2:
                ((ParametersDefaultPlayerModel) this.model).setPlayerIcon(ParameterEnum.PLAYER_2_ICON, ActionEnum.BATMAN_2.toString());
                break;
            case FLASH_2:
                ((ParametersDefaultPlayerModel) this.model).setPlayerIcon(ParameterEnum.PLAYER_2_ICON, ActionEnum.FLASH_2.toString());
                break;
            case AQUAMAN_2:
                ((ParametersDefaultPlayerModel) this.model).setPlayerIcon(ParameterEnum.PLAYER_2_ICON, ActionEnum.AQUAMAN_2.toString());
                break;
            case PARAMETERS_MENU:
                Parameters.save(((ParametersDefaultPlayerModel) this.model).getConfigurations());
                this.setChanged();
                this.notifyObservers(arg);
                break;
            default:
                throw new RuntimeException("The action : " + arg + " is not acceptable here");
        }
    }
}
