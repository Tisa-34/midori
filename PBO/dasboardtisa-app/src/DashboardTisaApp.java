import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

import view.FrameUtama;

public class DashboardTisaApp {
    public static void main(String[] args) //throws Exception 
    {try {
        UIManager.setLookAndFeel(new FlatMacLightLaf());
    } catch (Exception e) {
        System.err.println(e.getMessage());
    }

    SwingUtilities.invokeLater(() -> {
        new FrameUtama().setVisible(true);
    });

        
        //System.out.println("Hello, World!");
    }
}
