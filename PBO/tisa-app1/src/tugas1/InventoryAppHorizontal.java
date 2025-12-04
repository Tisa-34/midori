package tugas1;

import java.awt.Dimension;
import javax.swing.*;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import net.miginfocom.swing.MigLayout;

public class InventoryAppHorizontal {

    public static void main(String[] args) {
        
        // --- 1. SET LOOK AND FEEL ---
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Gagal mengatur Look and Feel: " + e.getMessage());
        }

        // --- 2. JALANKAN APLIKASI DI EVENT DISPATCH THREAD (EDT) ---
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Inventory App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Mengatur ukuran frame
            frame.setPreferredSize(new Dimension(700, 450));
            
            // --- FRAME UTAMA: Layout Kiri-Kanan (Horizontal Split) ---
            // Constraints: fill, insets 15. Col: [grow, fill] (Kolom kiri) [grow 2, fill] (Kolom kanan, 2x lebih besar)
            frame.setLayout(new MigLayout("fill, insets 15", "[grow, fill][grow 2, fill]", "[grow, fill]"));

            // --- PANEL KIRI: FORM INPUT ---
            JPanel inputPanel = createInputPanel();
            frame.add(inputPanel, "w 35%, h 100%"); // Batasi lebar panel kiri 35% dan penuhi tinggi

            // --- PANEL KANAN: LOG AKTIVITAS ---
            JPanel logPanel = createLogPanel();
            frame.add(logPanel, "w 65%, h 100%"); // Batasi lebar panel kanan 65% dan penuhi tinggi

            // Tampilkan Frame
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    /**
     * Membuat Panel untuk Form Input di sisi kiri.
     */
    private static JPanel createInputPanel() {
        // Layout: fill, insets 0. Col: [right] (Label) [grow, fill] (Input)
        JPanel panel = new JPanel(new MigLayout("fill, insets 0", "[right][grow, fill]", ""));

        // Komponen Input
        JTextField namaProdukField = new JTextField(20);
        JTextField stokField = new JTextField(20);
        String[] kategoriOptions = {"Elektronik", "Makanan", "Pakaian"};
        JComboBox<String> kategoriComboBox = new JComboBox<>(kategoriOptions);
        kategoriComboBox.setSelectedItem("Elektronik");
        JRadioButton yaButton = new JRadioButton("Ya");
        JRadioButton prioritasButton = new JRadioButton("Prioritas");
        ButtonGroup prioritasGroup = new ButtonGroup();
        prioritasGroup.add(yaButton);
        prioritasGroup.add(prioritasButton);
        JButton simpanButton = new JButton("Simpan & Notifikasi");
        
        // --- Penambahan Komponen ke Panel ---
        
        // Baris 1: Nama Produk
        panel.add(new JLabel("Nama Produk:"), "gapy 5");
        panel.add(namaProdukField, "wrap, h 25, pushx, growx");

        // Baris 2: Stok
        panel.add(new JLabel("Stok:"), "gapy 5");
        panel.add(stokField, "wrap, h 25, pushx, growx");

        // Baris 3: Kategori
        panel.add(new JLabel("Kategori:"), "gapy 5");
        // Constraint 'w 70::' agar lebar ComboBox tidak terlalu kecil (min 70, default, max auto)
        panel.add(kategoriComboBox, "wrap, h 25, w 70::");

        // Baris 4: Prioritas Kirim
        panel.add(new JLabel("Prioritas Kirim:"), "gapy 5");
        // Constraint 'split 2' agar kedua JRadioButton berada di kolom yang sama
        panel.add(yaButton, "split 2");
        panel.add(prioritasButton, "wrap");

        // Baris 5: Tombol Simpan
        panel.add(simpanButton, "span 2, gaptop 25, align center, w 150, h 35");

        return panel;
    }

    /**
     * Membuat Panel untuk Log Aktivitas di sisi kanan.
     */
    private static JPanel createLogPanel() {
        // Layout: fill, insets 0. Col: [grow, fill]. Row: [][grow, fill]
        JPanel panel = new JPanel(new MigLayout("fill, insets 0", "[grow, fill]", "[][grow, fill]"));
        
        JLabel logTitle = new JLabel("Log Aktivitas Tambahan");
        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        
        // Penambahan Komponen ke Panel
        panel.add(logTitle, "wrap"); // Judul log
        panel.add(scrollPane, "grow"); // Area log, tumbuh mengisi sisa ruang
        
        return panel;
    }
}
