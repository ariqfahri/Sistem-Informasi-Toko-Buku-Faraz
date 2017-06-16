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
public class Buku {
    private String id_buku, id_penerbit, judul_buku, pengarang, tipe;
    private int jumlah_buku, jumlah_tersedia, jumlah_dipinjam, counter,
                harga_pinjam, harga_jual, harga_baca, bantuan;
    private Date tanggal_buku;

    public Buku() {
    }

    public Buku(String id_buku, String id_penerbit, String judul_buku, String pengarang,
                String tipe, int jumlah_buku, int jumlah_tersedia, int jumlah_dipinjam,
                int counter, int harga_pinjam, int harga_jual, int harga_baca, int bantuan, Date tanggal_buku) {
        this.id_buku = id_buku;
        this.id_penerbit = id_penerbit;
        this.judul_buku = judul_buku;
        this.pengarang = pengarang;
        this.tipe = tipe;
        this.jumlah_buku = jumlah_buku;
        this.jumlah_tersedia = jumlah_tersedia;
        this.jumlah_dipinjam = jumlah_dipinjam;
        this.counter = counter;
        this.harga_pinjam = harga_pinjam;
        this.harga_jual = harga_jual;
        this.harga_baca = harga_baca;
        this.bantuan = bantuan;
        this.tanggal_buku = tanggal_buku;
    }

    public int getBantuan() {
        return bantuan;
    }

    public void setBantuan(int bantuan) {
        this.bantuan = bantuan;
    }

    public Date getTanggal_buku() {
        return tanggal_buku;
    }

    public void setTanggal_buku(Date tanggal_buku) {
        this.tanggal_buku = tanggal_buku;
    }
        
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getHarga_baca() {
        return harga_baca;
    }

    public void setHarga_baca(int harga_baca) {
        this.harga_baca = harga_baca;
    }

    public int getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(int harga_jual) {
        this.harga_jual = harga_jual;
    }

    public int getHarga_pinjam() {
        return harga_pinjam;
    }

    public void setHarga_pinjam(int harga_pinjam) {
        this.harga_pinjam = harga_pinjam;
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public String getId_penerbit() {
        return id_penerbit;
    }

    public void setId_penerbit(String id_penerbit) {
        this.id_penerbit = id_penerbit;
    }

    public String getJudul_buku() {
        return judul_buku;
    }

    public void setJudul_buku(String judul_buku) {
        this.judul_buku = judul_buku;
    }

    public int getJumlah_buku() {
        return jumlah_buku;
    }

    public void setJumlah_buku(int jumlah_buku) {
        this.jumlah_buku = jumlah_buku;
    }

    public int getJumlah_dipinjam() {
        return jumlah_dipinjam;
    }

    public void setJumlah_dipinjam(int jumlah_dipinjam) {
        this.jumlah_dipinjam = jumlah_dipinjam;
    }

    public int getJumlah_tersedia() {
        return jumlah_tersedia;
    }

    public void setJumlah_tersedia(int jumlah_tersedia) {
        this.jumlah_tersedia = jumlah_tersedia;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Buku other = (Buku) obj;
        if ((this.id_buku == null) ? (other.id_buku != null) : !this.id_buku.equals(other.id_buku)) {
            return false;
        }
        if ((this.id_penerbit == null) ? (other.id_penerbit != null) : !this.id_penerbit.equals(other.id_penerbit)) {
            return false;
        }
        if ((this.judul_buku == null) ? (other.judul_buku != null) : !this.judul_buku.equals(other.judul_buku)) {
            return false;
        }
        if ((this.pengarang == null) ? (other.pengarang != null) : !this.pengarang.equals(other.pengarang)) {
            return false;
        }
        if ((this.tipe == null) ? (other.tipe != null) : !this.tipe.equals(other.tipe)) {
            return false;
        }
        if (this.jumlah_buku != other.jumlah_buku) {
            return false;
        }
        if (this.jumlah_tersedia != other.jumlah_tersedia) {
            return false;
        }
        if (this.jumlah_dipinjam != other.jumlah_dipinjam) {
            return false;
        }
        if (this.counter != other.counter) {
            return false;
        }
        if (this.harga_pinjam != other.harga_pinjam) {
            return false;
        }
        if (this.harga_jual != other.harga_jual) {
            return false;
        }
        if (this.harga_baca != other.harga_baca) {
            return false;
        }
        if (this.bantuan != other.bantuan) {
            return false;
        }
        if (this.tanggal_buku != other.tanggal_buku && (this.tanggal_buku == null || !this.tanggal_buku.equals(other.tanggal_buku))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.id_buku != null ? this.id_buku.hashCode() : 0);
        hash = 17 * hash + (this.id_penerbit != null ? this.id_penerbit.hashCode() : 0);
        hash = 17 * hash + (this.judul_buku != null ? this.judul_buku.hashCode() : 0);
        hash = 17 * hash + (this.pengarang != null ? this.pengarang.hashCode() : 0);
        hash = 17 * hash + (this.tipe != null ? this.tipe.hashCode() : 0);
        hash = 17 * hash + this.jumlah_buku;
        hash = 17 * hash + this.jumlah_tersedia;
        hash = 17 * hash + this.jumlah_dipinjam;
        hash = 17 * hash + this.counter;
        hash = 17 * hash + this.harga_pinjam;
        hash = 17 * hash + this.harga_jual;
        hash = 17 * hash + this.harga_baca;
        hash = 17 * hash + this.bantuan;
        hash = 17 * hash + (this.tanggal_buku != null ? this.tanggal_buku.hashCode() : 0);
        return hash;
    }

}
