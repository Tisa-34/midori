package Contoh;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class Laf {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Gagal mengatur Look and Feel: " + e.getMessage());
        }

        SwingUtilities.invokeLater(() -> {

        });

    }
}