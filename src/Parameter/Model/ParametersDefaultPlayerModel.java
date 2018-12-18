package Parameter.Model;

import Launcher.Controller.LauncherController;
import Parameter.Factory.ColorFactory;
import Parameter.Factory.IconFactory;
import Parameter.Parameters.ColorParameter;
import Parameter.Parameters.Configurable;
import Parameter.Parameters.IconParameter;
import Structure.AbstractModel;

import java.util.Map;

public class ParametersDefaultPlayerModel extends AbstractModel {

    private Map<ParameterEnum, Configurable> configurations;
    private String invalidDataObjectText;

    public ParametersDefaultPlayerModel() {
        super();
        this.configurations = LauncherController.getConfiguration();
        this.invalidDataObjectText = "";
    }

    public void setPlayerColor(ParameterEnum player, String color) {
        ColorParameter colorParameter = new ColorParameter(ColorFactory.getColor(color), color);
        this.configurations.put(player, colorParameter);
    }

    public void setPlayerIcon(ParameterEnum player, String iconName) {
        IconParameter iconParameter = new IconParameter(IconFactory.getIcon(iconName), iconName);
        this.configurations.put(player, iconParameter);
    }

    public Map<ParameterEnum, Configurable> getConfigurations() {
        return this.configurations;
    }

    /**
     * Check if the parameter data is valid
     *
     * @return boolean
     */
    public boolean validateParametersData() {
        if (this.configurations.get(ParameterEnum.PLAYER_1_COLOR).getValue().equals(this.configurations.get(ParameterEnum.PLAYER_2_COLOR).getValue())) {
            this.invalidDataObjectText = "Both default players can't have the same color";
            return false;
        }

        return true;
    }

    public String getInvalidDataObjectText() {
        return this.invalidDataObjectText;
    }
}
