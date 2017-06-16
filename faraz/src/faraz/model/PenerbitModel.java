/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model;

import faraz.database.PenerbitDatabase;
import faraz.entity.Penerbit;
import faraz.error.PenerbitException;
import faraz.model.event.PenerbitListener;
import faraz.service.PenerbitDao;
import java.sql.SQLException;

/**
 *
 * @author FAM
 */
public class PenerbitModel {
    private String id_penerbit, nama_penerbit;
    
    private PenerbitListener listener;

    public PenerbitListener getListener() {
        return listener;
    }

    public void setListener(PenerbitListener listener) {
        this.listener = listener;
    }

    public String getId_penerbit() {
        return id_penerbit;
    }

    public void setId_penerbit(String id_penerbit) {
        this.id_penerbit = id_penerbit;
        fireOnChange();
    }

    public String getNama_penerbit() {
        return nama_penerbit;
    }

    public void setNama_penerbit(String nama_penerbit) {
        this.nama_penerbit = nama_penerbit;
        fireOnChange();
    }
    
    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Penerbit penerbit) {
        if (listener != null) {
            listener.onInsert(penerbit);
        }
    }
    
    protected void fireOnUpdate(Penerbit penerbit) {
        if (listener != null) {
            listener.onUpdate(penerbit);
        }
    }
    
    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }
    
    public void resetPenerbit() {
        setId_penerbit("");
        setNama_penerbit("");
    }
    
    public void insertPenerbit() throws SQLException, PenerbitException {
        PenerbitDao dao = PenerbitDatabase.getPenerbitDao();
        
        Penerbit penerbit = new Penerbit();
        penerbit.setId_penerbit(id_penerbit);
        penerbit.setNama_penerbit(nama_penerbit);
        
        dao.insertPenerbit(penerbit);
        
        fireOnInsert(penerbit);
    }
    
    public void updatePenerbit() throws SQLException, PenerbitException {
        PenerbitDao dao = PenerbitDatabase.getPenerbitDao();
        
        Penerbit penerbit = new Penerbit();
        penerbit.setId_penerbit(id_penerbit);
        penerbit.setNama_penerbit(nama_penerbit);
        
        dao.updatePenerbit(penerbit);
        
        fireOnUpdate(penerbit);
    }
    
    public void deletePenerbit() throws SQLException, PenerbitException {
        PenerbitDao dao = PenerbitDatabase.getPenerbitDao();
        
        dao.deletePenerbit(id_penerbit);
        
        fireOnDelete();
    }
}
