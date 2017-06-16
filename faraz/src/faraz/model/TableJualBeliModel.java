/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model;

import faraz.entity.JualBeli;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FAM
 */
public class TableJualBeliModel extends AbstractTableModel{
    
    private List<JualBeli> list = new ArrayList<JualBeli>();
    
    public void setList(List<JualBeli> list) {
        this.list = list;
    }

    public JualBeli set(int index, JualBeli element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public JualBeli remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public JualBeli get(int index) {
        return list.get(index);
    }

    public boolean add(JualBeli e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "Tanggal Penjualan";
            case 1 : return "ID Member";
            case 2 : return "ID Buku";
            case 3 : return "Harga Jual";
            case 4 : return "Kuantitas";
            case 5 : return "Total";
            default: return null;
        }
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getTanggal_jualbeli();
            case 1 : return list.get(rowIndex).getId_member();
            case 2 : return list.get(rowIndex).getId_buku();
            case 3 : return list.get(rowIndex).getHarga_jual();
            case 4 : return list.get(rowIndex).getKuantitas();
            case 5 : return list.get(rowIndex).getTotal();
            default: return null;
        }
    }
    
}
