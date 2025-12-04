package view.menu;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import java.awt.MenuItem;
import model.MenuItem;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import net.miginfocom.swing.MigLayout;

public class PanelMenu extends JPanel {

    

    private final CardLayout cardLayout;
    private final JPanel panelKonten;
    private JPanel panelSubMenu;
    private JPanel panelJudul;
    private JLabel labelJudul;
    private JLabel labelMenuItem;
    private PanelMenuItem panelMenuItem;
    private PanelMenuItem panelDashboard = null;

    public PanelMenu(List<MenuItem> listDaftarMenuItem, CardLayout cardLayout, JPanel panelKonten){
        this.cardLayout = cardLayout;
        this.panelKonten = panelKonten;
        initializeUI();
        buildMenu(listDaftarMenuItem);
        selectDefaultMenu();
    }

    private void initializeUI() {
        setLayout(new MigLayout(
            "fillx, wrap 1, insets 0, gap 0, hidemode 3",
            "[grow]",
            ""
        ));
        setPreferredSize(new Dimension(280, 0));
        setBackground(new Color(245, 247, 250));

        panelJudul = new JPanel(new MigLayout("fillx, h 60!, gap 0, insets 10"));
        labelJudul = new JLabel("Aplikai Tisa");
        labelJudul.setFont(new Font("inter", Font.BOLD, 20));
        labelJudul.setForeground(new Color(0, 48, 73));
        panelJudul.add(labelJudul, "center, pushy");
        panelJudul.setBackground(getBackground());
        add(panelJudul, "grow");

        add(new JSeparator(), "growx, gaptop 5, gapbottom 5");

        //throw new UnsupportedOperationException("Unimplemented method 'initializeUI'");
    }

    private void buildMenu(List<MenuItem> listDaftarMenuItem){
        for (MenuItem menu : listDaftarMenuItem) {
            labelMenuItem = new JLabel(menu.getJudul());
            labelMenuItem.setFont(new Font("Arial", Font.BOLD,14));

            /** Panel Menu Item */
            panelMenuItem = new PanelMenuItem(menu, this, true);
            add(panelMenuItem, "growx, wrap, h 37!");

            /** Panel (Sub) Menu Item */
            if (menu.hasSubMenuItem()) {
                panelSubMenu = panelMenuItem.getPanelContainerSubMenu();
                add(panelSubMenu, "growx, wrap, gapleft 24, gapright 10, gaptop 10, gapbottom 10");
                panelSubMenu.setVisible(false);
                
            }

            add(new JSeparator(), "growx, gaptop 5, gapbottom 5");

            if("Dashboard".equals(menu.getJudul())) {
                panelDashboard = panelMenuItem;
            }
        }
    }

    private void selectDefaultMenu() {
        if (panelDashboard != null) {
            selectMenuItem(panelDashboard);
        }
        //throw new UnsupportedOperationException("Unimplemented method 'selectDefaultMenu'");
    }

    public void selectMenuItem(PanelMenuItem clickedPanel) {
        if (panelMenuItem != null && panelMenuItem != clickedPanel) {
            panelMenuItem.setSelectedByParent(false);
        }

        clickedPanel.setSelectedByParent(true);
        panelMenuItem = clickedPanel;

        String key = clickedPanel.getContentKey();
        if (key != null) {
            cardLayout.show(panelKonten, key);
        }
        //throw new UnsupportedOperationException("Unimplemented method 'selectMenuItem'");
    }
    
}
