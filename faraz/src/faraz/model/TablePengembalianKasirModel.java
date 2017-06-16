/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model;

import faraz.entity.Pinjam;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FAM
 */
public class TablePengembalianKasirModel extends AbstractTableModel{
    
    private List<Pinjam> list = new ArrayList<Pinjam>();
    
    public void setList(List<Pinjam> list) {
        this.list = list;
    }

    public Pinjam set(int index, Pinjam element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Pinjam remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public Pinjam get(int index) {
        return list.get(index);
    }

    public boolean add(Pinjam e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "ID Peminjaman";
            case 1 : return "Tanggal Pinjam";
            case 2 : return "Tanggal Kembali";
            case 3 : return "Tanggal Dikembalikan";
            case 4 : return "ID Buku";
            case 5 : return "Denda";
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
            case 0 : return list.get(rowIndex).getId_pinjam();
            case 1 : return list.get(rowIndex).getTanggal_pinjam();
            case 2 : return list.get(rowIndex).getTanggal_kembali();
            case 3 : return list.get(rowIndex).getTanggal_dikembalikan();
            case 4 : return list.get(rowIndex).getId_buku();
            case 5 : return list.get(rowIndex).getDenda();
            default: return null;
        }
    }
    
}
