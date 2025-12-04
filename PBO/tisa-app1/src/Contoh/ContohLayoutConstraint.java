package Contoh;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class ContohLayoutConstraint {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Layout Constraints (Contoh)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 400));

        
        String layoutConstraints = "fill, debug, insets 10, hidemode 3";

        // Opsi pengganti:
        // String layoutConstraints = "fill, debug, insets 20, hidemode 3";
        // String layoutConstraints = "center, max 300";
        // String layoutConstraints = "nogrid, debug, insets 10";

        JPanel panel = new JPanel(new MigLayout(layoutConstraints));

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        panel.add(button1, "w 100, h 50");
        panel.add(button2, "w 100, h 50, wrap");
        panel.add(button3, "w 100, h 50, span 2, grow, wrap");
        JLabel statusLabel = new JLabel("Button 2 terlihat!");
        panel.add(statusLabel, "span 2, align center, gaptop 20");

        button1.addActionListener(e -> {
            boolean isVisible = button2.isVisible();
            button2.setVisible(!isVisible);
            if (isVisible) {
                statusLabel.setText("Button 2 Disembunyikan (Ruang Kosong Dilipat)");
            } else {
                statusLabel.setText("Button 2 Terlihat Kembali!");
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}