package ContestSettings.Controller;

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
    public ContestSettingsController(AbstractModel model, AbstractView view) {
        super(model, view);

        Map<ParameterEnum, Configurable> defaultConfiguration = ((ContestSettingsModel) this.model).getDefaultConfiguration();
        ((ContestSettingsView) this.view).setDefaultConfiguration(defaultConfiguration);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
