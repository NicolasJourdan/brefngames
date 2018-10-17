package Controller;

import Model.Launcher.Scene.Action;
import Model.Launcher.Scene.Scene;
import Model.Model;
import View.View;

public class DummyController extends AbstractSceneController {
    
    public DummyController(Model model, View view, Action action) {
        super(model, view);
        
        System.out.println(action.toString());
    }

    @Override
    public void setScene(Scene scene) {
        super.setScene(scene);
        
        // TODO: change the way actions are choosed
        this.updateScene(Action.Quit);
    }
    
}
