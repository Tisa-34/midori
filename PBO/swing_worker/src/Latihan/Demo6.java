package Latihan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

public class Demo6 extends JFrame implements TaskWorker.Listener {

    private JPanel panelUtama;
    private JButton buttonMulaiTask;
    private JButton buttonCancel;
    private JLabel labelStatus;
    private JProgressBar progressBar;
    private JTextArea textAreaHasil;

    private TaskWorker worker;

    public Demo6() {
        initializeUI();
        setupEventHandlers();
    }

    private void initializeUI() {
        setTitle("Demo 6: SwingWorker Toplevel + Cancelation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(720, 520));

        panelUtama = new JPanel(new MigLayout("fill, wrap 1, insets 20"));

        addPanelTombol();
        addLabelStatus();
        addProgressBar();
        addScrollTextArea();

        add(panelUtama);
        pack();
        setLocationRelativeTo(null);
    }

    private void addPanelTombol() {
        JPanel panelTombol = new JPanel(new MigLayout("fill", "[grow][grow]"));
        buttonMulaiTask = new JButton("Mulai Task (8 detik)");
        buttonCancel = new JButton("Cancel");

        buttonMulaiTask.setFont(new Font("Inter", Font.BOLD, 18));
        buttonCancel.setFont(new Font("Inter", Font.BOLD, 18));
        buttonCancel.setEnabled(false);

        panelTombol.add(buttonMulaiTask, "w 90%, growy");
        panelTombol.add(buttonCancel, "w 10%, growy");

        panelUtama.add(panelTombol, "h 20%, grow");
    }

    private void addLabelStatus() {
        labelStatus = new JLabel("Status: Siap", JLabel.CENTER);
        labelStatus.setFont(new Font("Inter", Font.BOLD, 24));
        labelStatus.setForeground(new Color(0, 100, 0));
        panelUtama.add(labelStatus, "h 10%, growx");
    }

    private void addProgressBar() {
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("Inter", Font.BOLD, 18));
        panelUtama.add(progressBar, "h 10%, growx");
    }

    private void addScrollTextArea() {
        textAreaHasil = new JTextArea();
        textAreaHasil.setEditable(false);
        textAreaHasil.setFont(new Font("Consolas", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(textAreaHasil);

        panelUtama.add(scroll, "h 60%, grow");
    }

    private void setupEventHandlers() {

        buttonMulaiTask.addActionListener(e -> mulaiProses());

        buttonCancel.addActionListener(e -> {
            if (worker != null && !worker.isDone()) {
                worker.cancel(true);
                addLog("Proses dibatalkan oleh user...");
            }
        });
    }

    private void mulaiProses() {
        buttonMulaiTask.setEnabled(false);
        buttonCancel.setEnabled(true);
        progressBar.setValue(0);
        textAreaHasil.setText("");

        labelStatus.setText("Status: Mulai bekerja");
        addLog("Mengerjakan Background Task (8 detik)");

        worker = new TaskWorker(this);
        worker.execute();
    }

    private void addLog(String msg) {
        textAreaHasil.append(msg + "\n");
        textAreaHasil.setCaretPosition(textAreaHasil.getDocument().getLength());
    }

    @Override
    public void onProgressUpdate(int progress, int remainingSeconds) {
        progressBar.setValue(progress);
        labelStatus.setText("Sisa " + remainingSeconds + " detik");
    }

    @Override
    public void onLog(String msg) {
        addLog(msg);
    }

    @Override
    public void onCompleted(int result) {
        labelStatus.setText("Status: Selesai");
        addLog("Background Task Selesai " + result + "%");

        JOptionPane.showMessageDialog(this,
                "Background Task Selesai",
                "Informasi",
                JOptionPane.INFORMATION_MESSAGE);

        resetButtons();
    }

    @Override
    public void onCancelled() {
        labelStatus.setText("Status: Dibatalkan");
        addLog("Task dibatalkan.");
        resetButtons();
    }

    @Override
    public void onError(Exception ex) {
        labelStatus.setText("Status: Error");
        addLog("Error: " + ex.getMessage());

        JOptionPane.showMessageDialog(this,
                "Terjadi kesalahan: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);

        resetButtons();
    }

    private void resetButtons() {
        buttonMulaiTask.setEnabled(true);
        buttonCancel.setEnabled(false);
        worker = null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}
            new Demo6().setVisible(true);
        });
    }
}

