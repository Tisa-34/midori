package view.konten;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

//import com.formdev.flatlaf.FlatLaf;

import net.miginfocom.swing.MigLayout;

public class PanelRenovasi extends JPanel {

    private static String buttonColor = "background: $Component.accentColor; foreground: #FFFFFF;";

    public PanelRenovasi() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Panel utama yang berisi seluruh komponen
        JPanel panelUtama = new JPanel(new MigLayout(
                "fill, wrap 3",
                "[][grow][]",
                "[][grow][grow][grow][]"
        ));

        
        JPanel panelClient = new JPanel(new MigLayout("wrap 2", "[right]10[left]"));
        panelClient.setBorder(new TitledBorder("Client"));

        panelClient.add(new JLabel("Client ID:"));
        panelClient.add(new JLabel("<html><b>101</b></html>"));

        panelClient.add(new JLabel("Name:"));
        panelClient.add(new JLabel("<html><b>Bapak Alex Gunawan</b></html>"));

        panelClient.add(new JLabel("Phone:"));
        panelClient.add(new JLabel("<html><b>(+62) 8123456789</b></html>"));

        panelClient.add(new JLabel("Registration No:"));
        panelClient.add(new JLabel("<html><b>RNV–JKT–AXG–001</b></html>"));

        JButton buttonDetails = new JButton("Details");
        buttonDetails.putClientProperty("FlatLaf.style", buttonColor);
        panelClient.add(buttonDetails, "span 2, center");

        panelUtama.add(panelClient, "grow");

        
        JPanel panelInformation = new JPanel(new MigLayout(
                "wrap 3",
                "[right]10[left,grow,fill][fill]"
        ));
        panelInformation.setBorder(new TitledBorder("Information"));

        panelInformation.add(new JLabel("Reserve days:"));
        panelInformation.add(new JTextField("0 of 30"));
        panelInformation.add(new JButton("Add Days"));

        panelInformation.add(new JLabel("Buyer:"));
        panelInformation.add(new JTextField("Bapak Alex Gunawan"), "span 2");

        panelInformation.add(new JLabel("Seller:"));
        panelInformation.add(new JTextField("PT Bangun Jaya Abadi"), "span 2");

        panelInformation.add(new JLabel("Address:"));
        panelInformation.add(new JTextField("Jl. Raya Lohbener Baru, 778A"), "span 2");

        panelInformation.add(new JLabel("Credit rating:"));
        panelInformation.add(new JTextField("AAA"));

        panelInformation.add(new JLabel("Update:"));
        panelInformation.add(new JButton("S&P Update"));

        panelInformation.add(new JCheckBox("Approved:"));

        panelInformation.add(new JLabel("Note:"));
        panelInformation.add(new JTextField("Proyek renovasi telah disetujui, siap dimulai"), "span 2");

        panelUtama.add(panelInformation, "grow");

        JPanel panelAdditional = new JPanel(new MigLayout("wrap 3", "[right]10[left,grow,fill][]"));
        panelAdditional.setBorder(new TitledBorder("Additional Information"));

        panelAdditional.add(new JLabel("Estimated close:"));
        panelAdditional.add(new JTextField("2025-12-15"));
        panelAdditional.add(new JButton("Edit"));

        panelAdditional.add(new JLabel("Creation date:"));
        panelAdditional.add(new JLabel("<html><b>2025-10-15</b></html>"), "span 2");

        panelAdditional.add(new JLabel("Created by:"));
        panelAdditional.add(new JLabel("<html><b>Admin</b></html>"), "span 2");

        panelAdditional.add(new JLabel("Last edit date:"));
        panelAdditional.add(new JLabel("<html><b>2025-11-16</b></html>"), "span 2");

        panelAdditional.add(new JLabel("Last edited by:"));
        panelAdditional.add(new JLabel("<html><b>Warnoto</b></html>"), "span 2");

        panelAdditional.add(new JLabel("Closed date:"));
        panelAdditional.add(new JLabel("<html><b>null</b></html>"), "span 2");

        panelAdditional.add(new JLabel("Closed by:"));
        panelAdditional.add(new JLabel("<html><b>null</b></html>"), "span 2");

        panelUtama.add(panelAdditional, "grow");

        
        JPanel panelProduk = new JPanel(new MigLayout("", "[grow][]"));
        panelProduk.setBorder(new TitledBorder("Product List"));

        String[] kolomProduct = {
                "Renovation", "Description", "Part #", "Quantity",
                "List Price", "Discount", "Price", "Wholesale Discount", "Wholesaler Price"
        };

        Object[][] dataProduct = {
                { "Dapur", "Keramik Dinding Putih", "KW-PT-DLX-01", 50, 150000, 0, 7500000L, 5, 712500L },
                { "Dapur", "Lem Keramik Instan", "MLR-GRY-STD", 5, 50000, 0, 250000L, 0, 250000L },
                { "Dapur", "Pipa PVC 3 inch", "PVC-3IN-STOD", 12, 35000, 0, 420000L, 10, 378000L },
                { "Kamar Mandi", "Shower Set Minimalis", "SHW-MN-STL", 1, 850000, 15, 722500L, 5, 686375L },
                { "Kamar Mandi", "Closet Duduk Premium", "CLO-DD-PRM", 1, 2500000, 5, 2375000L, 10, 2137500L },
                { "Ruang Tamu", "Lampu Gantung Hias", "LMP-MNG-CRS", 2, 750000, 0, 1500000L, 0, 1500000L },
                { "Ruang Tamu", "Cat Tembok Putih 20L", "CAT-PT-20L", 3, 450000, 10, 1215000L, 15, 1032750L },
                { "Garasi", "Semen PC 50Kg", "SMN-PC-50", 20, 60000, 0, 1200000L, 5, 1140000L },
        };

        JTable tableProduk = new JTable(new DefaultTableModel(dataProduct, kolomProduct));
        tableProduk.setAutoCreateRowSorter(true);
        tableProduk.setShowGrid(true);

        JScrollPane scrollProduk = new JScrollPane(tableProduk);
        panelProduk.add(scrollProduk, "growx, span 2, h 150");

        panelProduk.add(new JButton("Add"));
        panelProduk.add(new JButton("Edit"));
        panelProduk.add(new JButton("Delete"));

        panelUtama.add(panelProduk, "grow, span 3");

        
        JPanel panelTask = new JPanel(new MigLayout("", "[grow][]"));
        panelTask.setBorder(new TitledBorder("Tasks"));

        String[] kolomTask = {
                "State", "Task", "Assigner", "Executer",
                "Creation Date", "Estimated Date", "Executed Date"
        };

        Object[][] dataTask = {
                { "Completed", "Pengecatan ulang ruang tamu", "Warnoto", "Toni", "2025-10-25", "2025-10-28", "2025-10-27" },
                { "In Progress", "Instalasi closet duduk premium", "Warnoto", "Goang", "2025-11-15", "2025-11-17", null },
                { "Delayed", "Pemasangan keramik dinding dapur", "Warnoto", "Toni", "2025-11-01", "2025-11-04", null },
                { "Completed", "Pemasangan pipa PVC di area garasi", "Warnoto", "Goang", "2025-10-20", "2025-10-21", "2025-10-21" },
                { "Not Started", "Pembelian dan instalasi lampu gantung hias", "Warnoto", "Toni", "2025-11-16", "2025-11-18", null }
        };

        JTable tableTask = new JTable(new DefaultTableModel(dataTask, kolomTask));
        tableTask.setAutoCreateRowSorter(true);
        tableTask.setShowGrid(true);

        JScrollPane scrollTask = new JScrollPane(tableTask);
        panelTask.add(scrollTask, "grow, hmin 150, hmax 190");

        JPanel panelBtnTask = new JPanel(new MigLayout("wrap 1"));
        panelBtnTask.add(new JButton("Add"));
        panelBtnTask.add(new JButton("Edit"));
        panelBtnTask.add(new JButton("Delete"));

        panelTask.add(panelBtnTask, "grow");
        panelUtama.add(panelTask, "grow, span 3");

        
        JPanel panelComments = new JPanel(new MigLayout("", "[grow][]"));
        panelComments.setBorder(new TitledBorder("Comments"));

        String[] kolomComment = { "Date", "User", "Comment" };

        Object[][] dataComment = {
                { "2025-10-26 10:15", "Toni", "Cat tembok sudah diolesi lapisan pertama. Menunggu kering sebelum lapisan kedua." },
                { "2025-11-15 14:30", "Goang", "Barang sudah sampai di lokasi. Mulai proses pembongkaran closet lama sore ini." },
                { "2025-11-16 09:00", "Warnoto", "Pastikan sambungan pipa air bersih dan pembuangan tidak ada yang bocor, cek tekanannya." },
                { "2025-11-03 16:45", "Toni", "Cuaca hujan deras selama 2 hari, area kerja sedikit basah. Pemasangan ditunda besok pagi." },
                { "2025-11-16 20:00", "Warnoto", "Lampu yang diinginkan customer stoknya habis. Mencari alternatif lampu model serupa." }
        };

        JTable tableComment = new JTable(new DefaultTableModel(dataComment, kolomComment));
        tableComment.setAutoCreateRowSorter(true);
        tableComment.setShowGrid(true);

        JScrollPane scrollComment = new JScrollPane(tableComment);
        panelComments.add(scrollComment, "grow, hmin 150, hmax 190");

        JPanel panelBtnComment = new JPanel(new MigLayout("wrap 1"));
        panelBtnComment.add(new JButton("Add"));
        panelBtnComment.add(new JButton("Edit"));
        panelBtnComment.add(new JButton("Delete"));

        panelComments.add(panelBtnComment, "grow");
        panelUtama.add(panelComments, "grow, span 3");

        /** Deklarasi Panel Controls */
            JPanel panelControls = new JPanel(new MigLayout("insets 0", "[grow,left][right]"));

            /** Deklarasi Panel Controls (Left) */
            JPanel panelControlsLeft = new JPanel(new MigLayout());
            panelControlsLeft.add(new JButton("Export"));
            panelControls.add(panelControlsLeft);

            JPanel panelControlsRight = new JPanel(new MigLayout());
            JButton buttonSave = new JButton("Save");
            buttonSave.putClientProperty("FlatLaf.style", buttonColor);
            panelControlsRight.add(buttonSave);
            panelControlsRight.add(new JButton("Cancel"));
            panelControls.add(panelControlsRight);
            panelUtama.add(panelControls,"grow, span 3");


        // ======================================================
        // SCROLL WRAPPER
        // ======================================================
        JScrollPane scroll = new JScrollPane(panelUtama);
        scroll.getVerticalScrollBar().setUnitIncrement(18);

        add(scroll, BorderLayout.CENTER);

        // Smooth scrolling dipasang otomatis ketika panel ditambahkan ke frame
        addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                Window win = SwingUtilities.getWindowAncestor(PanelRenovasi.this);
                if (win instanceof JFrame) {
                    installModernScrollChaining((JFrame) win, scroll);
                }
            }
            @Override public void ancestorRemoved(AncestorEvent event) {}
            @Override public void ancestorMoved(AncestorEvent event) {}
        });
    }

    // ============================================================
    // MODERN SMOOTH SCROLL CHAINING
    // ============================================================
    private static void installModernScrollChaining(JFrame frame, JScrollPane mainScrollPane) {
        final double[] accumulatedDelta = {0.0};

        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (!(event instanceof MouseWheelEvent)) return;
            MouseWheelEvent mwe = (MouseWheelEvent) event;
            if (mwe.isConsumed()) return;

            Component source = mwe.getComponent();
            if (!SwingUtilities.isDescendingFrom(source, frame)) return;

            JScrollPane inner = null;
            for (Component c = source; c != null; c = c.getParent()) {
                if (c instanceof JScrollPane && c != mainScrollPane) {
                    inner = (JScrollPane) c;
                    break;
                }
            }

            if (inner == null) return;

            JScrollBar vbar = inner.getVerticalScrollBar();
            double rotation = mwe.getPreciseWheelRotation();
            if (rotation == 0) return;

            boolean scrollDown = rotation > 0;
            boolean scrollUp = rotation < 0;

            boolean canScrollFurther = false;
            if (vbar != null && vbar.isVisible()) {
                int value = vbar.getValue();
                int extent = vbar.getModel().getExtent();
                int max = vbar.getMaximum();

                boolean atBottom = (value + extent >= max - 1);
                boolean atTop = (value <= 1);

                canScrollFurther = (scrollDown && !atBottom) || (scrollUp && !atTop);
            }

            if (canScrollFurther) {
                accumulatedDelta[0] = 0;
                return;
            }

            accumulatedDelta[0] += rotation;
            if (Math.abs(accumulatedDelta[0]) < 0.7) return;

            JScrollBar mainBar = mainScrollPane.getVerticalScrollBar();
            int delta = (int) Math.signum(accumulatedDelta[0]) * mainBar.getUnitIncrement();

            int newValue = mainBar.getValue() + delta;
            newValue = Math.max(
                    mainBar.getMinimum(),
                    Math.min(mainBar.getMaximum() - mainBar.getModel().getExtent(), newValue)
            );

            mainBar.setValue(newValue);

            accumulatedDelta[0] = 0;
            mwe.consume();

        }, AWTEvent.MOUSE_WHEEL_EVENT_MASK);
    }
}

