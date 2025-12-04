package Tugas2;

import javax.swing.*;
//import javax.swing.border.TitledBorder;
import java.awt.*;
//import java.awt.geom.Rectangle2D;
import net.miginfocom.swing.MigLayout;

// --- 1. Kelas Kustom untuk Menggambar Garis Putus-Putus ---
class DebugPanel extends JPanel {
    private Color lineColor;
    private boolean drawDashed;

    public DebugPanel(LayoutManager layout, Color color, boolean dashed) {
        super(layout);
        this.lineColor = color;
        this.drawDashed = dashed;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Menggambar batas komponen itu sendiri
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(lineColor);
        
        // Atur stroke untuk garis putus-putus
        if (drawDashed) {
            float[] dash = {5.0f, 5.0f}; // Panjang garis, panjang spasi
            g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
        } else {
            g2d.setStroke(new BasicStroke(1.0f));
        }
        
        // Gambar batas luar panel
        g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        g2d.dispose();
    }
}

// --- 2. Kelas Utama Aplikasi ---
public class InventoryApp4 extends JFrame {

    private JTextField productNameField;
    private JTextField stockField;
    private JComboBox<String> categoryComboBox;
    private JCheckBox priorityCheckbox;
    private JButton saveButton;
    private JTextArea logTextArea;

    public InventoryApp4() {
        setTitle("Inventory App (Simulasi Debug)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Frame Utama (Border Biru Tebal)
        setLayout(new MigLayout("fill, insets 10", "[grow, fill]10[grow, fill]", "fill"));
        getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLUE, 3)); 
        
        // --- Panel Kiri (Form Input) ---
        JPanel inputPanel = createInputPanel();
        add(inputPanel, "grow, pushy"); 

        // --- Panel Kanan (Log Aktivitas) ---
        JPanel logPanel = createLogPanel();
        add(logPanel, "grow, pushy, wrap"); 

        saveButton.addActionListener(e -> showSuccessDialog());

        setMinimumSize(new Dimension(650, 400));
        pack(); 
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    // --- Metode Pembuatan Panel Kiri (Form Input) ---
    private JPanel createInputPanel() {
        // Menggunakan DebugPanel untuk menampilkan border Merah Putus-putus
        JPanel panel = new DebugPanel(new MigLayout(
                "wrap 2, gap 10", 
                "[right, pref!]10[grow, fill]", 
                "[]" 
        ), Color.RED, true);
        
        panel.setBorder(BorderFactory.createTitledBorder("Inventory App"));

        // Baris 1: Nama Produk (Dibungkus dalam DebugPanel Hijau)
        productNameField = new JTextField(20);
        productNameField.setText("Mouse Logitech"); 
        panel.add(createDebugRow("Nama Produk:", productNameField, Color.GREEN.darker()), "span 2, growx, wrap"); 

        // Baris 2: Stok (Dibungkus dalam DebugPanel Hijau)
        stockField = new JTextField(5);
        stockField.setText("14"); 
        panel.add(createDebugRow("Stok:", stockField, Color.GREEN.darker()), "span 2, growx, wrap");

        // Baris 3: Kategori (Dibungkus dalam DebugPanel Hijau)
        categoryComboBox = new JComboBox<>(new String[]{"Elektronik", "Peralatan Dapur", "Pakaian"});
        categoryComboBox.setSelectedItem("Elektronik"); 
        panel.add(createDebugRow("Kategori:", categoryComboBox, Color.GREEN.darker()), "span 2, growx, wrap");

        // Baris 4: Prioritas Kirim (Dibungkus dalam DebugPanel Hijau)
        priorityCheckbox = new JCheckBox("Ya, Prioritas");
        priorityCheckbox.setSelected(false);
        panel.add(createDebugRow("Prioritas Kirim:", priorityCheckbox, Color.GREEN.darker()), "span 2, growx, wrap");

        // Baris 5: Tombol Simpan
        saveButton = new JButton("Simpan & Notifikasi");
        // Tombol juga bisa dibungkus dalam DebugPanel Merah Putus-putus
        JPanel buttonContainer = new DebugPanel(new FlowLayout(FlowLayout.CENTER, 0, 0), Color.RED, true);
        buttonContainer.add(saveButton);
        panel.add(buttonContainer, "span 2, gaptop 20, align center");

        return panel;
    }

    // Metode Pembantu untuk menciptakan satu baris Form dengan batas Hijau Putus-putus
    private JPanel createDebugRow(String labelText, JComponent component, Color color) {
        // Menggunakan DebugPanel Merah Putus-putus untuk meniru sel layout
        JPanel container = new DebugPanel(new MigLayout("insets 0, fill", "[right, pref!]10[grow, fill]", "fill"), color, true);
        
        // Label dan komponen input
        container.add(new JLabel(labelText));
        container.add(component, "growx");
        
        // Memberi border pada komponen input itu sendiri (misal, Biru Tipis)
        component.setBorder(BorderFactory.createLineBorder(Color.BLUE.darker(), 1));
        
        return container;
    }

    // --- Metode Pembuatan Panel Kanan (Log Aktivitas) ---
    private JPanel createLogPanel() {
        // Menggunakan DebugPanel untuk menampilkan border Merah Putus-putus
        JPanel panel = new DebugPanel(new MigLayout("fill"), Color.RED, true);
        
        panel.setBorder(BorderFactory.createTitledBorder("Log Aktivitas Tambahan:"));
        
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logTextArea);
        
        // Memberi border pada ScrollPane (Hijau Putus-putus)
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker(), 1));

        panel.add(scrollPane, "grow, push"); 

        return panel;
    }

    private void showSuccessDialog() {
        String namaProduk = productNameField.getText();
        String stok = stockField.getText();
        String kategori = (String) categoryComboBox.getSelectedItem();
        String prioritas = priorityCheckbox.isSelected() ? "YA" : "TIDAK";

        String message = "<html><b>Data Produk Berhasil Disimpan!</b><br>"
                       + "Nama: " + namaProduk + "<br>"
                       + "Stok: " + stok + "<br>"
                       + "Kategori: " + kategori + "<br>"
                       + "Prioritas: " + prioritas + "</html>";
        
        JOptionPane.showMessageDialog(this, 
                                      message, 
                                      "Sukses", 
                                      JOptionPane.INFORMATION_MESSAGE);

        logTextArea.append(String.format("[%tT] Produk '%s' disimpan (Stok: %s). Prioritas: %s%n", 
                                        System.currentTimeMillis(), namaProduk, stok, prioritas));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryApp4::new);
    }
}