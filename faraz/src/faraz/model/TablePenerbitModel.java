/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model;

import faraz.entity.Penerbit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FAM
 */
public class TablePenerbitModel extends AbstractTableModel{

    private List<Penerbit> list = new ArrayList<Penerbit>();
    
    public void setList(List<Penerbit> list) {
        this.list = list;
    }

    public Penerbit set(int index, Penerbit element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Penerbit remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public Penerbit get(int index) {
        return list.get(index);
    }

    public boolean add(Penerbit e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "ID Penerbit";
            case 1 : return "Nama Penerbit";
            default: return null;
        }
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getId_penerbit();
            case 1 : return list.get(rowIndex).getNama_penerbit();
            default: return null;
        }
    }
    
}
