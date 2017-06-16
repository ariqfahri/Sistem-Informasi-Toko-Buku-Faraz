/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model;

import faraz.database.BukuDatabase;
import faraz.entity.Buku;
import faraz.error.BukuException;
import faraz.model.event.BukuListener;
import faraz.service.BukuDao;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author FAM
 */
public class BukuModel {

    private String id_buku, id_penerbit, judul_buku, pengarang, tipe;
    private int jumlah_buku, jumlah_tersedia, jumlah_dipinjam, counter, harga_pinjam, harga_jual, harga_baca, bantuan;
    private Date tanggal_buku;
    private BukuListener listener;

    public BukuListener getListener() {
        return listener;
    }

    public void setListener(BukuListener listener) {
        this.listener = listener;
    }

    public int getBantuan() {
        return bantuan;
    }

    public void setBantuan(int bantuan) {
        this.bantuan = bantuan;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
        fireOnChange();
    }

    public int getHarga_baca() {
        return harga_baca;
    }

    public void setHarga_baca(int harga_baca) {
        this.harga_baca = harga_baca;
        fireOnChange();
    }

    public int getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(int harga_jual) {
        this.harga_jual = harga_jual;
        fireOnChange();
    }

    public int getHarga_pinjam() {
        return harga_pinjam;
    }

    public void setHarga_pinjam(int harga_pinjam) {
        this.harga_pinjam = harga_pinjam;
        fireOnChange();
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
        fireOnChange();
    }

    public String getId_penerbit() {
        return id_penerbit;
    }

    public void setId_penerbit(String id_penerbit) {
        this.id_penerbit = id_penerbit;
        fireOnChange();
    }

    public String getJudul_buku() {
        return judul_buku;
    }

    public void setJudul_buku(String judul_buku) {
        this.judul_buku = judul_buku;
        fireOnChange();
    }

    public int getJumlah_buku() {
        return jumlah_buku;
    }

    public void setJumlah_buku(int jumlah_buku) {
        this.jumlah_buku = jumlah_buku;
        fireOnChange();
    }

    public int getJumlah_dipinjam() {
        return jumlah_dipinjam;
    }

    public void setJumlah_dipinjam(int jumlah_dipinjam) {
        this.jumlah_dipinjam = jumlah_dipinjam;
        fireOnChange();
    }

    public int getJumlah_tersedia() {
        return jumlah_tersedia;
    }

    public void setJumlah_tersedia(int jumlah_tersedia) {
        this.jumlah_tersedia = jumlah_tersedia;
        fireOnChange();
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
        fireOnChange();
    }

    public Date getTanggal_buku() {
        return tanggal_buku;
    }

    public void setTanggal_buku(Date tanggal_buku) {
        this.tanggal_buku = tanggal_buku;
        fireOnChange();
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Buku buku) {
        if (listener != null) {
            listener.onInsert(buku);
        }
    }

    protected void fireOnUpdate(Buku buku) {
        if (listener != null) {
            listener.onUpdate(buku);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void resetBuku() {
        setId_buku("");
        setId_penerbit("");
        setJudul_buku("");
        setPengarang("");
        setJumlah_buku(0);
        setHarga_jual(0);
        setHarga_pinjam(0);
        setHarga_baca(0);
        setTanggal_buku(new Date());
    }
    
    public void resetPinjamKasir() {
        setId_buku("");
    }

    public void getBuku() throws SQLException, BukuException {
        BukuDao dao = BukuDatabase.getBukuDao();

        fireOnInsert(dao.getBuku(getId_buku()));
    }
    
    public void insertBuku() throws SQLException, BukuException {
        BukuDao dao = BukuDatabase.getBukuDao();

        Buku buku = new Buku();
        buku.setId_buku(id_buku);
        buku.setId_penerbit(id_penerbit);
        buku.setTanggal_buku(tanggal_buku);
        buku.setJudul_buku(judul_buku);
        buku.setPengarang(pengarang);
        buku.setJumlah_buku(jumlah_buku);
        buku.setJumlah_dipinjam(jumlah_dipinjam);
        buku.setJumlah_tersedia(jumlah_tersedia);
        buku.setCounter(counter);
        buku.setHarga_jual(harga_jual);
        buku.setHarga_baca(harga_baca);
        buku.setHarga_pinjam(harga_pinjam);

        dao.insertBuku(buku);

        fireOnInsert(buku);
    }
    
    public void updateBuku() throws SQLException, BukuException {
        BukuDao dao = BukuDatabase.getBukuDao();

        Buku buku = new Buku();
        buku.setId_buku(id_buku);
        buku.setId_penerbit(id_penerbit);
        buku.setTanggal_buku(tanggal_buku);
        buku.setJudul_buku(judul_buku);
        buku.setPengarang(pengarang);
        buku.setJumlah_buku(jumlah_buku);
        buku.setJumlah_dipinjam(jumlah_dipinjam);
        buku.setJumlah_tersedia(jumlah_tersedia);
        buku.setHarga_jual(harga_jual);
        buku.setHarga_baca(harga_baca);
        buku.setHarga_pinjam(harga_pinjam);

        dao.updateBuku(buku);

        fireOnUpdate(buku);
    }
    
    public void updatePinjamBukuKasir() throws SQLException, BukuException {
        BukuDao dao = BukuDatabase.getBukuDao();

        dao.updatePinjamBukuKasir(getId_buku());
    }
    
    public void updatePengembalianBukuKasir() throws SQLException, BukuException {
        BukuDao dao = BukuDatabase.getBukuDao();

        dao.updatePengembalianBukuKasir(getId_buku());
    }
    
    public void updateJualBeliBukuKasir() throws SQLException, BukuException {
        BukuDao dao = BukuDatabase.getBukuDao();
        
        Buku buku = new Buku();
        buku.setId_buku(id_buku);
        buku.setBantuan(bantuan);
        
        dao.updateJualBeliBukuKasir(buku);
    }
    
    public void deleteBuku() throws SQLException, BukuException {
        BukuDao dao = BukuDatabase.getBukuDao();

        dao.deleteBuku(id_buku);

        fireOnDelete();
    }
}