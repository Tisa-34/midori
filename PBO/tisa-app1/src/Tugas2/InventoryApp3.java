package Tugas2;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder; // Impor untuk border solid
import net.miginfocom.swing.MigLayout;

// Menggunakan nama InventoryApp3 untuk membedakan dari versi sebelumnya
public class InventoryApp3 extends JFrame {

    // --- Deklarasi Komponen UI ---
    private JTextField productNameField;
    private JTextField stockField;
    private JComboBox<String> categoryComboBox;
    private JCheckBox priorityCheckbox;
    private JButton saveButton;
    private JTextArea logTextArea;

    public InventoryApp3() {
        // --- 1. Konfigurasi Frame Utama ---
        setTitle("Inventory App");
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Layout utama tanpa "debug"
        setLayout(new MigLayout("fill, insets 20", "[grow, fill]20[grow, fill]", "fill"));

        // TAMBAHAN: Memberi batas (border) pada JFrame secara visual
        getRootPane().setBorder(new LineBorder(Color.BLUE, 3)); // Border biru untuk Frame terluar

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

        // TAMBAHAN: Border merah untuk Panel Kiri
        panel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(Color.RED, 1), 
            BorderFactory.createTitledBorder("Inventory App")
        ));

        // Baris 1: Nama Produk
        productNameField = new JTextField(20);
        productNameField.setText("Mouse Logitech"); 
        panel.add(createLabeledComponent("Nama Produk:", productNameField), "span 2, growx, wrap"); 
        
        // Baris 2: Stok
        stockField = new JTextField(5);
        stockField.setText("14"); 
        panel.add(createLabeledComponent("Stok:", stockField), "span 2, growx, wrap");

        // Baris 3: Kategori
        categoryComboBox = new JComboBox<>(new String[]{"Elektronik", "Peralatan Dapur", "Pakaian"});
        categoryComboBox.setSelectedItem("Elektronik"); 
        panel.add(createLabeledComponent("Kategori:", categoryComboBox), "span 2, growx, wrap");

        // Baris 4: Prioritas Kirim
        priorityCheckbox = new JCheckBox("Ya, Prioritas");
        priorityCheckbox.setSelected(false);
        panel.add(createLabeledComponent("Prioritas Kirim:", priorityCheckbox), "span 2, wrap");

        // Baris 5: Tombol Simpan
        saveButton = new JButton("Simpan & Notifikasi");
        panel.add(saveButton, "span 2, gaptop 20, align center");

        return panel;
    }

    // Metode Pembantu untuk menciptakan Label dan Komponen dalam satu baris (agar mudah diberi border)
    private JPanel createLabeledComponent(String labelText, JComponent component) {
        JPanel container = new JPanel(new MigLayout("insets 0, fill", "[right, pref!]10[grow, fill]", "fill"));
        container.add(new JLabel(labelText));
        container.add(component, "growx");
        // TAMBAHAN: Border hijau untuk baris komponen
        container.setBorder(new LineBorder(Color.GREEN.darker(), 1));
        return container;
    }

    // --- Metode Pembuatan Panel Kanan (Log Aktivitas) ---
    private JPanel createLogPanel() {
        JPanel panel = new JPanel(new MigLayout("fill"));
        
        // TAMBAHAN: Border merah untuk Panel Kanan
        panel.setBorder(new LineBorder(Color.RED, 1));
        
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

    // --- Metode Main ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryApp3::new);
    }
}