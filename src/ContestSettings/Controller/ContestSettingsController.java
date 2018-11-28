package ContestSettings.Controller;

import ContestSettings.DataObject.ContestSettingsDataObject;
import ContestSettings.Model.ContestSettingsModel;
import ContestSettings.View.ContestSettingsView;
import Parameter.Model.ParameterEnum;
import Parameter.Parameters.Configurable;
import Scene.Model.ActionEnum;
import Structure.AbstractController;
import Structure.AbstractModel;
import Structure.AbstractView;

import java.util.Map;
import java.util.Observable;

public class ContestSettingsController extends AbstractController {

    private ContestSettingsDataObject settingsDataObject;

    public ContestSettingsController(AbstractModel model, AbstractView view) {
        super(model, view);

        Map<ParameterEnum, Configurable> defaultConfiguration = ((ContestSettingsModel) this.model).getDefaultConfiguration();
        ((ContestSettingsView) this.view).setDefaultConfiguration(defaultConfiguration);
    }

    public ContestSettingsDataObject getSettingsDataObject() {
        return settingsDataObject;
    }

    @Override
    public void update(Observable o, Object arg) {
        switch ((ActionEnum) arg) {
            case START_CONTEST:
                this.settingsDataObject = ((ContestSettingsView) this.view).getSettingsDataObject();

                this.setChanged();
                this.notifyObservers(ActionEnum.START_CONTEST);
        }
    }
}
