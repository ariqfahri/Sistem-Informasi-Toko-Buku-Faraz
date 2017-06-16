/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.controller;

import faraz.database.AdminDatabase;
import faraz.entity.Admin;
import faraz.error.AdminException;
import faraz.service.AdminDao;
import faraz.view.PasswordAdminView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author M. Ariq Fakhrizal
 */
public class GantiPassword {
    
    public void updateAkun(PasswordAdminView view, String username, String pass_lama, String pass_baru, String pass_konfirmasi) {
        
        Admin admin = new Admin();
        
        System.out.println("username " + username);
        System.out.println("lama " + pass_lama);
        System.out.println("baru " + pass_baru);
        System.out.println("konfirmasi " + pass_konfirmasi);
        try {
            AdminDao dao = AdminDatabase.getAdminDao();
            try {
                admin = dao.getAdmin(username);
                
                if (username.trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Username masih kosong");
                } else if (pass_lama.trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Password lama masih kosong");
                } else if (pass_baru.trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Password baru masih kosong");
                } else if (pass_konfirmasi.trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Konfirmasi password masih kosong");
                } else if (pass_baru.equals(pass_konfirmasi) && pass_lama.equals(admin.getPassword())) {
                    admin.setId_admin(username);
                    admin.setPassword(pass_baru);
                    dao.update(admin);
                    JOptionPane.showMessageDialog(null, "Ubah password berhasil");
                    view.dispose();
                } else {
                    view.labelValidasi.setText("Kesalahan!! Pastikan seluruh form diisi dengan benar");
                    view.inputUsername.setText("");
                    view.inputPassword_lama.setText("");
                    view.inputPassword_baru.setText("");
                    view.inputPassword_konfirmasi.setText("");
                }
            } catch (AdminException ex) {
                
                view.labelValidasi.setText("Data dengan username "+ username + "tidak ditemukan");
                    
                Logger.getLogger(PasswordAdminView.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        } catch (SQLException ex) {
        }
    }
}
