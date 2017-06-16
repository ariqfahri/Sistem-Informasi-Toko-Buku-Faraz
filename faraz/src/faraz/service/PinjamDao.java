/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.service;

import faraz.entity.Buku;
import faraz.entity.Pinjam;
import faraz.error.PinjamException;
import java.util.List;

/**
 *
 * @author FAM
 */
public interface PinjamDao {
    
    public void insertPinjam(Pinjam pinjam) throws PinjamException;
    
    public void updatePinjam(Pinjam pinjam) throws PinjamException;
    
    public void updatePengembalianKasir(Pinjam pinjam) throws PinjamException;
    
    public void deletePinjam(int id_pinjam) throws PinjamException;
    
    public List<Pinjam> getPinjam(String id_member) throws PinjamException;
    
    public List<Pinjam> top7LastLending() throws PinjamException;
    
    public List<Pinjam> chartPinjam() throws PinjamException;
    
    public List<Pinjam> selectAllPinjam() throws PinjamException;
}
