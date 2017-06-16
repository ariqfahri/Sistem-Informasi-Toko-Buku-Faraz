/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model;

import faraz.entity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FAM
 */
public class TableMemberModel extends AbstractTableModel{
    
    private List<Member> list = new ArrayList<Member>();
    
    public void setList(List<Member> list) {
        this.list = list;
    }

    public Member set(int index, Member element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Member remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public Member get(int index) {
        return list.get(index);
    }

    public boolean add(Member e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "Tanggal Daftar";
            case 1 : return "ID";
            case 2 : return "Nama";
            case 3 : return "Alamat";
            case 4 : return "Telepon";
            case 5 : return "Email";
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
            case 0 : return list.get(rowIndex).getTanggal_member();
            case 1 : return list.get(rowIndex).getId_member();
            case 2 : return list.get(rowIndex).getNama();
            case 3 : return list.get(rowIndex).getAlamat();
            case 4 : return list.get(rowIndex).getTelepon();
            case 5 : return list.get(rowIndex).getEmail();
            default: return null;
        }
    }
    
}
