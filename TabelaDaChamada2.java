package appchamada;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class TabelaDaChamada2 extends DefaultTableModel{

    //Pega os dados recebidos e lança na DefaultTableModel
    public TabelaDaChamada2(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
    
    //Configura o tipo de dados a serem inseridos nas colunas
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0:
                return java.lang.String.class;
            case 1:
                return java.lang.String.class;
            case 2:
                return java.lang.Boolean.class;
        }
        return null;
    }
    
    
    //Permite a edição apenas da terceira coluna
    @Override
    public boolean isCellEditable(int row, int column) {
        if(column==2){
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
