package Launcher;

import Launcher.Controller.LauncherController;
import Launcher.Model.LauncherModel;
import Launcher.View.LauncherView;

import javax.swing.*;

public class Launcher {

    public static void main(String arg[]) {
        LauncherView launcherView = new LauncherView();
        LauncherModel launcherModel = new LauncherModel();
        LauncherController launcherController = new LauncherController(launcherModel, launcherView);

        JFrame window = new JFrame();
        window.setTitle("BREF'N'Games");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setAlwaysOnTop(true);
        window.setLocationRelativeTo(null);
        window.setFocusable(true);

        window.add(launcherView);
        window.setVisible(true);
    }
}
