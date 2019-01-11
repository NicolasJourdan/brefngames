package Contest;

import Contest.Controller.LocalContestController;
import Contest.Model.LocalContest;
import Contest.View.ContestView;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.Scene;
import Scene.View.AbstractSceneManagerView;

public class LocalContestScene extends Scene {

    public LocalContestScene() {
        this.model = new LocalContest();
        this.view = new ContestView();
        this.controller = new LocalContestController((AbstractSceneManagerModel) this.model, (AbstractSceneManagerView) this.view);
        this.controller.addObserver(this);

    }
}
