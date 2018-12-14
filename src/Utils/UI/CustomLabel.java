package Utils.UI;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import java.awt.*;

public class CustomLabel extends JLabel {
    public CustomLabel(String text) {
        super(text);
        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL));
        this.setForeground((Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue());
    }
}
