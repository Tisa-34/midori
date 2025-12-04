package model;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private final String judul;
    private final String keyCardLayout;
    private final List<MenuItem> ListSubMenuItem;

    public MenuItem (String judul, String keyCardLayout) {
        this.judul = judul;
        this.keyCardLayout = keyCardLayout;
        this.ListSubMenuItem = new ArrayList<>();
    }

    public MenuItem (String judul) {
        this(judul, null);
    }

    public String getJudul() {
        return judul;
    }

    public String getKeyCardLayout() {
        return keyCardLayout;
    }

    public List<MenuItem> getListSubMenuItem() {
        return ListSubMenuItem;
    }

    public boolean hasSubMenuItem() {
        return !ListSubMenuItem.isEmpty();
    }
    
    public void addSubMenuItem(MenuItem subMenu) {
        ListSubMenuItem.add(subMenu);
    }
}
