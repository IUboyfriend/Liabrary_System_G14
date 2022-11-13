package View.User;

import Controller.BookController;
import Controller.BookHelpController;
import Controller.BookManagementController;
import Controller.OracleDB;
import View.Oracle_Login;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchBook {
    private JComboBox ComboBoxOption;
    private JTextField TFSearchBar;
    private JButton JBSearch;
    private JTable JTableSearch;
    private JPanel JPTable;
    private JPanel JPSearchBar;
    private JButton JBBack;
    JPanel JPMain;
    private JPanel JPButtons;
    private JButton JBBorrow;
    private JButton JBReserve;
    private JButton JBDesire;

    private String selectedItem = "All";

    public SearchBook(JFrame frame) {
        String[] titles = {"Book Name", "Publisher", "Author", "Category", "Available Copies"};
        String[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, titles);
        JTableSearch.setModel(model);
        JScrollPane s = new JScrollPane(JTableSearch);
        JPTable.add(s, BorderLayout.CENTER);
        frame.setTitle("Search Book");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        JBReserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = JTableSearch.getSelectedRow();
                String bookName = (String) model.getValueAt(rowIndex, 0);
                String publisher = (String) model.getValueAt(rowIndex, 1);
                String author = (String) model.getValueAt(rowIndex, 2);
                String category = (String) model.getValueAt(rowIndex, 3);
                try {
                    String message = BookHelpController.reserveBook(bookName, publisher, author, category);
                    JOptionPane.showMessageDialog(null, message);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JBDesire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = JTableSearch.getSelectedRow();
                String bookName = (String) model.getValueAt(rowIndex, 0);
                String publisher = (String) model.getValueAt(rowIndex, 1);
                String author = (String) model.getValueAt(rowIndex, 2);
                String category = (String) model.getValueAt(rowIndex, 3);
                String availablebook = (String) model.getValueAt(rowIndex, 4);
                try {
                    String message = BookHelpController.desireBook(bookName, publisher, author, category, availablebook);
                    JOptionPane.showMessageDialog(null, message);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JBSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                String searchText = TFSearchBar.getText();
                String searchType = selectedItem;
                try {
                    ResultSet rset = BookController.searchAll(searchText, searchType);
                    if (!rset.next())
                        JOptionPane.showMessageDialog(null, "No records are found!");
                    else {
                        int count = 0;
                        do {
                            String BookName = rset.getString("BOOKNAME");
                            String Author = rset.getString("AUTHOR");
                            String Category = rset.getString("CATEGORY");
                            String Publisher = rset.getString("PUBLISHER");
                            int number = BookManagementController.bookAvailable(BookName, Publisher, Author, Category, Oracle_Login.oracleDB);
                            String[] row = {BookName, Publisher, Author, Category, String.valueOf(number)};
                            model.addRow(row);
                        } while (rset.next());
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        ComboBoxOption.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (ItemEvent.SELECTED == e.getStateChange()) {
                    selectedItem = e.getItem().toString();
                }
            }
        });
        JBBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new UserOperation(frame).JPMain);
            }
        });
        JBBorrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = JTableSearch.getSelectedRow();
                String bookName = (String) model.getValueAt(rowIndex, 0);
                String publisher = (String) model.getValueAt(rowIndex, 1);
                String author = (String) model.getValueAt(rowIndex, 2);
                String category = (String) model.getValueAt(rowIndex, 3);
                try {
                    String message = BookController.borrowBook(bookName, publisher, author, category);
                    JOptionPane.showMessageDialog(null, message);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        JPMain = new JPanel();
        JPMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        JPMain.setBackground(new Color(-8806227));
        JPSearchBar = new JPanel();
        JPSearchBar.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(20, 20, 20, 20), -1, -1));
        JPSearchBar.setBackground(new Color(-7086643));
        JPMain.add(JPSearchBar, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ComboBoxOption = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("All");
        defaultComboBoxModel1.addElement("Name");
        defaultComboBoxModel1.addElement("Publisher");
        defaultComboBoxModel1.addElement("Author");
        defaultComboBoxModel1.addElement("Category");
        ComboBoxOption.setModel(defaultComboBoxModel1);
        JPSearchBar.add(ComboBoxOption, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, -1), null, 0, false));
        TFSearchBar = new JTextField();
        JPSearchBar.add(TFSearchBar, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 20), null, 0, false));
        JBSearch = new JButton();
        JBSearch.setBackground(new Color(-13345850));
        JBSearch.setForeground(new Color(-723724));
        JBSearch.setText("Search\n");
        JPSearchBar.add(JBSearch, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JBBack = new JButton();
        JBBack.setBackground(new Color(-3374631));
        JBBack.setForeground(new Color(-723724));
        JBBack.setText("Back\n");
        JPSearchBar.add(JBBack, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JPTable = new JPanel();
        JPTable.setLayout(new BorderLayout(0, 0));
        JPMain.add(JPTable, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JTableSearch = new JTable();
        JPTable.add(JTableSearch, BorderLayout.CENTER);
        JPButtons = new JPanel();
        JPButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        JPButtons.setBackground(new Color(-6828067));
        JPMain.add(JPButtons, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JPButtons.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        JBBorrow = new JButton();
        JBBorrow.setBackground(new Color(-9017150));
        JBBorrow.setText("Borrow");
        JPButtons.add(JBBorrow);
        JBReserve = new JButton();
        JBReserve.setBackground(new Color(-15022631));
        JBReserve.setText("Reserve");
        JPButtons.add(JBReserve);
        JBDesire = new JButton();
        JBDesire.setBackground(new Color(-13345850));
        JBDesire.setText("Desire");
        JPButtons.add(JBDesire);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return JPMain;
    }

}
