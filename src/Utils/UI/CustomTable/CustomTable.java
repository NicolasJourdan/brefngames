package Utils.UI.CustomTable;

import Launcher.LauncherWindow;
import Parameter.Factory.ColorFactory;
import Parameter.Model.ThemeEnum;
import Repository.Parameter.ThemeParameterRepository;
import Utils.UI.CustomLabel;
import Utils.UI.FileGetter;
import Utils.UI.Utils;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CustomTable extends JTable {
    private static final int ROW_HEIGHT = 30;
    private static final int DEFAULT_BORDER_SIZE = 10;
    public static final int FIRST_TABLE_INT = 0;
    public static final int SECOND_TABLE_INT = 1;
    public static final int MAX_TABLE_ROWS = 9;
    public static final float FONT_SIZE = 9f;

    private TableRowSorter<TableModel> sorter;

    public CustomTable(TableModel dm) {
        super(dm);
        this.sorter = new TableRowSorter<>(dm);

        // Sortkey to sort alphabetically
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        this.sorter.setSortKeys(sortKeys);

        this.setRowSorter(this.sorter);

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
            this.getColumn(this.getColumnName(i)).setPreferredWidth((LauncherWindow.JFRAME_WIDTH / 2) - CustomTable.DEFAULT_BORDER_SIZE);
            TableColumn column = this.getColumn(this.getColumnName(i));
            column.setCellRenderer(new CustomCellRenderer());
        }

        this.revalidate();
        this.repaint();
    }

    /**
     * This constructor is called when there is more than 1 table on the page
     * @param dm
     * @param tableIndex The index of table
     */
    public CustomTable(TableModel dm, final int tableIndex) {
        super(dm);
        this.sorter = new TableRowSorter<>(dm);

        // Filter to display 2 tables
        RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
            public boolean include(Entry entry) {
                if (
                        (FIRST_TABLE_INT == tableIndex && (int) entry.getIdentifier() < MAX_TABLE_ROWS) ||
                        (SECOND_TABLE_INT == tableIndex && (int) entry.getIdentifier() >= MAX_TABLE_ROWS)
                ) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        this.sorter.setRowFilter(filter);

        // Sortkey to sort alphabetically
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        this.sorter.setSortKeys(sortKeys);

        this.setRowSorter(this.sorter);

        this.setForeground((Color) ThemeParameterRepository.getColor(ThemeEnum.SECOND_COLOR).getValue());

        this.setFont(
                FileGetter.getFont().deriveFont(CustomTable.FONT_SIZE)
        );

        this.setRowHeight(CustomTable.ROW_HEIGHT);

        this.setBackground(
                ColorFactory.getBackgroundColor((Color) ThemeParameterRepository.getColor(ThemeEnum.FIRST_COLOR).getValue())
        );

        this.setShowGrid(false);

        for (int i = 0; i < this.getColumnCount(); i++) {
            this.getColumn(this.getColumnName(i)).setPreferredWidth((LauncherWindow.JFRAME_WIDTH / 4) - CustomTable.DEFAULT_BORDER_SIZE);
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
