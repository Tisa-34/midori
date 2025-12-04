package tugas1;

import java.awt.Dimension;
import javax.swing.*;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import net.miginfocom.swing.MigLayout;

public class TisaInventoryAppFiks {

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
            frame.setPreferredSize(new Dimension(650, 450));
            
            // --- FRAME UTAMA: Layout Kiri-Kanan (HORIZONTAL SPLIT) ---
            // Constraints: fill, debug, insets 10 (Jarak tepi dikurangi)
            // Col: [grow, fill] (Kolom kiri) [grow 2, fill] (Kolom kanan, 2x lebih besar)
            frame.setLayout(new MigLayout("fill, debug, insets 10", "[grow, fill][grow 2, fill]", "[grow, fill]"));

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
        // Layout: fill, debug, insets 0. Col: [right] (Label) [grow, fill] (Input)
        // Jarak (gap) antar baris dikurangi secara default dengan row constraints ""
        JPanel panel = new JPanel(new MigLayout("fill, debug, insets 0", "[right][grow, fill]", ""));

        // Komponen Input
        JTextField namaProdukField = new JTextField(20);
        JTextField stokField = new JTextField(20);
        String[] kategoriOptions = {"Elektronik", "Makanan", "Pakaian"};
        JComboBox<String> kategoriComboBox = new JComboBox<>(kategoriOptions);
        kategoriComboBox.setSelectedItem("Elektronik");
        
        // Radio Buttons (Prioritas dipilih secara default)
        JRadioButton prioritasButton = new JRadioButton("Ya, Prioritas", false); // Prioritas terpilih
        ButtonGroup prioritasGroup = new ButtonGroup();
        prioritasGroup.add(prioritasButton);
        
        JButton simpanButton = new JButton("Simpan & Notifikasi");
        
        // --- Penambahan Komponen ke Panel ---
        
        // Baris 1: Nama Produk
        // gaptop 10: Jarak dari tepi atas panel
        panel.add(new JLabel("Nama Produk:"), "gaptop 5");
        panel.add(namaProdukField, "wrap, h 25, pushx, growx");

        // Baris 2: Stok (Jarak vertikal antar baris sudah dekat)
        panel.add(new JLabel("Stok:"));
        panel.add(stokField, "wrap, h 25, pushx, growx");

        // Baris 3: Kategori
        panel.add(new JLabel("Kategori:"));
        // 'w 70::' agar lebar ComboBox tidak terlalu kecil
        panel.add(kategoriComboBox, "wrap, h 25, w 70::");

        // Baris 4: Prioritas Kirim
        panel.add(new JLabel("Prioritas Kirim:"));
        // Constraint 'split 2' agar kedua JRadioButton berada di kolom yang sama
        // gapx 15: Jarak horizontal antar radio button diperlebar sedikit
    
        panel.add(prioritasButton, "wrap");

        // Baris 5: Tombol Simpan
        // gaptop 30: Jarak vertikal dari baris Prioritas Kirim
        panel.add(simpanButton, "span 2, gaptop 30, align center, w 150, h 35");

        return panel;
    }

    /**
     * Membuat Panel untuk Log Aktivitas di sisi kanan.
     */
    private static JPanel createLogPanel() {
        // Layout: fill, debug, insets 0. Col: [grow, fill]. Row: [][grow, fill]
        JPanel panel = new JPanel(new MigLayout("fill, debug, insets 0", "[grow, fill]", "[][grow, fill]"));
        
        JLabel logTitle = new JLabel("Log Aktivitas Tambahan");
        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);
        
        // Penambahan Komponen ke Panel
        panel.add(logTitle, "gaptop 10, wrap"); // Judul log (dengan gaptop 10 agar sejajar dengan input form)
        panel.add(scrollPane, "grow"); // Area log, tumbuh mengisi sisa ruang
        
        return panel;
    }
}