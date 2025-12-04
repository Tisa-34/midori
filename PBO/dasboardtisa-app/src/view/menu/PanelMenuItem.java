package view.menu;

import java.awt.Color;
import java.awt.Font;
//import java.awt.MenuItem;
import model.MenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class PanelMenuItem extends JPanel{
    private static final Color BG_SIDEBAR = new Color(245, 247, 250);
    private static final Color BG_HOVER = new Color(224, 230, 235);
    private static final Color BG_SELECTED = new Color(234, 242, 235);

    private static final Color TEXT_NORMAL = new Color(98, 117, 138);
    private static final Color TEXT_HOVER = new Color(0, 48, 73);
    private static final Color TEXT_SELECTED = new Color(131, 188, 160);

    private final String contentKey;
    private boolean isSubMenu;
    private boolean selected = false;

    private JPanel panelContainerSubMenu;
    private JLabel labelMenu;
    private PanelMenuItem panelSubMenuItem;
    private PanelMenu panelMenu;
/** 
    public PanelMenuItem (MenuItem item, PanelMenu panelMenu, boolean isSubMenu){
        this(item, panelMenu, false);
    }

    private PanelMenuItem(MenuItem item, PanelMenu panelMenu, boolean isSubMenu){
        this.contentKey = item.getKeyCardLayout();
        this.panelMenu = panelMenu;
        this.isSubMenu = isSubMenu;

        initializeUI(item);
        setupEventHandlers();
    }
*/
/** */
    public PanelMenuItem(MenuItem item, PanelMenu panelMenu, boolean isSubMenu){ 
        this.contentKey = item.getKeyCardLayout();
        this.panelMenu = panelMenu;
        this.isSubMenu = isSubMenu;

        initializeUI(item);
        setupEventHandlers();
    }


    public PanelMenuItem(java.awt.MenuItem menu, PanelMenu panelMenu2) {
        this.contentKey = "";
    
}


    private void initializeUI(MenuItem item){
        panelContainerSubMenu = new JPanel(
            new MigLayout(
                "fillx, insets 10, gap 0, hidemode 3",
                "[grow]",
                ""
            )
        );

        panelContainerSubMenu.setBackground(Color.WHITE);
        panelContainerSubMenu.setOpaque(true);

        setLayout(new MigLayout(
            "fill, insets 0, gap 0",
            "[grow]",
            "[]"
        ));

        setBackground(isSubMenu ? Color.WHITE : BG_SIDEBAR);

        labelMenu = new JLabel();
        labelMenu.setText(item.getJudul());
        labelMenu.setFont(new Font("inter", isSubMenu ? Font.PLAIN : Font.BOLD, 15));
        labelMenu.setForeground(TEXT_NORMAL);

        if (isSubMenu) {
            add(labelMenu, "gapleft 10, grow, pushy, wrap");
        } else {
            add(labelMenu, "gapleft 24, grow, pushy, wrap");
        }

        for (MenuItem sub : item.getListSubMenuItem()) {
            panelSubMenuItem = new PanelMenuItem(sub, panelMenu, true);
            panelContainerSubMenu.add(panelSubMenuItem, "growx, h 42!, wrap");
        }
    }

    private void setupEventHandlers() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                if (!selected) {
                    setBackground(BG_HOVER);
                    labelMenu.setForeground(TEXT_HOVER);
                    
                }
            }

            @Override
            public void mouseExited(MouseEvent e){
                if (!selected) {
                    setBackground(isSubMenu ? Color.WHITE : BG_SIDEBAR);
                    labelMenu.setForeground(TEXT_NORMAL);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                panelMenu.selectMenuItem(PanelMenuItem.this);
                if (panelContainerSubMenu.getComponentCount() > 0) {
                    boolean visible = panelContainerSubMenu.isVisible();
                    panelContainerSubMenu.setVisible(!visible);
                    revalidate();
                    repaint();
                }
            }
        });
    }

    public void setSelectedByParent(boolean selected){
        this.selected = selected;
        setBackground(selected ? BG_SELECTED : (isSubMenu ? Color.WHITE : BG_SIDEBAR));
        labelMenu.setForeground(selected ? TEXT_SELECTED : TEXT_NORMAL);
    }

    public String getContentKey(){
        return contentKey;
    }

    public JPanel getPanelContainerSubMenu(){
        return panelContainerSubMenu;
    }
}
