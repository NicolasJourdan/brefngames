package Parameter.Model;

import Launcher.Controller.LauncherController;
import Parameter.Factory.ColorFactory;
import Parameter.Parameters.ColorParameter;
import Parameter.Parameters.Configurable;
import Structure.AbstractModel;

import java.util.Map;

public class ParametersThemeSoundModel extends AbstractModel {

    private Map<ParameterEnum, Configurable> configurations;

    public ParametersThemeSoundModel() {
        super();
        this.configurations = LauncherController.getConfiguration();
    }

    // Set sound in the configuration
    public void setSound(boolean isOn) {
        this.configurations.get(ParameterEnum.SOUND).setValue(isOn);
    }

    // Set first color in the configuration
    public void setFirstColor(String color) {
        ColorParameter colorParameter = new ColorParameter(ColorFactory.getColor(color), color);
        this.configurations.put(ParameterEnum.THEME_FIRST_COLOR, colorParameter);
    }

    // Set first color in the configuration
    public void setSecondColor(String color) {
        ColorParameter colorParameter = new ColorParameter(ColorFactory.getColor(color), color);
        this.configurations.put(ParameterEnum.THEME_SECOND_COLOR, colorParameter);
    }

    public Map<ParameterEnum, Configurable> getConfigurations() {
        return this.configurations;
    }

}
