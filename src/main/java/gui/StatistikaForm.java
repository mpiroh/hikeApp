package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import sk.ics.upjs.hikeapp.DaOFactory;
import sk.ics.upjs.hikeapp.Statistika;
import sk.ics.upjs.hikeapp.StatistikaDao;

public class StatistikaForm extends javax.swing.JFrame {
    
    private Long idUzivatela;
    private StatistikaDao statistikaDao = DaOFactory.INSTANCE.getStatistikaDao();
    private Statistika s;
    
    public StatistikaForm() {
        initComponents();
    }
    
    public StatistikaForm(Long idUzivatela) {
        initComponents();
        this.idUzivatela = idUzivatela;
        s = statistikaDao.dajPodlaUzivatela(idUzivatela);
        
        nastavLabely();
        
        pocetTurComboBox.addItem("Všetky");
        pocetTurComboBox.addItem("Jar");
        pocetTurComboBox.addItem("Leto");
        pocetTurComboBox.addItem("Jeseň");
        pocetTurComboBox.addItem("Zima");
        
        pocetTurComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(pocetTurComboBox.getSelectedIndex()) {
                    case 0: //vsetky
                        pocetTurLabel.setText(String.valueOf(s.getPocetTur()));
                        break;
                    case 1: //jar
                        pocetTurLabel.setText(String.valueOf(s.getSpoluTurJar()));
                        break;
                    case 2: //leto
                        pocetTurLabel.setText(String.valueOf(s.getSpoluTurLeto()));
                        break;
                    case 3: //jesen
                        pocetTurLabel.setText(String.valueOf(s.getSpoluTurJesen()));
                        break;
                    case 4: //zima
                        pocetTurLabel.setText(String.valueOf(s.getSpoluTurZima()));
                        break;
                }
            }
        });
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width - this.getSize().width) / 2, (dim.height - this.getSize().height) / 2);
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pocetTurComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        priemernaObtiaznostLabel = new javax.swing.JLabel();
        priemernaRychlostLabel = new javax.swing.JLabel();
        pocetHodinLabel = new javax.swing.JLabel();
        pocetKilometrovLabel = new javax.swing.JLabel();
        pocetFotiekLabel = new javax.swing.JLabel();
        pocetHodnoteniLabel = new javax.swing.JLabel();
        zrusitButton = new javax.swing.JButton();
        rebricekButton = new javax.swing.JButton();
        pocetTurLabel = new javax.swing.JLabel();
        vynulovatButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        datumLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Počet túr:");

        jLabel2.setText("Počet kilometrov:");

        jLabel3.setText("Počet hodín:");

        jLabel4.setText("Priemerná rýchlosť:");

        jLabel5.setText("Priemerná obtiažnosť:");

        jLabel6.setText("Počet fotiek:");

        jLabel7.setText("Počete hodnotení:");

        priemernaObtiaznostLabel.setText("...");

        priemernaRychlostLabel.setText("...");

        pocetHodinLabel.setText("...");

        pocetKilometrovLabel.setText("...");

        pocetFotiekLabel.setText("...");

        pocetHodnoteniLabel.setText("...");

        zrusitButton.setText("Zrušiť");
        zrusitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zrusitButtonActionPerformed(evt);
            }
        });

        rebricekButton.setText("Rebríček");
        rebricekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rebricekButtonActionPerformed(evt);
            }
        });

        pocetTurLabel.setText("...");

        vynulovatButton.setText("Vynulovať");
        vynulovatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vynulovatButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Zaznamenávané od:");

        datumLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        datumLabel.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(vynulovatButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addComponent(rebricekButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zrusitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pocetHodnoteniLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pocetFotiekLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                    .addComponent(priemernaObtiaznostLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(priemernaRychlostLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pocetHodinLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pocetKilometrovLabel))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pocetTurComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(pocetTurLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datumLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(datumLabel))
                .addGap(18, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pocetTurComboBox)
                        .addComponent(pocetTurLabel))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pocetKilometrovLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pocetHodinLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(priemernaRychlostLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(priemernaObtiaznostLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pocetFotiekLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pocetHodnoteniLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zrusitButton)
                    .addComponent(rebricekButton)
                    .addComponent(vynulovatButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zrusitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zrusitButtonActionPerformed
        StatistikaForm.this.dispose();
        new UzivatelMenu(idUzivatela).setVisible(true);
    }//GEN-LAST:event_zrusitButtonActionPerformed

    private void rebricekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rebricekButtonActionPerformed
        StatistikaForm.this.dispose();
        new RebricekForm(idUzivatela).setVisible(true);
    }//GEN-LAST:event_rebricekButtonActionPerformed

    private void vynulovatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vynulovatButtonActionPerformed
        statistikaDao.vynulujStatistiku(s);
        s = statistikaDao.dajPodlaUzivatela(idUzivatela);
        nastavLabely();
    }//GEN-LAST:event_vynulovatButtonActionPerformed

    private void nastavLabely() {
        pocetKilometrovLabel.setText(String.valueOf(s.getKmSpolu()));
        pocetHodinLabel.setText(String.valueOf(s.getHodSpolu()));
        priemernaRychlostLabel.setText(String.valueOf(s.getPriemernaRychlost()));
        priemernaObtiaznostLabel.setText(String.valueOf(s.getPriemernaObtiaznost()));
        pocetFotiekLabel.setText(String.valueOf(s.getPocetFotiek()));
        pocetHodnoteniLabel.setText(String.valueOf(s.getPocetHodnoteni()));
        pocetTurLabel.setText(String.valueOf(s.getPocetTur()));
        Date datum = s.getVynulovanie();
        int den = datum.getDate();
        int mesiac = datum.getMonth() + 1;
        int rok = datum.getYear() + 1900;
        datumLabel.setText(den + "." + mesiac + "." + rok);
    }
    
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
            java.util.logging.Logger.getLogger(StatistikaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatistikaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatistikaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatistikaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatistikaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel datumLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel pocetFotiekLabel;
    private javax.swing.JLabel pocetHodinLabel;
    private javax.swing.JLabel pocetHodnoteniLabel;
    private javax.swing.JLabel pocetKilometrovLabel;
    private javax.swing.JComboBox pocetTurComboBox;
    private javax.swing.JLabel pocetTurLabel;
    private javax.swing.JLabel priemernaObtiaznostLabel;
    private javax.swing.JLabel priemernaRychlostLabel;
    private javax.swing.JButton rebricekButton;
    private javax.swing.JButton vynulovatButton;
    private javax.swing.JButton zrusitButton;
    // End of variables declaration//GEN-END:variables
}
