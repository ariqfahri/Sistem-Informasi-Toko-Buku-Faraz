/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.view;

import faraz.controller.MengelolaPenjualan;
import faraz.database.JualBeliDatabase;
import faraz.entity.JualBeli;
import faraz.error.*;
import faraz.model.JualBeliModel;
import faraz.model.TableJualBeliModel;
import faraz.model.event.JualBeliListener;
import faraz.service.JualBeliDao;
import faraz.view.chart.ChartJualBeli;
import faraz.view.usu.TextBox;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author FAM
 */
public class JualBeliView extends javax.swing.JFrame implements JualBeliListener, ListSelectionListener {

    private TableJualBeliModel tableModel;
    private JualBeliModel model;
    private MengelolaPenjualan controller;
    
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    Map<String, Object> param = new HashMap<String, Object>();
    JualBeliDatabase koneksi = new JualBeliDatabase();

    /**
     * Creates new form JualBeliView2
     */
    public JualBeliView() {
        tableModel = new TableJualBeliModel();

        model = new JualBeliModel();
        model.setListener(this);

        controller = new MengelolaPenjualan();
        controller.setModel(model);

        initComponents();
        setTitle("Data Penjualan - Admin Faraz Information System (FISt)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        ImageIcon img = new ImageIcon("src/faraz/view/images/library.png");
        setIconImage(img.getImage());

        tabelJualBeli.getSelectionModel().addListSelectionListener(this);
        tabelJualBeli.setModel(tableModel);
        tabelJualBeli.getTableHeader().setReorderingAllowed(false);
        tabelJualBeli.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabelJualBeli.getTableHeader().setBackground(Color.CYAN);
    }

    public JTextField getInputHarga_jual() {
        return inputHarga_jual;
    }

    public JTextField getInputKuantitas() {
        return inputKuantitas;
    }

    public JTextField getInputTotal() {
        return inputTotal;
    }

    public JTable getTabelJualBeli() {
        return tabelJualBeli;
    }

    public TextBox getInputId_buku() {
        return inputId_buku;
    }

    public TextBox getInputId_member() {
        return inputId_member;
    }

    public JTextField getInputId_jualbeli() {
        return inputId_jualbeli;
    }

    public JFormattedTextField getInputTanggal_jualbeli() {
        return inputTanggal_jualbeli;
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
        panelMain1 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        tabelJualBeli = new javax.swing.JTable();
        buttonDeleteJualBeli = new faraz.view.usu.Button();
        inputId_member = new faraz.view.usu.TextBox();
        labelId_member = new javax.swing.JLabel();
        labelId_buku = new javax.swing.JLabel();
        inputId_buku = new faraz.view.usu.TextBox();
        buttonReset = new faraz.view.usu.Button();
        inputId_jualbeli = new javax.swing.JTextField();
        inputTanggal_jualbeli = new javax.swing.JFormattedTextField();
        inputHarga_jual = new javax.swing.JTextField();
        inputKuantitas = new javax.swing.JTextField();
        inputTotal = new javax.swing.JTextField();
        buttonLaporan = new faraz.view.usu.Button();
        buttonGrafik = new faraz.view.usu.Button();
        buttonBack1 = new faraz.view.usu.Button();
        toolbar = new faraz.view.usu.Toolbar();
        buttonBerandaView = new faraz.view.usu.Button();
        jLabel4 = new javax.swing.JLabel();
        buttonPenerbitView = new faraz.view.usu.Button();
        jLabel5 = new javax.swing.JLabel();
        buttonBukuView = new faraz.view.usu.Button();
        jLabel6 = new javax.swing.JLabel();
        buttonMemberView = new faraz.view.usu.Button();
        jLabel7 = new javax.swing.JLabel();
        buttonPinjamView = new faraz.view.usu.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelParent.setMaximumSize(new java.awt.Dimension(800, 600));
        panelParent.setPreferredSize(new java.awt.Dimension(800, 600));

        panelMain1.setBackground(new java.awt.Color(50, 50, 50));

        tabelJualBeli.setBackground(new java.awt.Color(50, 50, 50));
        tabelJualBeli.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabelJualBeli.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelJualBeli.setForeground(new java.awt.Color(255, 255, 255));
        tabelJualBeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane.setViewportView(tabelJualBeli);

        buttonDeleteJualBeli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/hapus.png"))); // NOI18N
        buttonDeleteJualBeli.setText("Hapus");
        buttonDeleteJualBeli.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonDeleteJualBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteJualBeliActionPerformed(evt);
            }
        });

        inputId_member.setBackground(new java.awt.Color(50, 50, 50));
        inputId_member.setEditable(false);
        inputId_member.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputId_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputId_memberActionPerformed(evt);
            }
        });

        labelId_member.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelId_member.setForeground(new java.awt.Color(255, 255, 255));
        labelId_member.setText("ID Member :");

        labelId_buku.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelId_buku.setForeground(new java.awt.Color(255, 255, 255));
        labelId_buku.setText("ID Buku :");

        inputId_buku.setBackground(new java.awt.Color(50, 50, 50));
        inputId_buku.setEditable(false);
        inputId_buku.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputId_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputId_bukuActionPerformed(evt);
            }
        });

        buttonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/reset.png"))); // NOI18N
        buttonReset.setText("Reset");
        buttonReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        inputId_jualbeli.setBackground(new java.awt.Color(50, 50, 50));
        inputId_jualbeli.setEditable(false);
        inputId_jualbeli.setForeground(new java.awt.Color(50, 50, 50));
        inputId_jualbeli.setBorder(null);
        inputId_jualbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputId_jualbeliActionPerformed(evt);
            }
        });

        inputTanggal_jualbeli.setBackground(new java.awt.Color(50, 50, 50));
        inputTanggal_jualbeli.setBorder(null);
        inputTanggal_jualbeli.setEditable(false);
        inputTanggal_jualbeli.setForeground(new java.awt.Color(50, 50, 50));
        inputTanggal_jualbeli.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));

        inputHarga_jual.setBackground(new java.awt.Color(50, 50, 50));
        inputHarga_jual.setEditable(false);
        inputHarga_jual.setForeground(new java.awt.Color(50, 50, 50));
        inputHarga_jual.setBorder(null);
        inputHarga_jual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputHarga_jualActionPerformed(evt);
            }
        });

        inputKuantitas.setBackground(new java.awt.Color(50, 50, 50));
        inputKuantitas.setEditable(false);
        inputKuantitas.setForeground(new java.awt.Color(50, 50, 50));
        inputKuantitas.setBorder(null);
        inputKuantitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputKuantitasActionPerformed(evt);
            }
        });

        inputTotal.setBackground(new java.awt.Color(50, 50, 50));
        inputTotal.setEditable(false);
        inputTotal.setForeground(new java.awt.Color(50, 50, 50));
        inputTotal.setBorder(null);
        inputTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTotalActionPerformed(evt);
            }
        });

        buttonLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/laporan.png"))); // NOI18N
        buttonLaporan.setText("Cetak Laporan");
        buttonLaporan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLaporanActionPerformed(evt);
            }
        });

        buttonGrafik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/chart.png"))); // NOI18N
        buttonGrafik.setText("Lihat Grafik");
        buttonGrafik.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonGrafik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGrafikActionPerformed(evt);
            }
        });

        buttonBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/kembali.png"))); // NOI18N
        buttonBack1.setText("Kembali");
        buttonBack1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMain1Layout = new javax.swing.GroupLayout(panelMain1);
        panelMain1.setLayout(panelMain1Layout);
        panelMain1Layout.setHorizontalGroup(
            panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMain1Layout.createSequentialGroup()
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMain1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane))
                    .addGroup(panelMain1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonGrafik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(275, 275, 275)
                        .addComponent(buttonBack1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDeleteJualBeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
            .addGroup(panelMain1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMain1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(labelId_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputId_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputHarga_jual, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputKuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMain1Layout.createSequentialGroup()
                        .addComponent(labelId_member)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputId_member, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inputId_jualbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTanggal_jualbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMain1Layout.setVerticalGroup(
            panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMain1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId_member)
                    .addComponent(inputId_member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputId_jualbeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTanggal_jualbeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId_buku)
                    .addComponent(inputId_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputHarga_jual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputKuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonGrafik, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDeleteJualBeli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buttonBack1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(buttonReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonLaporan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        toolbar.setBackground(new java.awt.Color(50, 50, 50));
        toolbar.setRollover(true);

        buttonBerandaView.setBackground(new java.awt.Color(0, 0, 0));
        buttonBerandaView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/admin1.png"))); // NOI18N
        buttonBerandaView.setText("Beranda Admin");
        buttonBerandaView.setFocusable(false);
        buttonBerandaView.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonBerandaView.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonBerandaView.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        buttonBerandaView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBerandaViewActionPerformed(evt);
            }
        });
        toolbar.add(buttonBerandaView);

        jLabel4.setText("..");
        toolbar.add(jLabel4);

        buttonPenerbitView.setBackground(new java.awt.Color(0, 0, 0));
        buttonPenerbitView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/penerbit1.png"))); // NOI18N
        buttonPenerbitView.setText("Data Penerbit");
        buttonPenerbitView.setFocusable(false);
        buttonPenerbitView.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonPenerbitView.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonPenerbitView.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        buttonPenerbitView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPenerbitViewActionPerformed(evt);
            }
        });
        toolbar.add(buttonPenerbitView);

        jLabel5.setText("..");
        toolbar.add(jLabel5);

        buttonBukuView.setBackground(new java.awt.Color(0, 0, 0));
        buttonBukuView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/buku.png"))); // NOI18N
        buttonBukuView.setText("Data Buku");
        buttonBukuView.setFocusable(false);
        buttonBukuView.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonBukuView.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonBukuView.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        buttonBukuView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBukuViewActionPerformed(evt);
            }
        });
        toolbar.add(buttonBukuView);

        jLabel6.setText("..");
        toolbar.add(jLabel6);

        buttonMemberView.setBackground(new java.awt.Color(0, 0, 0));
        buttonMemberView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/memberbaru.png"))); // NOI18N
        buttonMemberView.setText("Data Member");
        buttonMemberView.setFocusable(false);
        buttonMemberView.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonMemberView.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonMemberView.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        buttonMemberView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMemberViewActionPerformed(evt);
            }
        });
        toolbar.add(buttonMemberView);

        jLabel7.setText("..");
        toolbar.add(jLabel7);

        buttonPinjamView.setBackground(new java.awt.Color(0, 0, 0));
        buttonPinjamView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/peminjaman1.png"))); // NOI18N
        buttonPinjamView.setText("Data Peminjaman");
        buttonPinjamView.setFocusable(false);
        buttonPinjamView.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonPinjamView.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonPinjamView.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        buttonPinjamView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPinjamViewActionPerformed(evt);
            }
        });
        toolbar.add(buttonPinjamView);

        javax.swing.GroupLayout panelParentLayout = new javax.swing.GroupLayout(panelParent);
        panelParent.setLayout(panelParentLayout);
        panelParentLayout.setHorizontalGroup(
            panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParentLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(panelMain1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelParentLayout.setVerticalGroup(
            panelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParentLayout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(panelMain1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelParent, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDeleteJualBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteJualBeliActionPerformed
        // TODO add your handling code here:
        controller.deleteJualBeli(this);
    }//GEN-LAST:event_buttonDeleteJualBeliActionPerformed

    private void inputId_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputId_memberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputId_memberActionPerformed

    private void inputId_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputId_bukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputId_bukuActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        // TODO add your handling code here:
        controller.resetJualBeli(this);
    }//GEN-LAST:event_buttonResetActionPerformed

    private void buttonBerandaViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBerandaViewActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AdminView().setVisible(true);
    }//GEN-LAST:event_buttonBerandaViewActionPerformed

    private void buttonPenerbitViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPenerbitViewActionPerformed
        // TODO add your handling code here:
        this.dispose();
        PenerbitView penerbit = new PenerbitView();
        try {
            penerbit.loadDatabase();
            penerbit.setVisible(true);
        } catch (PenerbitException ex) {
            Logger.getLogger(JualBeliView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JualBeliView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonPenerbitViewActionPerformed

    private void buttonBukuViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBukuViewActionPerformed
        // TODO add your handling code here:
        this.dispose();
        BukuView buku = new BukuView();
        try {
            buku.loadDatabase();
            buku.setVisible(true);
        } catch (BukuException ex) {
            Logger.getLogger(JualBeliView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JualBeliView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonBukuViewActionPerformed

    private void buttonMemberViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMemberViewActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MemberView member = new MemberView();
        try {
            member.loadDatabase();
            member.setVisible(true);
        } catch (MemberException ex) {
            Logger.getLogger(JualBeliView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JualBeliView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonMemberViewActionPerformed

    private void buttonPinjamViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPinjamViewActionPerformed
        // TODO add your handling code here:
        this.dispose();
        PinjamView pinjam = new PinjamView();
        try {
            pinjam.loadDatabase();
            pinjam.setVisible(true);
        } catch (PinjamException ex) {
            Logger.getLogger(JualBeliView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JualBeliView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonPinjamViewActionPerformed

    private void inputId_jualbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputId_jualbeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputId_jualbeliActionPerformed

    private void inputHarga_jualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputHarga_jualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputHarga_jualActionPerformed

    private void inputKuantitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputKuantitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputKuantitasActionPerformed

    private void inputTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTotalActionPerformed

    private void buttonLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLaporanActionPerformed
        // TODO add your handling code here:
        try {
            File file = new File("src/faraz/view/laporan/LaporanJualBeli.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            param.clear();
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, param, koneksi.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_buttonLaporanActionPerformed

    private void buttonGrafikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGrafikActionPerformed
        // TODO add your handling code here:
        ChartJualBeli grafik = new ChartJualBeli();
        try {
            grafik.main(null);
        } catch (SQLException ex) {
            Logger.getLogger(JualBeliView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JualBeliException ex) {
            Logger.getLogger(JualBeliView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonGrafikActionPerformed

    private void buttonBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBack1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AdminView().setVisible(true);
    }//GEN-LAST:event_buttonBack1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private faraz.view.usu.Button buttonBack1;
    private faraz.view.usu.Button buttonBerandaView;
    private faraz.view.usu.Button buttonBukuView;
    private faraz.view.usu.Button buttonDeleteJualBeli;
    private faraz.view.usu.Button buttonGrafik;
    private faraz.view.usu.Button buttonLaporan;
    private faraz.view.usu.Button buttonMemberView;
    private faraz.view.usu.Button buttonPenerbitView;
    private faraz.view.usu.Button buttonPinjamView;
    private faraz.view.usu.Button buttonReset;
    private javax.swing.JTextField inputHarga_jual;
    private faraz.view.usu.TextBox inputId_buku;
    private javax.swing.JTextField inputId_jualbeli;
    private faraz.view.usu.TextBox inputId_member;
    private javax.swing.JTextField inputKuantitas;
    private javax.swing.JFormattedTextField inputTanggal_jualbeli;
    private javax.swing.JTextField inputTotal;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labelId_buku;
    private javax.swing.JLabel labelId_member;
    private javax.swing.JPanel panelMain1;
    private faraz.view.usu.Panel panelParent;
    private javax.swing.JTable tabelJualBeli;
    private faraz.view.usu.Toolbar toolbar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(JualBeliModel model) {
        inputId_jualbeli.setText(model.getId_jualbeli() + "");
        inputTanggal_jualbeli.setValue(model.getTanggal_jualbeli());
        inputId_member.setText(model.getId_member());
        inputId_buku.setText(model.getId_buku());
        inputHarga_jual.setText(model.getHarga_jual() + "");
        inputKuantitas.setText(model.getKuantitas() + "");
        inputTotal.setText(model.getTotal() + "");
    }

    @Override
    public void onInsert(JualBeli jualbeli) {
        tableModel.add(jualbeli);
    }

    @Override
    public void onUpdate(JualBeli jualbeli) {
        int index = tabelJualBeli.getSelectedRow();
        tableModel.set(index, jualbeli);
    }

    @Override
    public void onDelete() {
        int index = tabelJualBeli.getSelectedRow();
        tableModel.remove(index);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        try {
            JualBeli model = tableModel.get(tabelJualBeli.getSelectedRow());
            inputId_jualbeli.setText(model.getId_jualbeli() + "");
            inputTanggal_jualbeli.setValue(model.getTanggal_jualbeli());
            inputId_member.setText(model.getId_member());
            inputId_buku.setText(model.getId_buku());
            inputHarga_jual.setText(model.getHarga_jual() + "");
            inputKuantitas.setText(model.getKuantitas() + "");
            inputTotal.setText(model.getTotal() + "");
        } catch (IndexOutOfBoundsException exception) {
        }
    }

    public void loadDatabase() throws JualBeliException, SQLException {
        JualBeliDao dao = JualBeliDatabase.getJualBeliDao();
        tableModel.setList(dao.selectAllJualBeli());
    }
}