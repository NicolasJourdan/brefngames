package Menu;

import Menu.Controller.MenuController;
import Menu.Model.MenuModel;
import Menu.View.MenuView;
import Scene.Model.Scene;

public class MenuScene extends Scene {

    public MenuScene() {
        this.model = new MenuModel();
        this.view = new MenuView();
        this.controller = new MenuController(this.model, this.view);
        this.controller.addObserver(this);
    }
}
