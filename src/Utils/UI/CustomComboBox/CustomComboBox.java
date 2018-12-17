package Utils.UI.CustomComboBox;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;
import Utils.UI.FileGetter;
import Utils.UI.SoundPlayer;
import Utils.UI.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomComboBox extends JComboBox {

    private static final int MAXIMUM_ROW_COUNT = 5;

    private boolean loaded;

    public CustomComboBox() {
        super();
        this.setFont(FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_BUTTON_TEXT));
        this.setForeground((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());
        this.setUI(new CustomComboBoxUI());
        this.loaded = false;

        // Remove arrow
        this.remove(this.getComponent(0));
        this.setRenderer(new CustomComboBoxRenderer());

        this.setMaximumRowCount(MAXIMUM_ROW_COUNT);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!CustomComboBox.this.loaded) {
                    CustomComboBox.this.loaded = true;
                    return;
                }
                CustomComboBox.this.playSound();
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CustomComboBox.this.playSound();
            }
        });
    }

    private void playSound() {
        SoundPlayer.playSound(Utils.DEFAULT_CLICK_SOUND);
    }
}
