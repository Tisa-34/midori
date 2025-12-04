package Tugas2;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

// Kelas utama yang merupakan JFrame
public class InventoryApp1 extends JFrame {

    // --- Deklarasi Komponen UI ---
    private JTextField productNameField;
    private JTextField stockField;
    private JComboBox<String> categoryComboBox;
    private JCheckBox priorityCheckbox;
    private JButton saveButton;
    private JTextArea logTextArea;

    public InventoryApp1() {
        // --- 1. Konfigurasi Frame Utama ---
        setTitle("Inventory App");
        // Menggunakan System Look and Feel agar tampilan lebih modern (opsional)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Menggunakan MigLayout untuk layout utama (2 Kolom)
        // LC: fill, insets 20
        // AC: [grow, fill]20[grow, fill] -> Dua kolom sama rata, tumbuh, dan mengisi
        setLayout(new MigLayout("fill, insets 20", "[grow, fill]20[grow, fill]", "fill"));

        // --- 2. Menambahkan Header Utama ---
        // (Opsional, untuk menambahkan judul "Analisis Komponen Swing + MigLayout" di atas)
        // Kita letakkan di luar container panel utama
        
        // --- 3. Panel Kiri (Form Input) ---
        JPanel inputPanel = createInputPanel();
        add(inputPanel, "grow, pushy"); // Menambahkan panel input ke kolom 1

        // --- 4. Panel Kanan (Log Aktivitas) ---
        JPanel logPanel = createLogPanel();
        add(logPanel, "grow, pushy, wrap"); // Menambahkan panel log ke kolom 2

        // --- 5. Konfigurasi Aksi Tombol ---
        saveButton.addActionListener(e -> showSuccessDialog());

        // --- 6. Konfigurasi Akhir Frame ---
        // Atur ukuran minimal agar form tidak terlalu kecil
        setMinimumSize(new Dimension(650, 400));
        pack(); 
        setLocationRelativeTo(null); // Menempatkan frame di tengah layar
        setVisible(true);
    }
    
    // --- Metode Pembuatan Panel Kiri (Form Input) ---
    private JPanel createInputPanel() {
        // Layout Constraints Form: wrap 2 (2 kolom), gap 10
        // Column Constraints Form: [right]10[grow, fill] (Label rata kanan, Field tumbuh dan mengisi)
        JPanel panel = new JPanel(new MigLayout(
                "wrap 2, gap 10", 
                "[right, pref!]10[grow, fill]", 
                "[]" 
        ));

        // Memberi border dengan judul "Inventory App"
        panel.setBorder(BorderFactory.createTitledBorder("Inventory App"));

        // Baris 1: Nama Produk
        productNameField = new JTextField(20);
        productNameField.setText("Mouse Logitech"); 
        panel.add(new JLabel("Nama Produk:"));
        panel.add(productNameField, "growx");

        // Baris 2: Stok
        stockField = new JTextField(5);
        stockField.setText("14"); 
        panel.add(new JLabel("Stok:"));
        panel.add(stockField, "growx");

        // Baris 3: Kategori
        categoryComboBox = new JComboBox<>(new String[]{"Elektronik", "Peralatan Dapur", "Pakaian"});
        categoryComboBox.setSelectedItem("Elektronik"); 
        panel.add(new JLabel("Kategori:"));
        panel.add(categoryComboBox, "growx");

        // Baris 4: Prioritas Kirim
        priorityCheckbox = new JCheckBox("Ya, Prioritas");
        priorityCheckbox.setSelected(false);
        panel.add(new JLabel("Prioritas Kirim:"));
        panel.add(priorityCheckbox);

        // Baris 5: Tombol Simpan
        saveButton = new JButton("Simpan & Notifikasi");
        panel.add(saveButton, "span 2, gaptop 20, align center");

        return panel;
    }

    // --- Metode Pembuatan Panel Kanan (Log Aktivitas) ---
    private JPanel createLogPanel() {
        JPanel panel = new JPanel(new MigLayout("fill"));
        
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        // Menggunakan JScrollPane agar area log bisa di-scroll
        JScrollPane scrollPane = new JScrollPane(logTextArea);

        panel.add(new JLabel("Log Aktivitas Tambahan:"), "wrap");
        panel.add(scrollPane, "grow, push"); // ScrollPane mengisi sisa panel

        return panel;
    }

    // --- Metode untuk Menampilkan Dialog Sukses ---
    private void showSuccessDialog() {
        // Mengambil data dari form
        String namaProduk = productNameField.getText();
        String stok = stockField.getText();
        String kategori = (String) categoryComboBox.getSelectedItem();
        String prioritas = priorityCheckbox.isSelected() ? "YA" : "TIDAK";

        // Pesan dialog dalam format HTML
        String message = "<html><b>Data Produk Berhasil Disimpan!</b><br>"
                    + "Nama: " + namaProduk + "<br>"
                    + "Stok: " + stok + "<br>"
                    + "Kategori: " + kategori + "<br>"
                    + "Prioritas: " + prioritas + "</html>";
        
        // Menampilkan dialog "Sukses"
        JOptionPane.showMessageDialog(this, 
                                    message, 
                                    "Sukses", 
                                    JOptionPane.INFORMATION_MESSAGE);

        // Tambahkan log aktivitas
        logTextArea.append(String.format("[%tT] Produk '%s' disimpan (Stok: %s). Prioritas: %s%n", 
                                        System.currentTimeMillis(), namaProduk, stok, prioritas));
    }

    // --- Metode Main ---
    public static void main(String[] args) {
        // Jalankan GUI di Event Dispatch Thread (EDT) sesuai standar Swing
        SwingUtilities.invokeLater(InventoryApp::new);
    }
}
