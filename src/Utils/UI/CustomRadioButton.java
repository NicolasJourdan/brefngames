package Utils.UI;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CustomRadioButton extends JRadioButton {
    public CustomRadioButton(String text) {
        super(text);

        this.setIcon(FileGetter.getImageIcon("_circle.png"));
        this.setSelectedIcon(FileGetter.getImageIcon("_boxTick.png"));
        this.setDisabledIcon(FileGetter.getGreyImageIcon("_circle.png"));
        this.setDisabledSelectedIcon(FileGetter.getGreyImageIcon("_boxTick.png"));

        this.setForeground((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());
        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_BUTTON_TEXT));

        this.setOpaque(false);

        this.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (CustomRadioButton.this.model.isPressed()) {
                    CustomRadioButton.this.playSound();
                }
            }
        });
    }

    private void playSound() {
        SoundPlayer.playSound(Utils.DEFAULT_CLICK_SOUND);
    }
}
