/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.controller;

import faraz.model.JualBeliModel;
import faraz.view.JualBeliKasirView;
import faraz.view.JualBeliView;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author FAM
 */
public class MengelolaPenjualan {

    private JualBeliModel model;

    public void setModel(JualBeliModel model) {
        this.model = model;
    }

    public void resetJualBeli(JualBeliView view) {
        model.resetJualBeli();
    }

    public boolean insertJualBeliKasir(JualBeliKasirView view) {

        JTable tabelBuku = view.getTabelBuku();
        Date tanggal_jualbeli = new Date();
        String id_member = view.getInputId_member().getText();

        if (id_member.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Member masih kosong");
        } else if (id_member.length() > 10) {
            JOptionPane.showMessageDialog(view, "ID Member tidak boleh lebih dari 10 karakter");
        } else if (tabelBuku.getRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Tabel Penjualan masih kosong");
        } else {
            for (int i = 0; i < tabelBuku.getRowCount(); i++) {
                model.setTanggal_jualbeli(tanggal_jualbeli);
                model.setId_member(id_member);
                model.setId_buku((String) tabelBuku.getValueAt(i, 0));
                model.setHarga_jual((Integer) tabelBuku.getValueAt(i, 2));
                String q = (String) tabelBuku.getValueAt(i, 3);
                int kuantitas = Integer.parseInt(q);
                model.setKuantitas(kuantitas);
                int total = (Integer) tabelBuku.getValueAt(i, 4);
                model.setTotal(total);

                try {
                    model.insertJualBeliKasir();
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

    public void updateJualBeli(JualBeliView view) {

        if (view.getTabelJualBeli().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/buku yang akan dihapus");
        } else {
            Integer id_jualbeli = Integer.parseInt(view.getInputId_jualbeli().getText());
            Date tanggal_jualbeli = (Date) view.getInputTanggal_jualbeli().getValue();
            String id_member = view.getInputId_member().getText();
            String id_buku = view.getInputId_buku().getText();
            Integer harga_jual = Integer.parseInt(view.getInputHarga_jual().getText());
            Integer kuantitas = Integer.parseInt(view.getInputKuantitas().getText());
            Integer total = Integer.parseInt(view.getInputTotal().getText());


            if (id_member.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "ID Member masih kosong");
            } else if (id_member.length() > 10) {
                JOptionPane.showMessageDialog(view, "ID Member tidak boleh lebih dari 10 karakter");
            } else if (id_buku.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "ID Buku masih kosong");
            } else if (id_buku.length() > 30) {
                JOptionPane.showMessageDialog(view, "ID Buku tidak boleh lebih dari 30 karakter");
            } else {
                model.setId_jualbeli(id_jualbeli);
                model.setId_buku(id_buku);
                model.setId_member(id_member);
                model.setTanggal_jualbeli(tanggal_jualbeli);
                model.setHarga_jual(harga_jual);
                model.setKuantitas(kuantitas);
                model.setTotal(total);

                try {
                    model.updateJualBeli();
                    JOptionPane.showMessageDialog(view, "Data Penjualan berhasil diubah");
                    model.resetJualBeli();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }

    public void deleteJualBeli(JualBeliView view) {

        if (view.getTabelJualBeli().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/jualbeli yang akan dihapus");
        } else {
            if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus data JualBeli ini?") == JOptionPane.OK_OPTION) {
                Integer id_jualbeli = Integer.parseInt(view.getInputId_jualbeli().getText());
                model.setId_jualbeli(id_jualbeli);
                try {
                    model.deleteJualBeli();
                    JOptionPane.showMessageDialog(view, "Data Penjualan berhasil dihapus");
                    model.resetJualBeli();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }
}
