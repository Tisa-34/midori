package Tugas2;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

// Ini adalah kelas utama, dan namanya harus sesuai dengan nama file (.java)
public class InventoryApp extends JFrame {

    // --- Deklarasi Komponen UI ---
    private JTextField productNameField;
    private JTextField stockField;
    private JComboBox<String> categoryComboBox;
    private JCheckBox priorityCheckbox;
    private JButton saveButton;
    private JTextArea logTextArea;

    public InventoryApp() {
        // --- 1. Konfigurasi Frame Utama ---
        setTitle("Inventory App");
        
        // Menggunakan System Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Layout utama menggunakan MigLayout (2 Kolom)
        setLayout(new MigLayout("fill, insets 20", "[grow, fill]20[grow, fill]", "fill"));

        // --- 2. Panel Kiri (Form Input) ---
        JPanel inputPanel = createInputPanel();
        add(inputPanel, "grow, pushy");

        // --- 3. Panel Kanan (Log Aktivitas) ---
        JPanel logPanel = createLogPanel();
        add(logPanel, "grow, pushy, wrap");

        // --- 4. Konfigurasi Aksi Tombol ---
        saveButton.addActionListener(e -> showSuccessDialog());

        // --- 5. Konfigurasi Akhir Frame ---
        setMinimumSize(new Dimension(650, 400));
        pack(); 
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    // --- Metode Pembuatan Panel Kiri (Form Input) ---
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new MigLayout(
                "wrap 2, gap 10", 
                "[right, pref!]10[grow, fill]", 
                "[]" 
        ));

        panel.setBorder(BorderFactory.createTitledBorder("Inventory App"));

        // Nama Produk
        productNameField = new JTextField(20);
        productNameField.setText("Mouse Logitech"); 
        panel.add(new JLabel("Nama Produk:"));
        panel.add(productNameField, "growx");

        // Stok
        stockField = new JTextField(5);
        stockField.setText("14"); 
        panel.add(new JLabel("Stok:"));
        panel.add(stockField, "growx");

        // Kategori
        categoryComboBox = new JComboBox<>(new String[]{"Elektronik", "Peralatan Dapur", "Pakaian"});
        categoryComboBox.setSelectedItem("Elektronik"); 
        panel.add(new JLabel("Kategori:"));
        panel.add(categoryComboBox, "growx");

        // Prioritas Kirim
        priorityCheckbox = new JCheckBox("Ya, Prioritas");
        priorityCheckbox.setSelected(false);
        panel.add(new JLabel("Prioritas Kirim:"));
        panel.add(priorityCheckbox);

        // Tombol Simpan
        saveButton = new JButton("Simpan & Notifikasi");
        panel.add(saveButton, "span 2, gaptop 20, align center");

        return panel;
    }

    // --- Metode Pembuatan Panel Kanan (Log Aktivitas) ---
    private JPanel createLogPanel() {
        JPanel panel = new JPanel(new MigLayout("fill"));
        
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logTextArea);

        panel.add(new JLabel("Log Aktivitas Tambahan:"), "wrap");
        panel.add(scrollPane, "grow, push");

        return panel;
    }

    // --- Metode untuk Menampilkan Dialog Sukses ---
    private void showSuccessDialog() {
        String namaProduk = productNameField.getText();
        String stok = stockField.getText();
        String kategori = (String) categoryComboBox.getSelectedItem();
        String prioritas = priorityCheckbox.isSelected() ? "YA" : "TIDAK";

        String message = "<html><b>Data Produk Berhasil Disimpan!</b><br>"
                    + "Nama: " + namaProduk + "<br>"
                    + "Kategori: " + kategori + "<br>"
                    + "Stok: " + stok + "<br>"
                    + "Prioritas: " + prioritas + "</html>";
        
        JOptionPane.showMessageDialog(this, 
                                    message, 
                                    "Sukses", 
                                    JOptionPane.INFORMATION_MESSAGE);

        logTextArea.append(String.format("[%tT] Produk '%s' disimpan (Stok: %s). Prioritas: %s%n", 
                                        System.currentTimeMillis(), namaProduk, stok, prioritas));
    }

    // --- Metode Main untuk menjalankan aplikasi ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryApp::new);
    }
}