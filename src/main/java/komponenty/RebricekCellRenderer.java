package komponenty;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import sk.ics.upjs.hikeapp.Uzivatel;

public class RebricekCellRenderer extends DefaultListCellRenderer {

    private Long idUzivatela;
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Uzivatel uzivatel = (Uzivatel) value;
        if (idUzivatela.equals(uzivatel.getId())) {
            component.setFont(component.getFont().deriveFont(Font.BOLD));
            component.setForeground(Color.red);
        }
        return component;
    }

    public void setIdUzivatela(Long idUzivatela) {
        this.idUzivatela = idUzivatela;
    }
}
