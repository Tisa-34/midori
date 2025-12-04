package tugas1;

import java.awt.Dimension;
import javax.swing.*;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import net.miginfocom.swing.MigLayout;

public class InventoryApp {

    public static void main(String[] args) {
        
        // --- 1. SET LOOK AND FEEL (Menggunakan FlatLaf agar tampilan modern) ---
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Gagal mengatur Look and Feel: " + e.getMessage());
        }

        // --- 2. JALANKAN APLIKASI DI EVENT DISPATCH THREAD (EDT) ---
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Inventory App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Atur ukuran frame agar sesuai dengan layout
            frame.setPreferredSize(new Dimension(800, 450));
            
            // Menggunakan MigLayout pada content pane utama
            // Constraints: fill (mengisi seluruh frame), debug (opsional untuk melihat batas), insets 10
            frame.setLayout(new MigLayout("fill, insets 15", "[grow, fill][grow 2, fill]", "[grow, fill]"));

            // --- PANEL KIRI: FORM INPUT (Menggunakan JPanel) ---
            JPanel inputPanel = createInputPanel();
            
            // Tambahkan inputPanel ke frame. Constraint: wrap (pindah baris setelah ini)
            frame.add(inputPanel, "w 40%, h 100%, wrap");

            // --- PANEL KANAN: LOG AKTIVITAS (Menggunakan JScrollPane untuk JTextArea) ---
            JPanel logPanel = createLogPanel();

            // Tambahkan logPanel ke frame. Constraint: grow (tumbuh sisa ruang)
            frame.add(logPanel, "w 60%, h 100%");

            // Tampilkan Frame
            frame.pack();
            frame.setLocationRelativeTo(null); // Posisikan di tengah layar
            frame.setVisible(true);
        });
    }

    /**
     * Membuat Panel untuk Form Input di sisi kiri.
     */
    private static JPanel createInputPanel() {
        // Layout Constraint: fill (mengisi panel), insets 0
        // Column Constraints: [right] (kolom 0 rata kanan), [grow, fill] (kolom 1 tumbuh dan mengisi)
        JPanel panel = new JPanel(new MigLayout("fill, insets 0", "[right][grow, fill]", ""));

        // Komponen Input
        JLabel namaProdukLabel = new JLabel("Nama Produk:");
        JTextField namaProdukField = new JTextField(20);

        JLabel stokLabel = new JLabel("Stok:");
        JTextField stokField = new JTextField(20);

        JLabel kategoriLabel = new JLabel("Kategori:");
        String[] kategoriOptions = {"Elektronik", "Makanan", "Pakaian"};
        JComboBox<String> kategoriComboBox = new JComboBox<>(kategoriOptions);
        kategoriComboBox.setSelectedItem("Elektronik");

        JLabel prioritasLabel = new JLabel("Prioritas Kirim:");
        JRadioButton yaButton = new JRadioButton("Ya");
        JRadioButton prioritasButton = new JRadioButton("Prioritas");
        ButtonGroup prioritasGroup = new ButtonGroup();
        prioritasGroup.add(yaButton);
        prioritasGroup.add(prioritasButton);
        
        JButton simpanButton = new JButton("Simpan & Notifikasi");
        
        // --- Penambahan Komponen ke Panel ---

        // Baris 1: Nama Produk
        panel.add(namaProdukLabel);                      // Kolom 0 (right-aligned)
        panel.add(namaProdukField, "wrap, h 25");       // Kolom 1 (grow/fill), wrap

        // Baris 2: Stok
        panel.add(stokLabel);                           // Kolom 0
        panel.add(stokField, "wrap, h 25");             // Kolom 1, wrap

        // Baris 3: Kategori (Menggunakan cell constraint span 1 untuk komponen, span 1 untuk constraint)
        panel.add(kategoriLabel);                       // Kolom 0
        panel.add(kategoriComboBox, "wrap, h 25");      // Kolom 1, wrap

        // Baris 4: Prioritas Kirim
        panel.add(prioritasLabel);                      // Kolom 0
        panel.add(yaButton, "split 2");                 // Kolom 1, split 2 (membagi sel dengan 2 komponen berikutnya)
        panel.add(prioritasButton, "wrap");             // Komponen kedua di sel yang sama, wrap

        // Baris 5: Tombol Simpan (Span 2 kolom, align center)
        panel.add(simpanButton, "span 2, gaptop 15, align center, w 150, h 35");

        return panel;
    }

    /**
     * Membuat Panel untuk Log Aktivitas di sisi kanan.
     */
    private static JPanel createLogPanel() {
        // Layout Constraint: fill (mengisi panel), insets 0
        JPanel panel = new JPanel(new MigLayout("fill, insets 0", "[grow, fill]", "[][grow, fill]"));
        
        JLabel logTitle = new JLabel("Log Aktivitas Tambahan");
        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        
        // Penambahan Komponen ke Panel
        panel.add(logTitle, "wrap"); // Judul log
        panel.add(scrollPane, "grow, h 100%"); // Area log, tumbuh mengisi sisa ruang
        
        return panel;
    }
}