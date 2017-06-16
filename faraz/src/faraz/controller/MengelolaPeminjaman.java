/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.controller;

import faraz.model.PinjamModel;
import faraz.view.PengembalianKasirView;
import faraz.view.PinjamBacaKasirView;
import faraz.view.PinjamKasirView;
import faraz.view.PinjamView;
import faraz.view.usu.FormatterBox;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author FAM
 */
public class MengelolaPeminjaman {

    private PinjamModel model;

    public void setModel(PinjamModel model) {
        this.model = model;
    }

    public void resetPinjamKasir(PinjamKasirView view) {
        model.resetPinjamKasir();
    }

    public void resetPinjam(PinjamView view) {
        model.resetPinjam();
    }

    public boolean insertPinjamKasir(PinjamKasirView view) {

        JTable tabelBuku = view.getTabelBuku();
        Date tanggal_pinjam = new Date();
        Date tanggal_kembali = (Date) view.getInputTanggal_kembali().getDate();
        String id_member = view.getInputId_member().getText();
        Integer denda = 0;

        if (id_member.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Member masih kosong");
        } else if (id_member.length() > 10) {
            JOptionPane.showMessageDialog(view, "ID Member tidak boleh lebih dari 10 karakter");
        } else if (tanggal_kembali.compareTo(new Date()) <= 0) {
            JOptionPane.showMessageDialog(view, "Tanggal kembali tidak boleh tanggal yang telah lalu");
        } else if (tabelBuku.getRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Tabel Peminjaman masih kosong");
        } else {
            for (int i = 0; i < tabelBuku.getRowCount(); i++) {
                model.setTanggal_pinjam(tanggal_pinjam);
                model.setTanggal_kembali(tanggal_kembali);
                model.setId_member(id_member);
                model.setId_buku((String) tabelBuku.getValueAt(i, 0));
                model.setHarga_pinjam((Integer) tabelBuku.getValueAt(i, 2));
                model.setDenda(denda);

                try {
                    model.insertPinjamKasir();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
            return true;
        }
        return false;
    }

    public void insertPinjamBacaKasir(PinjamBacaKasirView view) {
        JTable tabelBuku = view.getTabelBuku();
        Date tanggal_pinjam = new Date();
        Date tanggal_kembali = new Date();
        String id_member = view.getInputId_member().getText();
        Integer denda = 0;

        if (id_member.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Member masih kosong");
        } else if (id_member.length() > 10) {
            JOptionPane.showMessageDialog(view, "ID Member tidak boleh lebih dari 10 karakter");
        } else if (tabelBuku.getRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Tabel Peminjaman masih kosong");
        } else {
            for (int i = 0; i < tabelBuku.getRowCount(); i++) {
                model.setTanggal_pinjam(tanggal_pinjam);
                model.setTanggal_kembali(tanggal_kembali);
                model.setId_member(id_member);
                model.setId_buku((String) tabelBuku.getValueAt(i, 0));
                model.setHarga_pinjam((Integer) tabelBuku.getValueAt(i, 2));
                model.setDenda(denda);

                try {
                    model.insertPinjamBacaKasir();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
            JOptionPane.showMessageDialog(view, "Transaksi Peminjaman berhasil disimpan");
        }
    }

    public void updatePinjam(PinjamView view) {

        if (view.getTabelPinjam().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/pinjam yang akan dihapus");
        } else {
            Integer id_pinjam = Integer.parseInt(view.getInputId_pinjam().getText());
            Date tanggal_pinjam = (Date) view.getInputTanggal_pinjam().getValue();
            Date tanggal_kembali = (Date) view.getInputTanggal_kembali().getValue();
            Date tanggal_dikembalikan = (Date) view.getInputTanggal_dikembalikan().getValue();
            String id_member = view.getInputId_member().getText();
            String id_buku = view.getInputId_buku().getText();
            Integer harga_pinjam = Integer.parseInt(view.getInputHarga_pinjam().getText());
            Integer denda = Integer.parseInt(view.getInputDenda().getText());

            if (id_member.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "ID Member masih kosong");
            } else if (id_member.length() > 10) {
                JOptionPane.showMessageDialog(view, "ID Member tidak boleh lebih dari 10 karakter");
            } else if (id_buku.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "ID Buku masih kosong");
            } else if (id_buku.length() > 30) {
                JOptionPane.showMessageDialog(view, "ID Buku tidak boleh lebih dari 30 karakter");
            } else if (tanggal_dikembalikan.compareTo(new Date()) <= 0) {
                JOptionPane.showMessageDialog(view, "Tanggal dikembalikan tidak boleh tanggal yang telah lalu");
            } else if (String.valueOf(denda).length() > 5) {
                JOptionPane.showMessageDialog(view, "Denda tidak boleh lebih dari 5 digit");
            } else {
                model.setId_pinjam(id_pinjam);
                model.setTanggal_pinjam(tanggal_pinjam);
                model.setTanggal_kembali(tanggal_kembali);
                model.setTanggal_dikembalikan(tanggal_dikembalikan);
                model.setId_buku(id_buku);
                model.setId_member(id_member);
                model.setHarga_pinjam(harga_pinjam);
                model.setDenda(denda);

                try {
                    model.updatePinjam();
                    JOptionPane.showMessageDialog(view, "Data Peminjaman berhasil diubah");
                    model.resetPinjam();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }

    
    public void deletePinjam(PinjamView view) {

        if (view.getTabelPinjam().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/pinjam yang akan dihapus");
        } else {
            if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus data Pinjam ini?") == JOptionPane.OK_OPTION) {
                Integer id_pinjam = Integer.parseInt(view.getInputId_pinjam().getText());
                model.setId_pinjam(id_pinjam);
                try {
                    model.deletePinjam();
                    JOptionPane.showMessageDialog(view, "Data Peminjaman berhasil dihapus");
                    model.resetPinjam();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }
    
    public void updatePengembalianKasir(PengembalianKasirView view) {
        Integer denda = Integer.parseInt(view.getInputDenda().getText());
        Date tanggal_dikembalikan = new Date();
        JTable tabelPinjam = view.getTabelPinjam();

        if (view.getInputDenda().getText().equals("")) {
            JOptionPane.showMessageDialog(view, "Isikan Denda dengan nilai 0 jika pengembalian tepat waktu");
        } else {
            model.setId_pinjam((Integer) tabelPinjam.getValueAt(0, 0));
            model.setTanggal_dikembalikan(tanggal_dikembalikan);
            model.setDenda(denda);
            try {
                model.updatePengembalianKasir();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi error di database dengan pesan :",
                            throwable.getMessage()});
            }
            for (int i = 1; i < tabelPinjam.getRowCount(); i++) {
                model.setId_pinjam((Integer) tabelPinjam.getValueAt(i, 0));
                model.setTanggal_dikembalikan(tanggal_dikembalikan);
                model.setDenda(0);

                try {
                    model.updatePengembalianKasir();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
            JOptionPane.showMessageDialog(view, "Transaksi pengembalian berhasil disimpan");
        }
    }
}
