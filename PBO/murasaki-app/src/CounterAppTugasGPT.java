import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import net.miginfocom.swing.MigLayout;

public class CounterAppTugasGPT {
    private static int nilaiCounter = 0;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Counter App Midori");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(400, 300));
            frame.setMinimumSize(new Dimension(200, 150));

            // PANEL UTAMA (3 baris seperti gambar)
            JPanel panelMain = new JPanel(
                    new MigLayout("fill, wrap1", "[grow, fill]", "[grow][grow][grow]"));

            // ====================================
            // 1) PANEL ATAS — LABEL COUNTER
            // ====================================
            JPanel panelCounterArea = new JPanel(new MigLayout("center"));
            panelCounterArea.setBorder(javax.swing.BorderFactory.createDashedBorder(Color.RED));

            JLabel labelCounter = new JLabel(String.valueOf(nilaiCounter));
            labelCounter.setFont(new Font("Arial", Font.BOLD, 50));

            panelCounterArea.add(labelCounter);

            // ====================================
            // 2) PANEL TENGAH — TOMBOL - dan +
            // ====================================
            JPanel panelButtons = new JPanel(new MigLayout("insets 0, center", "[]20[]", "[]"));
            panelButtons.setBorder(javax.swing.BorderFactory.createDashedBorder(Color.RED));

            JButton buttonMinus = new JButton("-");
            buttonMinus.setFont(new Font("Arial", Font.BOLD, 25));
            panelButtons.add(buttonMinus);

            JButton buttonPlus = new JButton("+");
            buttonPlus.setFont(new Font("Arial", Font.BOLD, 25));
            panelButtons.add(buttonPlus);

            // ACTION
            buttonMinus.addActionListener(e -> {
                nilaiCounter--;
                labelCounter.setText(String.valueOf(nilaiCounter));
            });

            buttonPlus.addActionListener(e -> {
                nilaiCounter++;
                labelCounter.setText(String.valueOf(nilaiCounter));
            });

            // ====================================
            // 3) PANEL BAWAH — TOMBOL NEXT >
            // ====================================
            JPanel panelNextArea = new JPanel(new MigLayout("right"));
            panelNextArea.setBorder(javax.swing.BorderFactory.createDashedBorder(Color.RED));

            JButton buttonNext = new JButton(">");
            buttonNext.setFont(new Font("Arial", Font.BOLD, 20));

            panelNextArea.add(buttonNext, "gapbottom 5, gapright 5");

            // MASUKKAN KE PANEL UTAMA
            panelMain.add(panelCounterArea, "grow");
            panelMain.add(panelButtons, "grow");
            panelMain.add(panelNextArea, "grow");

            // SCROLL (sesuai kode Anda sebelumnya)
            JScrollPane scrollPane = new JScrollPane(panelMain);
            scrollPane.getVerticalScrollBar().setUnitIncrement(10);
            scrollPane.getVerticalScrollBar().putClientProperty("JScrollBar.fastWheelScrolling", true);

            frame.add(scrollPane);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
