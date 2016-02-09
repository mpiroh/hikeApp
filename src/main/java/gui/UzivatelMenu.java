package gui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import sk.ics.upjs.hikeapp.DaOFactory;
import sk.ics.upjs.hikeapp.Tura;
import sk.ics.upjs.hikeapp.TuraDaO;
import sk.ics.upjs.hikeapp.UzivatelDaO;

public class UzivatelMenu extends javax.swing.JFrame implements MouseListener {

    private TuraDaO tury;
    private UzivatelDaO uzivatel;
    private List<Tura> zoznamTur;
    private Long IdUzivatela;
    private JLabel preListener = null; // lebo bude davata MouseListener len na JLabely

    public UzivatelMenu() {
        initComponents();
    }

    public UzivatelMenu(Long idU) {
        initComponents();
        tury = DaOFactory.INSTANCE.getTuraDaO();
        uzivatel = DaOFactory.INSTANCE.getUserDaO();
        IdUzivatela = idU;
        zoznamTur = tury.dajTuryPozivatela(idU);

        BufferedImage searchObrazok = null;
        BufferedImage addObrazok = null;
        BufferedImage toolsObrazok = null;
        BufferedImage inspirationObrazok = null;
        BufferedImage mapsObrazok = null;
        BufferedImage statsObrazok = null;

//        try {
//            searchObrazok = ImageIO.read(new File("C:\\naMenu\\search1.png"));
//           addObrazok = ImageIO.read(new File("C:\\naMenu\\add1.png"));
//            toolsObrazok = ImageIO.read(new File("C:\\naMenu\\tools1.png"));
//            inspirationObrazok = ImageIO.read(new File("C:\\naMenu\\inspiration.png"));
//            mapsObrazok = ImageIO.read(new File("C:\\naMenu\\map1.png"));
//            statsObrazok = ImageIO.read(new File("C:\\naMenu\\stats1.png"));

//        } catch (IOException ex) {
//            System.err.println("Neni obrazok!");
//        }
//        Image scaledSearch = searchObrazok.getScaledInstance(45,
//                40, Image.SCALE_SMOOTH);
//        Image scaledTools = toolsObrazok.getScaledInstance(45,
//                40, Image.SCALE_SMOOTH);
//        Image scaledMaps = mapsObrazok.getScaledInstance(45,
//                40, Image.SCALE_SMOOTH);
//        Image scaledStats = statsObrazok.getScaledInstance(35,
//                30, Image.SCALE_SMOOTH);
//        Image scaledInspiration = inspirationObrazok.getScaledInstance(45,
//                40, Image.SCALE_SMOOTH);
//        Image scaledAdd = addObrazok.getScaledInstance(35,
//                30, Image.SCALE_SMOOTH);

//        hladajLabel.setIcon(new ImageIcon(scaledSearch));
//        pridajLabel.setIcon(new ImageIcon(scaledAdd));
//        upravLabel.setIcon(new ImageIcon(scaledTools));
//        inspirujLabel.setIcon(new ImageIcon(scaledInspiration));
//        mojeTuryLabel.setIcon(new ImageIcon(scaledMaps));
//        statistikyLabel.setIcon(new ImageIcon(scaledStats));

        pridajLabel.setHorizontalAlignment(JLabel.CENTER);
        pridajLabel.setVerticalAlignment(JLabel.CENTER);

        hladajLabel.setHorizontalAlignment(JLabel.CENTER);
        hladajLabel.setVerticalAlignment(JLabel.CENTER);

        mojeTuryLabel.setHorizontalAlignment(JLabel.CENTER);
        mojeTuryLabel.setVerticalAlignment(JLabel.CENTER);

        statistikyLabel.setHorizontalAlignment(JLabel.CENTER);
        statistikyLabel.setVerticalAlignment(JLabel.CENTER);

        upravLabel.setHorizontalAlignment(JLabel.CENTER);
        upravLabel.setVerticalAlignment(JLabel.CENTER);

        inspirujLabel.setHorizontalAlignment(JLabel.CENTER);
        inspirujLabel.setVerticalAlignment(JLabel.CENTER);

        pridajLabel.addMouseListener(this);   
        hladajLabel.addMouseListener(this);
        mojeTuryLabel.addMouseListener(this);
        statistikyLabel.addMouseListener(this);
        upravLabel.addMouseListener(this);
        inspirujLabel.addMouseListener(this);
        
        pridajLabel.setText("pridat");
        hladajLabel.setText("hladat");
        mojeTuryLabel.setText("moje tury");
        statistikyLabel.setText("statistiky");
        upravLabel.setText("upravit");
        inspirujLabel.setText("inspirovat");
        
        this.pack();
        this.setTitle("HikeApp");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width - this.getSize().width) / 2, (dim.height - this.getSize().height) / 2);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                UzivatelMenu.this.dispose();
                new LogInForm().setVisible(true);
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pridajLabel = new javax.swing.JLabel();
        hladajLabel = new javax.swing.JLabel();
        upravLabel = new javax.swing.JLabel();
        inspirujLabel = new javax.swing.JLabel();
        mojeTuryLabel = new javax.swing.JLabel();
        statistikyLabel = new javax.swing.JLabel();
        pozadieLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pridajLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(pridajLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 85, 70));

        hladajLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(hladajLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 85, 70));

        upravLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(upravLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 85, 70));

        inspirujLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(inspirujLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 85, 70));

        mojeTuryLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(mojeTuryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 85, 70));

        statistikyLabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(statistikyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 85, 70));

        pozadieLabel.setIcon(new javax.swing.ImageIcon("C:\\naMenu\\menu1.jpg")); // NOI18N
        getContentPane().add(pozadieLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 410));

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
            java.util.logging.Logger.getLogger(UzivatelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UzivatelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UzivatelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UzivatelMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UzivatelMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hladajLabel;
    private javax.swing.JLabel inspirujLabel;
    private javax.swing.JLabel mojeTuryLabel;
    private javax.swing.JLabel pozadieLabel;
    private javax.swing.JLabel pridajLabel;
    private javax.swing.JLabel statistikyLabel;
    private javax.swing.JLabel upravLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        if (preListener.equals(pridajLabel)) {
            new VlozTuruForm(IdUzivatela).setVisible(true);
            this.dispose();
        }
        if (preListener.equals(hladajLabel)) {
            new FilterTurForm(IdUzivatela).setVisible(true);
            this.dispose();
        }
        if (preListener.equals(mojeTuryLabel)) {
            new MainForm(zoznamTur, IdUzivatela, -1).setVisible(true);
            this.dispose();
        }
        if (preListener.equals(upravLabel)) {
            new MainForm(zoznamTur, IdUzivatela, 0).setVisible(true);
            this.dispose();
        }
        if (preListener.equals(statistikyLabel)) {
            new StatistikaForm(IdUzivatela).setVisible(true);
            this.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        preListener = (JLabel) e.getSource();
        preListener.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        preListener = (JLabel) e.getSource();
        preListener.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        preListener = (JLabel) e.getSource();
        preListener.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        preListener = (JLabel) e.getSource();
        preListener.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
