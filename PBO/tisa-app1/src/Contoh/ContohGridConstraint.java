package Contoh;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class ContohGridConstraint {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Contoh Grid Constraints");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 200));

        // Contoh 1: width, grow, align (studi kasus login form)
        String colConstraints = "[right][grow, fill]";
        String rowConstraints = ""; // Default

        // Contoh 2: shrink, gap, push (layout footer)
        // String colConstraints = "[shrink][][grow, push, align right]";
        // String rowConstraints = "[height 50]"; // Contoh height/width di row/col constraint
        
        JPanel panel = new JPanel(new MigLayout("debug, fill", colConstraints, rowConstraints));

        // Komponen untuk Contoh 1
        panel.add(new JLabel("Username:")); // Kolom 0
        panel.add(new JTextField(10), "wrap"); // Kolom 1 (grow/fill)

        panel.add(new JLabel("Password:")); // Kolom 0
        panel.add(new JPasswordField(10), "wrap"); // Kolom 1 (grow/fill)

        // resize window untuk melihat efek grow/fill
        
        // Komponen untuk Contoh 2 (Footer style)
        panel.add(new JLabel("Copyright 2024")); // *Koreksi: Hapus '*'*. shrink by default
        panel.add(new JButton("Help"), "gap unrelated"); // gap
        panel.add(new JButton("Save"), "w 80, grow, push, align right"); // *Koreksi: Hapus '*'*.

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}