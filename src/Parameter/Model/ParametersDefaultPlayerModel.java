package Parameter.Model;

import Launcher.Controller.LauncherController;
import Parameter.Parameters.ColorParameter;
import Parameter.Parameters.Configurable;
import Parameter.Parameters.IconParameter;
import Structure.AbstractModel;

import java.util.Map;

public class ParametersDefaultPlayerModel extends AbstractModel {

    private Map<ParameterEnum, Configurable> configurations;

    public ParametersDefaultPlayerModel() {
        super();
        this.configurations = LauncherController.getConfiguration();
    }

    public void setColorFirstPlayer(String color) {
        ColorParameter colorParameter = new ColorParameter(ColorParameter.getColorFromString(color), color);
        this.configurations.replace(ParameterEnum.PLAYER_1_COLOR, colorParameter);
    }

    public void setColorSecondPlayer(String color) {
        ColorParameter colorParameter = new ColorParameter(ColorParameter.getColorFromString(color), color);
        this.configurations.replace(ParameterEnum.PLAYER_2_COLOR, colorParameter);
    }

    public void setIconFirstPlayer(String iconName) {
        IconParameter iconParameter = new IconParameter(IconParameter.getImageFromString(iconName), iconName);
        this.configurations.replace(ParameterEnum.PLAYER_1_ICON, iconParameter);
    }

    public void setIconSecondPlayer(String iconName) {
        IconParameter iconParameter = new IconParameter(IconParameter.getImageFromString(iconName), iconName);
        this.configurations.replace(ParameterEnum.PLAYER_2_ICON, iconParameter);
    }

    public Map<ParameterEnum, Configurable> getConfigurations() {
        return this.configurations;
    }
}
