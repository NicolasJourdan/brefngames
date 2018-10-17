package Controller;

import Model.Launcher.Scene.Action;
import Model.Launcher.Scene.Scene;
import Model.Model;
import View.View;
import javax.swing.JComponent;

public class AbstractSceneController extends Controller {

    private Scene scene;

    public AbstractSceneController(Model model, View view) {
        super(model, view);
    }

    
    public JComponent getViewComponent() {
        return this.view.getComponent();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    protected void updateScene(Action action) {
        this.scene.notify(action);
    }
}
