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
public class Pinjam {
    private String id_member, id_buku;
    private Date tanggal_pinjam, tanggal_kembali, tanggal_dikembalikan;
    private int id_pinjam, harga_pinjam, denda;

    public Pinjam() {
    }

    public Pinjam(String id_member, String id_buku, Date tanggal_pinjam, Date tanggal_kembali, Date tanggal_dikembalikan, int id_pinjam, int harga_pinjam, int denda) {
        this.id_member = id_member;
        this.id_buku = id_buku;
        this.tanggal_pinjam = tanggal_pinjam;
        this.tanggal_kembali = tanggal_kembali;
        this.tanggal_dikembalikan = tanggal_dikembalikan;
        this.id_pinjam = id_pinjam;
        this.harga_pinjam = harga_pinjam;
        this.denda = denda;
    }

    public Date getTanggal_dikembalikan() {
        return tanggal_dikembalikan;
    }

    public void setTanggal_dikembalikan(Date tanggal_dikembalikan) {
        this.tanggal_dikembalikan = tanggal_dikembalikan;
    }

    public int getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
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

    public int getId_pinjam() {
        return id_pinjam;
    }

    public void setId_pinjam(int id_pinjam) {
        this.id_pinjam = id_pinjam;
    }

    public Date getTanggal_kembali() {
        return tanggal_kembali;
    }

    public void setTanggal_kembali(Date tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
    }

    public Date getTanggal_pinjam() {
        return tanggal_pinjam;
    }

    public void setTanggal_pinjam(Date tanggal_pinjam) {
        this.tanggal_pinjam = tanggal_pinjam;
    }

    public int getHarga_pinjam() {
        return harga_pinjam;
    }

    public void setHarga_pinjam(int harga_pinjam) {
        this.harga_pinjam = harga_pinjam;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pinjam other = (Pinjam) obj;
        if ((this.id_member == null) ? (other.id_member != null) : !this.id_member.equals(other.id_member)) {
            return false;
        }
        if ((this.id_buku == null) ? (other.id_buku != null) : !this.id_buku.equals(other.id_buku)) {
            return false;
        }
        if (this.tanggal_pinjam != other.tanggal_pinjam && (this.tanggal_pinjam == null || !this.tanggal_pinjam.equals(other.tanggal_pinjam))) {
            return false;
        }
        if (this.tanggal_kembali != other.tanggal_kembali && (this.tanggal_kembali == null || !this.tanggal_kembali.equals(other.tanggal_kembali))) {
            return false;
        }
        if (this.tanggal_dikembalikan != other.tanggal_dikembalikan && (this.tanggal_dikembalikan == null || !this.tanggal_dikembalikan.equals(other.tanggal_dikembalikan))) {
            return false;
        }
        if (this.harga_pinjam != other.harga_pinjam) {
            return false;
        }
        if (this.denda != other.denda) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id_member != null ? this.id_member.hashCode() : 0);
        hash = 59 * hash + (this.id_buku != null ? this.id_buku.hashCode() : 0);
        hash = 59 * hash + (this.tanggal_pinjam != null ? this.tanggal_pinjam.hashCode() : 0);
        hash = 59 * hash + (this.tanggal_kembali != null ? this.tanggal_kembali.hashCode() : 0);
        hash = 59 * hash + (this.tanggal_dikembalikan != null ? this.tanggal_dikembalikan.hashCode() : 0);
        hash = 59 * hash + this.id_pinjam;
        hash = 59 * hash + this.harga_pinjam;
        hash = 59 * hash + this.denda;
        return hash;
    }

}
