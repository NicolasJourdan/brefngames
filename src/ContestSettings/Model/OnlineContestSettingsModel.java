package ContestSettings.Model;

public class OnlineContestSettingsModel extends ContestSettingsModel {

    private boolean firstPlayerValidation;
    private boolean secondPlayerValidation;

    public OnlineContestSettingsModel() {
        super();

        this.firstPlayerValidation = false;
        this.secondPlayerValidation = false;
    }

    public void firstPlayerValidate() {
        this.firstPlayerValidation = true;
    }

    public void secondPlayerValidate() {
        this.secondPlayerValidation = true;
    }

    public boolean canStartContest() {
        return this.firstPlayerValidation && this.secondPlayerValidation;
    }

    public void resetValidations() {
        this.firstPlayerValidation = false;
        this.secondPlayerValidation = false;
    }
}
