package appchamada;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyCellRendererOutrosValores extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;
    private Color cor1;
    private Color cor2;
    public MyCellRendererOutrosValores(Color cor1, Color cor2){
        this.cor1 = cor1;
        this.cor2 = cor2;
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        comp.setBackground(row % 2 == 0 ? cor1 : cor2);
        return comp;		
    }
}
