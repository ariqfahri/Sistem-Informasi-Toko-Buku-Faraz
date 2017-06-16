/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model;

import faraz.database.PinjamDatabase;
import faraz.entity.Pinjam;
import faraz.error.PinjamException;
import faraz.model.event.PinjamListener;
import faraz.service.PinjamDao;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author FAM
 */
public class PinjamModel {

    private String id_member, id_buku;
    private Date tanggal_pinjam, tanggal_kembali, tanggal_dikembalikan;
    private int id_pinjam, harga_pinjam, denda;
    private PinjamListener listener;

    public PinjamListener getListener() {
        return listener;
    }

    public void setListener(PinjamListener listener) {
        this.listener = listener;
    }

    public int getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
        fireOnChange();
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
        fireOnChange();
    }

    public String getId_member() {
        return id_member;
    }

    public void setId_member(String id_member) {
        this.id_member = id_member;
        fireOnChange();
    }

    public int getId_pinjam() {
        return id_pinjam;
    }

    public void setId_pinjam(int id_pinjam) {
        this.id_pinjam = id_pinjam;
        fireOnChange();
    }

    public Date getTanggal_kembali() {
        return tanggal_kembali;
    }

    public void setTanggal_kembali(Date tanggal_kembali) {
        this.tanggal_kembali = tanggal_kembali;
        fireOnChange();
    }

    public Date getTanggal_pinjam() {
        return tanggal_pinjam;
    }

    public void setTanggal_pinjam(Date tanggal_pinjam) {
        this.tanggal_pinjam = tanggal_pinjam;
        fireOnChange();
    }

    public Date getTanggal_dikembalikan() {
        return tanggal_dikembalikan;
    }

    public void setTanggal_dikembalikan(Date tanggal_dikembalikan) {
        this.tanggal_dikembalikan = tanggal_dikembalikan;
        fireOnChange();
    }

    public int getHarga_pinjam() {
        return harga_pinjam;
    }

    public void setHarga_pinjam(int harga_pinjam) {
        this.harga_pinjam = harga_pinjam;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Pinjam pinjam) {
        if (listener != null) {
            listener.onInsert(pinjam);
        }
    }

    protected void fireOnUpdate(Pinjam pinjam) {
        if (listener != null) {
            listener.onUpdate(pinjam);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void resetPinjamKasir() {
        setId_member("");
    }

    public void resetPinjam() {
        setId_pinjam(0);
        setId_member("");
        setId_buku("");
        setTanggal_pinjam(new Date());
        setTanggal_kembali(new Date());
        setTanggal_dikembalikan(new Date());
        setDenda(0);
    }

    public void insertPinjamKasir() throws SQLException, PinjamException {
        PinjamDao dao = PinjamDatabase.getPinjamDao();

        Pinjam pinjam = new Pinjam();
        pinjam.setId_member(id_member);
        pinjam.setId_buku(id_buku);
        pinjam.setTanggal_pinjam(tanggal_pinjam);
        pinjam.setTanggal_kembali(tanggal_kembali);
        pinjam.setHarga_pinjam(harga_pinjam);
        pinjam.setDenda(denda);

        dao.insertPinjam(pinjam);
    }
    
    public void insertPinjamBacaKasir() throws SQLException, PinjamException {
        PinjamDao dao = PinjamDatabase.getPinjamDao();

        Pinjam pinjam = new Pinjam();
        pinjam.setId_member(id_member);
        pinjam.setId_buku(id_buku);
        pinjam.setTanggal_pinjam(tanggal_pinjam);
        pinjam.setTanggal_kembali(tanggal_kembali);
        pinjam.setHarga_pinjam(harga_pinjam);
        pinjam.setDenda(denda);

        dao.insertPinjam(pinjam);
    }

    public void updatePinjam() throws SQLException, PinjamException {
        PinjamDao dao = PinjamDatabase.getPinjamDao();

        Pinjam pinjam = new Pinjam();
        pinjam.setId_pinjam(id_pinjam);
        pinjam.setId_member(id_member);
        pinjam.setId_buku(id_buku);
        pinjam.setTanggal_pinjam(tanggal_pinjam);
        pinjam.setTanggal_kembali(tanggal_kembali);
        pinjam.setTanggal_dikembalikan(tanggal_dikembalikan);
        pinjam.setHarga_pinjam(harga_pinjam);
        pinjam.setDenda(denda);

        dao.updatePinjam(pinjam);

        fireOnUpdate(pinjam);
    }

    public void updatePengembalianKasir() throws SQLException, PinjamException {
        PinjamDao dao = PinjamDatabase.getPinjamDao();

        Pinjam pinjam = new Pinjam();
        pinjam.setId_pinjam(id_pinjam);
        pinjam.setTanggal_dikembalikan(tanggal_dikembalikan);
        pinjam.setDenda(denda);

        dao.updatePengembalianKasir(pinjam);
    }

    public void deletePinjam() throws SQLException, PinjamException {
        PinjamDao dao = PinjamDatabase.getPinjamDao();

        dao.deletePinjam(id_pinjam);

        fireOnDelete();
    }

    
}
