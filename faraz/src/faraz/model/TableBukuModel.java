/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model;

import faraz.entity.Buku;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FAM
 */
public class TableBukuModel extends AbstractTableModel{
    
    private List<Buku> list = new ArrayList<Buku>();
    
    public void setList(List<Buku> list) {
        this.list = list;
    }

    public Buku set(int index, Buku element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Buku remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public Buku get(int index) {
        return list.get(index);
    }

    public boolean add(Buku e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "Tanggal Beli";
            case 1 : return "Barcode";
            case 2 : return "Penerbit";
            case 3 : return "Judul";
            case 4 : return "Pengarang";
            case 5 : return "Dipinjam";
            case 6 : return "Tersedia";
            case 7 : return "Total Buku";
            case 8 : return "Harga Pinjam";
            case 9 : return "Harga Baca";
            case 10 : return "Harga Jual";
            case 11 : return "Counter";
            default: return null;
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 12;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 : return list.get(rowIndex).getTanggal_buku();
            case 1 : return list.get(rowIndex).getId_buku();
            case 2 : return list.get(rowIndex).getId_penerbit();
            case 3 : return list.get(rowIndex).getJudul_buku();
            case 4 : return list.get(rowIndex).getPengarang();
            case 5 : return list.get(rowIndex).getJumlah_dipinjam();
            case 6 : return list.get(rowIndex).getJumlah_tersedia();
            case 7 : return list.get(rowIndex).getJumlah_buku();
            case 8 : return list.get(rowIndex).getHarga_pinjam();
            case 9 : return list.get(rowIndex).getHarga_baca();
            case 10 : return list.get(rowIndex).getHarga_jual();
            case 11 : return list.get(rowIndex).getCounter();
                
            default: return null;
        }
    
    }
    
}
