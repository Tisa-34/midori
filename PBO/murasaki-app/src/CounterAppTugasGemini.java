import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import net.miginfocom.swing.MigLayout;

public class CounterAppTugasGemini {
    private static int nilaiCounter = 0;
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Counter App"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(400, 300));
            frame.setMinimumSize(new Dimension(200, 150));

            JPanel mainPanel = new JPanel(new CardLayout());

            // --- PANEL COUNTER (Halaman 1) ---
            // Row Constraints Disesuaikan: [grow 2] (Angka), [grow 2] (Tombol +/-), [grow 1] (Navigasi)
            JPanel panelCounter = new JPanel(new MigLayout("fill, insets 20", "[grow]", "[grow 2]10[grow 2]10[grow 1]"));
            // panelCounter.setBorder(new LineBorder(Color.GREEN, 2, true)); 

            // Label Counter (Baris 1)
            JLabel labelCounter = new JLabel(nilaiCounter + "");
            labelCounter.setFont(new Font("Arial", Font.BOLD, 50));
            // labelCounter.setBorder(new LineBorder(Color.RED, 1)); 
            // Angka dipusatkan di Baris 1
            panelCounter.add(labelCounter, "align center, aligny center, wrap");

            // Panel Tombol +/-
            JPanel panelButtons = new JPanel(new MigLayout("insets 0", "[]10[]", "[]"));
            // panelButtons.setBorder(new LineBorder(Color.PINK, 1)); 

            JButton buttonMinus = new JButton("-");
            buttonMinus.setFont(new Font("Arial", Font.BOLD, 25));
            buttonMinus.setPreferredSize(new Dimension(50, 40)); 
            buttonMinus.setBorder(new LineBorder(Color.DARK_GRAY, 2));
            panelButtons.add(buttonMinus);

            buttonMinus.addActionListener(e -> {
                nilaiCounter--;
                labelCounter.setText(nilaiCounter + "");
            });

            JButton buttonAdd = new JButton("+");
            buttonAdd.setFont(new Font("Arial", Font.BOLD, 25));
            buttonAdd.setPreferredSize(new Dimension(50, 40)); 
            buttonAdd.setBorder(new LineBorder(Color.DARK_GRAY, 2));
            panelButtons.add(buttonAdd);

            buttonAdd.addActionListener(e -> {
                nilaiCounter++;
                labelCounter.setText(nilaiCounter + "");
            });

            // Tambahkan Panel Tombol (Baris 2)
            // Panel Tombol dipusatkan di Baris 2
            panelCounter.add(panelButtons, "align center, aligny center, wrap");

            // Tombol Next (>) (Baris 3)
            JButton buttonNext = new JButton(">");
            buttonNext.setFont(new Font("Arial", Font.BOLD, 25));
            buttonNext.setPreferredSize(new Dimension(50, 40));
            buttonNext.setBorder(new LineBorder(Color.BLUE, 2)); 
            // Tombol Navigasi di kanan bawah Baris 3
            panelCounter.add(buttonNext, "align right, aligny bottom, wrap");

            mainPanel.add(panelCounter, "page1");

            // --- PANEL RESULT (Halaman 2) - Menggunakan proporsi baris yang sama ---
            JPanel panelResult = new JPanel(new MigLayout("fill, insets 20", "[grow]", "[grow 2]10[grow 2]10[grow 1]"));
            // panelResult.setBorder(new LineBorder(Color.BLUE, 2, true)); 

            // Label Info (Baris 1)
            JLabel labelInfo = new JLabel("Nilai terakhir Anda adalah");
            labelInfo.setFont(new Font("Arial", Font.PLAIN, 18));
            // labelInfo.setBorder(new LineBorder(Color.GRAY, 1)); 
            panelResult.add(labelInfo, "align center, aligny center, wrap");

            // Label Hasil (Baris 2)
            JLabel labelHasil = new JLabel("0");
            labelHasil.setFont(new Font("Arial", Font.BOLD, 50));
            // labelHasil.setBorder(new LineBorder(Color.GRAY, 1)); 
            panelResult.add(labelHasil, "align center, aligny center, wrap");

            // Tombol Back (<) (Baris 3)
            JButton buttonBack = new JButton("<");
            buttonBack.setFont(new Font("Arial", Font.BOLD, 25));
            buttonBack.setPreferredSize(new Dimension(50, 40));
            buttonBack.setBorder(new LineBorder(Color.RED, 2)); 
            panelResult.add(buttonBack, "align left, aligny bottom, wrap");

            mainPanel.add(panelResult, "page2");

            // --- Action Listener ---
            buttonNext.addActionListener(e -> {
                labelHasil.setText(String.valueOf(nilaiCounter));
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "page2");
            });

            buttonBack.addActionListener(e -> {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "page1");
            });
        
            frame.add(mainPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }
}