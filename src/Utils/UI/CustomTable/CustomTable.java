package Utils.UI.CustomTable;

import Parameter.Factory.ColorFactory;
import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;
import Utils.UI.FileGetter;
import Utils.UI.Utils;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;

public class CustomTable extends JTable {
    private static final int ROW_HEIGHT = 30;

    public CustomTable(TableModel dm) {
        super(dm);

        this.setForeground((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());

        this.setFont(
                FileGetter.getFont().deriveFont(Utils.DEFAULT_SIZE_LABEL)
        );
        
        this.setRowHeight(CustomTable.ROW_HEIGHT);

        this.setBackground(
                ColorFactory.getBackgroundColor((Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue())
        );

        this.setShowGrid(false);

        for (int i = 0; i < this.getColumnCount(); i++) {
            TableColumn column = this.getColumn(this.getColumnName(i));
            column.setCellRenderer(new CustomCellRenderer());
        }

        this.revalidate();
        this.repaint();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
