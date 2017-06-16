/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.service;

import faraz.entity.Buku;
import faraz.error.BukuException;
import java.util.List;

/**
 *
 * @author FAM
 */
public interface BukuDao {
    
    public void insertBuku(Buku buku) throws BukuException;
    
    public void updateBuku(Buku buku) throws BukuException;
    
    public void updatePinjamBukuKasir(String id_buku) throws BukuException;
    
    public void updatePengembalianBukuKasir(String id_buku) throws BukuException;

    public void updateJualBeliBukuKasir(Buku buku) throws BukuException;
    
    public void deleteBuku(String id_buku) throws BukuException;
    
    public Buku getBuku(String id_buku) throws BukuException;
    
    public List<Buku> top7Buku() throws BukuException;
    
    public List<Buku> top7NewBuku() throws BukuException;
    
    public List<Buku> selectAllBuku() throws BukuException;

}
