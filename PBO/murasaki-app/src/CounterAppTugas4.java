//import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import net.miginfocom.swing.MigLayout;

public class CounterAppTugas4 {
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

            JPanel mainPanel = new JPanel(new CardLayout());

            JPanel panelCounter = new JPanel(new MigLayout("fill, wrap1", "[grow, center]", "[grow][grow]"));
            panelCounter.setBorder(new LineBorder(Color.GREEN, 2, true));

            

            JLabel labelCounter = new JLabel(nilaiCounter + "");
            labelCounter.setFont(new Font("Arial", Font.BOLD, 50));
            labelCounter.setBorder(new LineBorder(Color.RED, 1));
            panelCounter.add(labelCounter, "center");

            JPanel panelButtons = new JPanel(new MigLayout("insets 0", "[]10[]", "[]"));
            panelButtons.setBorder(new LineBorder(Color.PINK, 1)); 

            JButton buttonAdd1 = new JButton("-");
            buttonAdd1.setFont(new Font("Arial", Font.BOLD, 25));
            buttonAdd1.setBorder(new LineBorder(Color.DARK_GRAY, 2));
            //panelCounter.add(buttonAdd1, "top");
            panelButtons.add(buttonAdd1);

            buttonAdd1.addActionListener(e -> {
                nilaiCounter--;
                labelCounter.setText(nilaiCounter+"");
            } );

            JButton buttonAdd = new JButton("+");
            buttonAdd.setFont(new Font("Arial", Font.BOLD, 25));
            buttonAdd.setBorder(new LineBorder(Color.DARK_GRAY, 2));
            //panelCounter.add(buttonAdd, "top");
            panelButtons.add(buttonAdd);

            buttonAdd.addActionListener(e -> {
                nilaiCounter++;
                labelCounter.setText(nilaiCounter+"");
            } );

            

            panelCounter.add(panelButtons, "center");

            JButton buttonNext = new JButton(">");
            buttonNext.setFont(new Font("Arial", Font.BOLD, 25));
            buttonNext.setBorder(new LineBorder(Color.BLUE, 2)); 
            panelCounter.add(buttonNext, "right, bottom");

            mainPanel.add(panelCounter, "page1");

            JPanel panelResult = new JPanel(new MigLayout("fill, wrap1", "[grow, center]", "[grow][grow][grow]"));
            panelResult.setBorder(new LineBorder(Color.BLUE, 2, true));

            JLabel labelInfo = new JLabel("Nilai terakhir Anda adalah");
            labelInfo.setFont(new Font("Arial", Font.PLAIN, 18));
            labelInfo.setBorder(new LineBorder(Color.GRAY, 1));
            panelResult.add(labelInfo, "center");

            JLabel labelHasil = new JLabel("0");
            labelHasil.setFont(new Font("Arial", Font.BOLD, 50));
            labelHasil.setBorder(new LineBorder(Color.GRAY, 1));
            panelResult.add(labelHasil, "center");

            JButton buttonBack = new JButton("<");
            buttonBack.setFont(new Font("Arial", Font.BOLD, 25));
            buttonBack.setBorder(new LineBorder(Color.RED, 2)); 
            panelResult.add(buttonBack, "left, bottom");

            mainPanel.add(panelResult, "page2");

            buttonNext.addActionListener(e -> {
                labelHasil.setText(String.valueOf(nilaiCounter));
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "page2");
            } );

            buttonBack.addActionListener(e -> {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "page1");
            });
        

            JScrollPane scrollPane = new JScrollPane(mainPanel);
            scrollPane.getVerticalScrollBar().setUnitIncrement(10);
            scrollPane.getVerticalScrollBar().putClientProperty("JScrollBar.fastWheelScrolling", true);
            scrollPane.setOpaque(true);

            frame.add(scrollPane);
            //frame.add(mainPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }
}
