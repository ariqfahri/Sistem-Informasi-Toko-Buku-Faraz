/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.view;

import faraz.database.BukuDatabase;
import faraz.database.MemberDatabase;
import faraz.database.PinjamDatabase;
import faraz.entity.Buku;
import faraz.entity.Member;
import faraz.entity.Pinjam;
import faraz.error.BukuException;
import faraz.error.MemberException;
import faraz.error.PenerbitException;
import faraz.error.PinjamException;
import faraz.service.BukuDao;
import faraz.service.MemberDao;
import faraz.service.PinjamDao;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author FAM
 */
public class KasirView extends javax.swing.JFrame {

    /**
     * Creates new form KasirView
     */
    public KasirView() throws SQLException, BukuException, MemberException {
        initComponents();
        //btnBaca.hide();
        setTitle("Halaman Kasir - Faraz Information System (FISt)");
        setExtendedState(MAXIMIZED_BOTH);
        ImageIcon img = new ImageIcon("src/faraz/view/images/library.png");
        setIconImage(img.getImage());
        
        //Membuat tanggal
        Format formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        Date tanggal = new Date();
        String stanggal = formatter.format(tanggal);
        labelTanggal.setText(stanggal);        
        
        //7 Buku Terlaris
        List<Buku> buku = new ArrayList<Buku>();
        BukuDao daoBuku = BukuDatabase.getBukuDao();
        try {
            buku = daoBuku.top7Buku();
            for (int i = 0; i < buku.size(); i++) {
                labelTop7Buku.setText
                        (labelTop7Buku.getText() + "<tr><td>" + (i+1) + ". " + buku.get(i).getJudul_buku() + " </td>"
                        + "<td> --> (" + buku.get(i).getCounter() + " kali)</td></tr>");
            }
            labelTop7Buku.setText(labelTop7Buku.getText() + "</table></html>");
        } catch (BukuException ex) {
            Logger.getLogger(KasirView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //10 Buku Terbaru
        List<Buku> newBuku = new ArrayList<Buku>();
        try {
            buku = daoBuku.top7NewBuku();
            for (int i = 0; i < buku.size(); i++) {
                labelTop10NewBuku.setText
                        (labelTop10NewBuku.getText() + "<tr><td>" + (i+1) + ". " + buku.get(i).getJudul_buku() + "</td></tr>");
            }
            labelTop10NewBuku.setText(labelTop10NewBuku.getText() + "</table></html>");
        } catch (BukuException ex) {
            Logger.getLogger(KasirView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //10 Peminjaman Terakhir
        List<Pinjam> pinjam = new ArrayList<Pinjam>();
        PinjamDao daoPinjam = PinjamDatabase.getPinjamDao();
        MemberDao daoMember = MemberDatabase.getMemberDao();
        Buku pinjamBuku = new Buku();
        Member pinjamMember = new Member();
        try {
            pinjam = daoPinjam.top7LastLending();
            for (int i = 0; i < pinjam.size(); i++) {
                pinjamBuku = daoBuku.getBuku(pinjam.get(i).getId_buku());
                pinjamMember = daoMember.getMember(pinjam.get(i).getId_member());
                labelLastLending.setText
                        (labelLastLending.getText() + "<tr><td>" + (i+1) + ". " + pinjamMember.getNama() + " </td>"
                        + "<td> --> "+ pinjamBuku.getJudul_buku() + "</td></tr>");
            }
            labelLastLending.setText(labelLastLending.getText() + "</table></html>");
        } catch (PinjamException ex) {
            Logger.getLogger(KasirView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelParent = new faraz.view.usu.Panel();
        toolbar = new faraz.view.usu.Toolbar();
        jLabel1 = new javax.swing.JLabel();
        btnDataBuku = new faraz.view.usu.Button();
        labePilihanMenu = new faraz.view.usu.Label();
        SeparatorMenu = new javax.swing.JSeparator();
        btnDataMember = new faraz.view.usu.Button();
        btnDataPenerbit = new faraz.view.usu.Button();
        btnPeminjaman = new faraz.view.usu.Button();
        btnPenjualan = new faraz.view.usu.Button();
        btnLoginAdmin = new faraz.view.usu.Button();
        labelKasir = new faraz.view.usu.Label();
        btnPengembalian = new faraz.view.usu.Button();
        btnBaca = new faraz.view.usu.Button();
        labelTop7Buku = new faraz.view.usu.Label();
        labelLastLending = new faraz.view.usu.Label();
        TopTenBuku = new faraz.view.usu.Label();
        SeparatorMenu1 = new javax.swing.JSeparator();
        Top7Lending = new faraz.view.usu.Label();
        SeparatorMenu2 = new javax.swing.JSeparator();
        labelTop10NewBuku = new faraz.view.usu.Label();
        SeparatorMenu3 = new javax.swing.JSeparator();
        Top10NewBuku = new faraz.view.usu.Label();
        labelAbout = new faraz.view.usu.Label();
        recentLending = new faraz.view.usu.Label();
        SeparatorMenu4 = new javax.swing.JSeparator();
        labelTanggal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelParent.setMaximumSize(new java.awt.Dimension(800, 600));
        panelParent.setPreferredSize(new java.awt.Dimension(800, 600));

        toolbar.setBackground(new java.awt.Color(50, 50, 50));
        toolbar.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Selamat Datang di Toko Buku Faraz");
        toolbar.add(jLabel1);

        btnDataBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/buku.png"))); // NOI18N
        btnDataBuku.setText("Data Buku");
        btnDataBuku.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDataBuku.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataBukuActionPerformed(evt);
            }
        });

        labePilihanMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labePilihanMenu.setText("Pilihan Menu");
        labePilihanMenu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnDataMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/memberbaru.png"))); // NOI18N
        btnDataMember.setText("Data Member");
        btnDataMember.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDataMember.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataMemberActionPerformed(evt);
            }
        });

        btnDataPenerbit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/penerbit1.png"))); // NOI18N
        btnDataPenerbit.setText("Data Penerbit");
        btnDataPenerbit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDataPenerbit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDataPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPenerbitActionPerformed(evt);
            }
        });

        btnPeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/peminjaman1.png"))); // NOI18N
        btnPeminjaman.setText("Peminjaman");
        btnPeminjaman.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPeminjaman.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeminjamanActionPerformed(evt);
            }
        });

        btnPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/penjualan.png"))); // NOI18N
        btnPenjualan.setText("Penjualan");
        btnPenjualan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPenjualan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenjualanActionPerformed(evt);
            }
        });

        btnLoginAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/admin1.png"))); // NOI18N
        btnLoginAdmin.setText("Admin Faraz");
        btnLoginAdmin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoginAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginAdminActionPerformed(evt);
            }
        });

        labelKasir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelKasir.setText("Anda sebagai Kasir Toko Buku Faraz");
        labelKasir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelKasir.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        btnPengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/pengembalian.png"))); // NOI18N
        btnPengembalian.setText("Pengembalian");
        btnPengembalian.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPengembalian.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengembalianActionPerformed(evt);
            }
        });

        btnBaca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/baca.png"))); // NOI18N
        btnBaca.setText("Membaca");
        btnBaca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBaca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBacaActionPerformed(evt);
            }
        });

        labelTop7Buku.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTop7Buku.setText("<html><table>");
        labelTop7Buku.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelTop7Buku.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelTop7Buku.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        labelLastLending.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelLastLending.setText("<html><table>");
        labelLastLending.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelLastLending.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelLastLending.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        TopTenBuku.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TopTenBuku.setText("7 Buku Terlaris Dipinjam");
        TopTenBuku.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        Top7Lending.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Top7Lending.setText("7 Peminjaman Terakhir");
        Top7Lending.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        labelTop10NewBuku.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTop10NewBuku.setText("<html>");
        labelTop10NewBuku.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelTop10NewBuku.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelTop10NewBuku.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        Top10NewBuku.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Top10NewBuku.setText("7 Buku Terbaru");
        Top10NewBuku.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        labelAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/faraz.png"))); // NOI18N
        labelAbout.setText("<html>");
        labelAbout.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelAbout.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelAbout.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        recentLending.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        recentLending.setText("Credits");
        recentLending.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        labelTanggal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelTanggal.setForeground(new java.awt.Color(255, 255, 255));
        labelTanggal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout panelParentLayout = new javax.swing.GroupLayout(panelParent);
        panelParent.setLayout(panelParentLayout);
        panelParentLayout.setHorizontalGroup(
            panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelParentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelKasir, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(panelParentLayout.createSequentialGroup()
                .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelParentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBaca, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDataPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDataMember, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDataBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoginAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTop7Buku)
                            .addComponent(labelTop10NewBuku)
                            .addComponent(SeparatorMenu1)
                            .addComponent(SeparatorMenu3)
                            .addComponent(Top10NewBuku, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                            .addComponent(TopTenBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelParentLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(recentLending, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelLastLending, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelParentLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Top7Lending, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SeparatorMenu2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(SeparatorMenu4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelAbout, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(panelParentLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SeparatorMenu)
                            .addComponent(labePilihanMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12))
        );
        panelParentLayout.setVerticalGroup(
            panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParentLayout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labePilihanMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TopTenBuku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Top7Lending, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SeparatorMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeparatorMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeparatorMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelLastLending, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelParentLayout.createSequentialGroup()
                        .addComponent(btnPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBaca, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTop7Buku, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelParentLayout.createSequentialGroup()
                        .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDataPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelParentLayout.createSequentialGroup()
                                .addComponent(Top10NewBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SeparatorMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelParentLayout.createSequentialGroup()
                                .addComponent(btnDataMember, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDataBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLoginAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(labelTop10NewBuku)))
                    .addGroup(panelParentLayout.createSequentialGroup()
                        .addComponent(recentLending, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SeparatorMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelAbout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelParent, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelParent, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginAdminActionPerformed
        // TODO add your handling code here:
        LoginAdminView login = new LoginAdminView(this, rootPaneCheckingEnabled);
        login.setVisible(true);
    }//GEN-LAST:event_btnLoginAdminActionPerformed

    private void btnDataMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataMemberActionPerformed
        // TODO add your handling code here:
        MemberKasirView member = new MemberKasirView();
        try {
            member.loadDatabase();
            member.setVisible(true);
        } catch (MemberException ex) {
            Logger.getLogger(BukuView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BukuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDataMemberActionPerformed

    private void btnDataBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataBukuActionPerformed
        // TODO add your handling code here:
        BukuKasirView buku = new BukuKasirView();
        try {
            buku.loadDatabase();
            buku.setVisible(true);
        } catch (BukuException ex) {
            Logger.getLogger(BukuView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BukuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDataBukuActionPerformed

    private void btnDataPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataPenerbitActionPerformed
        // TODO add your handling code here:
        PenerbitKasirView penerbit = new PenerbitKasirView();
        try {
            penerbit.loadDatabase();
            penerbit.setVisible(true);
        } catch (PenerbitException ex) {
            Logger.getLogger(BukuView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BukuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDataPenerbitActionPerformed

    private void btnPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeminjamanActionPerformed
        // TODO add your handling code here:
        PinjamKasirView pinjam = new PinjamKasirView();
        pinjam.setVisible(true);
    }//GEN-LAST:event_btnPeminjamanActionPerformed

    private void btnPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengembalianActionPerformed
        // TODO add your handling code here:
        PengembalianKasirView kembali = new PengembalianKasirView();
        kembali.setVisible(true);
    }//GEN-LAST:event_btnPengembalianActionPerformed

    private void btnPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenjualanActionPerformed
        // TODO add your handling code here:
        JualBeliKasirView jualbeli = new JualBeliKasirView();
        jualbeli.setVisible(true);
    }//GEN-LAST:event_btnPenjualanActionPerformed

    private void btnBacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBacaActionPerformed
        // TODO add your handling code here:
        PinjamBacaKasirView baca = new PinjamBacaKasirView();
        baca.setVisible(true);
    }//GEN-LAST:event_btnBacaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator SeparatorMenu;
    private javax.swing.JSeparator SeparatorMenu1;
    private javax.swing.JSeparator SeparatorMenu2;
    private javax.swing.JSeparator SeparatorMenu3;
    private javax.swing.JSeparator SeparatorMenu4;
    private faraz.view.usu.Label Top10NewBuku;
    private faraz.view.usu.Label Top7Lending;
    private faraz.view.usu.Label TopTenBuku;
    private faraz.view.usu.Button btnBaca;
    private faraz.view.usu.Button btnDataBuku;
    private faraz.view.usu.Button btnDataMember;
    private faraz.view.usu.Button btnDataPenerbit;
    private faraz.view.usu.Button btnLoginAdmin;
    private faraz.view.usu.Button btnPeminjaman;
    private faraz.view.usu.Button btnPengembalian;
    private faraz.view.usu.Button btnPenjualan;
    private javax.swing.JLabel jLabel1;
    private faraz.view.usu.Label labePilihanMenu;
    private faraz.view.usu.Label labelAbout;
    private faraz.view.usu.Label labelKasir;
    private faraz.view.usu.Label labelLastLending;
    private javax.swing.JLabel labelTanggal;
    private faraz.view.usu.Label labelTop10NewBuku;
    private faraz.view.usu.Label labelTop7Buku;
    private faraz.view.usu.Panel panelParent;
    private faraz.view.usu.Label recentLending;
    private faraz.view.usu.Toolbar toolbar;
    // End of variables declaration//GEN-END:variables
}