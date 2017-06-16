/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.controller;

import faraz.model.BukuModel;
import faraz.view.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author FAM
 */
public class MengelolaBuku {

    private BukuModel model;

    public void setModel(BukuModel model) {
        this.model = model;
    }

    public void resetBuku(BukuView view) {
        model.resetBuku();
    }

    public void resetBuku(BukuKasirView view) {
        model.resetBuku();
    }
    
    public void getBuku(PinjamKasirView view) {
        String id_buku = view.getInputId_buku().getText();

        if (id_buku.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Buku masih kosong");
        } else if (id_buku.length() > 30) {
            JOptionPane.showMessageDialog(view, "ID Buku tidak boleh lebih dari 30 karakter");
        } else {
            model.setId_buku(id_buku);

            try {
                model.getBuku();
                JOptionPane.showMessageDialog(view, "Data Buku baru berhasil disimpan");
                model.resetPinjamKasir();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi error di database dengan pesan :",
                            throwable.getMessage()});
            }
        }
    }

    public void insertBuku(BukuView view) {

        String id_buku          = view.getInputId_buku().getText();
        String id_penerbit      = view.getInputId_penerbit().getText();
        Date tanggal_buku       = new Date();
        String judul_buku       = view.getInputJudul_buku().getText();
        String pengarang        = view.getInputPengarang().getText();
        Integer jumlah_buku     = Integer.parseInt(view.getInputJumlah_buku().getText());
        Integer jumlah_tersedia = jumlah_buku;
        Integer jumlah_dipinjam = 0;
        Integer harga_jual      = Integer.parseInt(view.getInputHarga_jual().getText());
        Integer harga_pinjam    = Integer.parseInt(view.getInputHarga_pinjam().getText());
        Integer harga_baca      = Integer.parseInt(view.getInputHarga_baca().getText());
        Integer counter         = 0;

        if (id_buku.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Buku masih kosong");
        } else if (id_buku.length() > 30) {
            JOptionPane.showMessageDialog(view, "ID Buku tidak boleh lebih dari 30 karakter");
        } else if (id_penerbit.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Penerbit masih kosong");
        } else if (id_penerbit.length() > 3) {
            JOptionPane.showMessageDialog(view, "ID Penerbit tidak boleh lebih dari 3 karakter");
        } else if (judul_buku.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Judul Buku masih kosong");
        } else if (judul_buku.length() > 50) {
            JOptionPane.showMessageDialog(view, "Judul Buku tidak boleh lebih dari 50 karakter");
        } else if (pengarang.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Pengarang masih kosong");
        } else if (pengarang.length() > 30) {
            JOptionPane.showMessageDialog(view, "Pengarang tidak boleh lebih dari 30 karakter");
        } else if (String.valueOf(jumlah_buku).trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Jumlah Buku masih kosong");
        } else if (String.valueOf(jumlah_buku).length() > 3) {
            JOptionPane.showMessageDialog(view, "Jumlah Buku tidak boleh lebih dari 3 digit");
        } else if (String.valueOf(harga_jual).trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Harga Jual masih kosong");
        } else if (String.valueOf(harga_jual).length() > 5) {
            JOptionPane.showMessageDialog(view, "Harga Jual tidak boleh lebih dari 6 digit");
        } else if (String.valueOf(harga_pinjam).trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Harga Jual masih kosong");
        } else if (String.valueOf(harga_pinjam).length() > 5) {
            JOptionPane.showMessageDialog(view, "Harga Jual tidak boleh lebih dari 5 digit");
        } else if (String.valueOf(harga_baca).trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Harga Jual masih kosong");
        } else if (String.valueOf(harga_baca).length() > 5) {
            JOptionPane.showMessageDialog(view, "Harga Jual tidak boleh lebih dari 5 digit");
        } else {
            model.setId_buku(id_buku);
            model.setId_penerbit(id_penerbit);
            model.setTanggal_buku(tanggal_buku);
            model.setJudul_buku(judul_buku);
            model.setPengarang(pengarang);
            model.setJumlah_buku(jumlah_buku);
            model.setJumlah_tersedia(jumlah_tersedia);
            model.setJumlah_dipinjam(jumlah_dipinjam);
            model.setHarga_jual(harga_jual);
            model.setHarga_pinjam(harga_pinjam);
            model.setHarga_baca(harga_baca);
            model.setCounter(counter);

            try {
                model.insertBuku();
                JOptionPane.showMessageDialog(view, "Data Buku baru berhasil disimpan");
                model.resetBuku();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi error di database dengan pesan :",
                            throwable.getMessage()});
            }
        }
    }

    public void insertBuku(BukuKasirView view) {

        String id_buku          = view.getInputId_buku().getText();
        String id_penerbit      = view.getInputId_penerbit().getText();
        Date tanggal_buku       = new Date();
        String judul_buku       = view.getInputJudul_buku().getText();
        String pengarang        = view.getInputPengarang().getText();
        Integer jumlah_buku     = Integer.parseInt(view.getInputJumlah_buku().getText());
        Integer jumlah_tersedia = jumlah_buku;
        Integer jumlah_dipinjam = 0;
        Integer harga_jual      = Integer.parseInt(view.getInputHarga_jual().getText());
        Integer harga_pinjam    = Integer.parseInt(view.getInputHarga_pinjam().getText());
        Integer harga_baca      = Integer.parseInt(view.getInputHarga_baca().getText());
        Integer counter         = 0;

        if (id_buku.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Buku masih kosong");
        } else if (id_buku.length() > 30) {
            JOptionPane.showMessageDialog(view, "ID Buku tidak boleh lebih dari 30 karakter");
        } else if (id_penerbit.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Penerbit masih kosong");
        } else if (id_penerbit.length() > 3) {
            JOptionPane.showMessageDialog(view, "ID Penerbit tidak boleh lebih dari 3 karakter");
        } else if (judul_buku.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Judul Buku masih kosong");
        } else if (judul_buku.length() > 50) {
            JOptionPane.showMessageDialog(view, "Judul Buku tidak boleh lebih dari 50 karakter");
        } else if (pengarang.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Pengarang masih kosong");
        } else if (pengarang.length() > 30) {
            JOptionPane.showMessageDialog(view, "Pengarang tidak boleh lebih dari 30 karakter");
        } else if (String.valueOf(jumlah_buku).trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Jumlah Buku masih kosong");
        } else if (String.valueOf(jumlah_buku).length() > 3) {
            JOptionPane.showMessageDialog(view, "Jumlah Buku tidak boleh lebih dari 3 digit");
        } else if (String.valueOf(harga_pinjam).trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Harga Jual masih kosong");
        } else if (String.valueOf(harga_pinjam).length() > 5) {
            JOptionPane.showMessageDialog(view, "Harga Jual tidak boleh lebih dari 5 digit");
        } else if (String.valueOf(harga_baca).trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Harga Jual masih kosong");
        } else if (String.valueOf(harga_baca).length() > 5) {
            JOptionPane.showMessageDialog(view, "Harga Jual tidak boleh lebih dari 5 digit");
        } else {
            model.setId_buku(id_buku);
            model.setId_penerbit(id_penerbit);
            model.setTanggal_buku(tanggal_buku);
            model.setJudul_buku(judul_buku);
            model.setPengarang(pengarang);
            model.setJumlah_buku(jumlah_buku);
            model.setJumlah_tersedia(jumlah_tersedia);
            model.setJumlah_dipinjam(jumlah_dipinjam);
            model.setHarga_jual(harga_jual);
            model.setHarga_pinjam(harga_pinjam);
            model.setHarga_baca(harga_baca);
            model.setCounter(counter);

            try {
                model.insertBuku();
                JOptionPane.showMessageDialog(view, "Data Buku baru berhasil disimpan");
                model.resetBuku();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi error di database dengan pesan :",
                            throwable.getMessage()});
            }
        }
    }
    
    public void updateBuku(BukuView view) {

        if (view.getTabelBuku().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/buku yang akan dihapus");
        } else {
            String id_buku          = view.getInputId_buku().getText();
            String id_penerbit      = view.getInputId_penerbit().getText();
            Date tanggal_buku       = (Date) view.getInputTanggal_buku().getValue();
            String judul_buku       = view.getInputJudul_buku().getText();
            String pengarang        = view.getInputPengarang().getText();
            Integer jumlah_buku     = Integer.parseInt(view.getInputJumlah_buku().getText());
            Integer jumlah_tersedia = jumlah_buku;
            Integer harga_jual      = Integer.parseInt(view.getInputHarga_jual().getText());
            Integer harga_pinjam    = Integer.parseInt(view.getInputHarga_pinjam().getText());
            Integer harga_baca      = Integer.parseInt(view.getInputHarga_baca().getText());

            if (id_buku.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "ID Buku masih kosong");
            } else if (id_buku.length() > 30) {
                JOptionPane.showMessageDialog(view, "ID Buku tidak boleh lebih dari 30 karakter");
            } else if (id_penerbit.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "ID Penerbit masih kosong");
            } else if (id_penerbit.length() > 3) {
                JOptionPane.showMessageDialog(view, "ID Penerbit tidak boleh lebih dari 3 karakter");
            } else if (judul_buku.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Judul Buku masih kosong");
            } else if (judul_buku.length() > 50) {
                JOptionPane.showMessageDialog(view, "Judul Buku tidak boleh lebih dari 50 karakter");
            } else if (pengarang.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Pengarang masih kosong");
            } else if (pengarang.length() > 30) {
                JOptionPane.showMessageDialog(view, "Pengarang tidak boleh lebih dari 30 karakter");
            } else if (String.valueOf(jumlah_buku).trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Jumlah Buku masih kosong");
            } else if (String.valueOf(jumlah_buku).length() > 3) {
                JOptionPane.showMessageDialog(view, "Jumlah Buku tidak boleh lebih dari 3 digit");
            } else if (String.valueOf(harga_jual).trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Harga Jual masih kosong");
            } else if (String.valueOf(harga_jual).length() > 5) {
                JOptionPane.showMessageDialog(view, "Harga Jual tidak boleh lebih dari 6 digit");
            } else if (String.valueOf(harga_pinjam).trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Harga Jual masih kosong");
            } else if (String.valueOf(harga_pinjam).length() > 5) {
                JOptionPane.showMessageDialog(view, "Harga Jual tidak boleh lebih dari 5 digit");
            } else if (String.valueOf(harga_baca).trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Harga Jual masih kosong");
            } else if (String.valueOf(harga_baca).length() > 5) {
                JOptionPane.showMessageDialog(view, "Harga Jual tidak boleh lebih dari 5 digit");
            } else {
                model.setId_buku(id_buku);
                model.setId_penerbit(id_penerbit);
                model.setTanggal_buku(tanggal_buku);
                model.setJudul_buku(judul_buku);
                model.setPengarang(pengarang);
                model.setJumlah_buku(jumlah_buku);
                model.setJumlah_tersedia(jumlah_tersedia);
                model.setHarga_jual(harga_jual);
                model.setHarga_pinjam(harga_pinjam);
                model.setHarga_baca(harga_baca);

                try {
                    model.updateBuku();
                    JOptionPane.showMessageDialog(view, "Data Buku berhasil diubah");
                    model.resetBuku();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }

    public void updateBuku(BukuKasirView view) {

        if (view.getTabelBuku().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/buku yang akan dihapus");
        } else {
            String id_buku          = view.getInputId_buku().getText();
            String id_penerbit      = view.getInputId_penerbit().getText();
            Date tanggal_buku       = (Date) view.getInputTanggal_buku().getValue();
            String judul_buku       = view.getInputJudul_buku().getText();
            String pengarang        = view.getInputPengarang().getText();
            Integer jumlah_buku     = Integer.parseInt(view.getInputJumlah_buku().getText());
            Integer jumlah_tersedia = jumlah_buku;
            Integer harga_jual      = Integer.parseInt(view.getInputHarga_jual().getText());
            Integer harga_pinjam    = Integer.parseInt(view.getInputHarga_pinjam().getText());
            Integer harga_baca      = Integer.parseInt(view.getInputHarga_baca().getText());

            if (id_buku.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "ID Buku masih kosong");
            } else if (id_buku.length() > 30) {
                JOptionPane.showMessageDialog(view, "ID Buku tidak boleh lebih dari 30 karakter");
            } else if (id_penerbit.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "ID Penerbit masih kosong");
            } else if (id_penerbit.length() > 3) {
                JOptionPane.showMessageDialog(view, "ID Penerbit tidak boleh lebih dari 3 karakter");
            } else if (judul_buku.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Judul Buku masih kosong");
            } else if (judul_buku.length() > 50) {
                JOptionPane.showMessageDialog(view, "Judul Buku tidak boleh lebih dari 50 karakter");
            } else if (pengarang.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Pengarang masih kosong");
            } else if (pengarang.length() > 30) {
                JOptionPane.showMessageDialog(view, "Pengarang tidak boleh lebih dari 30 karakter");
            } else if (String.valueOf(jumlah_buku).trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Jumlah Buku masih kosong");
            } else if (String.valueOf(jumlah_buku).length() > 3) {
                JOptionPane.showMessageDialog(view, "Jumlah Buku tidak boleh lebih dari 3 digit");
            } else if (String.valueOf(harga_jual).trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Harga Jual masih kosong");
            } else if (String.valueOf(harga_jual).length() > 5) {
                JOptionPane.showMessageDialog(view, "Harga Jual tidak boleh lebih dari 6 digit");
            } else if (String.valueOf(harga_pinjam).trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Harga Jual masih kosong");
            } else if (String.valueOf(harga_pinjam).length() > 5) {
                JOptionPane.showMessageDialog(view, "Harga Jual tidak boleh lebih dari 5 digit");
            } else if (String.valueOf(harga_baca).trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Harga Jual masih kosong");
            } else if (String.valueOf(harga_baca).length() > 5) {
                JOptionPane.showMessageDialog(view, "Harga Jual tidak boleh lebih dari 5 digit");
            } else {
                model.setId_buku(id_buku);
                model.setId_penerbit(id_penerbit);
                model.setTanggal_buku(tanggal_buku);
                model.setJudul_buku(judul_buku);
                model.setPengarang(pengarang);
                model.setJumlah_buku(jumlah_buku);
                model.setJumlah_tersedia(jumlah_tersedia);
                model.setHarga_jual(harga_jual);
                model.setHarga_pinjam(harga_pinjam);
                model.setHarga_baca(harga_baca);

                try {
                    model.updateBuku();
                    JOptionPane.showMessageDialog(view, "Data Buku berhasil diubah");
                    model.resetBuku();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }
    
    public void updatePinjamBukuKasir(PinjamKasirView view) {

        JTable tabelBuku = view.getTabelBuku();
        int rowCounts = tabelBuku.getRowCount();
        String id_member = view.getInputId_member().getText();

        if (rowCounts == 0) {
            JOptionPane.showMessageDialog(view, "Tabel peminjaman masih kosong");
        } else if (id_member.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Member masih kosong");
        } else if (id_member.length() > 10) {
            JOptionPane.showMessageDialog(view, "ID Member tidak boleh lebih dari 10 karakter");
        } else {
            for (int i = 0; i < tabelBuku.getRowCount(); i++) {
                String id_buku = (String) tabelBuku.getValueAt(i, 0);
                model.setId_buku(id_buku);

                try {
                    model.updatePinjamBukuKasir();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
            JOptionPane.showMessageDialog(view, "Data Buku berhasil diubah");
        }
    }
    
    public void updatePinjamBukuKasir(PinjamBacaKasirView view) {
        JTable tabelBuku = view.getTabelBuku();
        int rowCounts = tabelBuku.getRowCount();
        String id_member = view.getInputId_member().getText();

        if (rowCounts == 0) {
            JOptionPane.showMessageDialog(view, "Tabel peminjaman masih kosong");
        } else if (id_member.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Member masih kosong");
        } else if (id_member.length() > 10) {
            JOptionPane.showMessageDialog(view, "ID Member tidak boleh lebih dari 10 karakter");
        } else {
            for (int i = 0; i < tabelBuku.getRowCount(); i++) {
                String id_buku = (String) tabelBuku.getValueAt(i, 0);
                model.setId_buku(id_buku);

                try {
                    model.updatePinjamBukuKasir();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
            JOptionPane.showMessageDialog(view, "Data Buku berhasil diubah");
        }
    }

    public void updatePengembalianBukuKasir(PengembalianKasirView view) {
        JTable tabelPinjam = view.getTabelPinjam();

        for (int i = 0; i < tabelPinjam.getRowCount(); i++) {
            model.setId_buku((String) tabelPinjam.getValueAt(i, 4));

            try {
                model.updatePengembalianBukuKasir();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi error di database dengan pesan :",
                            throwable.getMessage()});
            }
        }
        JOptionPane.showMessageDialog(view, "Data Buku berhasil diubah");
    }

    public void updateJualBeliBukuKasir(JualBeliKasirView view) {
        JTable tabelBuku = view.getTabelBuku();
        int rowCounts = tabelBuku.getRowCount();
        String id_member = view.getInputId_member().getText();

        if (rowCounts == 0) {
            JOptionPane.showMessageDialog(view, "Tabel penjualan masih kosong");
        } else if (id_member.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Member masih kosong");
        } else if (id_member.length() > 10) {
            JOptionPane.showMessageDialog(view, "ID Member tidak boleh lebih dari 10 karakter");
        } else {
            for (int i = 0; i < tabelBuku.getRowCount(); i++) {
                String id_buku = (String) tabelBuku.getValueAt(i, 0);
                model.setId_buku(id_buku);
                String q = (String) tabelBuku.getValueAt(i, 3);
                model.setBantuan(Integer.parseInt(q));

                try {
                    model.updateJualBeliBukuKasir();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
            JOptionPane.showMessageDialog(view, "Data Buku berhasil diubah");
        }
    }

    public void deleteBuku(BukuView view) {

        if (view.getTabelBuku().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/buku yang akan dihapus");
        } else {

            if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus data Buku ini?") == JOptionPane.OK_OPTION) {
                String id_buku = view.getInputId_buku().getText();
                model.setId_buku(id_buku);
                try {
                    model.deleteBuku();
                    JOptionPane.showMessageDialog(view, "Data Buku berhasil dihapus");
                    model.resetBuku();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }
    
    public void deleteBuku(BukuKasirView view) {

        if (view.getTabelBuku().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/buku yang akan dihapus");
        } else {

            if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus data Buku ini?") == JOptionPane.OK_OPTION) {
                String id_buku = view.getInputId_buku().getText();
                model.setId_buku(id_buku);
                try {
                    model.deleteBuku();
                    JOptionPane.showMessageDialog(view, "Data Buku berhasil dihapus");
                    model.resetBuku();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }
}
