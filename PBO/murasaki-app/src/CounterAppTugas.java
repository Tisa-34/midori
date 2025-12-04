//import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import net.miginfocom.swing.MigLayout;

public class CounterAppTugas {
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

            JPanel panelCounter = new JPanel(new MigLayout("fill, wrap1", "[grow, center]", "[grow][grow]"));

            

            JLabel labelCounter = new JLabel(nilaiCounter + "");
            labelCounter.setFont(new Font("Arial", Font.BOLD, 50));
            panelCounter.add(labelCounter, "bottom");

            JPanel panelButtons = new JPanel(new MigLayout("insets 0", "[]10[]", "[]"));

            JButton buttonAdd1 = new JButton("-");
            buttonAdd1.setFont(new Font("Arial", Font.BOLD, 25));
            //panelCounter.add(buttonAdd1, "top");
            panelButtons.add(buttonAdd1);

            buttonAdd1.addActionListener(e -> {
                nilaiCounter--;
                labelCounter.setText(nilaiCounter+"");
            } );

            JButton buttonAdd = new JButton("+");
            buttonAdd.setFont(new Font("Arial", Font.BOLD, 25));
            //panelCounter.add(buttonAdd, "top");
            panelButtons.add(buttonAdd);

            buttonAdd.addActionListener(e -> {
                nilaiCounter++;
                labelCounter.setText(nilaiCounter+"");
            } );

            

            panelCounter.add(panelButtons, "top");

            JScrollPane scrollPane = new JScrollPane(panelCounter);
            scrollPane.getVerticalScrollBar().setUnitIncrement(10);
            scrollPane.getVerticalScrollBar().putClientProperty("JScrollBar.fastWheelScrolling", true);
            scrollPane.setOpaque(true);

            frame.add(scrollPane);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }
}
