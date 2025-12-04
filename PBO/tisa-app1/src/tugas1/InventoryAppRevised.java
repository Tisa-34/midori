package tugas1;

import java.awt.Dimension;
import javax.swing.*;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import net.miginfocom.swing.MigLayout;

public class InventoryAppRevised {

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
            frame.setPreferredSize(new Dimension(650, 500));
            
            // Menggunakan MigLayout pada content pane utama
            // Constraints: fill (mengisi seluruh frame), insets 15
            // Column Constraints: [grow, fill] (Hanya satu kolom yang tumbuh mengisi frame)
            // Row Constraints: [][grow, fill] (Baris pertama auto-size (untuk form), Baris kedua tumbuh (untuk log))
            frame.setLayout(new MigLayout("fill, insets 15", "[grow, fill]", "[][grow, fill]"));

            // --- PANEL ATAS: FORM INPUT (Menggunakan JPanel) ---
            JPanel inputPanel = createInputPanel();
            
            // Tambahkan inputPanel ke frame. Constraint: wrap (Pindah baris ke log panel)
            frame.add(inputPanel, "wrap");

            // --- PANEL BAWAH: LOG AKTIVITAS (Menggunakan JScrollPane untuk JTextArea) ---
            JPanel logPanel = createLogPanel();

            // Tambahkan logPanel ke frame. Constraint: grow (tumbuh mengisi sisa tinggi)
            frame.add(logPanel, "grow");

            // Tampilkan Frame
            frame.pack();
            frame.setLocationRelativeTo(null); // Posisikan di tengah layar
            frame.setVisible(true);
        });
    }

    /**
     * Membuat Panel untuk Form Input di bagian atas.
     */
    private static JPanel createInputPanel() {
        // Layout Constraint: fill (mengisi panel), insets 0
        // Column Constraints: [right] (kolom 0 rata kanan), [grow, fill] (kolom 1 tumbuh dan mengisi)
        JPanel panel = new JPanel(new MigLayout("fill, insets 0, hidemode 3", "[right][grow, fill]", ""));

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
        panel.add(namaProdukLabel, "gapy 5");                   // Kolom 0 (right-aligned)
        panel.add(namaProdukField, "wrap, h 25, pushx, growx"); // Kolom 1 (tumbuh dan mengisi), wrap

        // Baris 2: Stok
        panel.add(stokLabel, "gapy 5");                         // Kolom 0
        panel.add(stokField, "wrap, h 25, pushx, growx");       // Kolom 1 (tumbuh dan mengisi), wrap

        // Baris 3: Kategori
        panel.add(kategoriLabel, "gapy 5");                     // Kolom 0
        panel.add(kategoriComboBox, "wrap, h 25, growx 0");     // Kolom 1. growx 0 agar combo box tidak ikut melebar penuh.

        // Baris 4: Prioritas Kirim
        panel.add(prioritasLabel, "gapy 5");                    // Kolom 0
        panel.add(yaButton, "split 2");                         // Kolom 1, split 2 (Ya)
        panel.add(prioritasButton, "wrap");                     // Komponen kedua di sel yang sama (Prioritas), wrap

        // Baris 5: Tombol Simpan (Span 2 kolom, align center)
        panel.add(simpanButton, "span 2, gaptop 25, align center, w 150, h 35, wrap");
        
        // Baris 6: Judul Log (diletakkan di inputPanel agar tidak terpengaruh oleh grow di panel utama)
        JLabel logTitle = new JLabel("Log Aktivitas Tambahan");
        panel.add(logTitle, "span 2, gaptop 15, wrap");         // Span 2 kolom, wrap

        return panel;
    }

    /**
     * Membuat Panel untuk Log Aktivitas di bagian bawah.
     */
    private static JPanel createLogPanel() {
        // Layout Constraint: fill (mengisi panel), insets 0
        JPanel panel = new JPanel(new MigLayout("fill, insets 0"));
        
        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        // Atur border 
        logArea.setBorder(BorderFactory.createLineBorder(UIManager.getColor("Component.borderColor")));
        JScrollPane scrollPane = new JScrollPane(logArea);
        
        // Penambahan Komponen ke Panel
        panel.add(scrollPane, "grow"); // Area log, tumbuh mengisi sisa ruang
        
        return panel;
    }
}
