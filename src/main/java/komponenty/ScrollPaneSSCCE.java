package komponenty;

import gui.TuraForm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ScrollPaneSSCCE extends JPanel {

    private JTable table;

    public JTable getTable() {
        return table;
    }
    private TuraForm turaForm;

    public ScrollPaneSSCCE(ArrayList<ImageIcon> zoznamFotiek) {
        turaForm = new TuraForm();
        setLayout(new BorderLayout());
        table = new JTable(1, zoznamFotiek.size());
        table.setFillsViewportHeight(true);

        class ImageRenderer extends DefaultTableCellRenderer {

            JLabel lbl = new JLabel();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                lbl.setHorizontalAlignment(JLabel.CENTER);
                lbl.setVerticalAlignment(JLabel.CENTER);
                lbl.setIcon((Icon) value);
                if (table.getSelectedColumn() == column) {
                    lbl.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
                } else {
                    lbl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                }
                return lbl;
            }
        }

        DefaultTableModel model = new DefaultTableModel(1, zoznamFotiek.size()) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        model.fireTableDataChanged();
        table.setDefaultRenderer(Object.class, new ImageRenderer());
        table.setModel(model);
        for (int i = 0; i < zoznamFotiek.size(); i++) {
            model.setValueAt(zoznamFotiek.get(i), 0, i);
            table.getColumnModel().getColumn(i).setPreferredWidth(200);
        }

        table.setShowGrid(false);
        table.setTableHeader(null);
        table.setRowHeight(120);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        JScrollBar horizontal = scrollPane.getHorizontalScrollBar();

        BasicArrowButton west = new BasicArrowButton(BasicArrowButton.WEST);

        west.setAction(
                new ActionMapAction("", horizontal, "negativeUnitIncrement"));
        add(west, BorderLayout.WEST);

        BasicArrowButton east = new BasicArrowButton(BasicArrowButton.EAST);

        east.setAction(
                new ActionMapAction("", horizontal, "positiveUnitIncrement"));
        add(east, BorderLayout.EAST);
        add(scrollPane);
    }

}
