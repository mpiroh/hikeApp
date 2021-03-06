/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Patrik
 */
public class testik extends javax.swing.JFrame {

    private JButton loginButton;
    private JButton registerButton;
    private JTextField menoTextField;
    private JTextField hesloTextField;
    private JLabel hostLabel;

    public testik() {
        initComponents();
        loginButton = new JButton("Login");
        registerButton = new JButton("Registruj");
        menoTextField = new JTextField(11);
        hesloTextField = new JTextField(11);
        hostLabel = new JLabel("<html><u>Hosť</u></html>");
        pack();
        JPanel content = new JPanel(new GridBagLayout());
        content.setBackground(Color.white);
        //content.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setContentPane(content);
        this.add(new LoginPane());
        final Color farbaHostLabel = hostLabel.getForeground();
        hostLabel.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                hostLabel.setForeground(Color.BLUE);
                hostLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

        });
        hostLabel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(MouseEvent e) {
                hostLabel.setForeground(farbaHostLabel);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        pack();
        //this.setLocationRelativeTo(null);
    }

    public class LoginPane extends JPanel {

        public LoginPane() {
            setLayout(new GridBagLayout());
            //setBorder(new TitledBorder("Login"));
            setBackground(Color.white);

            BufferedImage logInObrazok = null;
            try {
                logInObrazok = ImageIO.read(new File("C:\\loginLogo.jpg"));
            } catch (IOException ex) {
                System.err.println("Neni obrazok!");
            }
            Image scaledObrazok = logInObrazok.getScaledInstance(350,
                    220, Image.SCALE_SMOOTH);
            //l.setIcon(new ImageIcon(scaledObrazok));
            ImageIcon img = new ImageIcon(scaledObrazok);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            //gbc.ipadx = 350;
            //gbc.ipady = 220;
            gbc.gridwidth = 5;
            JLabel l = new JLabel(img);
            l.setBorder(BorderFactory.createLineBorder(Color.black));
            add(l, gbc);

            // vynulovat
            gbc.ipadx = 0;
            gbc.ipady = 0;
            gbc.gridwidth = 1;

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.ipadx = 80;
            l = new JLabel();
            //l.setBorder(BorderFactory.createLineBorder(Color.black));
            add(l, gbc);
            // vynulovat
            gbc.ipadx = 0;

            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Meno:"), gbc);
            gbc.gridy = 2;
            add(new JLabel("Heslo:"), gbc);

            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.gridwidth = 3;
            //gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;
            add(menoTextField, gbc);
            gbc.gridy++;
            add(hesloTextField, gbc);

            gbc.gridx = 2;
            gbc.gridy++;
            gbc.gridwidth = 1;
            gbc.weightx = 0;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.EAST;
            add(loginButton, gbc);

            gbc.gridx = 3;
            gbc.anchor = GridBagConstraints.WEST;
            add(registerButton, gbc);

            gbc.gridx = 4;
            gbc.anchor = GridBagConstraints.CENTER;
            add(hostLabel, gbc);
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

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(testik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
