package OnlineEnding.Model;

import Structure.AbstractModel;

public class ServerOnlineEndingModel extends AbstractModel {

    private boolean firstPlayerContinue;
    private boolean secondPlayerContinue;

    public ServerOnlineEndingModel() {
        this.firstPlayerContinue = false;
        this.secondPlayerContinue = false;
    }

    public void localPlayerContinue() {
        this.firstPlayerContinue = true;
    }

    public void onlinePlayerContinue() {
        this.secondPlayerContinue = true;
    }

    public boolean shouldContinue() {
        return this.firstPlayerContinue && this.secondPlayerContinue;
    }
}
