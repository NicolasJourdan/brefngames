package Credit;

import Credit.Controller.CreditController;
import Credit.Model.CreditModel;
import Credit.View.CreditView;
import Scene.Model.Scene;

public class CreditScene extends Scene {

    public CreditScene() {
        this.model = new CreditModel();
        this.view = new CreditView();
        this.controller = new CreditController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
