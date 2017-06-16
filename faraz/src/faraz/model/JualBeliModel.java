/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.model;

import faraz.database.JualBeliDatabase;
import faraz.entity.JualBeli;
import faraz.error.JualBeliException;
import faraz.model.event.JualBeliListener;
import faraz.service.JualBeliDao;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author FAM
 */
public class JualBeliModel {
    private int id_jualbeli, harga_jual, kuantitas, total;
    private String id_member, id_buku;
    private Date tanggal_jualbeli;
    private JualBeliListener listener;

    public JualBeliListener getListener() {
        return listener;
    }

    public void setListener(JualBeliListener listener) {
        this.listener = listener;
    }

    public int getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(int harga_jual) {
        this.harga_jual = harga_jual;
        fireOnChange();
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
        fireOnChange();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        fireOnChange();
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
        fireOnChange();
    }

    public int getId_jualbeli() {
        return id_jualbeli;
    }

    public void setId_jualbeli(int id_jualbeli) {
        this.id_jualbeli = id_jualbeli;
        fireOnChange();
    }

    public String getId_member() {
        return id_member;
    }

    public void setId_member(String id_member) {
        this.id_member = id_member;
        fireOnChange();
    }

    public Date getTanggal_jualbeli() {
        return tanggal_jualbeli;
    }

    public void setTanggal_jualbeli(Date tanggal_jualbeli) {
        this.tanggal_jualbeli = tanggal_jualbeli;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(JualBeli jualbeli) {
        if (listener != null) {
            listener.onInsert(jualbeli);
        }
    }

    protected void fireOnUpdate(JualBeli jualbeli) {
        if (listener != null) {
            listener.onUpdate(jualbeli);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void resetJualBeli() {
        setId_jualbeli(0);
        setId_member("");
        setId_buku("");
        setTanggal_jualbeli(new Date());
    }

    public void insertJualBeliKasir() throws SQLException, JualBeliException {
        JualBeliDao dao = JualBeliDatabase.getJualBeliDao();

        JualBeli jualbeli = new JualBeli();
        jualbeli.setId_member(id_member);
        jualbeli.setId_buku(id_buku);
        jualbeli.setTanggal_jualbeli(tanggal_jualbeli);
        jualbeli.setHarga_jual(harga_jual);
        jualbeli.setKuantitas(kuantitas);
        jualbeli.setTotal(total);

        dao.insertJualBeli(jualbeli);
    }

    public void updateJualBeli() throws SQLException, JualBeliException {
        JualBeliDao dao = JualBeliDatabase.getJualBeliDao();

        JualBeli jualbeli = new JualBeli();
        jualbeli.setId_jualbeli(id_jualbeli);
        jualbeli.setId_member(id_member);
        jualbeli.setId_buku(id_buku);
        jualbeli.setTanggal_jualbeli(tanggal_jualbeli);
        jualbeli.setHarga_jual(harga_jual);
        jualbeli.setKuantitas(kuantitas);
        jualbeli.setTotal(total);

        dao.updateJualBeli(jualbeli);

        fireOnUpdate(jualbeli);
    }

    public void deleteJualBeli() throws SQLException, JualBeliException {
        JualBeliDao dao = JualBeliDatabase.getJualBeliDao();

        dao.deleteJualBeli(id_jualbeli);

        fireOnDelete();
    }
}
