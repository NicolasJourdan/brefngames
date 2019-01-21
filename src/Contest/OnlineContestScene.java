package Contest;

import Contest.Controller.OnlineContestController;
import Contest.Model.OnlineContest;
import Contest.View.ContestView;
import Scene.Model.AbstractSceneManagerModel;
import Scene.Model.Scene;
import Scene.View.AbstractSceneManagerView;

public class OnlineContestScene extends Scene {

    public OnlineContestScene() {
        this.model = new OnlineContest();
        this.view = new ContestView();
        this.controller = new OnlineContestController((AbstractSceneManagerModel) this.model, (AbstractSceneManagerView) this.view);
        this.controller.addObserver(this);
    }
}
