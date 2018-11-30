package ContestSettings.Model;

import ContestSettings.DataObject.ContestSettingsDataObject;
import Parameter.Model.ParameterEnum;
import Parameter.Model.Parameters;
import Parameter.Parameters.Configurable;
import Structure.AbstractModel;

import java.util.Map;

public class ContestSettingsModel extends AbstractModel {

    private Map<ParameterEnum, Configurable> defaultConfiguration;
    private String invalidDataObjectText;

    public ContestSettingsModel() {
        this.defaultConfiguration = Parameters.getConfiguration();
        this.invalidDataObjectText = "";
    }

    public Map<ParameterEnum, Configurable> getDefaultConfiguration() {
        return defaultConfiguration;
    }

    /**
     * Check if the settingsDataObject is valid
     *
     * @param settingsDataObject
     * @return boolean
     */
    public boolean validateSettingsDataObject(ContestSettingsDataObject settingsDataObject) {
        if (settingsDataObject.getFirstPlayerColor() == settingsDataObject.getSecondPlayerColor()) {
            this.invalidDataObjectText = "Both players can't choose the same color";
            return false;
        }

        return true;
    }

    /**
     * @return Invalid settings DTO text
     */
    public String getInvalidDataObjectText() {
        return invalidDataObjectText;
    }
}
