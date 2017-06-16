/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.controller;

import faraz.model.MemberModel;
import faraz.view.MemberKasirView;
import faraz.view.MemberView;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author FAM
 */
public class MengelolaMember {

    private MemberModel model;

    public void setModel(MemberModel model) {
        this.model = model;
    }

    public void resetMember(MemberView view) {
        model.resetMember();
    }
    
    public void resetMember(MemberKasirView view) {
        model.resetMember();
    }

    public void insertMember(MemberView view) {

        String id_member = view.getInputId_member().getText();
        Date tanggal_member = new Date();
        String nama = view.getInputNama().getText();
        String alamat = view.getInputAlamat().getText();
        String telepon = view.getInputTelepon().getText();
        String email = view.getInputEmail().getText();

        if (id_member.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Member masih kosong");
        } else if (id_member.length() > 10) {
            JOptionPane.showMessageDialog(view, "ID Member tidak boleh lebih dari 10 karakter");
        } else if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Member masih kosong");
        } else if (nama.length() > 30) {
            JOptionPane.showMessageDialog(view, "Nama Member tidak boleh lebih dari 30 karakter");
        } else if (alamat.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Alamat Member masih kosong");
        } else if (alamat.length() > 50) {
            JOptionPane.showMessageDialog(view, "Alamat Member tidak boleh lebih dari 50 karakter");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else if (email.length() > 30) {
            JOptionPane.showMessageDialog(view, "Email tidak boleh lebih dari 30 karakter");
        } else {
            model.setId_member(id_member);
            model.setTanggal_member(tanggal_member);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setEmail(email);
            model.setTelepon(telepon);

            try {
                model.insertMember();
                JOptionPane.showMessageDialog(view, "Data Member baru berhasil disimpan");
                model.resetMember();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi error di database dengan pesan :",
                            throwable.getMessage()});
            }
        }
    }
    
    public void insertMember(MemberKasirView view) {

        String id_member = view.getInputId_member().getText();
        Date tanggal_member = new Date();
        String nama = view.getInputNama().getText();
        String alamat = view.getInputAlamat().getText();
        String telepon = view.getInputTelepon().getText();
        String email = view.getInputEmail().getText();

        if (id_member.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "ID Member masih kosong");
        } else if (id_member.length() > 10) {
            JOptionPane.showMessageDialog(view, "ID Member tidak boleh lebih dari 10 karakter");
        } else if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Member masih kosong");
        } else if (nama.length() > 30) {
            JOptionPane.showMessageDialog(view, "Nama Member tidak boleh lebih dari 30 karakter");
        } else if (alamat.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Alamat Member masih kosong");
        } else if (alamat.length() > 50) {
            JOptionPane.showMessageDialog(view, "Alamat Member tidak boleh lebih dari 50 karakter");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else if (email.length() > 30) {
            JOptionPane.showMessageDialog(view, "Email tidak boleh lebih dari 30 karakter");
        } else {
            model.setId_member(id_member);
            model.setTanggal_member(tanggal_member);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setEmail(email);
            model.setTelepon(telepon);

            try {
                model.insertMember();
                JOptionPane.showMessageDialog(view, "Data Member baru berhasil disimpan");
                model.resetMember();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                            "Terjadi error di database dengan pesan :",
                            throwable.getMessage()});
            }
        }
    }

    public void updateMember(MemberView view) {

        if (view.getTabelMember().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/member yang akan dihapus");
        } else {
            Date tanggal_member = (Date) view.getInputTanggal_member().getValue();
            String id_member = view.getInputId_member().getText();
            String nama = view.getInputNama().getText();
            String alamat = view.getInputAlamat().getText();
            String telepon = view.getInputTelepon().getText();
            String email = view.getInputEmail().getText();

            if (id_member.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "ID Member masih kosong");
            } else if (id_member.length() > 10) {
                JOptionPane.showMessageDialog(view, "ID Member tidak boleh lebih dari 10 karakter");
            } else if (nama.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Nama Member masih kosong");
            } else if (nama.length() > 30) {
                JOptionPane.showMessageDialog(view, "Nama Member tidak boleh lebih dari 30 karakter");
            } else if (alamat.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Alamat Member masih kosong");
            } else if (alamat.length() > 50) {
                JOptionPane.showMessageDialog(view, "Alamat Member tidak boleh lebih dari 50 karakter");
            } else if (telepon.length() > 12) {
                JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
            } else if (!email.contains("@") || !email.contains(".")) {
                JOptionPane.showMessageDialog(view, "Email tidak valid");
            } else if (email.length() > 30) {
                JOptionPane.showMessageDialog(view, "Email tidak boleh lebih dari 30 karakter");
            } else {
                model.setId_member(id_member);
                model.setNama(nama);
                model.setAlamat(alamat);
                model.setEmail(email);
                model.setTelepon(telepon);
                model.setTanggal_member(tanggal_member);

                try {
                    model.updateMember();
                    JOptionPane.showMessageDialog(view, "Data Member berhasil diubah");
                    model.resetMember();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }

    public void updateMember(MemberKasirView view) {

        if (view.getTabelMember().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/member yang akan dihapus");
        } else {
            Date tanggal_member = (Date) view.getInputTanggal_member().getValue();
            String id_member = view.getInputId_member().getText();
            String nama = view.getInputNama().getText();
            String alamat = view.getInputAlamat().getText();
            String telepon = view.getInputTelepon().getText();
            String email = view.getInputEmail().getText();

            if (id_member.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "ID Member masih kosong");
            } else if (id_member.length() > 10) {
                JOptionPane.showMessageDialog(view, "ID Member tidak boleh lebih dari 10 karakter");
            } else if (nama.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Nama Member masih kosong");
            } else if (nama.length() > 30) {
                JOptionPane.showMessageDialog(view, "Nama Member tidak boleh lebih dari 30 karakter");
            } else if (alamat.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Alamat Member masih kosong");
            } else if (alamat.length() > 50) {
                JOptionPane.showMessageDialog(view, "Alamat Member tidak boleh lebih dari 50 karakter");
            } else if (telepon.length() > 12) {
                JOptionPane.showMessageDialog(view, "Nomor telepon tidak boleh lebih dari 12 digit");
            } else if (!email.contains("@") || !email.contains(".")) {
                JOptionPane.showMessageDialog(view, "Email tidak valid");
            } else if (email.length() > 30) {
                JOptionPane.showMessageDialog(view, "Email tidak boleh lebih dari 30 karakter");
            } else {
                model.setId_member(id_member);
                model.setNama(nama);
                model.setAlamat(alamat);
                model.setEmail(email);
                model.setTelepon(telepon);
                model.setTanggal_member(tanggal_member);

                try {
                    model.updateMember();
                    JOptionPane.showMessageDialog(view, "Data Member berhasil diubah");
                    model.resetMember();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }
    
    public void deleteMember(MemberView view) {

        if (view.getTabelMember().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/member yang akan dihapus");
        } else {
            if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus data Member ini?") == JOptionPane.OK_OPTION) {
                String id_member = view.getInputId_member().getText();
                model.setId_member(id_member);
                try {
                    model.deleteMember();
                    JOptionPane.showMessageDialog(view, "Data Member berhasil dihapus");
                    model.resetMember();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }
    
    public void deleteMember(MemberKasirView view) {

        if (view.getTabelMember().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih dahulu baris/member yang akan dihapus");
        } else {
            if (JOptionPane.showConfirmDialog(view, "Anda yakin ingin menghapus data Member ini?") == JOptionPane.OK_OPTION) {
                String id_member = view.getInputId_member().getText();
                model.setId_member(id_member);
                try {
                    model.deleteMember();
                    JOptionPane.showMessageDialog(view, "Data Member berhasil dihapus");
                    model.resetMember();
                } catch (Throwable throwable) {
                    JOptionPane.showMessageDialog(view, new Object[]{
                                "Terjadi error di database dengan pesan :",
                                throwable.getMessage()});
                }
            }
        }
    }
}
