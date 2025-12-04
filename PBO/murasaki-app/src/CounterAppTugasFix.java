import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;

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

public class CounterAppTugasFix {
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

            // ===== CARDLAYOUT UTAMA =====
            JPanel mainPanel = new JPanel(new CardLayout());

            // ============================================================
            // =============== PAGE 1 (contoh asli, 3 baris) ===============
            // ============================================================
            JPanel page1 = new JPanel(
                    new MigLayout("fill, wrap1", "[grow, fill]", "[grow][grow][grow]"));

            // ---------- Baris 1 ----------
            JPanel top = new JPanel(new MigLayout("center"));
            top.setBorder(javax.swing.BorderFactory.createDashedBorder(Color.RED));

            JLabel labelCounter = new JLabel(String.valueOf(nilaiCounter));
            labelCounter.setFont(new Font("Arial", Font.BOLD, 70));

            top.add(labelCounter);

            // ---------- Baris 2 ----------
            JPanel middle = new JPanel(new MigLayout("center", "[]20[]", "[]"));
            middle.setBorder(javax.swing.BorderFactory.createDashedBorder(Color.RED));

            JButton btnMinus = new JButton("-");
            btnMinus.setFont(new Font("Arial", Font.BOLD, 25));

            JButton btnPlus = new JButton("+");
            btnPlus.setFont(new Font("Arial", Font.BOLD, 25));

            middle.add(btnMinus);
            middle.add(btnPlus);

            btnMinus.addActionListener(e -> {
                nilaiCounter--;
                labelCounter.setText(String.valueOf(nilaiCounter));
            });

            btnPlus.addActionListener(e -> {
                nilaiCounter++;
                labelCounter.setText(String.valueOf(nilaiCounter));
            });

            // ---------- Baris 3 ----------
            JPanel bottom = new JPanel(new MigLayout("right"));
            bottom.setBorder(javax.swing.BorderFactory.createDashedBorder(Color.RED));

            JButton buttonNext = new JButton(">");
            buttonNext.setFont(new Font("Arial", Font.BOLD, 25));

            bottom.add(buttonNext, "gapright 10, gapbottom 10");

            // Tambahkan ke page1
            page1.add(top, "grow");
            page1.add(middle, "grow");
            page1.add(bottom, "grow");

            // ============================================================
            // =============== PAGE 2 (tambahkan border juga) ===============
            // ============================================================
            JPanel page2 = new JPanel(
                    new MigLayout("fill, wrap1", "[grow, fill]", "[grow][grow][grow]"));
            page2.setBorder(javax.swing.BorderFactory.createDashedBorder(Color.BLUE));

            JLabel labelInfo = new JLabel("Nilai terakhir Anda adalah");
            labelInfo.setFont(new Font("Arial", Font.PLAIN, 18));

            JLabel labelHasil = new JLabel("0");
            labelHasil.setFont(new Font("Arial", Font.BOLD, 60));

            JButton buttonBack = new JButton("<");
            buttonBack.setFont(new Font("Arial", Font.BOLD, 25));

            page2.add(labelInfo, "center");
            page2.add(labelHasil, "center");
            page2.add(buttonBack, "left, bottom");

            // ============================================================
            // =============== PERPINDAHAN HALAMAN =========================
            // ============================================================
            buttonNext.addActionListener(e -> {
                labelHasil.setText(String.valueOf(nilaiCounter));
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "page2");
            });

            buttonBack.addActionListener(e -> {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "page1");
            });

            mainPanel.add(page1, "page1");
            mainPanel.add(page2, "page2");

            JScrollPane scrollPane = new JScrollPane(mainPanel);

            frame.add(scrollPane);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
