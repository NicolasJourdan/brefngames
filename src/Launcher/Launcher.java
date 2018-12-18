package Launcher;

import Launcher.Controller.LauncherController;
import Launcher.Model.LauncherModel;
import Launcher.View.LauncherView;
import Repository.Parameter.MusicParameterRepository;
import Utils.Music.MusicManager;

import javax.swing.*;

public class Launcher {

    public static void main(String arg[]) {
        try {
            // set default plaf for cross platform view unification
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch(Exception e){
            System.out.println(e);
        }

        LauncherView launcherView = new LauncherView();
        LauncherModel launcherModel = new LauncherModel();
        LauncherController launcherController = new LauncherController(launcherModel, launcherView);

        LauncherWindow window = LauncherWindow.getInstance();
        window.add(launcherView);

        // manually repaint the window because we just added a panel
        launcherView.revalidate();
        launcherView.repaint();

        // music manager
        if ((Boolean) MusicParameterRepository.getMusic().getValue()) {
            MusicManager.getInstance().start();
        }
    }
}
