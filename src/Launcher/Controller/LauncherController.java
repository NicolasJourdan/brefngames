package Launcher.Controller;

import Launcher.Model.LauncherModel;
import Launcher.View.LauncherView;
import Parameter.Model.Configurable;
import Parameter.Model.ParametersEnum;

import java.util.*;

/**
 * @author BrefNGames
 */
public class LauncherController {

    private LauncherModel launcherModel;

    private LauncherView launcherView;

    private Map<ParametersEnum, Configurable> configurations;

    public LauncherController() {
    }
}
