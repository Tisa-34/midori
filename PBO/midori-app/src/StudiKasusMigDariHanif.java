import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.FlatLightLaf;

public class StudiKasusMigDariHanif extends JFrame {
    private DefaultTableModel productModel, tasksModel, commentsModel;
    private JTable productTable, tasksTable, commentsTable;

    public StudiKasusMigDariHanif() {
        initUI();
    }

    private void initUI() {
        setTitle("Detail Proyek: RNV-JKT-AXG-001");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(null);

        // Main panel using MigLayout
        JPanel main = new JPanel(new MigLayout("fill, insets 10",
                "[30%]10[35%]10[30%]",
                "[][grow 0, 220!][grow 0, 20%][grow 0, 20%][]"));
        
        JScrollPane scrollPane = new JScrollPane(main);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);
        
        add(scrollPane);

        // HEADER
        JPanel header = new JPanel(new BorderLayout());
        header.setBorder(BorderFactory.createEmptyBorder(4,4,8,4));
        JLabel title = new JLabel("Detail Proyek: RNV-JKT-AXG-001");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 16f));
        header.add(title, BorderLayout.WEST);
        main.add(header, "spanx, wrap, growx");

        // Row 1: three titled panels
        main.add(createClientPanel(), "growy, top, gapbottom 4");
        main.add(createInformationPanel(), "growy, top, gapbottom 4");
        main.add(createAdditionalPanel(), "growy, top, wrap, gapbottom 8");

        // Row 2: Product List
        main.add(createProductListPanel(), "spanx, growx, h 160!, wrap, gapbottom 8");

        // Row 3: Tasks
        main.add(createTasksPanel(), "spanx, growx, h 120!, wrap, gapbottom 8");

        // Row 4: Comments
        main.add(createCommentsPanel(), "spanx, growx, h 120!, wrap, gapbottom 8");

        // Row 5: Controls
        JPanel bottomControls = new JPanel(new BorderLayout());
        bottomControls.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JButton exportBtn = new JButton("Export");
        exportBtn.setPreferredSize(new Dimension(90, 28));
        exportBtn.setFocusPainted(false);
        bottomControls.add(exportBtn, BorderLayout.WEST);

        JPanel rightBtns = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        JButton saveBtn = new JButton("Save");
        saveBtn.setPreferredSize(new Dimension(90, 28));
        saveBtn.setBackground(new Color(153, 51, 204));
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setOpaque(true);
        saveBtn.setBorderPainted(false);
        saveBtn.setFocusPainted(false);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setPreferredSize(new Dimension(90, 28));
        cancelBtn.setFocusPainted(false);

        rightBtns.add(saveBtn);
        rightBtns.add(cancelBtn);
        bottomControls.add(rightBtns, BorderLayout.EAST);

        exportBtn.addActionListener(e -> onExport());
        saveBtn.addActionListener(e -> onSave());
        cancelBtn.addActionListener(e -> onCancel());

        main.add(bottomControls, "spanx, growx");
    }

    private JPanel createClientPanel() {
        JPanel p = new JPanel(new BorderLayout(8, 8));
        p.setBorder(createSectionBorder("Client"));
        p.setBackground(Color.WHITE);

        JPanel contentPanel = new JPanel(new MigLayout("insets 8", "[][grow]", "[]4[]4[]4[]8[]"));
        contentPanel.setBackground(Color.WHITE);

        // Client ID
        contentPanel.add(new JLabel("Client ID:"), "align right");
        JLabel idValue = new JLabel("101");
        idValue.setFont(idValue.getFont().deriveFont(Font.BOLD));
        contentPanel.add(idValue, "wrap");

        // Name
        contentPanel.add(new JLabel("Name:"), "align right");
        JLabel nameValue = new JLabel("Bapak Alex Gunawan");
        nameValue.setFont(nameValue.getFont().deriveFont(Font.BOLD));
        contentPanel.add(nameValue, "wrap");

        // Phone
        contentPanel.add(new JLabel("Phone:"), "align right");
        contentPanel.add(new JLabel("(+62) 8123456789"), "wrap");

        // Registration No
        contentPanel.add(new JLabel("Registration No:"), "align right");
        JLabel regValue = new JLabel("RNV-JKT-AXG-001");
        regValue.setFont(regValue.getFont().deriveFont(Font.BOLD));
        contentPanel.add(regValue, "wrap");

        // Details button
        JButton details = new JButton("Details");
        details.setPreferredSize(new Dimension(100, 28));
        details.setBackground(new Color(153, 51, 204));
        details.setForeground(Color.WHITE);
        details.setOpaque(true);
        details.setBorderPainted(false);
        details.setFocusPainted(false);
        contentPanel.add(details, "span, center");

        p.add(contentPanel, BorderLayout.CENTER);
        return p;
    }

    private JPanel createInformationPanel() {
        JPanel p = new JPanel(new BorderLayout(8, 8));
        p.setBorder(createSectionBorder("Information"));
        p.setBackground(Color.WHITE);

        JPanel contentPanel = new JPanel(new MigLayout("insets 8", "[][grow][]", "[]4[]8[]4[]4[]4[]8[]4[]"));
        contentPanel.setBackground(Color.WHITE);

        // Reserve days dengan textfield dan button
        contentPanel.add(new JLabel("Reserve days:"), "align right");
        JTextField reserveDaysField = new JTextField("0 of 30");
        reserveDaysField.setEditable(false);
        reserveDaysField.setBackground(Color.WHITE);
        contentPanel.add(reserveDaysField, "growx");
        JButton addDaysBtn = new JButton("Add Days");
        addDaysBtn.setPreferredSize(new Dimension(90, 26));
        addDaysBtn.setFocusPainted(false);
        contentPanel.add(addDaysBtn, "wrap");

        // Buyer
        contentPanel.add(new JLabel("Buyer:"), "align right");
        JTextField buyerField = new JTextField("Bapak Alex Gunawan");
        buyerField.setEditable(false);
        buyerField.setBackground(Color.WHITE);
        contentPanel.add(buyerField, "span, growx, wrap");

        // Seller
        contentPanel.add(new JLabel("Seller:"), "align right");
        JTextField sellerField = new JTextField("PT Bangun Jaya Abadi");
        sellerField.setEditable(false);
        sellerField.setBackground(Color.WHITE);
        contentPanel.add(sellerField, "span, growx, wrap");

        // Address
        contentPanel.add(new JLabel("Address:"), "align right");
        JTextField addressField = new JTextField("Jl. Raya Lohbener Baru, 778A");
        addressField.setEditable(false);
        addressField.setBackground(Color.WHITE);
        contentPanel.add(addressField, "span, growx, wrap");

        // Credit rating dengan textfield dan button
        contentPanel.add(new JLabel("Credit rating:"), "align right");
        JTextField creditField = new JTextField("AAA");
        creditField.setEditable(false);
        creditField.setBackground(Color.WHITE);
        contentPanel.add(creditField, "growx");
        JButton spUpdateBtn = new JButton("S&P Update");
        spUpdateBtn.setPreferredSize(new Dimension(100, 26));
        spUpdateBtn.setFocusPainted(false);
        contentPanel.add(spUpdateBtn, "wrap");

        // Approved dengan checkbox dan textfield
        JCheckBox approvedCheck = new JCheckBox("Approved:");
        approvedCheck.setSelected(true);
        approvedCheck.setBackground(Color.WHITE);
        contentPanel.add(approvedCheck, "align right");
        JTextField approvedField = new JTextField("Proyek renovasi telah disetujui, siap dimulai");
        approvedField.setEditable(false);
        approvedField.setBackground(Color.WHITE);
        contentPanel.add(approvedField, "span, growx, wrap");

        p.add(contentPanel, BorderLayout.CENTER);
        return p;
    }

    private JPanel createAdditionalPanel() {
        JPanel p = new JPanel(new BorderLayout(8, 8));
        p.setBorder(createSectionBorder("Additional Information"));
        p.setBackground(Color.WHITE);

        JPanel contentPanel = new JPanel(new MigLayout("insets 8", "[][grow][]", "[]8[]4[]4[]4[]4[]4[]"));
        contentPanel.setBackground(Color.WHITE);

        // Estimated close dengan textfield dan button
        contentPanel.add(new JLabel("Estimated close"), "align right");
        JTextField estDateField = new JTextField("2025-12-15");
        estDateField.setEditable(false);
        estDateField.setBackground(Color.WHITE);
        contentPanel.add(estDateField, "growx");
        JButton editEst = new JButton("Edit");
        editEst.setPreferredSize(new Dimension(60, 26));
        editEst.setFocusPainted(false);
        contentPanel.add(editEst, "wrap");

        // Creation date
        contentPanel.add(new JLabel("Creation date:"), "align right");
        JLabel creationValue = new JLabel("2025-10-15");
        creationValue.setFont(creationValue.getFont().deriveFont(Font.BOLD));
        contentPanel.add(creationValue, "span, wrap");

        // Created by
        contentPanel.add(new JLabel("Created by:"), "align right");
        JLabel createdByValue = new JLabel("Admin");
        createdByValue.setFont(createdByValue.getFont().deriveFont(Font.BOLD));
        contentPanel.add(createdByValue, "span, wrap");

        // Last edit date
        contentPanel.add(new JLabel("Last edit date:"), "align right");
        JLabel lastEditValue = new JLabel("2025-11-16");
        lastEditValue.setFont(lastEditValue.getFont().deriveFont(Font.BOLD));
        contentPanel.add(lastEditValue, "span, wrap");

        // Last edited by
        contentPanel.add(new JLabel("Last edited by:"), "align right");
        JLabel lastEditedByValue = new JLabel("Warnoto");
        lastEditedByValue.setFont(lastEditedByValue.getFont().deriveFont(Font.BOLD));
        contentPanel.add(lastEditedByValue, "span, wrap");

        // Closed date
        contentPanel.add(new JLabel("Closed date:"), "align right");
        JLabel closedDateValue = new JLabel("null");
        closedDateValue.setFont(closedDateValue.getFont().deriveFont(Font.BOLD));
        contentPanel.add(closedDateValue, "span, wrap");

        // Closed by
        contentPanel.add(new JLabel("Closed by:"), "align right");
        JLabel closedByValue = new JLabel("null");
        closedByValue.setFont(closedByValue.getFont().deriveFont(Font.BOLD));
        contentPanel.add(closedByValue, "span, wrap");

        p.add(contentPanel, BorderLayout.CENTER);
        return p;
    }

    private JPanel createProductListPanel() {
        // Panel utama dengan border
        JPanel mainPanel = new JPanel(new MigLayout("fill, insets 0", "[grow]", "[grow][]"));
        
        // Panel untuk tabel dengan border dan button
        JPanel tablePanel = new JPanel(new BorderLayout(6,6));
        tablePanel.setBorder(createSectionBorder("Product List"));

        String[] cols = {"Renovation","Description","Part #","Quantity","List Price","Discount","Price","Wholesale Discount","Wholesaler Price"};
        Object[][] rows = {
            {"Dapur","Keramik Dinding Putih","KW-PT-DLX-01",50,150000,0,7500000,5,7125000},
            {"Dapur","Lem Keramik Instan","LMI-GRY-STD",5,50000,0,250000,0,250000},
            {"Dapur","Pipa PVC 3 inch","PVC-3IN-STD",12,35000,0,420000,10,378000}
        };
        productModel = new DefaultTableModel(rows, cols) {
            @Override public boolean isCellEditable(int row, int col) { return false; }
        };
        productTable = new JTable(productModel);
        productTable.setRowHeight(28);
        
        // Atur tinggi header
        productTable.getTableHeader().setPreferredSize(new Dimension(0, 32));
        
        // Set warna selection
        UIManager.put("Table.selectionBackground", new Color(153, 51, 204));
        UIManager.put("Table.selectionForeground", Color.WHITE);
        productTable.setSelectionBackground(new Color(153, 51, 204));
        productTable.setSelectionForeground(Color.WHITE);
        
        // Listener untuk mengubah warna saat kehilangan focus
        productTable.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                productTable.setSelectionBackground(new Color(200, 200, 200));
                productTable.setSelectionForeground(Color.BLACK);
                productTable.repaint();
            }
            
            @Override
            public void focusGained(FocusEvent e) {
                productTable.setSelectionBackground(new Color(153, 51, 204));
                productTable.setSelectionForeground(Color.WHITE);
                productTable.repaint();
            }
        });
        
        productTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        productTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        productTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        productTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        productTable.getColumnModel().getColumn(3).setPreferredWidth(60);
        productTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        productTable.getColumnModel().getColumn(5).setPreferredWidth(70);
        productTable.getColumnModel().getColumn(6).setPreferredWidth(80);
        productTable.getColumnModel().getColumn(7).setPreferredWidth(100);
        productTable.getColumnModel().getColumn(8).setPreferredWidth(100);
        
        JScrollPane sp = new JScrollPane(productTable);
        tablePanel.add(sp, BorderLayout.CENTER);

        // Right-side buttons
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
        JButton add = new JButton("Add");
        JButton edit = new JButton("Edit");
        JButton del = new JButton("Delete");
        add.setMaximumSize(new Dimension(90, 28));
        edit.setMaximumSize(new Dimension(90, 28));
        del.setMaximumSize(new Dimension(90, 28));
        add.setFocusPainted(false);
        edit.setFocusPainted(false);
        del.setFocusPainted(false);
        right.add(add);
        right.add(Box.createRigidArea(new Dimension(0,6)));
        right.add(edit);
        right.add(Box.createRigidArea(new Dimension(0,6)));
        right.add(del);
        tablePanel.add(right, BorderLayout.EAST);

        add.addActionListener(e -> onAddProduct());
        edit.addActionListener(e -> onEditProduct());
        del.addActionListener(e -> onDeleteProduct());

        // Tambahkan table panel ke main panel
        mainPanel.add(tablePanel, "grow, wrap");

        // Summary panel di bawah tabel (di luar border)
        JPanel sumPanel = new JPanel(new MigLayout("insets 8 8 12 8", "[grow][][right]", "[]2[]2[]"));
        
        sumPanel.add(new JLabel(""), "grow"); // spacer
        sumPanel.add(new JLabel("Subtotal list price:"), "");
        sumPanel.add(new JLabel("Rp 15.570.000"), "wrap");
        
        sumPanel.add(new JLabel(""), "grow"); // spacer
        sumPanel.add(new JLabel("Total retailer price:"), "");
        sumPanel.add(new JLabel("Rp 15.182.500"), "wrap");
        
        sumPanel.add(new JLabel(""), "grow"); // spacer
        sumPanel.add(new JLabel("Total wholesaler price:"), "");
        sumPanel.add(new JLabel("Rp 14.249.625"), "");
        
        mainPanel.add(sumPanel, "growx");

        return mainPanel;
    }

    private JPanel createTasksPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(createSectionBorder("Tasks"));

        String[] cols = {"State","Task","Assigner","Executer","Creation Date","Estimated Date","Executed Date"};
        Object[][] rows = {
            {"Completed","Pemasangan pipa PVC di area garasi","Warnoto","Goang","2025-10-20","2025-10-21","2025-10-21"},
            {"Completed","Pengecatan ulang ruang tamu","Warnoto","Toni","2025-10-25","2025-10-28","2025-10-27"},
            {"Delayed","Pemasangan keramik dinding dapur","Warnoto","Toni","2025-11-01","2025-11-04",""}
        };
        tasksModel = new DefaultTableModel(rows, cols) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        tasksTable = new JTable(tasksModel);
        tasksTable.setRowHeight(22);
        tasksTable.setSelectionBackground(new Color(153, 51, 204));
        tasksTable.setSelectionForeground(Color.WHITE);
        
        // Listener untuk mengubah warna saat kehilangan focus
        tasksTable.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                tasksTable.setSelectionBackground(new Color(200, 200, 200));
                tasksTable.setSelectionForeground(Color.BLACK);
                tasksTable.repaint();
            }
            
            @Override
            public void focusGained(FocusEvent e) {
                tasksTable.setSelectionBackground(new Color(153, 51, 204));
                tasksTable.setSelectionForeground(Color.WHITE);
                tasksTable.repaint();
            }
        });
        
        tasksTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tasksTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        tasksTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        tasksTable.getColumnModel().getColumn(2).setPreferredWidth(80);
        tasksTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        tasksTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        tasksTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        tasksTable.getColumnModel().getColumn(6).setPreferredWidth(100);
        
        p.add(new JScrollPane(tasksTable), BorderLayout.CENTER);

        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        JButton add = new JButton("Add"), edit = new JButton("Edit"), del = new JButton("Delete");
        add.setMaximumSize(new Dimension(90, 28));
        edit.setMaximumSize(new Dimension(90, 28));
        del.setMaximumSize(new Dimension(90, 28));
        add.setFocusPainted(false);
        edit.setFocusPainted(false);
        del.setFocusPainted(false);
        right.add(add); 
        right.add(Box.createRigidArea(new Dimension(0,6))); 
        right.add(edit); 
        right.add(Box.createRigidArea(new Dimension(0,6))); 
        right.add(del);
        p.add(right, BorderLayout.EAST);

        add.addActionListener(e -> onAddTask());
        edit.addActionListener(e -> onEditTask());
        del.addActionListener(e -> onDeleteTask());

        return p;
    }

    private JPanel createCommentsPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(createSectionBorder("Comments"));

        String[] cols = {"Date","User","Comment"};
        Object[][] rows = {
            {"2025-10-26 10:15","Toni","Cat tembok sudah diolesi lapisan pertama. Menunggu kering sebelum lapisan kedua."},
            {"2025-11-03 16:45","Toni","Cuaca hujan deras selama 2 hari, area kerja sedikit basah. Pemasangan ditunda besok pagi."},
            {"2025-11-15 14:30","Goang","Barang sudah sampai di lokasi. Mulai proses pembongkaran closet lama sore ini."}
        };
        commentsModel = new DefaultTableModel(rows, cols) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        commentsTable = new JTable(commentsModel);
        commentsTable.setRowHeight(22);
        commentsTable.setSelectionBackground(new Color(153, 51, 204));
        commentsTable.setSelectionForeground(Color.WHITE);
        
        // Listener untuk mengubah warna saat kehilangan focus
        commentsTable.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                commentsTable.setSelectionBackground(new Color(200, 200, 200));
                commentsTable.setSelectionForeground(Color.BLACK);
                commentsTable.repaint();
            }
            
            @Override
            public void focusGained(FocusEvent e) {
                commentsTable.setSelectionBackground(new Color(153, 51, 204));
                commentsTable.setSelectionForeground(Color.WHITE);
                commentsTable.repaint();
            }
        });
        
        p.add(new JScrollPane(commentsTable), BorderLayout.CENTER);

        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        JButton add = new JButton("Add"), edit = new JButton("Edit"), del = new JButton("Delete");
        add.setMaximumSize(new Dimension(90,28)); 
        edit.setMaximumSize(new Dimension(90,28)); 
        del.setMaximumSize(new Dimension(90,28));
        add.setFocusPainted(false);
        edit.setFocusPainted(false);
        del.setFocusPainted(false);
        right.add(add); 
        right.add(Box.createRigidArea(new Dimension(0,6))); 
        right.add(edit); 
        right.add(Box.createRigidArea(new Dimension(0,6))); 
        right.add(del);
        p.add(right, BorderLayout.EAST);

        add.addActionListener(e -> onAddComment());
        edit.addActionListener(e -> onEditComment());
        del.addActionListener(e -> onDeleteComment());

        return p;
    }

    // Product handlers
    private void onAddProduct() {
        JPanel panel = new JPanel(new MigLayout("wrap 2", "[][grow, fill]"));
        JTextField fRenov = new JTextField("Dapur");
        JTextField fDesc = new JTextField();
        JTextField fPart = new JTextField();
        JTextField fQty = new JTextField("1");
        JTextField fList = new JTextField("0");
        JTextField fDiscount = new JTextField("0");
        JTextField fPrice = new JTextField("0");
        JTextField fWholeDisc = new JTextField("0");
        JTextField fWholePrice = new JTextField("0");

        panel.add(new JLabel("Renovation:")); panel.add(fRenov);
        panel.add(new JLabel("Description:")); panel.add(fDesc);
        panel.add(new JLabel("Part #:")); panel.add(fPart);
        panel.add(new JLabel("Quantity:")); panel.add(fQty);
        panel.add(new JLabel("List Price:")); panel.add(fList);
        panel.add(new JLabel("Discount:")); panel.add(fDiscount);
        panel.add(new JLabel("Price:")); panel.add(fPrice);
        panel.add(new JLabel("Wholesale Discount:")); panel.add(fWholeDisc);
        panel.add(new JLabel("Wholesaler Price:")); panel.add(fWholePrice);

        int res = JOptionPane.showConfirmDialog(this, panel, "Add Product", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (res == JOptionPane.OK_OPTION) {
            try {
                Object[] row = new Object[] {
                    fRenov.getText(), fDesc.getText(), fPart.getText(),
                    Integer.parseInt(fQty.getText()), Integer.parseInt(fList.getText()),
                    Integer.parseInt(fDiscount.getText()), Integer.parseInt(fPrice.getText()),
                    Integer.parseInt(fWholeDisc.getText()), Integer.parseInt(fWholePrice.getText())
                };
                productModel.addRow(row);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Pastikan field numerik diisi angka.", "Input error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void onEditProduct() {
        int sel = productTable.getSelectedRow();
        if (sel == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris produk yang ingin diedit.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String ren = productModel.getValueAt(sel, 0).toString();
        String desc = productModel.getValueAt(sel, 1).toString();
        String part = productModel.getValueAt(sel, 2).toString();
        String qty = productModel.getValueAt(sel, 3).toString();
        String list = productModel.getValueAt(sel, 4).toString();
        String disc = productModel.getValueAt(sel, 5).toString();
        String price = productModel.getValueAt(sel, 6).toString();
        String wdisc = productModel.getValueAt(sel, 7).toString();
        String wprice = productModel.getValueAt(sel, 8).toString();

        JPanel panel = new JPanel(new MigLayout("wrap 2", "[][grow, fill]"));
        JTextField fRenov = new JTextField(ren);
        JTextField fDesc = new JTextField(desc);
        JTextField fPart = new JTextField(part);
        JTextField fQty = new JTextField(qty);
        JTextField fList = new JTextField(list);
        JTextField fDiscount = new JTextField(disc);
        JTextField fPrice = new JTextField(price);
        JTextField fWholeDisc = new JTextField(wdisc);
        JTextField fWholePrice = new JTextField(wprice);

        panel.add(new JLabel("Renovation:")); panel.add(fRenov);
        panel.add(new JLabel("Description:")); panel.add(fDesc);
        panel.add(new JLabel("Part #:")); panel.add(fPart);
        panel.add(new JLabel("Quantity:")); panel.add(fQty);
        panel.add(new JLabel("List Price:")); panel.add(fList);
        panel.add(new JLabel("Discount:")); panel.add(fDiscount);
        panel.add(new JLabel("Price:")); panel.add(fPrice);
        panel.add(new JLabel("Wholesale Discount:")); panel.add(fWholeDisc);
        panel.add(new JLabel("Wholesaler Price:")); panel.add(fWholePrice);

        int res = JOptionPane.showConfirmDialog(this, panel, "Edit Product", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (res == JOptionPane.OK_OPTION) {
            try {
                productModel.setValueAt(fRenov.getText(), sel, 0);
                productModel.setValueAt(fDesc.getText(), sel, 1);
                productModel.setValueAt(fPart.getText(), sel, 2);
                productModel.setValueAt(Integer.parseInt(fQty.getText()), sel, 3);
                productModel.setValueAt(Integer.parseInt(fList.getText()), sel, 4);
                productModel.setValueAt(Integer.parseInt(fDiscount.getText()), sel, 5);
                productModel.setValueAt(Integer.parseInt(fPrice.getText()), sel, 6);
                productModel.setValueAt(Integer.parseInt(fWholeDisc.getText()), sel, 7);
                productModel.setValueAt(Integer.parseInt(fWholePrice.getText()), sel, 8);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Pastikan field numerik diisi angka.", "Input error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void onDeleteProduct() {
        int sel = productTable.getSelectedRow();
        if (sel == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris produk yang ingin dihapus.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Hapus produk terpilih?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            productModel.removeRow(sel);
        }
    }

    // Tasks handlers
    private void onAddTask() {
        JPanel panel = new JPanel(new MigLayout("wrap 2", "[][grow, fill]"));
        JTextField fState = new JTextField("Pending");
        JTextField fTask = new JTextField();
        JTextField fAssigner = new JTextField();
        JTextField fExecuter = new JTextField();
        JTextField fCreation = new JTextField();
        JTextField fEst = new JTextField();
        JTextField fExecDate = new JTextField();

        panel.add(new JLabel("State:")); panel.add(fState);
        panel.add(new JLabel("Task:")); panel.add(fTask);
        panel.add(new JLabel("Assigner:")); panel.add(fAssigner);
        panel.add(new JLabel("Executer:")); panel.add(fExecuter);
        panel.add(new JLabel("Creation Date:")); panel.add(fCreation);
        panel.add(new JLabel("Estimated Date:")); panel.add(fEst);
        panel.add(new JLabel("Executed Date:")); panel.add(fExecDate);

        int res = JOptionPane.showConfirmDialog(this, panel, "Add Task", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (res == JOptionPane.OK_OPTION) {
            Object[] row = new Object[] {
                fState.getText(), fTask.getText(), fAssigner.getText(), fExecuter.getText(),
                fCreation.getText(), fEst.getText(), fExecDate.getText()
            };
            tasksModel.addRow(row);
        }
    }

    private void onEditTask() {
        int sel = tasksTable.getSelectedRow();
        if (sel == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris tugas yang ingin diedit.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String state = tasksModel.getValueAt(sel, 0).toString();
        String task = tasksModel.getValueAt(sel, 1).toString();
        String assigner = tasksModel.getValueAt(sel, 2).toString();
        String executer = tasksModel.getValueAt(sel, 3).toString();
        String creation = tasksModel.getValueAt(sel, 4).toString();
        String est = tasksModel.getValueAt(sel, 5).toString();
        String execDate = tasksModel.getValueAt(sel, 6).toString();

        JPanel panel = new JPanel(new MigLayout("wrap 2", "[][grow, fill]"));
        JTextField fState = new JTextField(state);
        JTextField fTask = new JTextField(task);
        JTextField fAssigner = new JTextField(assigner);
        JTextField fExecuter = new JTextField(executer);
        JTextField fCreation = new JTextField(creation);
        JTextField fEst = new JTextField(est);
        JTextField fExecDate = new JTextField(execDate);

        panel.add(new JLabel("State:")); panel.add(fState);
        panel.add(new JLabel("Task:")); panel.add(fTask);
        panel.add(new JLabel("Assigner:")); panel.add(fAssigner);
        panel.add(new JLabel("Executer:")); panel.add(fExecuter);
        panel.add(new JLabel("Creation Date:")); panel.add(fCreation);
        panel.add(new JLabel("Estimated Date:")); panel.add(fEst);
        panel.add(new JLabel("Executed Date:")); panel.add(fExecDate);

        int res = JOptionPane.showConfirmDialog(this, panel, "Edit Task", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (res == JOptionPane.OK_OPTION) {
            tasksModel.setValueAt(fState.getText(), sel, 0);
            tasksModel.setValueAt(fTask.getText(), sel, 1);
            tasksModel.setValueAt(fAssigner.getText(), sel, 2);
            tasksModel.setValueAt(fExecuter.getText(), sel, 3);
            tasksModel.setValueAt(fCreation.getText(), sel, 4);
            tasksModel.setValueAt(fEst.getText(), sel, 5);
            tasksModel.setValueAt(fExecDate.getText(), sel, 6);
        }
    }

    private void onDeleteTask() {
        int sel = tasksTable.getSelectedRow();
        if (sel == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris tugas yang ingin dihapus.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Hapus tugas terpilih?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            tasksModel.removeRow(sel);
        }
    }

    // Comments handlers
    private void onAddComment() {
        JPanel panel = new JPanel(new BorderLayout(6,6));
        JPanel fields = new JPanel(new MigLayout("wrap 2", "[][grow, fill]"));
        JTextField fDate = new JTextField();
        JTextField fUser = new JTextField();
        JTextArea fComment = new JTextArea(4, 30);
        fComment.setLineWrap(true);
        fComment.setWrapStyleWord(true);

        fields.add(new JLabel("Date:")); fields.add(fDate);
        fields.add(new JLabel("User:")); fields.add(fUser);
        panel.add(fields, BorderLayout.NORTH);
        panel.add(new JScrollPane(fComment), BorderLayout.CENTER);

        int res = JOptionPane.showConfirmDialog(this, panel, "Add Comment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (res == JOptionPane.OK_OPTION) {
            commentsModel.addRow(new Object[] { fDate.getText(), fUser.getText(), fComment.getText() });
        }
    }

    private void onEditComment() {
        int sel = commentsTable.getSelectedRow();
        if (sel == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris komentar yang ingin diedit.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String date = commentsModel.getValueAt(sel, 0).toString();
        String user = commentsModel.getValueAt(sel, 1).toString();
        String comment = commentsModel.getValueAt(sel, 2).toString();

        JPanel panel = new JPanel(new BorderLayout(6,6));
        JPanel fields = new JPanel(new MigLayout("wrap 2", "[][grow, fill]"));
        JTextField fDate = new JTextField(date);
        JTextField fUser = new JTextField(user);
        JTextArea fComment = new JTextArea(4, 30);
        fComment.setText(comment);
        fComment.setLineWrap(true);
        fComment.setWrapStyleWord(true);

        fields.add(new JLabel("Date:")); fields.add(fDate);
        fields.add(new JLabel("User:")); fields.add(fUser);
        panel.add(fields, BorderLayout.NORTH);
        panel.add(new JScrollPane(fComment), BorderLayout.CENTER);

        int res = JOptionPane.showConfirmDialog(this, panel, "Edit Comment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (res == JOptionPane.OK_OPTION) {
            commentsModel.setValueAt(fDate.getText(), sel, 0);
            commentsModel.setValueAt(fUser.getText(), sel, 1);
            commentsModel.setValueAt(fComment.getText(), sel, 2);
        }
    }

    private void onDeleteComment() {
        int sel = commentsTable.getSelectedRow();
        if (sel == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris komentar yang ingin dihapus.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Hapus komentar terpilih?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            commentsModel.removeRow(sel);
        }
    }

    // Bottom controls handlers
    private void onExport() {
        JOptionPane.showMessageDialog(this, "Fitur Export akan diimplementasikan", "Export", JOptionPane.INFORMATION_MESSAGE);
    }

    private void onSave() {
        JOptionPane.showMessageDialog(this, "Data proyek berhasil disimpan", "Save", JOptionPane.INFORMATION_MESSAGE);
    }

    private void onCancel() {
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Batalkan perubahan? Data yang belum disimpan akan hilang.", 
            "Konfirmasi", 
            JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Operasi dibatalkan", "Cancel", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Helper methods
    private Border createSectionBorder(String title) {
        return BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)), 
            title,
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Dialog", Font.PLAIN, 11),
            new Color(100, 100, 100)
        );
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        SwingUtilities.invokeLater(() -> {
            StudiKasusMig ex = new StudiKasusMig();
            ex.setVisible(true);
        });
    }
}