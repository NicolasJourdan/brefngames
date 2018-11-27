package ContestSettings.Model;

import Parameter.Model.ParameterEnum;
import Parameter.Model.Parameters;
import Parameter.Parameters.Configurable;
import Structure.AbstractModel;

import java.util.Map;

public class ContestSettingsModel extends AbstractModel {

    private Map<ParameterEnum, Configurable> defaultConfiguration;

    public ContestSettingsModel() {
        this.defaultConfiguration = Parameters.getConfiguration();
    }

    public Map<ParameterEnum, Configurable> getDefaultConfiguration() {
        return defaultConfiguration;
    }
}
