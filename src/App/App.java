package App;

import Controller.Launcher.LauncherController;
import Model.Launcher.LaucherModel;
import View.Launcher.LauncherView;

public class App {
    public static void main(String args[]) {
        // TODO: create a factory in order to create controllers
        new LauncherController(
            new LaucherModel(),
            new LauncherView()
        );
    }
}
