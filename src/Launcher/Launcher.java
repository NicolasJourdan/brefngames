package Launcher;

import Launcher.Controller.LauncherController;
import Launcher.Model.LauncherModel;
import Launcher.View.LauncherView;

public class Launcher {

    public static void main(String arg[]) {
        LauncherView launcherView = new LauncherView();
        LauncherModel launcherModel = new LauncherModel();
        LauncherController launcherController = new LauncherController(launcherModel, launcherView);

        LauncherWindow window = new LauncherWindow();
        window.add(launcherView);

        // manually repaint the window because we just added a panel
        launcherView.revalidate();
        launcherView.repaint();

    }
}
