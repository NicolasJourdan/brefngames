package OnlineEnding.View;

import Scene.Model.ActionEnum;
import Utils.UI.CustomButton;
import Utils.UI.CustomPanel.CustomBackgroundPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineEndingView extends CustomBackgroundPanel {

    private static final String QUIT = "Quit";
    private static final String CONTINUE = "Continue";
    private static final String WAITING = "Waiting ...";

    private final JButton quitButton;
    private final JButton continueButton;

    public OnlineEndingView() {
        this.quitButton = new CustomButton(OnlineEndingView.QUIT);
        this.quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnlineEndingView.this.observable.notifyObservers(ActionEnum.END_CONTEST);
            }
        });
        this.add(this.quitButton);

        this.continueButton = new CustomButton(OnlineEndingView.CONTINUE);
        this.continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnlineEndingView.this.observable.notifyObservers(ActionEnum.ONLINE_ENDING_CONTINUE);
            }
        });
        this.add(this.continueButton);
    }

    public void setWaitingButton() {
        OnlineEndingView.this.continueButton.setText(OnlineEndingView.WAITING);
    }
}
