package View.Admin;

import Controller.BookController;
import Controller.BookRecordController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRecord {
    private JPanel JPSearchBar;
    private JTextField TFSearchBar;
    private JButton JBSearch;
    private JButton JBBack;
    private JPanel JPTable;
    private JTable JTableSearch;
    public JPanel JPMain;

    public BookRecord(JFrame frame) {
        String[] titles = {"Book", "AUTHOR", "CATEGORY", "PUBLISHER", "User", "Status", "BorrowTime", "ReturnTime"};
        String[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, titles);
        JTableSearch.setModel(model);
        JScrollPane s = new JScrollPane(JTableSearch);
        JPMain.add(s, BorderLayout.CENTER);
        frame.setTitle("Borrow and Return Record");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JBSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                String searchText = TFSearchBar.getText();
                try {
                    ResultSet rset;
                    if(searchText.equals(""))
                        rset = BookController.searchTable("BORROW_AND_RETURN_RECORD");
                    else rset = BookRecordController.searchBorrowReturn(searchText);
                    if (!rset.next())
                        JOptionPane.showMessageDialog(null, "No records are found!");
                    else {
                        do {
                            String BookName = rset.getString("BookName");
                            String Author = rset.getString("AUTHOR");
                            String Category = rset.getString("CATEGORY");
                            String Publisher = rset.getString("PUBLISHER");
                            String Nickname = rset.getString("Nickname");
                            String StatusName = rset.getString("StatusName");
                            String BorrowTime = rset.getString("BorrowTime");
                            String ReturnTime = rset.getString("ReturnTime");
                            String[] row = {Nickname, BookName, Publisher, Author, Category, StatusName, BorrowTime, ReturnTime};
                            model.addRow(row);
                        } while (rset.next());
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

        JBBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new AdminOperation(frame).JPMain);
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
        JPMain.setLayout(new BorderLayout(0, 0));
        JPSearchBar = new JPanel();
        JPSearchBar.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 4, new Insets(20, 20, 20, 20), -1, -1));
        JPSearchBar.setBackground(new Color(-7086643));
        JPMain.add(JPSearchBar, BorderLayout.NORTH);
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
        final JLabel label1 = new JLabel();
        label1.setForeground(new Color(-789517));
        label1.setText("Book Information:  ");
        JPSearchBar.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JPTable = new JPanel();
        JPTable.setLayout(new BorderLayout(0, 0));
        JPMain.add(JPTable, BorderLayout.CENTER);
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
