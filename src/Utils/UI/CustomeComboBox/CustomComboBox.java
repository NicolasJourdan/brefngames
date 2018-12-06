package Utils.UI.CustomeComboBox;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;
import Utils.UI.FileGetter;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;

public class CustomComboBox extends JComboBox {

    private static final int MAXIMUM_ROW_COUNT = 5;

    public CustomComboBox() {
        super();
        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_BUTTON_TEXT));
        this.setForeground((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());
        this.setUI(new CustomComboBoxUI());

        // Remove arrow
        this.remove(this.getComponent(0));
        this.setRenderer(new CustomComboBoxRenderer());
        this.setMaximumRowCount(MAXIMUM_ROW_COUNT);
    }
}
