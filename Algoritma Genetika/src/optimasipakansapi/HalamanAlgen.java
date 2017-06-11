/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimasipakansapi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author noortopik
 */
public class HalamanAlgen extends javax.swing.JFrame {

    AlgoritmaGenetika ag = new AlgoritmaGenetika();
    PakanSapi ps = new PakanSapi();
    List<KebutuhanNutrisi> listNutrisi = new ArrayList<>();
    List<Kromosom> kR = new ArrayList<>();
    int popsize, jumlah_generasi, bb, ambilgen = 0;
    double cr, mr, pbb, alphaMax, alphaMin, Randmax, Randmin;
    String Pakan1, Pakan2, Pakan3, Pakan4, jenis_sapi;
    int x;
    DecimalFormat df = new DecimalFormat(".##");
    private DefaultTableModel model;
    private DefaultListModel pakan;

    /**
     * Creates new form HalamanAlgen
     */
    public HalamanAlgen() {
        initComponents();

    }

    public void buatTable(String pkn1, String pkn2, String pkn3, String pkn4, int bb, double pbb, String jenis_sapi) {
        this.Pakan1 = pkn1;
        this.Pakan2 = pkn2;
        this.Pakan3 = pkn3;
        this.Pakan4 = pkn4;
        this.jenis_sapi = jenis_sapi;
        this.bb = bb;
        this.pbb = pbb;
        model = new DefaultTableModel();
        pakan = new DefaultListModel();
        model.addColumn("No Individu");
        model.addColumn(pkn1);
        model.addColumn(pkn2);
        model.addColumn(pkn3);
        model.addColumn(pkn4);
        model.addColumn("Total Harga");
        model.addColumn("Penalti");
        model.addColumn("Fitness");
        tblAlgen.setModel(model);
        ListNutrisiPakan.setModel(pakan);

    }

    private void clearTable() {
        DefaultTableModel model1 = (DefaultTableModel) tblAlgen.getModel();
        while (model1.getRowCount() > 0) {
            for (int i = 0; i < model1.getRowCount(); i++) {
                model1.removeRow(i);
            }
        }
    }

    public void ambilKromosom() {
        int p = 1;
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        kR.clear();
        kR = ag.simpanIndividu();
        for (x = ((kR.size()) - popsize); x < kR.size(); x++) {
            Object[] data = new Object[8];
            data[0] = p;
            data[1] = kR.get(x).getKromosom1();
            data[2] = kR.get(x).getKromosom2();
            data[3] = kR.get(x).getKromosom3();
            data[4] = kR.get(x).getKromosom4();
            data[5] = kR.get(x).getHarga();
            data[6] = kR.get(x).getPenalty();
            data[7] = kR.get(x).getFitness();
            if (x == kR.size() - popsize) {
                double[] data2 = new double[4];
                data2[0] = (double) data[1];
                data2[1] = (double) data[2];
                data2[2] = (double) data[3];
                data2[3] = (double) data[4];
                pakan.addElement(ag.hitungPenalti(data2));
                textAreaKeterangan.setText(textarea(data2, data[5], data[6], data[7]));
            }
            model.addRow(data);
            p++;
        }
    }

    public String textarea(double[] data2, Object harga, Object penalty, Object fitness) {
        return "Pakan yang bisa digunakan untuk  menggemukkan sapi seberat " + bb + " Kg,\n"
                + pbb + " Kg perhari adalah sebagai berikut :\n"
                + "Pakan 1  : " + Pakan1 + " seberat " + Double.valueOf(df.format(data2[0])) + " Kg\n"
                + "Pakan 2  : " + Pakan2 + " seberat " + Double.valueOf(df.format(data2[1])) + " Kg\n"
                + "Pakan 3  : " + Pakan3 + " seberat " + Double.valueOf(df.format(data2[2])) + " Kg\n"
                + "Pakan 4  : " + Pakan4 + " seberat " + Double.valueOf(df.format(data2[3])) + " Kg\n"
                + "Harga total  : Rp " + harga
                + "\nTotal penalty  : " + penalty
                + "\nFitness  : " + fitness;
    }

    public void ambilKromosom(int generasi) {
        int p = 0;
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        x = (popsize * (generasi - 1));
        while (x < kR.size()) {
            Object[] data = new Object[8];
            data[0] = p + 1;
            data[1] = kR.get(x).getKromosom1();
            data[2] = kR.get(x).getKromosom2();
            data[3] = kR.get(x).getKromosom3();
            data[4] = kR.get(x).getKromosom4();
            data[5] = kR.get(x).getHarga();
            data[6] = kR.get(x).getPenalty();
            data[7] = kR.get(x).getFitness();
            model.addRow(data);
            p++;
            x++;
        }
    }

    private void ambilGenerasi() {

        jcomboboxtampilgenerasi.removeAllItems();
        int i = 0;
        while (i < jumlah_generasi) {
            jcomboboxtampilgenerasi.addItem(i + 1);
            i++;
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPopsize = new javax.swing.JTextField();
        txtJumGen = new javax.swing.JTextField();
        btnProses = new javax.swing.JButton();
        comboCr = new javax.swing.JComboBox();
        comboMr = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAlphaMax = new javax.swing.JTextField();
        txtAlphaMin = new javax.swing.JTextField();
        txtRandomMax = new javax.swing.JTextField();
        txtRandomMin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jcomboboxtampilgenerasi = new javax.swing.JComboBox();
        btnLihatGenerasi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaKeterangan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAlgen = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListNutrisiPakan = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Parameter Algoritma Genetika");

        jLabel2.setText("Popsize");

        jLabel3.setText("Crossover Rate");

        jLabel4.setText("Mutation rate");

        jLabel5.setText("Jumlah Generasi");

        txtPopsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPopsizeActionPerformed(evt);
            }
        });

        txtJumGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumGenActionPerformed(evt);
            }
        });

        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        comboCr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0" }));
        comboCr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCrActionPerformed(evt);
            }
        });

        comboMr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0" }));
        comboMr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMrActionPerformed(evt);
            }
        });

        jLabel7.setText("Nilai alpha max");

        jLabel8.setText("Nilai alpha min");

        jLabel9.setText("Nilai random max");

        jLabel10.setText("Nilai random min");

        txtAlphaMax.setText("0.1");
        txtAlphaMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlphaMaxActionPerformed(evt);
            }
        });

        txtAlphaMin.setText("-0.1");
        txtAlphaMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlphaMinActionPerformed(evt);
            }
        });

        txtRandomMax.setText("0.1");
        txtRandomMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRandomMaxActionPerformed(evt);
            }
        });

        txtRandomMin.setText("-0.1");
        txtRandomMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRandomMinActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Tampilkan Populasi Generasi Ke :");

        jLabel12.setText("Pilih Generasi  :");

        jcomboboxtampilgenerasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboboxtampilgenerasiActionPerformed(evt);
            }
        });

        btnLihatGenerasi.setText("Lihat");
        btnLihatGenerasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatGenerasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJumGen, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCr, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPopsize, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboMr, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(btnProses, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAlphaMax, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                    .addComponent(txtAlphaMin)
                                    .addComponent(txtRandomMax)
                                    .addComponent(txtRandomMin))
                                .addGap(4, 4, 4))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLihatGenerasi, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                            .addComponent(jcomboboxtampilgenerasi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPopsize)
                    .addComponent(jLabel7)
                    .addComponent(txtAlphaMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jcomboboxtampilgenerasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboCr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlphaMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnLihatGenerasi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboMr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRandomMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJumGen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtRandomMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(24, 24, 24)
                .addComponent(btnProses)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Keterangan Hasil Data Pakan Sapi");

        textAreaKeterangan.setColumns(20);
        textAreaKeterangan.setRows(5);
        jScrollPane1.setViewportView(textAreaKeterangan);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(23, 23, 23))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tblAlgen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblAlgen);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(ListNutrisiPakan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKembali)
                    .addComponent(btnReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        pakan.removeAllElements();
        txtPopsize.setText("");
        textAreaKeterangan.setText("");
        txtJumGen.setText("");
        clearTable();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtRandomMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRandomMinActionPerformed
        // TODO add your handling code here:
        Randmin = Double.parseDouble(txtRandomMin.getText());

    }//GEN-LAST:event_txtRandomMinActionPerformed

    private void txtRandomMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRandomMaxActionPerformed
        // TODO add your handling code here:
        Randmax = Double.parseDouble(txtRandomMax.getText());
    }//GEN-LAST:event_txtRandomMaxActionPerformed

    private void txtAlphaMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlphaMinActionPerformed
        // TODO add your handling code here:
        alphaMin = Double.parseDouble(txtAlphaMin.getText());
    }//GEN-LAST:event_txtAlphaMinActionPerformed

    private void txtAlphaMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlphaMaxActionPerformed
        // TODO add your handling code here:
        alphaMax = Double.parseDouble(txtAlphaMax.getText());
    }//GEN-LAST:event_txtAlphaMaxActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
//        halamanNutrisi hn = new halamanNutrisi();
        this.dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void comboCrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCrActionPerformed
        // TODO add your handling code here:
        String Cr = (String) comboCr.getSelectedItem();
        cr = Double.parseDouble(Cr);
    }//GEN-LAST:event_comboCrActionPerformed

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        textAreaKeterangan.setText("");
        pakan.removeAllElements();
        ag.setPbb(pbb);
        ag.setCr(cr);
        ag.setMr(mr);
        ag.setAlphaMax(alphaMax);
        ag.setAlphaMin(alphaMin);
        ag.setRandmax(Randmax);
        ag.setRandmin(Randmin);
        ag.setJum_gen(jumlah_generasi);
        ag.setPopsize(popsize);
        ag.generasi(Pakan1, Pakan2, Pakan3, Pakan4, bb, jenis_sapi);
        ambilKromosom();
        ambilGenerasi();
    }//GEN-LAST:event_btnProsesActionPerformed

    private void txtJumGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumGenActionPerformed
        // TODO add your handling code here:
        jumlah_generasi = Integer.parseInt(txtJumGen.getText());
    }//GEN-LAST:event_txtJumGenActionPerformed

    private void txtPopsizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPopsizeActionPerformed
        // TODO add your handling code here:
        popsize = Integer.parseInt(txtPopsize.getText());
    }//GEN-LAST:event_txtPopsizeActionPerformed

    private void comboMrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMrActionPerformed
        // TODO add your handling code here:
        String Mr = (String) comboMr.getSelectedItem();
        mr = Double.parseDouble(Mr);
    }//GEN-LAST:event_comboMrActionPerformed

    private void jcomboboxtampilgenerasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboboxtampilgenerasiActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jcomboboxtampilgenerasiActionPerformed

    private void btnLihatGenerasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatGenerasiActionPerformed
        // TODO add your handling code here:
        ambilgen = (int) jcomboboxtampilgenerasi.getSelectedItem();
        ambilKromosom(ambilgen);
    }//GEN-LAST:event_btnLihatGenerasiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HalamanAlgen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalamanAlgen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalamanAlgen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalamanAlgen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HalamanAlgen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ListNutrisiPakan;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnLihatGenerasi;
    private javax.swing.JButton btnProses;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox comboCr;
    private javax.swing.JComboBox comboMr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox jcomboboxtampilgenerasi;
    private javax.swing.JTable tblAlgen;
    private javax.swing.JTextArea textAreaKeterangan;
    private javax.swing.JTextField txtAlphaMax;
    private javax.swing.JTextField txtAlphaMin;
    private javax.swing.JTextField txtJumGen;
    private javax.swing.JTextField txtPopsize;
    private javax.swing.JTextField txtRandomMax;
    private javax.swing.JTextField txtRandomMin;
    // End of variables declaration//GEN-END:variables
}
