package View.User;

import Controller.BookController;
import Controller.OracleDB;

import javax.swing.*;
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
    private JPanel JPMain;

    private String selectedItem = "All";

    public static JFrame frame;
    public SearchBook() {
        String[] titles = {"Book Name", "Publisher", "Author", "Category", "Available"};
        String[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, titles);
        JTableSearch.setModel(model);
        JScrollPane s = new JScrollPane(JTableSearch);
        JPTable.add(s, BorderLayout.CENTER);
        JBSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OracleDB oracleDB = new OracleDB();
                String searchText = TFSearchBar.getText();
                if (searchText.equals(""))
                    JOptionPane.showMessageDialog(null, "Please type something in the search bar!");
                else if (selectedItem.equals("All")) {
                    try {
                        ResultSet rset = BookController.searchAll(searchText, oracleDB);
                        if (!rset.next())
                            JOptionPane.showMessageDialog(null, "No records are found!");
                        else {
                            do {
                                String BookName = rset.getString("BookName");
                                String Author = rset.getString("Author");
                                String Category = rset.getString("Category");
                                String Publisher = rset.getString("Publisher");
                                int status = rset.getInt("Status");
                                String whatStatus = status == 0 ? "Available" : status == 1 ? "Borrowed" : "Reserved";
                                String[] row = {BookName, Publisher, Author, Category, whatStatus};
                                model.addRow(row);
                            } while (rset.next());

                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    try {
                        ResultSet rset = BookController.searchOneField(searchText, selectedItem, oracleDB);
                        if (!rset.next())
                            JOptionPane.showMessageDialog(null, "No records are found!");
                        else {
                            do {
                                String BookName = rset.getString("BookName");
                                String Author = rset.getString("Author");
                                String Category = rset.getString("Category");
                                String Publisher = rset.getString("Publisher");
                                int status = rset.getInt("Status");
                                String whatStatus = status == 0 ? "Available" : status == 1 ? "Borrowed" : "Reserved";
                                String[] row = {BookName, Publisher, Author, Category, whatStatus};
                                model.addRow(row);
                            } while (rset.next());
                        }

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                try {
                    oracleDB.closeConnection();
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
    }

    public static void main(String[] args) {
        frame = new JFrame("SearchBook");
        frame.setContentPane(new SearchBook().JPMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
        JPMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
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
        JBBack.setForeground(new Color(-7105645));
        JBBack.setText("Back\n");
        JPSearchBar.add(JBBack, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JPTable = new JPanel();
        JPTable.setLayout(new BorderLayout(0, 0));
        JPMain.add(JPTable, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JTableSearch = new JTable();
        JPTable.add(JTableSearch, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return JPMain;
    }

}
