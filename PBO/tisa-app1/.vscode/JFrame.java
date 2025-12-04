package Tugas2;



import javax.swing.SwingUtilities;

// Kelas ini hanya dibuat untuk memenuhi permintaan nama file JFrame.java
// Kelas harus diberi nama yang berbeda (misalnya JFrameRunner) agar tidak konflik
// dengan kelas bawaan Java (javax.swing.JFrame).

public class JFrame { 
    public static void main(String[] args) {
        // Panggil kelas utama GUI Anda, InventoryApp1, dan jalankan di EDT.
        // Asumsi InventoryApp1 berada dalam package Tugas2
        SwingUtilities.invokeLater(InventoryApp1::new);
    }
}