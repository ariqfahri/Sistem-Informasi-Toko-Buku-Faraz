/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.service;

import faraz.entity.Penerbit;
import faraz.error.PenerbitException;
import java.util.List;

/**
 *
 * @author FAM
 */
public interface PenerbitDao {
    
    public void insertPenerbit(Penerbit penerbit) throws PenerbitException;
    
    public void updatePenerbit(Penerbit penerbit) throws PenerbitException;
    
    public void deletePenerbit(String id_penerbit) throws PenerbitException;
    
    public Penerbit getPenerbit(String id_penerbit) throws PenerbitException;
    
    public List<Penerbit> selectAllPenerbit() throws PenerbitException;
}
