/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.entity;

/**
 *
 * @author FAM
 */
public class Penerbit {
    private String id_penerbit, nama_penerbit;

    public Penerbit() {
    }

    public Penerbit(String id_penerbit, String nama_penerbit) {
        this.id_penerbit = id_penerbit;
        this.nama_penerbit = nama_penerbit;
    }
    
    public String getId_penerbit() {
        return id_penerbit;
    }

    public void setId_penerbit(String id_penerbit) {
        this.id_penerbit = id_penerbit;
    }

    public String getNama_penerbit() {
        return nama_penerbit;
    }

    public void setNama_penerbit(String nama_penerbit) {
        this.nama_penerbit = nama_penerbit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Penerbit other = (Penerbit) obj;
        if ((this.id_penerbit == null) ? (other.id_penerbit != null) : !this.id_penerbit.equals(other.id_penerbit)) {
            return false;
        }
        if ((this.nama_penerbit == null) ? (other.nama_penerbit != null) : !this.nama_penerbit.equals(other.nama_penerbit)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.id_penerbit != null ? this.id_penerbit.hashCode() : 0);
        hash = 29 * hash + (this.nama_penerbit != null ? this.nama_penerbit.hashCode() : 0);
        return hash;
    }
    
    
}
