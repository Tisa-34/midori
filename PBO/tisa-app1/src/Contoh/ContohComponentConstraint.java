package Contoh;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class ContohComponentConstraint {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Contoh Component Constraints");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));

        JPanel panel = new JPanel(new MigLayout("debug, fill"));

        panel.add(new JLabel("Username:"));
        
        // wrap: pindah baris setelah ini
        panel.add(new JTextField(), "wrap");

        panel.add(new JLabel("Password:"));

        // span 2: rentang 2 kolom penuh
        // growx: hanya tumbuh horizontal
        // wmax 250: maksimum lebar 250px
        panel.add(new JPasswordField(), "span 2, growx, wmax 250, wrap");
        
        // skip: lewati 1 sel (kolom pertama kosong)
        // newline: mulai baris baru (sama dengan wrap di akhir baris sebelumnya)
        panel.add(new JLabel("Divisi:"), "skip 1, newline");

        panel.add(new JTextField(), "wrap");

        // align center/pos 50% 50%
        panel.add(new JButton("Login"), "span 3, align center, gaptop 20");

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}