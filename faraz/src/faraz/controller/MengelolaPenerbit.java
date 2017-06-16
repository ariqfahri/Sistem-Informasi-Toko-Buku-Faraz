/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.controller;

import faraz.model.PenerbitModel;
import faraz.view.PenerbitKasirView;
import faraz.view.PenerbitView;
import javax.swing.JOptionPane;

/**
 *
 * @author FAM
 */
public class MengelolaPenerbit {

    private PenerbitModel model;

    public void setModel(PenerbitModel model) {
        this.model = model;
    }

    public void resetPenerbit(PenerbitView view) {
        model.resetPenerbit();
    }

    public void resetPenerbit(PenerbitKasirView view) {
        model.resetPenerbit();
    }

    public void insertPenerbit(PenerbitView view) {

        String id_penerbit = view.getInputId_penerbit().getText();
        String nama_penerbit = view.getInputNama_penerbit().getText();

        if (id_penerbit.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Penerbit masih kosong");
        } else if (id_penerbit.length() > 3) {
            JOptionPane.showMessageDialog(view, "ID Penerbit tidak boleh lebih dari 3 karakter");
        } else if (nama_penerbit.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Penerbit masih kosong");
        } else if (nama_penerbit.length() > 30) {
            JOptionPane.showMessageDialog(view, "Nama Penerbit tidak boleh lebih dari 30 karakter");
        } else {
            model.setId_penerbit(id_penerbit);
            model.setNama_penerbit(nama_penerbit);

            try {
                model.insertPenerbit();
                JOptionPane.showMessageDialog(view, "Data Penerbit baru berhasil disimpan");
                model.resetPenerbit();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi error di database dengan pesan :",
                            throwable.getMessage()});
            }
        }
    }

    public void insertPenerbit(PenerbitKasirView view) {

        String id_penerbit = view.getInputId_penerbit().getText();
        String nama_penerbit = view.getInputNama_penerbit().getText();

        if (id_penerbit.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Penerbit masih kosong");
        } else if (id_penerbit.length() > 3) {
            JOptionPane.showMessageDialog(view, "ID Penerbit tidak boleh lebih dari 3 karakter");
        } else if (nama_penerbit.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Penerbit masih kosong");
        } else if (nama_penerbit.length() > 30) {
            JOptionPane.showMessageDialog(view, "Nama Penerbit tidak boleh lebih dari 30 karakter");
        } else {
            model.setId_penerbit(id_penerbit);
            model.setNama_penerbit(nama_penerbit);

            try {
                model.insertPenerbit();
                JOptionPane.showMessageDialog(view, "Data Penerbit baru berhasil disimpan");
                model.resetPenerbit();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi error di database dengan pesan :",
                            throwable.getMessage()});
            }
        }
    }

    public void updatePenerbit(PenerbitView view) {

        if (view.getTabelPenerbit().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/penerbit yang akan dihapus");
        } else {
            String id_penerbit = view.getInputId_penerbit().getText();
            String nama_penerbit = view.getInputNama_penerbit().getText();

            if (id_penerbit.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "ID Penerbit masih kosong");
            } else if (id_penerbit.length() > 3) {
                JOptionPane.showMessageDialog(view, "ID Penerbit tidak boleh lebih dari 3 karakter");
            } else if (nama_penerbit.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Nama Penerbit masih kosong");
            } else if (nama_penerbit.length() > 30) {
                JOptionPane.showMessageDialog(view, "Nama Penerbit tidak boleh lebih dari 30 karakter");
            } else {
                model.setId_penerbit(id_penerbit);
                model.setNama_penerbit(nama_penerbit);

                try {
                    model.updatePenerbit();
                    JOptionPane.showMessageDialog(view, "Data Penerbit berhasil diubah");
                    model.resetPenerbit();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }

    public void updatePenerbit(PenerbitKasirView view) {

        if (view.getTabelPenerbit().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/penerbit yang akan dihapus");
        } else {
            String id_penerbit = view.getInputId_penerbit().getText();
            String nama_penerbit = view.getInputNama_penerbit().getText();

            if (id_penerbit.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "ID Penerbit masih kosong");
            } else if (id_penerbit.length() > 3) {
                JOptionPane.showMessageDialog(view, "ID Penerbit tidak boleh lebih dari 3 karakter");
            } else if (nama_penerbit.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Nama Penerbit masih kosong");
            } else if (nama_penerbit.length() > 30) {
                JOptionPane.showMessageDialog(view, "Nama Penerbit tidak boleh lebih dari 30 karakter");
            } else {
                model.setId_penerbit(id_penerbit);
                model.setNama_penerbit(nama_penerbit);

                try {
                    model.updatePenerbit();
                    JOptionPane.showMessageDialog(view, "Data Penerbit berhasil diubah");
                    model.resetPenerbit();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }

    public void deletePenerbit(PenerbitView view) {

        if (view.getTabelPenerbit().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/penerbit yang akan dihapus");
        } else {

            if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus data Penerbit ini?") == JOptionPane.OK_OPTION) {
                String id_penerbit = view.getInputId_penerbit().getText();
                model.setId_penerbit(id_penerbit);
                try {
                    model.deletePenerbit();
                    JOptionPane.showMessageDialog(view, "Data Penerbit berhasil dihapus");
                    model.resetPenerbit();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }

    public void deletePenerbit(PenerbitKasirView view) {

        if (view.getTabelPenerbit().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/penerbit yang akan dihapus");
        } else {

            if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus data Penerbit ini?") == JOptionPane.OK_OPTION) {
                String id_penerbit = view.getInputId_penerbit().getText();
                model.setId_penerbit(id_penerbit);
                try {
                    model.deletePenerbit();
                    JOptionPane.showMessageDialog(view, "Data Penerbit berhasil dihapus");
                    model.resetPenerbit();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }
}
