/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.view;

import faraz.controller.MengelolaPeminjaman;
import faraz.database.PinjamDatabase;
import faraz.entity.Pinjam;
import faraz.error.*;
import faraz.model.PinjamModel;
import faraz.model.TablePinjamModel;
import faraz.model.event.PinjamListener;
import faraz.service.PinjamDao;
import faraz.view.chart.ChartPinjam;
import faraz.view.usu.TextBox;
import faraz.view.usu.FormatterBox;
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
public class PinjamView extends javax.swing.JFrame implements PinjamListener, ListSelectionListener {

    private TablePinjamModel tableModel;
    private PinjamModel model;
    private MengelolaPeminjaman controller;
    
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    Map<String, Object> param = new HashMap<String, Object>();
    PinjamDatabase koneksi = new PinjamDatabase();
    
    /**
     * Creates new form PinjamView
     */
    public PinjamView() {
        tableModel = new TablePinjamModel();

        model = new PinjamModel();
        model.setListener(this);

        controller = new MengelolaPeminjaman();
        controller.setModel(model);

        initComponents();
        setTitle("Data Peminjaman - Admin Faraz Information System (FISt)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        ImageIcon img = new ImageIcon("src/faraz/view/images/library.png");
        setIconImage(img.getImage());

        tabelPinjam.getSelectionModel().addListSelectionListener(this);
        tabelPinjam.setModel(tableModel);
        tabelPinjam.getTableHeader().setReorderingAllowed(false);
        tabelPinjam.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabelPinjam.getTableHeader().setBackground(Color.CYAN);
    }

    public TextBox getInputDenda() {
        return inputDenda;
    }

    public JTextField getInputHarga_pinjam() {
        return inputHarga_pinjam;
    }

    public TextBox getInputId_buku() {
        return inputId_buku;
    }

    public TextBox getInputId_member() {
        return inputId_member;
    }

    public JTextField getInputId_pinjam() {
        return inputId_pinjam;
    }

    public FormatterBox getInputTanggal_dikembalikan() {
        return inputTanggal_dikembalikan;
    }

    public JFormattedTextField getInputTanggal_kembali() {
        return inputTanggal_kembali;
    }

    public JFormattedTextField getInputTanggal_pinjam() {
        return inputTanggal_pinjam;
    }

    public JTable getTabelPinjam() {
        return tabelPinjam;
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
        tabelPinjam = new javax.swing.JTable();
        buttonUpdatePinjam = new faraz.view.usu.Button();
        buttonDeletePinjam = new faraz.view.usu.Button();
        inputId_member = new faraz.view.usu.TextBox();
        labelId_member = new javax.swing.JLabel();
        labelId_buku = new javax.swing.JLabel();
        inputId_buku = new faraz.view.usu.TextBox();
        labelDenda = new javax.swing.JLabel();
        inputDenda = new faraz.view.usu.TextBox();
        buttonReset = new faraz.view.usu.Button();
        inputId_pinjam = new javax.swing.JTextField();
        inputTanggal_pinjam = new javax.swing.JFormattedTextField();
        inputTanggal_kembali = new javax.swing.JFormattedTextField();
        labelTanggal_dikembalikan = new javax.swing.JLabel();
        inputTanggal_dikembalikan = new faraz.view.usu.FormatterBox();
        inputHarga_pinjam = new javax.swing.JTextField();
        buttonLaporan = new faraz.view.usu.Button();
        buttonGrafik = new faraz.view.usu.Button();
        buttonKembali = new faraz.view.usu.Button();
        toolbar = new faraz.view.usu.Toolbar();
        buttonBerandaView = new faraz.view.usu.Button();
        jLabel4 = new javax.swing.JLabel();
        buttonPenerbitView = new faraz.view.usu.Button();
        jLabel5 = new javax.swing.JLabel();
        buttonBukuView = new faraz.view.usu.Button();
        jLabel6 = new javax.swing.JLabel();
        buttonMemberView = new faraz.view.usu.Button();
        jLabel7 = new javax.swing.JLabel();
        buttonJualBeliView = new faraz.view.usu.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelParent.setMaximumSize(new java.awt.Dimension(800, 600));
        panelParent.setPreferredSize(new java.awt.Dimension(800, 600));

        panelMain1.setBackground(new java.awt.Color(50, 50, 50));

        tabelPinjam.setBackground(new java.awt.Color(50, 50, 50));
        tabelPinjam.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabelPinjam.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelPinjam.setForeground(new java.awt.Color(255, 255, 255));
        tabelPinjam.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane.setViewportView(tabelPinjam);

        buttonUpdatePinjam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/update.png"))); // NOI18N
        buttonUpdatePinjam.setText("Update");
        buttonUpdatePinjam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonUpdatePinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdatePinjamActionPerformed(evt);
            }
        });

        buttonDeletePinjam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/hapus.png"))); // NOI18N
        buttonDeletePinjam.setText("Hapus");
        buttonDeletePinjam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonDeletePinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeletePinjamActionPerformed(evt);
            }
        });

        inputId_member.setEditable(false);
        inputId_member.setBackground(new java.awt.Color(50, 50, 50));
        inputId_member.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputId_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputId_memberActionPerformed(evt);
            }
        });

        labelId_member.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelId_member.setForeground(new java.awt.Color(255, 255, 255));
        labelId_member.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelId_member.setText("ID Member :");

        labelId_buku.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelId_buku.setForeground(new java.awt.Color(255, 255, 255));
        labelId_buku.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelId_buku.setText("ID Buku :");

        inputId_buku.setEditable(false);
        inputId_buku.setBackground(new java.awt.Color(50, 50, 50));
        inputId_buku.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputId_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputId_bukuActionPerformed(evt);
            }
        });

        labelDenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDenda.setForeground(new java.awt.Color(255, 255, 255));
        labelDenda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDenda.setText("Denda   :");

        inputDenda.setBackground(new java.awt.Color(50, 50, 50));
        inputDenda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputDenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDendaActionPerformed(evt);
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

        inputId_pinjam.setEditable(false);
        inputId_pinjam.setBackground(new java.awt.Color(50, 50, 50));
        inputId_pinjam.setForeground(new java.awt.Color(50, 50, 50));
        inputId_pinjam.setBorder(null);

        inputTanggal_pinjam.setEditable(false);
        inputTanggal_pinjam.setBackground(new java.awt.Color(50, 50, 50));
        inputTanggal_pinjam.setBorder(null);
        inputTanggal_pinjam.setForeground(new java.awt.Color(50, 50, 50));
        inputTanggal_pinjam.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));

        inputTanggal_kembali.setEditable(false);
        inputTanggal_kembali.setBackground(new java.awt.Color(50, 50, 50));
        inputTanggal_kembali.setBorder(null);
        inputTanggal_kembali.setForeground(new java.awt.Color(50, 50, 50));
        inputTanggal_kembali.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));

        labelTanggal_dikembalikan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelTanggal_dikembalikan.setForeground(new java.awt.Color(255, 255, 255));
        labelTanggal_dikembalikan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTanggal_dikembalikan.setText("Tgl Dikembalikan :");

        inputTanggal_dikembalikan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputTanggal_dikembalikan.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));

        inputHarga_pinjam.setBackground(new java.awt.Color(50, 50, 50));
        inputHarga_pinjam.setForeground(new java.awt.Color(50, 50, 50));
        inputHarga_pinjam.setBorder(null);
        inputHarga_pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputHarga_pinjamActionPerformed(evt);
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

        buttonKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/kembali.png"))); // NOI18N
        buttonKembali.setText("Kembali");
        buttonKembali.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKembaliActionPerformed(evt);
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
                        .addGap(178, 178, 178)
                        .addComponent(buttonKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUpdatePinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDeletePinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
            .addGroup(panelMain1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelId_member, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTanggal_dikembalikan, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputTanggal_dikembalikan, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(inputId_member, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelId_buku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputDenda, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelMain1Layout.createSequentialGroup()
                        .addComponent(inputId_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputId_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTanggal_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTanggal_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputHarga_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMain1Layout.setVerticalGroup(
            panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMain1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelId_member)
                    .addComponent(inputId_member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelId_buku)
                    .addComponent(inputId_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputId_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTanggal_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTanggal_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputHarga_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTanggal_dikembalikan)
                    .addComponent(inputTanggal_dikembalikan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDenda)
                    .addComponent(inputDenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(buttonDeletePinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdatePinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonGrafik, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        toolbar.setBackground(new java.awt.Color(50, 50, 50));
        toolbar.setRollover(true);

        buttonBerandaView.setBackground(new java.awt.Color(0, 0, 0));
        buttonBerandaView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/admin1.png"))); // NOI18N
        buttonBerandaView.setText("Beranda Admin");
        buttonBerandaView.setFocusable(false);
        buttonBerandaView.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonBerandaView.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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

        buttonJualBeliView.setBackground(new java.awt.Color(0, 0, 0));
        buttonJualBeliView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/penjualan.png"))); // NOI18N
        buttonJualBeliView.setText("Data Penjualan");
        buttonJualBeliView.setFocusable(false);
        buttonJualBeliView.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonJualBeliView.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonJualBeliView.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        buttonJualBeliView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonJualBeliViewActionPerformed(evt);
            }
        });
        toolbar.add(buttonJualBeliView);

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
                .addComponent(panelParent, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
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

    private void buttonUpdatePinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdatePinjamActionPerformed
        // TODO add your handling code here:
        controller.updatePinjam(this);
    }//GEN-LAST:event_buttonUpdatePinjamActionPerformed

    private void buttonDeletePinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeletePinjamActionPerformed
        // TODO add your handling code here:
        controller.deletePinjam(this);
    }//GEN-LAST:event_buttonDeletePinjamActionPerformed

    private void inputId_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputId_memberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputId_memberActionPerformed

    private void inputId_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputId_bukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputId_bukuActionPerformed

    private void inputDendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDendaActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        // TODO add your handling code here:
        controller.resetPinjam(this);
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
            Logger.getLogger(PinjamView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PinjamView.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PinjamView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PinjamView.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PinjamView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PinjamView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonMemberViewActionPerformed

    private void buttonJualBeliViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonJualBeliViewActionPerformed
        // TODO add your handling code here:
        this.dispose();
        JualBeliView jualbeli = new JualBeliView();
        try {
            jualbeli.loadDatabase();
            jualbeli.setVisible(true);
        } catch (JualBeliException ex) {
            Logger.getLogger(PinjamView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PinjamView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonJualBeliViewActionPerformed

    private void inputHarga_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputHarga_pinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputHarga_pinjamActionPerformed

    private void buttonLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLaporanActionPerformed
        // TODO add your handling code here:
        try {
            File file = new File("src/faraz/view/laporan/LaporanPeminjaman.jrxml");
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
        ChartPinjam grafik = new ChartPinjam();
        try {
            grafik.main(null);
        } catch (SQLException ex) {
            Logger.getLogger(PinjamView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PinjamException ex) {
            Logger.getLogger(PinjamView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonGrafikActionPerformed

    private void buttonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKembaliActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AdminView().setVisible(true);
    }//GEN-LAST:event_buttonKembaliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private faraz.view.usu.Button buttonBerandaView;
    private faraz.view.usu.Button buttonBukuView;
    private faraz.view.usu.Button buttonDeletePinjam;
    private faraz.view.usu.Button buttonGrafik;
    private faraz.view.usu.Button buttonJualBeliView;
    private faraz.view.usu.Button buttonKembali;
    private faraz.view.usu.Button buttonLaporan;
    private faraz.view.usu.Button buttonMemberView;
    private faraz.view.usu.Button buttonPenerbitView;
    private faraz.view.usu.Button buttonReset;
    private faraz.view.usu.Button buttonUpdatePinjam;
    private faraz.view.usu.TextBox inputDenda;
    private javax.swing.JTextField inputHarga_pinjam;
    private faraz.view.usu.TextBox inputId_buku;
    private faraz.view.usu.TextBox inputId_member;
    private javax.swing.JTextField inputId_pinjam;
    private faraz.view.usu.FormatterBox inputTanggal_dikembalikan;
    private javax.swing.JFormattedTextField inputTanggal_kembali;
    private javax.swing.JFormattedTextField inputTanggal_pinjam;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labelDenda;
    private javax.swing.JLabel labelId_buku;
    private javax.swing.JLabel labelId_member;
    private javax.swing.JLabel labelTanggal_dikembalikan;
    private javax.swing.JPanel panelMain1;
    private faraz.view.usu.Panel panelParent;
    private javax.swing.JTable tabelPinjam;
    private faraz.view.usu.Toolbar toolbar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(PinjamModel model) {
        inputId_pinjam.setText(model.getId_pinjam() + "");
        inputId_member.setText(model.getId_member());
        inputId_buku.setText(model.getId_buku());
        inputTanggal_pinjam.setValue(model.getTanggal_pinjam());
        inputTanggal_kembali.setValue(model.getTanggal_kembali());
        inputTanggal_dikembalikan.setValue(model.getTanggal_dikembalikan());
        inputHarga_pinjam.setText(model.getHarga_pinjam() + "");
        inputDenda.setText(model.getDenda() + "");
    }

    @Override
    public void onInsert(Pinjam pinjam) {
        tableModel.add(pinjam);
    }

    @Override
    public void onUpdate(Pinjam pinjam) {
        int index = tabelPinjam.getSelectedRow();
        tableModel.set(index, pinjam);
    }

    @Override
    public void onDelete() {
        int index = tabelPinjam.getSelectedRow();
        tableModel.remove(index);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        try {
            Pinjam model = tableModel.get(tabelPinjam.getSelectedRow());
            inputId_pinjam.setText(model.getId_pinjam() + "");
            inputId_member.setText(model.getId_member());
            inputId_buku.setText(model.getId_buku());
            inputTanggal_pinjam.setValue(model.getTanggal_pinjam());
            inputTanggal_kembali.setValue(model.getTanggal_kembali());
            inputTanggal_dikembalikan.setValue(model.getTanggal_dikembalikan());
            inputHarga_pinjam.setText(model.getHarga_pinjam() + "");
            inputDenda.setText(model.getDenda() + "");
        } catch (IndexOutOfBoundsException exception) {
        }
    }

    public void loadDatabase() throws PinjamException, SQLException {
        PinjamDao dao = PinjamDatabase.getPinjamDao();
        tableModel.setList(dao.selectAllPinjam());
    }
}
