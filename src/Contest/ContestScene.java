package Contest;

import Contest.Controller.ContestController;
import Contest.Model.LocalContest;
import Contest.View.ContestView;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.Scene;
import Scene.View.AbstractSceneManagerView;

public class ContestScene extends Scene {

    public ContestScene() {
        this.model = new LocalContest();
        this.view = new ContestView();
        this.controller = new ContestController((AbstractSceneManagerModel) this.model, (AbstractSceneManagerView) this.view);
        this.controller.addObserver(this);

    }
}
