/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package faraz.view;

import faraz.controller.MengelolaBuku;
import faraz.database.BukuDatabase;
import faraz.entity.Buku;
import faraz.error.*;
import faraz.model.BukuModel;
import faraz.model.TableBukuModel;
import faraz.model.event.BukuListener;
import faraz.service.BukuDao;
import faraz.view.usu.TextBox;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author FAM
 */
public class BukuKasirView extends javax.swing.JFrame implements BukuListener, ListSelectionListener {

    private TableBukuModel tableModel;
    private BukuModel model;
    private MengelolaBuku controller;

    /**
     * Creates new form BukuView2
     */
    public BukuKasirView() {
        tableModel = new TableBukuModel();

        model = new BukuModel();
        model.setListener(this);

        controller = new MengelolaBuku();
        controller.setModel(model);

        initComponents();
        setTitle("Data Buku - Admin Faraz Information System (FISt)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        ImageIcon img = new ImageIcon("src/faraz/view/images/library.png");
        setIconImage(img.getImage());

        tabelBuku.getSelectionModel().addListSelectionListener(this);
        tabelBuku.setModel(tableModel);
        tabelBuku.getTableHeader().setReorderingAllowed(false);
        tabelBuku.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabelBuku.getTableHeader().setBackground(Color.CYAN);
    }

    public JTable getTabelBuku() {
        return tabelBuku;
    }

    public TextBox getInputHarga_jual() {
        return inputHarga_jual;
    }

    public TextBox getInputHarga_baca() {
        return inputHarga_baca;
    }

    public TextBox getInputHarga_pinjam() {
        return inputHarga_pinjam;
    }

    public TextBox getInputId_buku() {
        return inputId_buku;
    }

    public TextBox getInputId_penerbit() {
        return inputId_penerbit;
    }

    public TextBox getInputJudul_buku() {
        return inputJudul_buku;
    }

    public TextBox getInputJumlah_buku() {
        return inputJumlah_buku;
    }

    public TextBox getInputPengarang() {
        return inputPengarang;
    }

    public JFormattedTextField getInputTanggal_buku() {
        return inputTanggal_buku;
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
        labelBarcode = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        tabelBuku = new javax.swing.JTable();
        inputId_buku = new faraz.view.usu.TextBox();
        buttonInsertBuku = new faraz.view.usu.Button();
        buttonUpdateBuku = new faraz.view.usu.Button();
        buttonDeleteBuku = new faraz.view.usu.Button();
        labelPenerbit = new javax.swing.JLabel();
        inputId_penerbit = new faraz.view.usu.TextBox();
        inputJudul_buku = new faraz.view.usu.TextBox();
        labelJudul = new javax.swing.JLabel();
        labelPengarang = new javax.swing.JLabel();
        inputPengarang = new faraz.view.usu.TextBox();
        labelJumlah = new javax.swing.JLabel();
        inputJumlah_buku = new faraz.view.usu.TextBox();
        buttonReset = new faraz.view.usu.Button();
        inputHarga_jual = new faraz.view.usu.TextBox();
        labelHargaJual = new javax.swing.JLabel();
        inputTanggal_buku = new javax.swing.JFormattedTextField();
        labelFokusKode_penerbit = new javax.swing.JLabel();
        labelFokusBarcode = new javax.swing.JLabel();
        buttonBack1 = new faraz.view.usu.Button();
        labelHargaPinjam = new javax.swing.JLabel();
        inputHarga_pinjam = new faraz.view.usu.TextBox();
        inputHarga_baca = new faraz.view.usu.TextBox();
        labelHargaBaca = new javax.swing.JLabel();
        toolbar = new faraz.view.usu.Toolbar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelParent.setMaximumSize(new java.awt.Dimension(800, 600));
        panelParent.setPreferredSize(new java.awt.Dimension(800, 600));

        panelMain1.setBackground(new java.awt.Color(50, 50, 50));

        labelBarcode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelBarcode.setForeground(new java.awt.Color(255, 255, 255));
        labelBarcode.setText("ID Buku :");

        tabelBuku.setBackground(new java.awt.Color(50, 50, 50));
        tabelBuku.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabelBuku.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tabelBuku.setForeground(new java.awt.Color(255, 255, 255));
        tabelBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane.setViewportView(tabelBuku);

        inputId_buku.setBackground(new java.awt.Color(50, 50, 50));
        inputId_buku.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputId_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputId_bukuActionPerformed(evt);
            }
        });
        inputId_buku.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputId_bukuFocusGained(evt);
            }
        });

        buttonInsertBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/tambah.png"))); // NOI18N
        buttonInsertBuku.setText("Tambah");
        buttonInsertBuku.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonInsertBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertBukuActionPerformed(evt);
            }
        });

        buttonUpdateBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/update.png"))); // NOI18N
        buttonUpdateBuku.setText("Update");
        buttonUpdateBuku.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonUpdateBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateBukuActionPerformed(evt);
            }
        });

        buttonDeleteBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/hapus.png"))); // NOI18N
        buttonDeleteBuku.setText("Hapus");
        buttonDeleteBuku.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonDeleteBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteBukuActionPerformed(evt);
            }
        });

        labelPenerbit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPenerbit.setForeground(new java.awt.Color(255, 255, 255));
        labelPenerbit.setText("ID Penerbit :");

        inputId_penerbit.setBackground(new java.awt.Color(50, 50, 50));
        inputId_penerbit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputId_penerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputId_penerbitActionPerformed(evt);
            }
        });
        inputId_penerbit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputId_penerbitFocusGained(evt);
            }
        });

        inputJudul_buku.setBackground(new java.awt.Color(50, 50, 50));
        inputJudul_buku.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputJudul_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputJudul_bukuActionPerformed(evt);
            }
        });
        inputJudul_buku.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputJudul_bukuFocusGained(evt);
            }
        });

        labelJudul.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelJudul.setForeground(new java.awt.Color(255, 255, 255));
        labelJudul.setText("Judul :");

        labelPengarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPengarang.setForeground(new java.awt.Color(255, 255, 255));
        labelPengarang.setText("Pengarang :");

        inputPengarang.setBackground(new java.awt.Color(50, 50, 50));
        inputPengarang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputPengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPengarangActionPerformed(evt);
            }
        });
        inputPengarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputPengarangFocusGained(evt);
            }
        });

        labelJumlah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelJumlah.setForeground(new java.awt.Color(255, 255, 255));
        labelJumlah.setText("Jumlah :");

        inputJumlah_buku.setBackground(new java.awt.Color(50, 50, 50));
        inputJumlah_buku.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputJumlah_buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputJumlah_bukuActionPerformed(evt);
            }
        });
        inputJumlah_buku.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputJumlah_bukuFocusGained(evt);
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

        inputHarga_jual.setBackground(new java.awt.Color(50, 50, 50));
        inputHarga_jual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputHarga_jual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputHarga_jualActionPerformed(evt);
            }
        });
        inputHarga_jual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputHarga_jualFocusGained(evt);
            }
        });

        labelHargaJual.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelHargaJual.setForeground(new java.awt.Color(255, 255, 255));
        labelHargaJual.setText("HargaJual :");

        inputTanggal_buku.setEditable(false);
        inputTanggal_buku.setBackground(new java.awt.Color(50, 50, 50));
        inputTanggal_buku.setBorder(null);
        inputTanggal_buku.setForeground(new java.awt.Color(50, 50, 50));
        inputTanggal_buku.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd MMMM yyyy"))));
        inputTanggal_buku.setValue(new java.util.Date());

        labelFokusKode_penerbit.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        labelFokusKode_penerbit.setForeground(new java.awt.Color(255, 255, 255));

        labelFokusBarcode.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        labelFokusBarcode.setForeground(new java.awt.Color(255, 255, 255));

        buttonBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faraz/view/images/kembali.png"))); // NOI18N
        buttonBack1.setText("Kembali");
        buttonBack1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBack1ActionPerformed(evt);
            }
        });

        labelHargaPinjam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelHargaPinjam.setForeground(new java.awt.Color(255, 255, 255));
        labelHargaPinjam.setText("HargaPinjam :");

        inputHarga_pinjam.setBackground(new java.awt.Color(50, 50, 50));
        inputHarga_pinjam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputHarga_pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputHarga_pinjamActionPerformed(evt);
            }
        });
        inputHarga_pinjam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputHarga_pinjamFocusGained(evt);
            }
        });

        inputHarga_baca.setBackground(new java.awt.Color(50, 50, 50));
        inputHarga_baca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inputHarga_baca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputHarga_bacaActionPerformed(evt);
            }
        });
        inputHarga_baca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputHarga_bacaFocusGained(evt);
            }
        });

        labelHargaBaca.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelHargaBaca.setForeground(new java.awt.Color(255, 255, 255));
        labelHargaBaca.setText("HargaBaca :");

        javax.swing.GroupLayout panelMain1Layout = new javax.swing.GroupLayout(panelMain1);
        panelMain1.setLayout(panelMain1Layout);
        panelMain1Layout.setHorizontalGroup(
            panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMain1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelJudul, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelPenerbit, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelBarcode, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelPengarang, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelJumlah, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMain1Layout.createSequentialGroup()
                        .addComponent(inputId_penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelFokusKode_penerbit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelMain1Layout.createSequentialGroup()
                        .addComponent(inputId_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelFokusBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelMain1Layout.createSequentialGroup()
                        .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputJudul_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelMain1Layout.createSequentialGroup()
                                .addComponent(inputJumlah_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelHargaJual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputHarga_jual, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelHargaPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputHarga_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelHargaBaca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputHarga_baca, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputTanggal_buku, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelMain1Layout.createSequentialGroup()
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMain1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane))
                    .addGroup(panelMain1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonBack1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(312, 312, 312)
                        .addComponent(buttonReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonInsertBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUpdateBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDeleteBuku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        panelMain1Layout.setVerticalGroup(
            panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMain1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(inputId_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBarcode)
                    .addComponent(labelFokusBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputId_penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPenerbit))
                    .addComponent(labelFokusKode_penerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(inputJudul_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJudul))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(inputPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPengarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(inputJumlah_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelJumlah)
                    .addComponent(inputHarga_jual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHargaJual)
                    .addComponent(inputHarga_pinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHargaPinjam)
                    .addComponent(inputHarga_baca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHargaBaca)
                    .addComponent(inputTanggal_buku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(buttonDeleteBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUpdateBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonInsertBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonBack1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        toolbar.setBackground(new java.awt.Color(50, 50, 50));
        toolbar.setRollover(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Data Buku");
        toolbar.add(jLabel2);

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
                .addGap(13, 13, 13)
                .addComponent(panelMain1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelParent, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
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

    private void inputId_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputId_bukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputId_bukuActionPerformed

    private void buttonInsertBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertBukuActionPerformed
        // TODO add your handling code here:
        controller.insertBuku(this);
    }//GEN-LAST:event_buttonInsertBukuActionPerformed

    private void buttonUpdateBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateBukuActionPerformed
        // TODO add your handling code here:
        controller.updateBuku(this);
    }//GEN-LAST:event_buttonUpdateBukuActionPerformed

    private void buttonDeleteBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteBukuActionPerformed
        // TODO add your handling code here:
        controller.deleteBuku(this);
    }//GEN-LAST:event_buttonDeleteBukuActionPerformed

    private void inputId_penerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputId_penerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputId_penerbitActionPerformed

    private void inputJudul_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputJudul_bukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJudul_bukuActionPerformed

    private void inputPengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPengarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPengarangActionPerformed

    private void inputJumlah_bukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputJumlah_bukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputJumlah_bukuActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        // TODO add your handling code here:
        controller.resetBuku(this);
    }//GEN-LAST:event_buttonResetActionPerformed

    private void inputHarga_jualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputHarga_jualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputHarga_jualActionPerformed

    private void inputId_bukuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputId_bukuFocusGained
        // TODO add your handling code here:
        labelFokusBarcode.setText("ID Buku tidak dapat di-update, jika terjadi kesalahan hapus dulu data yang dimaksud");
        labelFokusKode_penerbit.setText("");
    }//GEN-LAST:event_inputId_bukuFocusGained

    private void inputId_penerbitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputId_penerbitFocusGained
        // TODO add your handling code here:
        labelFokusBarcode.setText("");
        labelFokusKode_penerbit.setText("ID Penerbit harus ditulis sama dengan ID Penerbit yang terdaftar di Data Penerbit, misal: emk");
    }//GEN-LAST:event_inputId_penerbitFocusGained

    private void inputJumlah_bukuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputJumlah_bukuFocusGained
        // TODO add your handling code here:
        labelFokusBarcode.setText("");
        labelFokusKode_penerbit.setText("");
    }//GEN-LAST:event_inputJumlah_bukuFocusGained

    private void inputHarga_jualFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputHarga_jualFocusGained
        // TODO add your handling code here:
        labelFokusBarcode.setText("");
        labelFokusKode_penerbit.setText("");
    }//GEN-LAST:event_inputHarga_jualFocusGained

    private void inputJudul_bukuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputJudul_bukuFocusGained
        // TODO add your handling code here:
        labelFokusBarcode.setText("");
        labelFokusKode_penerbit.setText("");
    }//GEN-LAST:event_inputJudul_bukuFocusGained

    private void inputPengarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPengarangFocusGained
        // TODO add your handling code here:
        labelFokusBarcode.setText("");
        labelFokusKode_penerbit.setText("");
    }//GEN-LAST:event_inputPengarangFocusGained

    private void buttonBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBack1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_buttonBack1ActionPerformed

    private void inputHarga_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputHarga_pinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputHarga_pinjamActionPerformed

    private void inputHarga_pinjamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputHarga_pinjamFocusGained
        // TODO add your handling code here:
        labelFokusBarcode.setText("");
        labelFokusKode_penerbit.setText("");
    }//GEN-LAST:event_inputHarga_pinjamFocusGained

    private void inputHarga_bacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputHarga_bacaActionPerformed
        // TODO add your handling code here:
        buttonInsertBukuActionPerformed(evt);
    }//GEN-LAST:event_inputHarga_bacaActionPerformed

    private void inputHarga_bacaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputHarga_bacaFocusGained
        // TODO add your handling code here:
        labelFokusBarcode.setText("");
        labelFokusKode_penerbit.setText("");
    }//GEN-LAST:event_inputHarga_bacaFocusGained
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private faraz.view.usu.Button buttonBack1;
    private faraz.view.usu.Button buttonDeleteBuku;
    private faraz.view.usu.Button buttonInsertBuku;
    private faraz.view.usu.Button buttonReset;
    private faraz.view.usu.Button buttonUpdateBuku;
    private faraz.view.usu.TextBox inputHarga_baca;
    private faraz.view.usu.TextBox inputHarga_jual;
    private faraz.view.usu.TextBox inputHarga_pinjam;
    private faraz.view.usu.TextBox inputId_buku;
    private faraz.view.usu.TextBox inputId_penerbit;
    private faraz.view.usu.TextBox inputJudul_buku;
    private faraz.view.usu.TextBox inputJumlah_buku;
    private faraz.view.usu.TextBox inputPengarang;
    private javax.swing.JFormattedTextField inputTanggal_buku;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel labelBarcode;
    private javax.swing.JLabel labelFokusBarcode;
    private javax.swing.JLabel labelFokusKode_penerbit;
    private javax.swing.JLabel labelHargaBaca;
    private javax.swing.JLabel labelHargaJual;
    private javax.swing.JLabel labelHargaPinjam;
    private javax.swing.JLabel labelJudul;
    private javax.swing.JLabel labelJumlah;
    private javax.swing.JLabel labelPenerbit;
    private javax.swing.JLabel labelPengarang;
    private javax.swing.JPanel panelMain1;
    private faraz.view.usu.Panel panelParent;
    private javax.swing.JTable tabelBuku;
    private faraz.view.usu.Toolbar toolbar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(BukuModel model) {
        inputId_buku.setText(model.getId_buku());
        inputId_penerbit.setText(model.getId_penerbit());
        inputTanggal_buku.setValue(model.getTanggal_buku());
        inputJudul_buku.setText(model.getJudul_buku());
        inputPengarang.setText(model.getPengarang());
        inputJumlah_buku.setText(model.getJumlah_buku() + "");
        inputHarga_jual.setText(model.getHarga_jual() + "");
        inputHarga_baca.setText(model.getHarga_baca() + "");
        inputHarga_pinjam.setText(model.getHarga_pinjam() + "");
    }

    @Override
    public void onInsert(Buku buku) {
        tableModel.add(buku);
    }

    @Override
    public void onUpdate(Buku buku) {
        int index = tabelBuku.getSelectedRow();
        tableModel.set(index, buku);
    }

    @Override
    public void onDelete() {
        int index = tabelBuku.getSelectedRow();
        tableModel.remove(index);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        try {
            Buku model = tableModel.get(tabelBuku.getSelectedRow());
            inputId_buku.setText(model.getId_buku());
            inputId_penerbit.setText(model.getId_penerbit());
            inputTanggal_buku.setValue(model.getTanggal_buku());
            inputJudul_buku.setText(model.getJudul_buku());
            inputPengarang.setText(model.getPengarang());
            inputJumlah_buku.setText(model.getJumlah_buku() + "");
            inputHarga_jual.setText(model.getHarga_jual() + "");
            inputHarga_baca.setText(model.getHarga_baca() + "");
            inputHarga_pinjam.setText(model.getHarga_pinjam() + "");
        } catch (IndexOutOfBoundsException exception) {
        }
    }

    public void loadDatabase() throws BukuException, SQLException {
        BukuDao dao = BukuDatabase.getBukuDao();
        tableModel.setList(dao.selectAllBuku());
    }
}
