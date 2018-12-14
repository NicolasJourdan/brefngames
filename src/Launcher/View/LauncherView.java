package Launcher.View;

import Parameter.Factory.ColorFactory;
import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;
import Scene.View.AbstractSceneManagerView;

import java.awt.*;

public class LauncherView extends AbstractSceneManagerView {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        Color firstColor = ColorFactory.getBackgroundColor(
                (Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue()
        );
        g2d.setPaint(firstColor);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}
