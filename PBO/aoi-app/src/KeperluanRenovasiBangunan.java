import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.FlatLightLaf;

public class KeperluanRenovasiBangunan extends JFrame {
    public KeperluanRenovasiBangunan() {
        initUI();
    }

    private void initUI() {
        setTitle("Studi Kasus Analisis Layout & UI Swing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);

        // Main panel using MigLayout yang lebih sederhana
        JPanel main = new JPanel(new MigLayout(
            "fill, insets 15", 
            "[fill]10[fill]10[fill]", // 3 kolom dengan fill
            "[][grow][grow][grow][]"  // 5 baris
        ));
        
        // Create scroll pane for main content
        JScrollPane scrollPane = new JScrollPane(main);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane);

        // HEADER (title + author) spanning three columns
        JPanel header = new JPanel(new BorderLayout());
        header.setBorder(BorderFactory.createEmptyBorder(4,4,8,4));
        JLabel title = new JLabel("Detail Proyek: RNV-JKT-AXG-001");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 16f));
        header.add(title, BorderLayout.WEST);
        JLabel author = new JLabel("Fachrul Pralienka  — Studi Kasus Layout & UI Swing");
        author.setFont(author.getFont().deriveFont(12f));
        header.add(author, BorderLayout.EAST);
        main.add(header, "span 3, growx, wrap");

        // Row 1: three titled panels (Client | Information | Additional Information)
        main.add(createClientPanel(), "grow");
        main.add(createInformationPanel(), "grow");
        main.add(createAdditionalPanel(), "grow, wrap");

        // Row 2: Product List - span 3 cols
        main.add(createProductListPanel(), "span 3, grow, h 200!, wrap");

        // Row 3: Tasks - span 3 cols
        main.add(createTasksPanel(), "span 3, grow, h 150!, wrap");

        // Row 4: Comments - span 3 cols
        main.add(createCommentsPanel(), "span 3, grow, h 150!, wrap");

        // Row 5: Controls: Export left, Save & Cancel right
        JPanel bottomControls = createBottomControls();
        main.add(bottomControls, "span 3, growx");

        // Footer (small caption)
        JLabel footer = new JLabel("Studi Kasus Analisis Layout & UI Swing - Fachrul Pralienka Bani Muhammad, S.ST., M.Kom.");
        footer.setFont(footer.getFont().deriveFont(Font.ITALIC, 12f));
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setBorder(BorderFactory.createEmptyBorder(8,0,0,0));
        add(footer, BorderLayout.SOUTH);

        // Some global tweaks for table selection color
        UIManager.put("Table.selectionBackground", new Color(153, 51, 204));
        UIManager.put("Table.selectionForeground", Color.white);
    }

    private JPanel createBottomControls() {
        JPanel bottomControls = new JPanel(new BorderLayout());
        bottomControls.setBorder(BorderFactory.createEmptyBorder(8,0,0,0));
        
        // Left side - Export button
        JButton exportBtn = new JButton("Export");
        exportBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, 
                "Fitur Export akan mengunduh laporan proyek dalam format PDF.\nFitur ini dalam pengembangan.",
                "Export Proyek", 
                JOptionPane.INFORMATION_MESSAGE);
        });
        bottomControls.add(exportBtn, BorderLayout.WEST);

        // Right side - Save and Cancel buttons (URUTAN DIPERBAIKI: Save dulu, lalu Cancel)
        JPanel rightBtns = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        
        // TOMBOL SAVE - sekarang di kiri (sebelum Cancel)
        JButton saveBtn = new JButton("Save");
        saveBtn.setOpaque(true);
        saveBtn.setBackground(new Color(153, 51, 204)); // purple
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setPreferredSize(new Dimension(90, 28));
        saveBtn.addActionListener(e -> {
            // Simulate saving process
            saveBtn.setEnabled(false);
            
            Timer timer = new Timer(1000, evt -> {
                saveBtn.setEnabled(true);
                JOptionPane.showMessageDialog(this, 
                    "Data proyek berhasil disimpan!\n\n" +
                    "Detail Proyek: RNV-JKT-AXG-001\n" +
                    "Client: Bapak Alex Gunawan\n" +
                    "Tanggal Update: " + java.time.LocalDateTime.now().format(
                        java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                    "Simpan Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);
                ((Timer)evt.getSource()).stop();
            });
            timer.setRepeats(false);
            timer.start();
        });
        
        // TOMBOL CANCEL - sekarang di kanan (setelah Save)
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setPreferredSize(new Dimension(90, 28));
        cancelBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Batalkan semua perubahan? Perubahan yang belum disimpan akan hilang.",
                "Konfirmasi Batal",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, 
                    "Perubahan dibatalkan. Kembali ke data semula.",
                    "Dibatalkan",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // URUTAN YANG BENAR: Save dulu, lalu Cancel
        rightBtns.add(saveBtn);
        rightBtns.add(cancelBtn);
        bottomControls.add(rightBtns, BorderLayout.EAST);

        return bottomControls;
    }

    private JPanel createClientPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(titledBorder("Client"));
        p.setBackground(Color.WHITE);

        p.add(rowLabel("Client ID:", "101"));
        p.add(rowLabel("Name:", "<html><b>Bapak Alex Gunawan</b></html>"));
        p.add(rowLabel("Phone:", "(+62) 8123456789"));
        p.add(rowLabel("Registration No:", "RNV-JKT-AXG-001"));

        p.add(Box.createVerticalGlue());
        JButton details = new JButton("Details");
        details.setAlignmentX(Component.CENTER_ALIGNMENT);
        details.setBackground(new Color(153, 51, 204));
        details.setForeground(Color.WHITE);
        details.setOpaque(true);
        
        details.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, 
                "Detail Client:\n\n" +
                "Client ID: 101\n" +
                "Nama: Bapak Alex Gunawan\n" +
                "Telepon: (+62) 8123456789\n" +
                "No. Registrasi: RNV-JKT-AXG-001\n" +
                "Alamat: Jl. Raya Lohbener Baru, 778A",
                "Detail Client",
                JOptionPane.INFORMATION_MESSAGE);
        });
        
        p.add(Box.createRigidArea(new Dimension(0,6)));
        p.add(details);

        return p;
    }

    private JPanel createInformationPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(titledBorder("Information"));

        // Reserve Days dengan tombol Add Days
        JPanel reserveDaysPanel = new JPanel(new BorderLayout(6, 0));
        reserveDaysPanel.setOpaque(false);
        JLabel reserveLabel = new JLabel("Reserve days:");
        reserveLabel.setPreferredSize(new Dimension(120, 20));
        
        JPanel reserveRightPanel = new JPanel(new BorderLayout());
        JLabel daysLabel = new JLabel("0 of 30");
        reserveRightPanel.add(daysLabel, BorderLayout.CENTER);
        
        JButton addDaysBtn = new JButton("Add Days");
        addDaysBtn.setPreferredSize(new Dimension(80, 20));
        addDaysBtn.setFont(addDaysBtn.getFont().deriveFont(10f));
        addDaysBtn.addActionListener(e -> {
            showAddDaysDialog(daysLabel);
        });
        
        reserveRightPanel.add(addDaysBtn, BorderLayout.EAST);
        reserveDaysPanel.add(reserveLabel, BorderLayout.WEST);
        reserveDaysPanel.add(reserveRightPanel, BorderLayout.CENTER);
        reserveDaysPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Credit Rating dengan tombol S&P Update
        JPanel creditRatingPanel = new JPanel(new BorderLayout(6, 0));
        creditRatingPanel.setOpaque(false);
        JLabel creditLabel = new JLabel("Credit rating:");
        creditLabel.setPreferredSize(new Dimension(120, 20));
        
        JPanel creditRightPanel = new JPanel(new BorderLayout());
        JLabel ratingLabel = new JLabel("AAA");
        ratingLabel.setForeground(new Color(0, 128, 0)); // Hijau untuk AAA
        creditRightPanel.add(ratingLabel, BorderLayout.CENTER);
        
        JButton spUpdateBtn = new JButton("S&P Update");
        spUpdateBtn.setPreferredSize(new Dimension(90, 20));
        spUpdateBtn.setFont(spUpdateBtn.getFont().deriveFont(10f));
        spUpdateBtn.addActionListener(e -> {
            showSPRatingDialog(ratingLabel);
        });
        
        creditRightPanel.add(spUpdateBtn, BorderLayout.EAST);
        creditRatingPanel.add(creditLabel, BorderLayout.WEST);
        creditRatingPanel.add(creditRightPanel, BorderLayout.CENTER);
        creditRatingPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Approved dengan checkbox
        JPanel approvedPanel = new JPanel(new BorderLayout(6, 0));
        approvedPanel.setOpaque(false);
        JLabel approvedLabel = new JLabel("Approved:");
        approvedLabel.setPreferredSize(new Dimension(120, 20));
        
        JCheckBox approvedCheckbox = new JCheckBox("Proyek renovasi telah disetujui, siap dimulai");
        approvedCheckbox.setSelected(true);
        approvedCheckbox.setOpaque(false);
        approvedCheckbox.addActionListener(e -> {
            if (!approvedCheckbox.isSelected()) {
                JOptionPane.showMessageDialog(this, 
                    "Status approved diubah menjadi tidak disetujui",
                    "Status Diubah",
                    JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Status approved diubah menjadi disetujui",
                    "Status Diubah",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        approvedPanel.add(approvedLabel, BorderLayout.WEST);
        approvedPanel.add(approvedCheckbox, BorderLayout.CENTER);
        approvedPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Tambahkan komponen ke panel utama
        p.add(reserveDaysPanel);
        p.add(rowLabel("Buyer:", "Bapak Alex Gunawan"));
        p.add(rowLabel("Seller:", "PT Bangun Jaya Abadi"));
        p.add(rowLabel("Address:", "Jl. Raya Lohbener Baru, 778A"));
        p.add(creditRatingPanel);
        p.add(approvedPanel);

        return p;
    }

    // Dialog untuk Add Days
    private void showAddDaysDialog(JLabel daysLabel) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel instruction = new JLabel("Tambah hari reservasi:");
        JSpinner daysSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
        daysSpinner.setPreferredSize(new Dimension(60, 20));
        
        inputPanel.add(instruction);
        inputPanel.add(daysSpinner);
        
        panel.add(inputPanel, BorderLayout.CENTER);
        
        // Tampilkan info current days
        String currentText = daysLabel.getText();
        int currentDays = Integer.parseInt(currentText.split(" ")[0]);
        int maxDays = 30;
        
        JLabel infoLabel = new JLabel("Current: " + currentDays + " hari (Max: " + maxDays + " hari)");
        infoLabel.setFont(infoLabel.getFont().deriveFont(Font.ITALIC, 11f));
        panel.add(infoLabel, BorderLayout.NORTH);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "Tambah Hari Reservasi", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            int additionalDays = (Integer) daysSpinner.getValue();
            int newTotal = currentDays + additionalDays;
            
            if (newTotal <= maxDays) {
                daysLabel.setText(newTotal + " of " + maxDays);
                JOptionPane.showMessageDialog(this, 
                    "Berhasil menambah " + additionalDays + " hari!\n" +
                    "Total reservasi: " + newTotal + " hari",
                    "Hari Ditambahkan",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Total hari melebihi batas maksimal (" + maxDays + " hari)",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Dialog untuk S&P Rating Update
    private void showSPRatingDialog(JLabel ratingLabel) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        
        JPanel ratingPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        
        ButtonGroup ratingGroup = new ButtonGroup();
        JRadioButton aaaButton = new JRadioButton("AAA - Excellent");
        JRadioButton aaButton = new JRadioButton("AA - Very Good");
        JRadioButton aButton = new JRadioButton("A - Good");
        JRadioButton bbbButton = new JRadioButton("BBB - Average");
        JRadioButton bbButton = new JRadioButton("BB - Below Average");
        JRadioButton bButton = new JRadioButton("B - Poor");
        
        // Set current rating
        String currentRating = ratingLabel.getText();
        switch (currentRating) {
            case "AAA": aaaButton.setSelected(true); break;
            case "AA": aaButton.setSelected(true); break;
            case "A": aButton.setSelected(true); break;
            case "BBB": bbbButton.setSelected(true); break;
            case "BB": bbButton.setSelected(true); break;
            case "B": bButton.setSelected(true); break;
            default: aaaButton.setSelected(true);
        }
        
        ratingGroup.add(aaaButton);
        ratingGroup.add(aaButton);
        ratingGroup.add(aButton);
        ratingGroup.add(bbbButton);
        ratingGroup.add(bbButton);
        ratingGroup.add(bButton);
        
        ratingPanel.add(aaaButton);
        ratingPanel.add(aaButton);
        ratingPanel.add(aButton);
        ratingPanel.add(bbbButton);
        ratingPanel.add(bbButton);
        ratingPanel.add(bButton);
        
        panel.add(new JLabel("Pilih Credit Rating:"), BorderLayout.NORTH);
        panel.add(ratingPanel, BorderLayout.CENTER);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "Update S&P Rating", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            String newRating = "";
            Color ratingColor = Color.BLACK;
            
            if (aaaButton.isSelected()) {
                newRating = "AAA";
                ratingColor = new Color(0, 128, 0); // Hijau
            } else if (aaButton.isSelected()) {
                newRating = "AA";
                ratingColor = new Color(0, 150, 0); // Hijau muda
            } else if (aButton.isSelected()) {
                newRating = "A";
                ratingColor = new Color(50, 150, 50); // Hijau medium
            } else if (bbbButton.isSelected()) {
                newRating = "BBB";
                ratingColor = Color.ORANGE;
            } else if (bbButton.isSelected()) {
                newRating = "BB";
                ratingColor = new Color(255, 140, 0); // Orange tua
            } else if (bButton.isSelected()) {
                newRating = "B";
                ratingColor = Color.RED;
            }
            
            ratingLabel.setText(newRating);
            ratingLabel.setForeground(ratingColor);
            
            JOptionPane.showMessageDialog(this, 
                "Credit rating diperbarui menjadi: " + newRating,
                "Rating Diupdate",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private JPanel createAdditionalPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(titledBorder("Additional Information"));

        // Buat komponen yang bisa diedit
        JTextField estimatedCloseField = new JTextField("2025-12-15");
        estimatedCloseField.setEditable(true);
        
        // Label untuk informasi yang tidak bisa diedit
        JLabel creationDateLabel = new JLabel("2025-10-15");
        JLabel createdByLabel = new JLabel("Admin");
        JLabel lastEditDateLabel = new JLabel("2025-11-16");
        JLabel lastEditedByLabel = new JLabel("Warnoto");
        JLabel closedDateLabel = new JLabel("null");
        JLabel closedByLabel = new JLabel("null");

        // Panel untuk Estimated Close dengan tombol Edit
        JPanel estimatedClosePanel = new JPanel(new BorderLayout(6, 0));
        estimatedClosePanel.setOpaque(false);
        JLabel estimatedLabel = new JLabel("Estimated close:");
        estimatedLabel.setPreferredSize(new Dimension(120, 20));
        
        JPanel estimatedRightPanel = new JPanel(new BorderLayout());
        estimatedRightPanel.add(estimatedCloseField, BorderLayout.CENTER);
        
        JButton editDateBtn = new JButton("Edit");
        editDateBtn.setPreferredSize(new Dimension(60, 20));
        editDateBtn.setFont(editDateBtn.getFont().deriveFont(10f));
        editDateBtn.addActionListener(e -> {
            showDatePickerDialog(estimatedCloseField, lastEditDateLabel, lastEditedByLabel);
        });
        
        estimatedRightPanel.add(editDateBtn, BorderLayout.EAST);
        estimatedClosePanel.add(estimatedLabel, BorderLayout.WEST);
        estimatedClosePanel.add(estimatedRightPanel, BorderLayout.CENTER);
        estimatedClosePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Tambahkan komponen ke panel utama
        p.add(estimatedClosePanel);
        p.add(rowLabel("Creation date:", creationDateLabel));
        p.add(rowLabel("Created by:", createdByLabel));
        p.add(rowLabel("Last edit date:", lastEditDateLabel));
        p.add(rowLabel("Last edited by:", lastEditedByLabel));
        p.add(rowLabel("Closed date:", closedDateLabel));
        p.add(rowLabel("Closed by:", closedByLabel));

        return p;
    }

    // Method untuk menampilkan date picker dialog
    private void showDatePickerDialog(JTextField dateField, JLabel lastEditDateLabel, JLabel lastEditedByLabel) {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Buat komponen date picker sederhana
        JPanel datePanel = new JPanel(new FlowLayout());
        
        // Tahun
        JComboBox<Integer> yearCombo = new JComboBox<>();
        int currentYear = java.time.Year.now().getValue();
        for (int i = currentYear; i <= currentYear + 5; i++) {
            yearCombo.addItem(i);
        }
        
        // Bulan
        JComboBox<String> monthCombo = new JComboBox<>(new String[]{
            "01", "02", "03", "04", "05", "06", 
            "07", "08", "09", "10", "11", "12"
        });
        
        // Hari
        JComboBox<Integer> dayCombo = new JComboBox<>();
        updateDayCombo(dayCombo, (Integer)yearCombo.getSelectedItem(), 
                      monthCombo.getSelectedIndex() + 1);
        
        // Listener untuk update hari ketika tahun/bulan berubah
        yearCombo.addActionListener(e -> updateDayCombo(dayCombo, (Integer)yearCombo.getSelectedItem(), 
                              monthCombo.getSelectedIndex() + 1));
        monthCombo.addActionListener(e -> updateDayCombo(dayCombo, (Integer)yearCombo.getSelectedItem(), 
                               monthCombo.getSelectedIndex() + 1));
        
        datePanel.add(new JLabel("Tahun:"));
        datePanel.add(yearCombo);
        datePanel.add(new JLabel("Bulan:"));
        datePanel.add(monthCombo);
        datePanel.add(new JLabel("Hari:"));
        datePanel.add(dayCombo);
        
        panel.add(datePanel, BorderLayout.CENTER);
        
        // Parse tanggal yang ada untuk set nilai default
        String currentDate = dateField.getText();
        if (isValidDate(currentDate)) {
            String[] parts = currentDate.split("-");
            if (parts.length == 3) {
                yearCombo.setSelectedItem(Integer.parseInt(parts[0]));
                monthCombo.setSelectedIndex(Integer.parseInt(parts[1]) - 1);
                dayCombo.setSelectedItem(Integer.parseInt(parts[2]));
            }
        }
        
        int result = JOptionPane.showConfirmDialog(this, panel, "Pilih Tanggal", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            String selectedDate = String.format("%d-%s-%02d", 
                yearCombo.getSelectedItem(),
                monthCombo.getSelectedItem(),
                dayCombo.getSelectedItem());
            dateField.setText(selectedDate);
            
            // Otomatis update last edit info
            lastEditDateLabel.setText(java.time.LocalDate.now().toString());
            lastEditedByLabel.setText("Current User");
            
            JOptionPane.showMessageDialog(this, 
                "Estimated close berhasil diubah!\n\n" +
                "Tanggal baru: " + selectedDate + "\n" +
                "Last edit date: " + java.time.LocalDate.now() + "\n" +
                "Last edited by: Current User",
                "Perubahan Tersimpan",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Method untuk update jumlah hari berdasarkan bulan dan tahun
    private void updateDayCombo(JComboBox<Integer> dayCombo, int year, int month) {
        dayCombo.removeAllItems();
        int daysInMonth = java.time.YearMonth.of(year, month).lengthOfMonth();
        for (int i = 1; i <= daysInMonth; i++) {
            dayCombo.addItem(i);
        }
    }

    // Validasi format tanggal sederhana
    private boolean isValidDate(String date) {
        if (date == null || !date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }
        try {
            java.time.LocalDate.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private JPanel createProductListPanel() {
        JPanel p = new JPanel(new BorderLayout(6,6));
        p.setBorder(titledBorder("Product List"));

        String[] cols = {"Renovation","Description","Part #","Quantity","List Price","Discount","Price","Wholesale Discount","Wholesaler Price"};
        Object[][] rows = {
            {"Dapur","Keramik Dinding Putih","KW-PT-DLX-01",50,150000,0,7500000,5,7125000},
            {"Dapur","Lem Keramik Instan","LMI-GRY-STD",5,50000,0,250000,0,250000},
            {"Dapur","Pipa PVC 3 inch","PVC-3IN-STD",12,35000,0,420000,10,378000}
        };
        DefaultTableModel model = new DefaultTableModel(rows, cols) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };
        JTable table = new JTable(model);
        table.setRowHeight(24);
        table.setSelectionBackground(new Color(153,51,204));
        table.setSelectionForeground(Color.white);
        
        // Set preferred column widths to prevent excessive widening
        table.getColumnModel().getColumn(0).setPreferredWidth(80);  // Renovation
        table.getColumnModel().getColumn(1).setPreferredWidth(120); // Description
        table.getColumnModel().getColumn(2).setPreferredWidth(100); // Part #
        table.getColumnModel().getColumn(3).setPreferredWidth(60);  // Quantity
        table.getColumnModel().getColumn(4).setPreferredWidth(80);  // List Price
        table.getColumnModel().getColumn(5).setPreferredWidth(60);  // Discount
        table.getColumnModel().getColumn(6).setPreferredWidth(80);  // Price
        table.getColumnModel().getColumn(7).setPreferredWidth(100); // Wholesale Discount
        table.getColumnModel().getColumn(8).setPreferredWidth(100); // Wholesaler Price
        
        JScrollPane sp = new JScrollPane(table);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        p.add(sp, BorderLayout.CENTER);

        // summary on bottom-right
        JPanel sum = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 6));
        sum.add(new JLabel("Subtotal: Rp 15.570.000"));
        sum.add(Box.createHorizontalStrut(10));
        sum.add(new JLabel("Retailer: Rp 15.182.500"));
        sum.add(Box.createHorizontalStrut(10));
        sum.add(new JLabel("Wholesaler: Rp 14.249.625"));
        p.add(sum, BorderLayout.SOUTH);

        // Right-side buttons (Add/Edit/Delete) anchored vertically
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBorder(BorderFactory.createEmptyBorder(0,8,0,0));
        JButton add = new JButton("Add");
        JButton edit = new JButton("Edit");
        JButton del = new JButton("Delete");
        add.setMaximumSize(new Dimension(90, 28));
        edit.setMaximumSize(new Dimension(90, 28));
        del.setMaximumSize(new Dimension(90, 28));
        
        add.addActionListener(e -> showAddProductDialog(model));
        edit.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                showEditProductDialog(model, selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih produk yang akan diedit", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });
        del.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                int confirm = JOptionPane.showConfirmDialog(this, 
                    "Hapus produk ini?", "Konfirmasi Hapus", 
                    JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    model.removeRow(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih produk yang akan dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        right.add(add);
        right.add(Box.createRigidArea(new Dimension(0,6)));
        right.add(edit);
        right.add(Box.createRigidArea(new Dimension(0,6)));
        right.add(del);
        p.add(right, BorderLayout.EAST);

        return p;
    }

    private JPanel createTasksPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(titledBorder("Tasks"));

        String[] cols = {"State","Task","Assigner","Executer","Creation Date","Estimated Date","Executed Date"};
        Object[][] rows = {
            {"Completed","Pemasangan pipa PVC di area garasi","Warnoto","Goang","2025-10-20","2025-10-21","2025-10-21"},
            {"Completed","Pengecatan ulang ruang tamu","Warnoto","Toni","2025-10-25","2025-10-28","2025-10-27"},
            {"Delayed","Pemasangan keramik dinding dapur","Warnoto","Toni","2025-11-01","2025-11-04",""}
        };
        DefaultTableModel model = new DefaultTableModel(rows, cols) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        JTable table = new JTable(model);
        table.setRowHeight(22);
        table.setSelectionBackground(new Color(153,51,204));
        table.setSelectionForeground(Color.white);
        
        // Set preferred column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(80);  // State
        table.getColumnModel().getColumn(1).setPreferredWidth(200); // Task
        table.getColumnModel().getColumn(2).setPreferredWidth(80);  // Assigner
        table.getColumnModel().getColumn(3).setPreferredWidth(80);  // Executer
        table.getColumnModel().getColumn(4).setPreferredWidth(100); // Creation Date
        table.getColumnModel().getColumn(5).setPreferredWidth(100); // Estimated Date
        table.getColumnModel().getColumn(6).setPreferredWidth(100); // Executed Date
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        p.add(scrollPane, BorderLayout.CENTER);

        // right vertical buttons
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        JButton add = new JButton("Add"), edit = new JButton("Edit"), del = new JButton("Delete");
        add.setMaximumSize(new Dimension(90, 28));
        edit.setMaximumSize(new Dimension(90, 28));
        del.setMaximumSize(new Dimension(90, 28));
        
        add.addActionListener(e -> showAddTaskDialog(model));
        edit.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                showEditTaskDialog(model, selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih task yang akan diedit", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });
        del.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                int confirm = JOptionPane.showConfirmDialog(this, 
                    "Hapus task ini?", "Konfirmasi Hapus", 
                    JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    model.removeRow(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih task yang akan dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        right.add(add); right.add(Box.createRigidArea(new Dimension(0,6))); right.add(edit); right.add(Box.createRigidArea(new Dimension(0,6))); right.add(del);
        p.add(right, BorderLayout.EAST);

        return p;
    }

    private JPanel createCommentsPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(titledBorder("Comments"));

        String[] cols = {"Date","User","Comment"};
        Object[][] rows = {
            {"2025-10-26 10:15","Toni","Cat tembok sudah diolesi lapisan pertama. Menunggu kering sebelum lapisan kedua."},
            {"2025-11-03 16:45","Toni","Cuaca hujan deras selama 2 hari, area kerja sedikit basah. Pemasangan ditunda besok pagi."},
            {"2025-11-15 14:30","Goang","Barang sudah sampai di lokasi. Mulai proses pembongkaran closet lama sore ini."}
        };
        DefaultTableModel model = new DefaultTableModel(rows, cols) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        JTable table = new JTable(model);
        table.setRowHeight(22);
        table.setSelectionBackground(new Color(153,51,204));
        table.setSelectionForeground(Color.white);
        
        // Set preferred column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(120); // Date
        table.getColumnModel().getColumn(1).setPreferredWidth(80);  // User
        table.getColumnModel().getColumn(2).setPreferredWidth(300); // Comment
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        p.add(scrollPane, BorderLayout.CENTER);

        // right-side small buttons
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        JButton add = new JButton("Add"), edit = new JButton("Edit"), del = new JButton("Delete");
        add.setMaximumSize(new Dimension(90,28)); edit.setMaximumSize(new Dimension(90,28)); del.setMaximumSize(new Dimension(90,28));
        
        add.addActionListener(e -> showAddCommentDialog(model));
        edit.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                showEditCommentDialog(model, selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih komentar yang akan diedit", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });
        del.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                int confirm = JOptionPane.showConfirmDialog(this, 
                    "Hapus komentar ini?", "Konfirmasi Hapus", 
                    JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    model.removeRow(selectedRow);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih komentar yang akan dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        right.add(add); right.add(Box.createRigidArea(new Dimension(0,6))); right.add(edit); right.add(Box.createRigidArea(new Dimension(0,6))); right.add(del);
        p.add(right, BorderLayout.EAST);

        return p;
    }

    // Helper methods untuk dialog-dialog
    private void showAddProductDialog(DefaultTableModel model) {
        JTextField renovationField = new JTextField();
        JTextField descField = new JTextField();
        JTextField partField = new JTextField();
        JTextField qtyField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField discountField = new JTextField();
        JTextField wsDiscountField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Renovation:"));
        panel.add(renovationField);
        panel.add(new JLabel("Description:"));
        panel.add(descField);
        panel.add(new JLabel("Part #:"));
        panel.add(partField);
        panel.add(new JLabel("Quantity:"));
        panel.add(qtyField);
        panel.add(new JLabel("List Price:"));
        panel.add(priceField);
        panel.add(new JLabel("Discount:"));
        panel.add(discountField);
        panel.add(new JLabel("Wholesale Discount:"));
        panel.add(wsDiscountField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Tambah Produk", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int quantity = Integer.parseInt(qtyField.getText());
                double listPrice = Double.parseDouble(priceField.getText());
                double discount = Double.parseDouble(discountField.getText());
                double wsDiscount = Double.parseDouble(wsDiscountField.getText());
                
                double price = quantity * listPrice * (1 - discount/100);
                double wsPrice = quantity * listPrice * (1 - wsDiscount/100);
                
                model.addRow(new Object[]{
                    renovationField.getText(),
                    descField.getText(),
                    partField.getText(),
                    quantity,
                    listPrice,
                    discount,
                    price,
                    wsDiscount,
                    wsPrice
                });
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Format angka tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showEditProductDialog(DefaultTableModel model, int row) {
        JTextField renovationField = new JTextField(model.getValueAt(row, 0).toString());
        JTextField descField = new JTextField(model.getValueAt(row, 1).toString());
        JTextField partField = new JTextField(model.getValueAt(row, 2).toString());
        JTextField qtyField = new JTextField(model.getValueAt(row, 3).toString());
        JTextField priceField = new JTextField(model.getValueAt(row, 4).toString());
        JTextField discountField = new JTextField(model.getValueAt(row, 5).toString());
        JTextField wsDiscountField = new JTextField(model.getValueAt(row, 7).toString());

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Renovation:"));
        panel.add(renovationField);
        panel.add(new JLabel("Description:"));
        panel.add(descField);
        panel.add(new JLabel("Part #:"));
        panel.add(partField);
        panel.add(new JLabel("Quantity:"));
        panel.add(qtyField);
        panel.add(new JLabel("List Price:"));
        panel.add(priceField);
        panel.add(new JLabel("Discount:"));
        panel.add(discountField);
        panel.add(new JLabel("Wholesale Discount:"));
        panel.add(wsDiscountField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Edit Produk", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            try {
                int quantity = Integer.parseInt(qtyField.getText());
                double listPrice = Double.parseDouble(priceField.getText());
                double discount = Double.parseDouble(discountField.getText());
                double wsDiscount = Double.parseDouble(wsDiscountField.getText());
                
                double price = quantity * listPrice * (1 - discount/100);
                double wsPrice = quantity * listPrice * (1 - wsDiscount/100);
                
                model.setValueAt(renovationField.getText(), row, 0);
                model.setValueAt(descField.getText(), row, 1);
                model.setValueAt(partField.getText(), row, 2);
                model.setValueAt(quantity, row, 3);
                model.setValueAt(listPrice, row, 4);
                model.setValueAt(discount, row, 5);
                model.setValueAt(price, row, 6);
                model.setValueAt(wsDiscount, row, 7);
                model.setValueAt(wsPrice, row, 8);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Format angka tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showAddTaskDialog(DefaultTableModel model) {
        JComboBox<String> stateCombo = new JComboBox<>(new String[]{"Pending", "In Progress", "Completed", "Delayed"});
        JTextField taskField = new JTextField();
        JTextField assignerField = new JTextField("Warnoto");
        JTextField executerField = new JTextField();
        JTextField createDateField = new JTextField(java.time.LocalDate.now().toString());
        JTextField estDateField = new JTextField();
        JTextField execDateField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("State:"));
        panel.add(stateCombo);
        panel.add(new JLabel("Task:"));
        panel.add(taskField);
        panel.add(new JLabel("Assigner:"));
        panel.add(assignerField);
        panel.add(new JLabel("Executer:"));
        panel.add(executerField);
        panel.add(new JLabel("Creation Date:"));
        panel.add(createDateField);
        panel.add(new JLabel("Estimated Date:"));
        panel.add(estDateField);
        panel.add(new JLabel("Executed Date:"));
        panel.add(execDateField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Tambah Task", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            model.addRow(new Object[]{
                stateCombo.getSelectedItem(),
                taskField.getText(),
                assignerField.getText(),
                executerField.getText(),
                createDateField.getText(),
                estDateField.getText(),
                execDateField.getText()
            });
        }
    }

    private void showEditTaskDialog(DefaultTableModel model, int row) {
        JComboBox<String> stateCombo = new JComboBox<>(new String[]{"Pending", "In Progress", "Completed", "Delayed"});
        stateCombo.setSelectedItem(model.getValueAt(row, 0));
        JTextField taskField = new JTextField(model.getValueAt(row, 1).toString());
        JTextField assignerField = new JTextField(model.getValueAt(row, 2).toString());
        JTextField executerField = new JTextField(model.getValueAt(row, 3).toString());
        JTextField createDateField = new JTextField(model.getValueAt(row, 4).toString());
        JTextField estDateField = new JTextField(model.getValueAt(row, 5).toString());
        JTextField execDateField = new JTextField(model.getValueAt(row, 6).toString());

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("State:"));
        panel.add(stateCombo);
        panel.add(new JLabel("Task:"));
        panel.add(taskField);
        panel.add(new JLabel("Assigner:"));
        panel.add(assignerField);
        panel.add(new JLabel("Executer:"));
        panel.add(executerField);
        panel.add(new JLabel("Creation Date:"));
        panel.add(createDateField);
        panel.add(new JLabel("Estimated Date:"));
        panel.add(estDateField);
        panel.add(new JLabel("Executed Date:"));
        panel.add(execDateField);

        int result = JOptionPane.showConfirmDialog(this, panel, "Edit Task", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            model.setValueAt(stateCombo.getSelectedItem(), row, 0);
            model.setValueAt(taskField.getText(), row, 1);
            model.setValueAt(assignerField.getText(), row, 2);
            model.setValueAt(executerField.getText(), row, 3);
            model.setValueAt(createDateField.getText(), row, 4);
            model.setValueAt(estDateField.getText(), row, 5);
            model.setValueAt(execDateField.getText(), row, 6);
        }
    }

    private void showAddCommentDialog(DefaultTableModel model) {
        JTextField dateField = new JTextField(java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        JTextField userField = new JTextField("User");
        JTextArea commentArea = new JTextArea(3, 20);
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);

        JPanel panel = new JPanel(new BorderLayout(5, 5));
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        topPanel.add(new JLabel("Date:"));
        topPanel.add(dateField);
        topPanel.add(new JLabel("User:"));
        topPanel.add(userField);
        
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JLabel("Comment:"), BorderLayout.CENTER);
        panel.add(new JScrollPane(commentArea), BorderLayout.SOUTH);

        int result = JOptionPane.showConfirmDialog(this, panel, "Tambah Komentar", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            model.addRow(new Object[]{
                dateField.getText(),
                userField.getText(),
                commentArea.getText()
            });
        }
    }

    private void showEditCommentDialog(DefaultTableModel model, int row) {
        JTextField dateField = new JTextField(model.getValueAt(row, 0).toString());
        JTextField userField = new JTextField(model.getValueAt(row, 1).toString());
        JTextArea commentArea = new JTextArea(model.getValueAt(row, 2).toString(), 3, 20);
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);

        JPanel panel = new JPanel(new BorderLayout(5, 5));
        JPanel topPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        topPanel.add(new JLabel("Date:"));
        topPanel.add(dateField);
        topPanel.add(new JLabel("User:"));
        topPanel.add(userField);
        
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JLabel("Comment:"), BorderLayout.CENTER);
        panel.add(new JScrollPane(commentArea), BorderLayout.SOUTH);

        int result = JOptionPane.showConfirmDialog(this, panel, "Edit Komentar", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            model.setValueAt(dateField.getText(), row, 0);
            model.setValueAt(userField.getText(), row, 1);
            model.setValueAt(commentArea.getText(), row, 2);
        }
    }

    // helpers
    private Border titledBorder(String title) {
        return BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), title);
    }

    private JPanel rowLabel(String left, String right) {
        return rowLabel(left, new JLabel(right));
    }

    // Overload method rowLabel untuk menerima JComponent
    private JPanel rowLabel(String left, JComponent rightComponent) {
        JPanel p = new JPanel(new BorderLayout(6,0));
        p.setOpaque(false);
        JLabel l = new JLabel(left);
        l.setPreferredSize(new Dimension(120, 20));
        p.add(l, BorderLayout.WEST);
        p.add(rightComponent, BorderLayout.CENTER);
        p.setAlignmentX(Component.LEFT_ALIGNMENT);
        return p;
    }

    public static void main(String[] args) {
        // Set FlatLaf look
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        SwingUtilities.invokeLater(() -> {
            KeperluanRenovasiBangunan ex = new KeperluanRenovasiBangunan();
            ex.setVisible(true);
        });
    }
}