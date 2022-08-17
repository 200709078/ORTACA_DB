package ssmeb;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public class sForm extends javax.swing.JFrame {

    static String url = "jdbc:sqlite:./src/others//ORTACA_MEB.db";

    static Connection conn = null;
    static ResultSet rs = null, rsFoto = null;
    static Statement st = null;
    static boolean ekle = true;

    static DefaultTableModel modelimMevcut = new DefaultTableModel();
    static Object[] kolonlarMevcut = {"Öğretim Yılı", "Okul Mevcudu", "Değişim Oranı"};
    static Object[] satirlarMevcut = new Object[20];

    static int ek = 0, f = 0;
    private JFrame frame;
    static List listKkodu = new ArrayList<String>();
    static List listKadi = new ArrayList<String>();
    static List lstFotolar = new ArrayList<String>();

    static ImageIcon icon = new ImageIcon("./src/others/jicon.png");

    public sForm() {
        initComponents();
        this.setIconImage(icon.getImage());
        kurumlarAl();
        txtKurumKodu.setText(listKkodu.get(0).toString());
        baglanListele(Integer.toString(Math.abs(Integer.parseInt(txtKurumKodu.getText()))));
        secimCalistir();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSecimGroup = new javax.swing.ButtonGroup();
        prntDialog = new javax.swing.JDialog();
        btnKurumlariYazdir = new javax.swing.JButton();
        rbYazdirFotosuz = new javax.swing.JRadioButton();
        rbYazdirFotolu = new javax.swing.JRadioButton();
        btnYazdirGroup = new javax.swing.ButtonGroup();
        solPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtMerkezeUzakligi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtOgretmenSayisi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtYuzolcumu = new javax.swing.JTextField();
        txtDerslikSayisi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBlokSayisi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtYapimTarihi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtOnarimTarihi = new javax.swing.JTextField();
        btnSonraki = new javax.swing.JButton();
        txtKurumKodu = new javax.swing.JTextField();
        btnOnceki = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbKurumAdi = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbOnarim = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cmbDisBoya = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cmbicBoya = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmbElektrik = new javax.swing.JComboBox<>();
        cmbSu = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cmbSuBaskini = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cmbTuvalet = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbCati = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cmbKapiPencere = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cmbBahce = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMevcut = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        btnMevcutSatirEkle = new javax.swing.JButton();
        btnMevcutSatirSil = new javax.swing.JButton();
        sagAltPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDigerSorunlar = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        taSosyolojik = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbKurum = new javax.swing.JRadioButton();
        rbic = new javax.swing.JRadioButton();
        rbDis = new javax.swing.JRadioButton();
        rbCati = new javax.swing.JRadioButton();
        rbTuvalet = new javax.swing.JRadioButton();
        rbSu = new javax.swing.JRadioButton();
        rbKapiPencere = new javax.swing.JRadioButton();
        rbBahce = new javax.swing.JRadioButton();
        rbSuBaskini = new javax.swing.JRadioButton();
        rbElektrik = new javax.swing.JRadioButton();
        rbKonum = new javax.swing.JRadioButton();
        btnFotoEkle = new javax.swing.JButton();
        btnSonrakiFoto = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGuncelle = new javax.swing.JButton();
        btnKayitEkle = new javax.swing.JButton();
        btnSil = new javax.swing.JButton();
        btnYazdir = new javax.swing.JButton();

        prntDialog.setTitle("made by mADEMatik");
        prntDialog.setResizable(false);

        btnKurumlariYazdir.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnKurumlariYazdir.setText("YAZDIR");
        btnKurumlariYazdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKurumlariYazdirActionPerformed(evt);
            }
        });

        btnYazdirGroup.add(rbYazdirFotosuz);
        rbYazdirFotosuz.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbYazdirFotosuz.setSelected(true);
        rbYazdirFotosuz.setText("Kurumları Yazdır (Fotosuz)");

        btnYazdirGroup.add(rbYazdirFotolu);
        rbYazdirFotolu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbYazdirFotolu.setText("Kurumları Yazdır (Fotolu)");

        javax.swing.GroupLayout prntDialogLayout = new javax.swing.GroupLayout(prntDialog.getContentPane());
        prntDialog.getContentPane().setLayout(prntDialogLayout);
        prntDialogLayout.setHorizontalGroup(
            prntDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prntDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(prntDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKurumlariYazdir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(prntDialogLayout.createSequentialGroup()
                        .addGroup(prntDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rbYazdirFotosuz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbYazdirFotolu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        prntDialogLayout.setVerticalGroup(
            prntDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, prntDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbYazdirFotosuz)
                .addGap(18, 18, 18)
                .addComponent(rbYazdirFotolu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnKurumlariYazdir)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ORTACA MEB");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("sForm1"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        solPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), new java.awt.Color(0, 102, 204))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Merkeze Uzaklığı :");

        txtMerkezeUzakligi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtMerkezeUzakligi.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Öğretmen Sayısı :");

        txtOgretmenSayisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtOgretmenSayisi.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Yüz Ölçümü :");

        txtYuzolcumu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtYuzolcumu.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        txtDerslikSayisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDerslikSayisi.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Derslik Sayısı :");

        txtBlokSayisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtBlokSayisi.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Blok Sayısı :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Yapım Tarihi :");

        txtYapimTarihi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Onarım Tarihi :");

        txtOnarimTarihi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnSonraki.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSonraki.setIcon(new javax.swing.ImageIcon(getClass().getResource("/others/bSonraki.png"))); // NOI18N
        btnSonraki.setBorder(null);
        btnSonraki.setPreferredSize(new java.awt.Dimension(26, 26));
        btnSonraki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSonrakiActionPerformed(evt);
            }
        });

        txtKurumKodu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtKurumKodu.setForeground(new java.awt.Color(255, 51, 51));
        txtKurumKodu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtKurumKodu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKurumKoduKeyPressed(evt);
            }
        });

        btnOnceki.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOnceki.setIcon(new javax.swing.ImageIcon(getClass().getResource("/others/bOnceki.png"))); // NOI18N
        btnOnceki.setBorder(null);
        btnOnceki.setPreferredSize(new java.awt.Dimension(26, 26));
        btnOnceki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOncekiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Kurum Kodu :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Kurum Adı :");

        cmbKurumAdi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbKurumAdi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbKurumAdiKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Onarım Durumu :");

        cmbOnarim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbOnarim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Yok", "Güçlendirme", "Onarım" }));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Dış Boya :");

        cmbDisBoya.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbDisBoya.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("İç Boya :");

        cmbicBoya.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbicBoya.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Su Tesisatı :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Elektrik Tesisatı :");

        cmbElektrik.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbElektrik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));

        cmbSu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbSu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Su Baskını :");

        cmbSuBaskini.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbSuBaskini.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Yok", "Her zaman su baskını var", "Sadece aşırı yağışlı günlerde var" }));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Tuvaletler :");

        cmbTuvalet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbTuvalet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Çatı :");

        cmbCati.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbCati.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Kapı - Pencere :");

        cmbKapiPencere.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbKapiPencere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Bahçe :");

        cmbBahce.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbBahce.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "İyi", "Kötü" }));

        tableMevcut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tableMevcut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Öğretim Yılı", "Okul Mevcudu", "Değişim Oranı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMevcut.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableMevcut.setRowHeight(30);
        tableMevcut.setShowGrid(false);
        tableMevcut.setShowHorizontalLines(true);
        tableMevcut.setShowVerticalLines(true);
        tableMevcut.setSurrendersFocusOnKeystroke(true);
        tableMevcut.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableMevcutFocusLost(evt);
            }
        });
        jScrollPane3.setViewportView(tableMevcut);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("YILLARA GÖRE ÖĞRENCİ SAYILARI");

        btnMevcutSatirEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/others/bEkle.png"))); // NOI18N
        btnMevcutSatirEkle.setMaximumSize(new java.awt.Dimension(38, 38));
        btnMevcutSatirEkle.setMinimumSize(new java.awt.Dimension(38, 38));
        btnMevcutSatirEkle.setPreferredSize(new java.awt.Dimension(26, 26));
        btnMevcutSatirEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMevcutSatirEkleActionPerformed(evt);
            }
        });

        btnMevcutSatirSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/others/bCikar.png"))); // NOI18N
        btnMevcutSatirSil.setPreferredSize(new java.awt.Dimension(26, 26));
        btnMevcutSatirSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMevcutSatirSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout solPanelLayout = new javax.swing.GroupLayout(solPanel);
        solPanel.setLayout(solPanelLayout);
        solPanelLayout.setHorizontalGroup(
            solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solPanelLayout.createSequentialGroup()
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, solPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(solPanelLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbBahce, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, solPanelLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCati, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(solPanelLayout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSuBaskini, 0, 0, Short.MAX_VALUE))
                            .addGroup(solPanelLayout.createSequentialGroup()
                                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbOnarim, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtOnarimTarihi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtBlokSayisi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtOgretmenSayisi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(solPanelLayout.createSequentialGroup()
                                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbSu, 0, 115, Short.MAX_VALUE)
                                    .addComponent(cmbDisBoya, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(6, 6, 6)
                        .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDerslikSayisi)
                            .addComponent(txtYuzolcumu)
                            .addComponent(cmbicBoya, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbElektrik, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMerkezeUzakligi)
                            .addComponent(cmbTuvalet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtYapimTarihi)
                            .addComponent(cmbKapiPencere, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, solPanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbKurumAdi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(solPanelLayout.createSequentialGroup()
                                .addComponent(btnOnceki, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtKurumKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSonraki, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6))
            .addGroup(solPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(solPanelLayout.createSequentialGroup()
                        .addComponent(btnMevcutSatirEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMevcutSatirSil, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        solPanelLayout.setVerticalGroup(
            solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solPanelLayout.createSequentialGroup()
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cmbKurumAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(6, 6, 6)
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(btnOnceki, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKurumKodu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSonraki, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(cmbOnarim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtYapimTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOnarimTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtDerslikSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(txtBlokSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtYuzolcumu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(txtOgretmenSayisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtMerkezeUzakligi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(cmbDisBoya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cmbicBoya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(cmbSu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cmbElektrik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19)
                    .addComponent(cmbSuBaskini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(cmbTuvalet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel11)
                    .addComponent(cmbCati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cmbKapiPencere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(cmbBahce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(solPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnMevcutSatirEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMevcutSatirSil, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        sagAltPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 10), new java.awt.Color(0, 0, 153))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Diğer Fiziki Sorunlar");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Mahallenin Sosyolojik Yapısı");

        taDigerSorunlar.setColumns(20);
        taDigerSorunlar.setLineWrap(true);
        taDigerSorunlar.setRows(3);
        taDigerSorunlar.setWrapStyleWord(true);
        jScrollPane1.setViewportView(taDigerSorunlar);

        taSosyolojik.setColumns(20);
        taSosyolojik.setLineWrap(true);
        taSosyolojik.setRows(3);
        taSosyolojik.setWrapStyleWord(true);
        jScrollPane4.setViewportView(taSosyolojik);

        javax.swing.GroupLayout sagAltPanelLayout = new javax.swing.GroupLayout(sagAltPanel);
        sagAltPanel.setLayout(sagAltPanelLayout);
        sagAltPanelLayout.setHorizontalGroup(
            sagAltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sagAltPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sagAltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(sagAltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sagAltPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        sagAltPanelLayout.setVerticalGroup(
            sagAltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sagAltPanelLayout.createSequentialGroup()
                .addGroup(sagAltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sagAltPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fotoğraflar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), new java.awt.Color(0, 51, 153))); // NOI18N

        btnSecimGroup.add(rbKurum);
        rbKurum.setSelected(true);
        rbKurum.setText("Kurum");
        rbKurum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKurumActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbic);
        rbic.setText("İç Cephe");
        rbic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbicActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbDis);
        rbDis.setText("Dış Cephe");
        rbDis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDisActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbCati);
        rbCati.setText("Çatı");
        rbCati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCatiActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbTuvalet);
        rbTuvalet.setText("Tuvalet");
        rbTuvalet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTuvaletActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbSu);
        rbSu.setText("Su");
        rbSu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSuActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbKapiPencere);
        rbKapiPencere.setText("Kapı Pencere");
        rbKapiPencere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKapiPencereActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbBahce);
        rbBahce.setText("Bahçe");
        rbBahce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBahceActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbSuBaskini);
        rbSuBaskini.setText("Su Baskını");
        rbSuBaskini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSuBaskiniActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbElektrik);
        rbElektrik.setText("Elektrik");
        rbElektrik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbElektrikActionPerformed(evt);
            }
        });

        btnSecimGroup.add(rbKonum);
        rbKonum.setText("Konum");
        rbKonum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKonumActionPerformed(evt);
            }
        });

        btnFotoEkle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFotoEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/others/bEkle.png"))); // NOI18N
        btnFotoEkle.setBorder(null);
        btnFotoEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFotoEkleActionPerformed(evt);
            }
        });

        btnSonrakiFoto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSonrakiFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/others/bSonraki.png"))); // NOI18N
        btnSonrakiFoto.setActionCommand("");
        btnSonrakiFoto.setBorder(null);
        btnSonrakiFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSonrakiFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbElektrik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbSuBaskini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbBahce, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbKapiPencere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbSu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbTuvalet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbCati, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbDis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbKurum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbKonum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFotoEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSonrakiFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbKurum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbCati)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTuvalet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbKapiPencere)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbBahce)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbSuBaskini)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbElektrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbKonum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFotoEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSonrakiFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Kurum Fotoğrafı - 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10), new java.awt.Color(0, 0, 153))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        btnGuncelle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuncelle.setText("Güncelle");
        btnGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelleActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuncelle);

        btnKayitEkle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKayitEkle.setText("Kayıt Ekle");
        btnKayitEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKayitEkleActionPerformed(evt);
            }
        });
        jPanel3.add(btnKayitEkle);

        btnSil.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });
        jPanel3.add(btnSil);

        btnYazdir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnYazdir.setText("Yazdır");
        btnYazdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYazdirActionPerformed(evt);
            }
        });
        jPanel3.add(btnYazdir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(solPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sagAltPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(solPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sagAltPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void cmbKurumAdiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbKurumAdiKeyPressed
        if (evt.getKeyCode() == 10) {
            baglanListele(listKkodu.get(listKadi.indexOf(cmbKurumAdi.getSelectedItem())).toString());
        }
    }//GEN-LAST:event_cmbKurumAdiKeyPressed
    private void btnOncekiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOncekiActionPerformed
        ek = 0;
        kurumlarAl();
        if (txtKurumKodu.getText().equals("")) {
            txtKurumKodu.setText(listKkodu.get(listKkodu.size() - 1).toString());
        } else {
            if (f == 0) {
                f = listKkodu.size() - 1;
                txtKurumKodu.setText(listKkodu.get(f).toString());
            } else {
                f--;
                txtKurumKodu.setText(listKkodu.get(f).toString());
            }
            baglanListele(txtKurumKodu.getText());
        }
        rbKurum.setSelected(true);
        baglanListele(txtKurumKodu.getText());
        secimCalistir();
    }//GEN-LAST:event_btnOncekiActionPerformed
    private void txtKurumKoduKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKurumKoduKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtKurumKodu.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "KURUM KODU BOŞ OLAMAZ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                baglanListele(Integer.toString(Math.abs(Integer.parseInt(txtKurumKodu.getText()))));
            }
        }
    }//GEN-LAST:event_txtKurumKoduKeyPressed
    private void btnSonrakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSonrakiActionPerformed
        ek = 0;
        kurumlarAl();
        if (txtKurumKodu.getText().equals("")) {
            txtKurumKodu.setText(listKkodu.get(0).toString());
        } else {
            if (f == listKkodu.size() - 1) {
                f = 0;
                txtKurumKodu.setText(listKkodu.get(f).toString());
            } else {
                f++;
                txtKurumKodu.setText(listKkodu.get(f).toString());
            }
        }
        rbKurum.setSelected(true);
        baglanListele(txtKurumKodu.getText());
        secimCalistir();
    }//GEN-LAST:event_btnSonrakiActionPerformed
    private void btnMevcutSatirSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMevcutSatirSilActionPerformed
        if (tableMevcut.getSelectedRowCount() > 0) {
            modelimMevcut.removeRow(tableMevcut.getSelectedRow());
            tableMevcut.setModel(modelimMevcut);
            guncelle("");
        }
    }//GEN-LAST:event_btnMevcutSatirSilActionPerformed
    private void btnMevcutSatirEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMevcutSatirEkleActionPerformed
        modelimMevcut.addRow(new Object[]{"", ""});
        tableMevcut.setModel(modelimMevcut);
    }//GEN-LAST:event_btnMevcutSatirEkleActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        frame = new JFrame("Çıkış");
//        if (JOptionPane.showConfirmDialog(frame, "Çıkış yapmak istiyor musunuz?", "mADEMatik", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
//            System.exit(0);
//        }
    }//GEN-LAST:event_formWindowClosing
    private void rbKurumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKurumActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbKurumActionPerformed
    private void rbicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbicActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbicActionPerformed
    private void rbDisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDisActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbDisActionPerformed
    private void rbCatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCatiActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbCatiActionPerformed
    private void rbTuvaletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTuvaletActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbTuvaletActionPerformed
    private void rbSuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSuActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbSuActionPerformed
    private void rbKapiPencereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKapiPencereActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbKapiPencereActionPerformed
    private void rbBahceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBahceActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbBahceActionPerformed
    private void rbSuBaskiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSuBaskiniActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbSuBaskiniActionPerformed
    private void rbElektrikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbElektrikActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbElektrikActionPerformed
    private void rbKonumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKonumActionPerformed
        secimCalistir();
    }//GEN-LAST:event_rbKonumActionPerformed
    private void btnFotoEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFotoEkleActionPerformed
        if (!txtKurumKodu.getText().equals("")) {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("DOSYA SEÇME - made by mADEMatik");
            chooser.setCurrentDirectory(new File(".\\src\\fotolar\\"));
            chooser.setMultiSelectionEnabled(true);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGES", "jpg", "jpeg", "png");
            chooser.setFileFilter(filter);
            chooser.showOpenDialog(null);

            String fotoTuru = secimbul();
            baglan();

            if (chooser.getSelectedFiles().length > 0) {
                String silFotolarSQL = "DELETE FROM Fotolar WHERE kurum_kodu = '" + txtKurumKodu.getText() + "' AND turu = '" + fotoTuru + "'";
                sorguCalistir(silFotolarSQL);
                for (File selectedFile : chooser.getSelectedFiles()) {
                    String fotoSQL = "INSERT INTO Fotolar (kurum_kodu, turu, adi) VALUES ('"
                            + txtKurumKodu.getText() + "', '" + fotoTuru + "', '" + selectedFile.getName() + "')";
                    sorguCalistir(fotoSQL);
                }
                secimCalistir();
                JOptionPane.showMessageDialog(null, cmbKurumAdi.getSelectedItem() + " " + fotoTuru + " FOTOĞRAFLARI EKLENDİ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                String silFotolarSQL = "DELETE FROM Fotolar WHERE kurum_kodu = '" + txtKurumKodu.getText() + "' AND turu = '" + fotoTuru + "'";
                sorguCalistir(silFotolarSQL);
                lblFoto.setIcon(null);
                lstFotolar.clear();
                secimCalistir();
                JOptionPane.showMessageDialog(null, cmbKurumAdi.getSelectedItem() + " " + fotoTuru + " FOTOĞRAFLARI SİLİNDİ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }//GEN-LAST:event_btnFotoEkleActionPerformed
    private void btnSonrakiFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSonrakiFotoActionPerformed
        if (!lstFotolar.isEmpty()) {
            if (ek == lstFotolar.size() - 1) {
                ek = 0;
            } else {
                ek++;
            }
            lblFotoEkle();
        }
    }//GEN-LAST:event_btnSonrakiFotoActionPerformed
    private void btnGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelleActionPerformed
        guncelle(evt.getActionCommand());
    }//GEN-LAST:event_btnGuncelleActionPerformed
    private void btnKayitEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKayitEkleActionPerformed
        if (ekle) {
            temizle();
            ekle = false;
        } else {
            String kadi;
            int kkodu;

            if (txtKurumKodu.getText().equals("") || cmbKurumAdi.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "KURUM KODU ve KURUM ADI BOŞ OLAMAZ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                baglan();
                kkodu = Integer.parseInt(txtKurumKodu.getText());
                kadi = cmbKurumAdi.getSelectedItem().toString();

                String kurumSQL = "INSERT INTO Kurumlar (kurum_kodu, kurum_adi) VALUES ('" + Math.abs(kkodu) + "', '" + kadi + "')";
                sorguCalistir(kurumSQL);
                kurumlarAl();
                baglanListele(Integer.toString(kkodu));
                ekle = true;
                JOptionPane.showMessageDialog(null, "KAYIT EKLEME İŞLEMİ BAŞARILI.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }//GEN-LAST:event_btnKayitEkleActionPerformed
    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        if (txtKurumKodu.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "KURUM KODU BOŞ OLAMAZ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            f = 0;
            frame = new JFrame("Kayıt Silme!!!");
            if (JOptionPane.showConfirmDialog(frame, txtKurumKodu.getText() + " numaralı kaydı silmek istiyor musunuz?", "ORTACA DB", JOptionPane.YES_NO_OPTION, 0, icon) == JOptionPane.YES_NO_OPTION) {
                String kurum_kodu = txtKurumKodu.getText();

                baglan();
                String silFotolarSQL = "DELETE FROM Fotolar WHERE kurum_kodu = " + kurum_kodu;
                sorguCalistir(silFotolarSQL);

                String silMevcutlarSQL = "DELETE FROM Mevcutlar WHERE kurum_kodu = " + kurum_kodu;
                sorguCalistir(silMevcutlarSQL);

                String silKurumlarSQL = "DELETE FROM Kurumlar WHERE kurum_kodu = " + kurum_kodu;
                sorguCalistir(silKurumlarSQL);

                JOptionPane.showMessageDialog(null, "KAYIT SİLME İŞLEMİ BAŞARILI.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);

                kurumlarAl();
                baglanListele(listKkodu.get(0).toString());
                secimCalistir();
            }
        }
    }//GEN-LAST:event_btnSilActionPerformed
    private void btnYazdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYazdirActionPerformed
        prntDialog.setSize(new Dimension(260, 160));
        prntDialog.setIconImage(icon.getImage());
        prntDialog.setLocationRelativeTo(null);
        prntDialog.setModal(true);
        prntDialog.setAlwaysOnTop(true);
        //prntDialog.setModalityType(ModalityType.APPLICATION_MODAL);
        prntDialog.setVisible(true);
    }//GEN-LAST:event_btnYazdirActionPerformed
    private void tableMevcutFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableMevcutFocusLost
        for (int i = 0; i < tableMevcut.getRowCount(); i++) {
            tableMevcut.setValueAt("", i, 2);
        }
    }//GEN-LAST:event_tableMevcutFocusLost
    private void btnKurumlariYazdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKurumlariYazdirActionPerformed
        if (rbYazdirFotosuz.isSelected()) {
            prntDialog.setVisible(false);
            try {
                baglan();
                String rp = ".\\src\\reports\\rptFotosuz.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(rp);
                JasperPrint pr = JasperFillManager.fillReport(jr, null, conn);
                JasperViewer jasperViewer = new JasperViewer(pr, false, getLocale());
                JDialog dialog = new JDialog(this);
                dialog.setContentPane(jasperViewer.getContentPane());
                dialog.setSize(new Dimension(1024, 768));
                dialog.setLocationRelativeTo(this);
                dialog.setTitle("FOTOĞRAFSIZ KURUM YAZDIRMA - made by mADEMatik");
                dialog.setModal(true);
                dialog.setVisible(true);

            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
        if (rbYazdirFotolu.isSelected()) {
            prntDialog.setVisible(false);
            try {
                baglan();
                String rp = ".\\src\\reports\\rptFotolu.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(rp);
                JasperPrint pr = JasperFillManager.fillReport(jr, null, conn);
                JasperViewer jasperViewer = new JasperViewer(pr, false, getLocale());
                JDialog dialog = new JDialog(this);
                dialog.setContentPane(jasperViewer.getContentPane());
                dialog.setSize(new Dimension(1024, 768));
                dialog.setLocationRelativeTo(this);
                dialog.setTitle("FOTOĞRAFLI KURUM YAZDIRMA - made by mADEMatik");
                dialog.setModal(true);
                dialog.setVisible(true);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }//GEN-LAST:event_btnKurumlariYazdirActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFotoEkle;
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JButton btnKayitEkle;
    private javax.swing.JButton btnKurumlariYazdir;
    private javax.swing.JButton btnMevcutSatirEkle;
    private javax.swing.JButton btnMevcutSatirSil;
    private javax.swing.JButton btnOnceki;
    private javax.swing.ButtonGroup btnSecimGroup;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton btnSonraki;
    private javax.swing.JButton btnSonrakiFoto;
    private javax.swing.JButton btnYazdir;
    private javax.swing.ButtonGroup btnYazdirGroup;
    private javax.swing.JComboBox<String> cmbBahce;
    private javax.swing.JComboBox<String> cmbCati;
    private javax.swing.JComboBox<String> cmbDisBoya;
    private javax.swing.JComboBox<String> cmbElektrik;
    private javax.swing.JComboBox<String> cmbKapiPencere;
    private javax.swing.JComboBox<String> cmbKurumAdi;
    private javax.swing.JComboBox<String> cmbOnarim;
    private javax.swing.JComboBox<String> cmbSu;
    private javax.swing.JComboBox<String> cmbSuBaskini;
    private javax.swing.JComboBox<String> cmbTuvalet;
    private javax.swing.JComboBox<String> cmbicBoya;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JDialog prntDialog;
    private javax.swing.JRadioButton rbBahce;
    private javax.swing.JRadioButton rbCati;
    private javax.swing.JRadioButton rbDis;
    private javax.swing.JRadioButton rbElektrik;
    private javax.swing.JRadioButton rbKapiPencere;
    private javax.swing.JRadioButton rbKonum;
    private javax.swing.JRadioButton rbKurum;
    private javax.swing.JRadioButton rbSu;
    private javax.swing.JRadioButton rbSuBaskini;
    private javax.swing.JRadioButton rbTuvalet;
    private javax.swing.JRadioButton rbYazdirFotolu;
    private javax.swing.JRadioButton rbYazdirFotosuz;
    private javax.swing.JRadioButton rbic;
    private javax.swing.JPanel sagAltPanel;
    private javax.swing.JPanel solPanel;
    private javax.swing.JTextArea taDigerSorunlar;
    private javax.swing.JTextArea taSosyolojik;
    private javax.swing.JTable tableMevcut;
    private javax.swing.JTextField txtBlokSayisi;
    private javax.swing.JTextField txtDerslikSayisi;
    private javax.swing.JTextField txtKurumKodu;
    private javax.swing.JTextField txtMerkezeUzakligi;
    private javax.swing.JTextField txtOgretmenSayisi;
    private javax.swing.JTextField txtOnarimTarihi;
    private javax.swing.JTextField txtYapimTarihi;
    private javax.swing.JTextField txtYuzolcumu;
    // End of variables declaration//GEN-END:variables
    private void baglanListele(String kkodu) {
        baglan();
        cmbKurumAdi.setEditable(false);
        String listeleSQL = "SELECT * FROM Kurumlar WHERE kurum_kodu = " + kkodu;
        rs = listeAl(listeleSQL);
        lblFoto.setIcon(null);

        try {
            txtKurumKodu.setText(rs.getString("kurum_kodu"));
            cmbKurumAdi.setSelectedIndex(listKadi.indexOf(rs.getString("kurum_adi")));
            txtYapimTarihi.setText(rs.getString("yapim_tarihi"));
            cmbOnarim.setSelectedIndex(rs.getInt("onarim"));
            txtOnarimTarihi.setText(rs.getString("onarim_tarihi"));
            txtYuzolcumu.setText(rs.getString("yuzolcumu"));
            txtMerkezeUzakligi.setText(rs.getString("merkeze_uzakligi"));
            txtBlokSayisi.setText(rs.getString("blok_sayisi"));
            txtDerslikSayisi.setText(rs.getString("derslik_sayisi"));
            txtOgretmenSayisi.setText(rs.getString("ogretmen_sayisi"));
            cmbicBoya.setSelectedIndex(rs.getInt("ic"));
            cmbDisBoya.setSelectedIndex(rs.getInt("dis"));
            cmbCati.setSelectedIndex(rs.getInt("cati"));
            cmbTuvalet.setSelectedIndex(rs.getInt("tuvalet"));
            cmbElektrik.setSelectedIndex(rs.getInt("elektrik"));
            cmbSu.setSelectedIndex(rs.getInt("su"));
            cmbKapiPencere.setSelectedIndex(rs.getInt("kapi_pencere"));
            cmbBahce.setSelectedIndex(rs.getInt("bahce"));
            cmbSuBaskini.setSelectedIndex(rs.getInt("su_baskini"));
            taDigerSorunlar.setText(rs.getString("diger_sorunlar").replace("**", "'"));
            taSosyolojik.setText(rs.getString("sosyolojik").replace("**", "'"));

            String mevcutSQL = "SELECT * FROM Mevcutlar WHERE kurum_kodu = " + kkodu + " ORDER BY yili";
            ResultSet rsM = listeAl(mevcutSQL);
            modelimMevcut.setColumnCount(0);
            modelimMevcut.setRowCount(0);
            modelimMevcut.setColumnIdentifiers(kolonlarMevcut);

            while (rsM.next()) {
                satirlarMevcut[0] = rsM.getString("yili");
                satirlarMevcut[1] = rsM.getString("mevcudu");
                satirlarMevcut[2] = rsM.getString("degisim_orani");
                modelimMevcut.addRow(satirlarMevcut);
            }
            tableMevcut.setModel(modelimMevcut);
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            tableMevcut.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            tableMevcut.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            tableMevcut.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
            ((DefaultTableCellRenderer) tableMevcut.getTableHeader().getDefaultRenderer())
                    .setHorizontalAlignment(JLabel.CENTER);

            conn.close();
            st.close();
        } catch (SQLException e) {
            if (e.getErrorCode() == 0) {
                temizle();
                JOptionPane.showMessageDialog(null, kkodu + " NUMARALI KAYIT BULUNAMADI", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }

    static void baglan() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }

    static ResultSet listeAl(String sorgu) {
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sorgu);
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            return null;
        }
    }

    static void sorguCalistir(String sorgu) {
        try {
            st = conn.createStatement();
            st.executeUpdate(sorgu);
        } catch (SQLException e) {
            if (e.getErrorCode() == 5) {
                JOptionPane.showMessageDialog(null, "Veritabanı kilitlendi. Lütfen programı kapatıp tekrar açın.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }

    private void temizle() {
        txtKurumKodu.setText(null);
        cmbKurumAdi.removeAllItems();
        cmbKurumAdi.addItem("");
        cmbKurumAdi.setEditable(true);
        txtYapimTarihi.setText(null);
        cmbOnarim.setSelectedIndex(0);
        txtOnarimTarihi.setText(null);
        txtYuzolcumu.setText("0");
        txtMerkezeUzakligi.setText("0");
        txtBlokSayisi.setText("0");
        txtDerslikSayisi.setText("0");
        txtOgretmenSayisi.setText("0");
        cmbicBoya.setSelectedIndex(0);
        cmbDisBoya.setSelectedIndex(0);
        cmbCati.setSelectedIndex(0);
        cmbTuvalet.setSelectedIndex(0);
        cmbElektrik.setSelectedIndex(0);
        cmbSu.setSelectedIndex(0);
        cmbKapiPencere.setSelectedIndex(0);
        cmbBahce.setSelectedIndex(0);
        cmbSuBaskini.setSelectedIndex(0);
        taDigerSorunlar.setText(null);
        taSosyolojik.setText(null);
        lblFoto.setIcon(null);

        modelimMevcut.setColumnIdentifiers(kolonlarMevcut);
        modelimMevcut.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    private void kurumlarAl() {
        listKkodu.clear();
        listKadi.clear();
        cmbKurumAdi.removeAllItems();
        baglan();
        String listeleSQL = "SELECT * FROM Kurumlar ORDER BY kurum_kodu";
        rs = listeAl(listeleSQL);

        try {
            while (rs.next()) {
                listKkodu.add(rs.getString("kurum_kodu"));
                listKadi.add(rs.getString("kurum_adi"));
            }
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 0) {
                JOptionPane.showMessageDialog(null, "HENÜZ KAYDINIZ YOK.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
        for (Object object : listKadi) {
            cmbKurumAdi.addItem(object.toString());
        }
    }

    private void guncelle(String evtAction) {
        String kurum_kodu, kurum_adi, yapim_tarihi, onarim_tarihi, diger_sorunlar, sosyolojik, ogretim_yili, degisim_orani, mevcudu;
        int onarim, blok_sayisi, derslik_sayisi, ogretmen_sayisi, ic, dis, cati, tuvalet, elektrik, su, kapi_pencere,
                bahce, su_baskini;
        float yuzolcumu, merkeze_uzakligi;
        if (txtKurumKodu.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "KURUM KODU BOŞ OLAMAZ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            baglan();
            try {
                kurum_kodu = txtKurumKodu.getText();
                kurum_adi = cmbKurumAdi.getSelectedItem().toString().toUpperCase();
                yapim_tarihi = txtYapimTarihi.getText();
                onarim = cmbOnarim.getSelectedIndex();
                onarim_tarihi = txtOnarimTarihi.getText();
                yuzolcumu = Float.parseFloat((txtYuzolcumu.getText()));
                merkeze_uzakligi = Float.parseFloat(txtMerkezeUzakligi.getText());
                blok_sayisi = Integer.parseInt(txtBlokSayisi.getText());
                derslik_sayisi = Integer.parseInt(txtDerslikSayisi.getText());
                ogretmen_sayisi = Integer.parseInt(txtOgretmenSayisi.getText());
                ic = cmbicBoya.getSelectedIndex();
                dis = cmbDisBoya.getSelectedIndex();
                cati = cmbCati.getSelectedIndex();
                tuvalet = cmbTuvalet.getSelectedIndex();
                elektrik = cmbElektrik.getSelectedIndex();
                su = cmbSu.getSelectedIndex();
                kapi_pencere = cmbKapiPencere.getSelectedIndex();
                bahce = cmbKapiPencere.getSelectedIndex();
                su_baskini = cmbSuBaskini.getSelectedIndex();
                diger_sorunlar = taDigerSorunlar.getText();
                sosyolojik = taSosyolojik.getText();

                String kurumSQL = "UPDATE Kurumlar SET kurum_adi = '" + kurum_adi
                        + "', yapim_tarihi = '" + yapim_tarihi
                        + "', onarim = '" + onarim
                        + "', onarim_tarihi = '" + onarim_tarihi
                        + "', yuzolcumu = '" + Math.abs(yuzolcumu)
                        + "', merkeze_uzakligi = '" + Math.abs(merkeze_uzakligi)
                        + "', blok_sayisi = '" + Math.abs(blok_sayisi)
                        + "', derslik_sayisi = '" + Math.abs(derslik_sayisi)
                        + "', ogretmen_sayisi = '" + Math.abs(ogretmen_sayisi)
                        + "', ic = '" + ic
                        + "', dis = '" + dis
                        + "', cati = '" + cati
                        + "', tuvalet = '" + tuvalet
                        + "', elektrik = '" + elektrik
                        + "', su = '" + su
                        + "', kapi_pencere = '" + kapi_pencere
                        + "', bahce = '" + bahce
                        + "', su_baskini = '" + su_baskini
                        + "', diger_sorunlar = '" + diger_sorunlar.replace("'", "**")
                        + "', sosyolojik = '" + sosyolojik.replace("'", "**")
                        + "' WHERE kurum_kodu = " + kurum_kodu;

                sorguCalistir(kurumSQL);

                String silMevcutlarSQL = "DELETE FROM Mevcutlar WHERE kurum_kodu = " + kurum_kodu;
                sorguCalistir(silMevcutlarSQL);
                for (int i = 0; i < tableMevcut.getRowCount(); i++) {
                    if (tableMevcut.getValueAt(i, 0) != "") {
                        ogretim_yili = tableMevcut.getValueAt(i, 0).toString();
                        mevcudu = tableMevcut.getValueAt(i, 1).toString();
                        degisim_orani = tableMevcut.getValueAt(i, 2).toString();
                        String mevcutSQL1 = "INSERT INTO Mevcutlar (kurum_kodu, yili, mevcudu, degisim_orani) VALUES ('"
                                + kurum_kodu + "', '" + ogretim_yili + "', '" + mevcudu + "', '" + degisim_orani + "')";
                        sorguCalistir(mevcutSQL1);
                    }
                }
                baglanListele(kurum_kodu);

                baglan();
                DecimalFormat decF = new DecimalFormat("0.00");
                for (int i = 1; i < tableMevcut.getRowCount(); i++) {
                    float onceki = Float.parseFloat((String) tableMevcut.getValueAt(i - 1, 1));
                    float simdiki = Float.parseFloat((String) tableMevcut.getValueAt(i, 1));
                    float oran = (simdiki / onceki - 1) * 100;
                    String yaz = decF.format((oran)) + " %";
                    if (yaz.equals("NaN %") || yaz.equals("∞ %")) {
                        yaz = "";
                    }
                    tableMevcut.setValueAt(yaz, i, 2);
                }

                sorguCalistir(silMevcutlarSQL);
                for (int i = 0; i < tableMevcut.getRowCount(); i++) {
                    if (tableMevcut.getValueAt(i, 0) != "") {
                        ogretim_yili = tableMevcut.getValueAt(i, 0).toString();
                        mevcudu = tableMevcut.getValueAt(i, 1).toString();
                        degisim_orani = tableMevcut.getValueAt(i, 2).toString();
                        String mevcutSQL = "INSERT INTO Mevcutlar (kurum_kodu, yili, mevcudu, degisim_orani) VALUES ('"
                                + kurum_kodu + "', '" + ogretim_yili + "', '" + mevcudu + "', '" + degisim_orani + "')";
                        sorguCalistir(mevcutSQL);
                    }
                }

                if (evtAction.equals("Güncelle")) {
                    baglanListele(kurum_kodu);
                    secimCalistir();
                    JOptionPane.showMessageDialog(null, kurum_kodu + " NUMARALI KAYIT GÜNCELLENDİ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
                }
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "SAYISAL DEĞERLERİ KONTROL EDİNİZ.", "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        }
    }

    private String secimbul() {
        if (rbKurum.isSelected()) {
            return "KURUM";
        }
        if (rbic.isSelected()) {
            return "İÇ CEPHE";
        }
        if (rbDis.isSelected()) {
            return "DIŞ CEPHE";
        }
        if (rbCati.isSelected()) {
            return "ÇATI";
        }
        if (rbTuvalet.isSelected()) {
            return "TUVALET";
        }
        if (rbElektrik.isSelected()) {
            return "ELEKTRİK TESİSATI";
        }
        if (rbSu.isSelected()) {
            return "SU TESİSATI";
        }
        if (rbKapiPencere.isSelected()) {
            return "KAPI - PENCERE";
        }
        if (rbBahce.isSelected()) {
            return "BAHÇE";
        }
        if (rbSuBaskini.isSelected()) {
            return "SU BASKINI";
        }
        if (rbKonum.isSelected()) {
            return "KONUM";
        }
        return "";
    }

    private void lblFotoEkle() {

        String baslik;
        if (lstFotolar.isEmpty()) {
            baslik = secimbul() + " FOTOĞRAFI YOK      ";
        } else {
            baslik = secimbul() + " FOTOĞRAFI (" + (ek + 1) + " / " + lstFotolar.size() + ")     ";
        }
        TitledBorder titledBorder = new TitledBorder(baslik);
        lblFoto.setBorder(titledBorder);

        if (!lstFotolar.isEmpty()) {
            ImageIcon iconFoto = new ImageIcon("./src/fotolar/" + lstFotolar.get(ek));
            Image imageFoto = iconFoto.getImage();
            Image modFoto = imageFoto.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(modFoto);
            lblFoto.setIcon(icon);
        }
    }

    @SuppressWarnings("unchecked")
    private void secimCalistir() {
        lstFotolar.clear();
        ek = 0;
        try {
            baglan();
            lblFoto.setIcon(null);
            String fotoListeleSQL = "SELECT * FROM Fotolar WHERE kurum_kodu = '" + txtKurumKodu.getText() + "' AND turu = '" + secimbul() + "'";
            rsFoto = listeAl(fotoListeleSQL);

            while (rsFoto.next()) {
                lstFotolar.add(rsFoto.getString("adi"));
            }
            baglanListele(txtKurumKodu.getText());
            lblFotoEkle();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "mADEMatik", JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }
}
