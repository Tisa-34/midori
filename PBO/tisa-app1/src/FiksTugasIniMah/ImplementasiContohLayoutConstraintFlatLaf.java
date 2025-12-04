package FiksTugasIniMah;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.FlatLightLaf; 

public class ImplementasiContohLayoutConstraintFlatLaf {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
            try {
                FlatLightLaf.setup();
            } catch (Exception ex) {
                System.err.println("Gagal mengatur FlatLaf Look and Feel: " + ex);
            }

            JFrame frame = new JFrame("Implementasi Layout Constraints Tisa");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(500, 400));

            
            String layoutConstraints = "fill, debug, insets 20, hidemode 3";

            JPanel panel = new JPanel(new MigLayout(layoutConstraints));

            JButton button1 = new JButton("Button 1 (Toggle)");
            JButton button2 = new JButton("Button 2");
            JButton button3 = new JButton("Button 3");
            JLabel statusLabel = new JLabel("Button 2 Terlihat");

            
            panel.add(button1, "w 100, h 50"); 
            panel.add(button2, "w 100, h 50, wrap"); 
            panel.add(button3, "span 2, growx, h 50, wrap");
            panel.add(statusLabel, "span 2, align center, gaptop 20");

            
            button1.addActionListener(e -> {
                boolean isVisible = button2.isVisible();
                button2.setVisible(!isVisible);
                
                if (!isVisible) {
                    statusLabel.setText("Button 2 Terlihat Kembali");
                } else {
                    statusLabel.setText("Button 2 Disembunyikan (Ruang Kosong Dilipat)");
                }
                
                
                panel.revalidate();
                panel.repaint();
            });

            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}