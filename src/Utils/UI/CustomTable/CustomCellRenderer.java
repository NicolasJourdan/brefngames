package Utils.UI.CustomTable;

import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class CustomCellRenderer extends JLabel implements TableCellRenderer {


    private static final int MARGIN = 10;
    public static final int BORDER_THICKNESS = 2;

    public CustomCellRenderer() {
        this.setBorder(
                BorderFactory.createLineBorder(
                        (Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue(),
                        CustomCellRenderer.BORDER_THICKNESS
                )
        );

        Border padding = BorderFactory.createEmptyBorder(CustomCellRenderer.MARGIN, CustomCellRenderer.MARGIN, CustomCellRenderer.MARGIN, CustomCellRenderer.MARGIN);
        this.setBorder(
                BorderFactory.createCompoundBorder(
                        this.getBorder(),
                        padding
                )
        );
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
        this.setForeground(table.getForeground());
        this.setFont(table.getFont());
        this.setText((String) value);

        return this;
    }
}
