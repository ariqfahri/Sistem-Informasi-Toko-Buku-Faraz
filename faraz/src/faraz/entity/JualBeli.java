/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.entity;

import java.util.Date;

/**
 *
 * @author FAM
 */
public class JualBeli {
    private Date tanggal_jualbeli;
    private String id_member, id_buku;
    private int id_jualbeli, harga_jual, kuantitas, total;
    
    public JualBeli() {
    }

    public JualBeli(Date tanggal_jualbeli, String id_member, String id_buku, int id_jualbeli, int harga_jual, int kuantitas, int total) {
        this.tanggal_jualbeli = tanggal_jualbeli;
        this.id_member = id_member;
        this.id_buku = id_buku;
        this.id_jualbeli = id_jualbeli;
        this.harga_jual = harga_jual;
        this.kuantitas = kuantitas;
        this.total = total;
    }

    public int getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(int harga_jual) {
        this.harga_jual = harga_jual;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public String getId_member() {
        return id_member;
    }

    public void setId_member(String id_member) {
        this.id_member = id_member;
    }

    public int getId_jualbeli() {
        return id_jualbeli;
    }

    public void setId_jualbeli(int id_jualbeli) {
        this.id_jualbeli = id_jualbeli;
    }

    public Date getTanggal_jualbeli() {
        return tanggal_jualbeli;
    }

    public void setTanggal_jualbeli(Date tanggal_jualbeli) {
        this.tanggal_jualbeli = tanggal_jualbeli;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JualBeli other = (JualBeli) obj;
        if (this.tanggal_jualbeli != other.tanggal_jualbeli && (this.tanggal_jualbeli == null || !this.tanggal_jualbeli.equals(other.tanggal_jualbeli))) {
            return false;
        }
        if ((this.id_member == null) ? (other.id_member != null) : !this.id_member.equals(other.id_member)) {
            return false;
        }
        if ((this.id_buku == null) ? (other.id_buku != null) : !this.id_buku.equals(other.id_buku)) {
            return false;
        }
        if (this.id_jualbeli != other.id_jualbeli) {
            return false;
        }
        if (this.harga_jual != other.harga_jual) {
            return false;
        }
        if (this.kuantitas != other.kuantitas) {
            return false;
        }
        if (this.total != other.total) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.tanggal_jualbeli != null ? this.tanggal_jualbeli.hashCode() : 0);
        hash = 59 * hash + (this.id_member != null ? this.id_member.hashCode() : 0);
        hash = 59 * hash + (this.id_buku != null ? this.id_buku.hashCode() : 0);
        hash = 59 * hash + this.id_jualbeli;
        hash = 59 * hash + this.harga_jual;
        hash = 59 * hash + this.kuantitas;
        hash = 59 * hash + this.total;
        return hash;
    }
    
}
