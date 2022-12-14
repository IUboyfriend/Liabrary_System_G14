package View.User;

import Controller.BookController;
import Controller.BookHelpController;
import Controller.BookManagementController;
import View.Initial;
import View.Oracle_Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;


public class MyBookBorrow {
    public JPanel JPMain;
    private JTable JTableBorrow;
    private JButton JBBorrow;
    private JButton JBReservings;
    private JButton JBDesire;
    private JButton JBReturn;
    private JButton JBBack;
    private JPanel JPButtons1;
    private JPanel JPButton2;
    private JPanel JPTable;
    private JButton JBPick;

    private String[] titles;

    private String[][] data;

    DefaultTableModel modelInitial, modelBorrow, modelReserve, modelDesire;

    boolean showMessage = true;

    public MyBookBorrow(JFrame frame) {

        titles = new String[]{};
        data = new String[][]{};
        modelInitial = new DefaultTableModel(data, titles);
        JTableBorrow.setModel(modelInitial);
        JScrollPane s = new JScrollPane(JTableBorrow);
        JPTable.add(s, BorderLayout.CENTER);
        JBBorrow.setEnabled(true);
        JBDesire.setEnabled(true);
        JBReservings.setEnabled(true);
        JBReturn.setVisible(false);
        frame.setTitle("Please choose one page to check....");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JBPick.setVisible(false);


        JBBorrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JBPick.setVisible(false);
                titles = new String[]{"Book Name", "Publisher", "Author", "Category", "Borrow time", "Expected Return time"};
                data = new String[][]{};
                modelBorrow = new DefaultTableModel(data, titles);
                JTableBorrow.setModel(modelBorrow);
                JBBorrow.setEnabled(false);
                JBDesire.setEnabled(true);
                JBReservings.setEnabled(true);
                frame.setTitle("My Borrowing");
                JBReturn.setText("Return Book");
                JBReturn.setVisible(true);

                modelBorrow.setRowCount(0);
                try {
                    ResultSet rset = BookController.searchReturnTable();
                    while (rset.next()) {
                        String BookID = rset.getString("BOOKID");
                        ResultSet rsetbook = BookManagementController.getall(BookID, Oracle_Login.oracleDB);
                        rsetbook.next();
                        String BookName = rsetbook.getString("BOOKNAME");
                        String Author = rsetbook.getString("AUTHOR");
                        String Category = rsetbook.getString("CATEGORY");
                        String Publisher = rsetbook.getString("PUBLISHER");

                        String sd1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rset.getTimestamp("BORROWTIME"));
                        String sd2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rset.getTimestamp("EXPECTEDRETURNTIME"));

                        String[] row = {BookName, Publisher, Author, Category, sd1, sd2};
                        modelBorrow.addRow(row);
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JBReservings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titles = new String[]{"Book Name", "Publisher", "Author", "Category", "Reserve time", "Expected Pick-up time"};
                data = new String[][]{};
                modelReserve = new DefaultTableModel(data, titles);
                JTableBorrow.setModel(modelReserve);
                JBBorrow.setEnabled(true);
                JBDesire.setEnabled(true);
                JBReservings.setEnabled(false);
                frame.setTitle("My Reserving");
                JBReturn.setText("Cancel Reservation");
                JBReturn.setVisible(true);

                modelReserve.setRowCount(0);

                JBPick.setVisible(true);
                try {
                    ResultSet rset = BookController.searchTable("RESERVED_RECORD");
                    while (rset.next()) {
                        String BookID = rset.getString("BOOKID");
                        ResultSet rsetbook = BookManagementController.getall(BookID, Oracle_Login.oracleDB);
                        rsetbook.next();
                        String BookName = rsetbook.getString("BOOKNAME");
                        String Author = rsetbook.getString("AUTHOR");
                        String Category = rsetbook.getString("CATEGORY");
                        String Publisher = rsetbook.getString("PUBLISHER");

                        String sd1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rset.getTimestamp("RESERVEDTIME"));
                        String sd2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rset.getTimestamp("EXPECTEDGETTIME"));

                        String[] row = {BookName, Publisher, Author, Category, sd1, sd2};
                        modelReserve.addRow(row);
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        JBDesire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JBPick.setVisible(false);
                titles = new String[]{"Book Name", "Publisher", "Author", "Category", "Available"};
                data = new String[][]{};
                modelDesire = new DefaultTableModel(data, titles);
                JTableBorrow.setModel(modelDesire);
                JBBorrow.setEnabled(true);
                JBDesire.setEnabled(false);
                JBReservings.setEnabled(true);
                frame.setTitle("My Desiring");
                JBReturn.setText("Cancel Desiring");
                JBReturn.setVisible(true);
                modelDesire.setRowCount(0);
                try {
                    ResultSet rset = BookController.searchTable("BOOK_DESIRED");
                    if (rset.next())
                        do {
                            String BookName = rset.getString("BOOKNAME");
                            String Author = rset.getString("AUTHOR");
                            String Category = rset.getString("CATEGORY");
                            String Publisher = rset.getString("PUBLISHER");
                            String Judge = BookManagementController.bookAvailable(BookName, Publisher, Author, Category, Oracle_Login.oracleDB) > 0 ? "YES" : "NO";
                            String[] row = {BookName, Publisher, Author, Category, Judge};
                            modelDesire.addRow(row);
                        } while (rset.next());


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        JBReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = JTableBorrow.getSelectedRow();
                if (rowIndex >= 0) {
                    try {
                        String currentType = JBReturn.getText();
                        if (currentType.equals("Return Book")) {
                            String borrowtime = (String) modelBorrow.getValueAt(rowIndex, 4);
                            String message = BookHelpController.returnBook(BookManagementController.BfindBookId(Initial.ID, borrowtime, Oracle_Login.oracleDB), borrowtime);
                            JOptionPane.showMessageDialog(null, message);
                            JBBorrow.setEnabled(true);
                            JBBorrow.doClick();
                            JBBorrow.setEnabled(false);
                        } else if (currentType.equals("Cancel Reservation")) {
                            //System.out.println((String) model.getValueAt(rowIndex, 0));
                            String reservedtime = (String) modelReserve.getValueAt(rowIndex, 4);

                            String message = BookHelpController.cancelReserveBook(BookManagementController.RfindBookId(Initial.ID, reservedtime, Oracle_Login.oracleDB), reservedtime);

                            if (showMessage == true)
                                JOptionPane.showMessageDialog(null, message);
                            else
                                showMessage = true;
                            JBReservings.setEnabled(true);
                            JBReservings.doClick();
                            JBReservings.setEnabled(false);
                        } else if (currentType.equals("Cancel Desiring")) {
                            String bookName = (String) modelDesire.getValueAt(rowIndex, 0);
                            String publisher = (String) modelDesire.getValueAt(rowIndex, 1);
                            String author = (String) modelDesire.getValueAt(rowIndex, 2);
                            String category = (String) modelDesire.getValueAt(rowIndex, 3);

                            String message = BookHelpController.cancelDesireBook(bookName, author, category, publisher);
                            JOptionPane.showMessageDialog(null, message);
                            JBDesire.setEnabled(true);
                            JBDesire.doClick();
                            JBDesire.setEnabled(false);
                        }


                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                } else JOptionPane.showMessageDialog(null, "Please select a line!");
            }
        });

        JBBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new UserOperation(frame).JPMain);
            }
        });
        JBPick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = JTableBorrow.getSelectedRow();
                if (rowIndex == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a book!");
                    return;
                }
                String reservedtime = (String) modelReserve.getValueAt(rowIndex, 4);
                try {
                    String BookId = BookManagementController.RfindBookId(Initial.ID, reservedtime, Oracle_Login.oracleDB);
                    System.out.println(BookId);
                    ResultSet resultSet = BookManagementController.findBookInfoById(BookId);
                    if (resultSet.next()) {
                        String bookName = resultSet.getString("BOOKNAME");
                        String publisher = resultSet.getString("PUBLISHER");
                        String author = resultSet.getString("AUTHOR");
                        String category = resultSet.getString("CATEGORY");
                        String message = BookController.borrowBook(bookName, publisher, author, category, true);
                        if (message.equals("Successfully borrow a book! Please return it in one month!")) {
                            showMessage = false;
                            JBReturn.doClick();
                            JOptionPane.showMessageDialog(null, "Successfully borrow your reserved book!\nPlease return it in one month!");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "This book doesn't exist any more!");
                    }

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
        JPButtons1 = new JPanel();
        JPButtons1.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 15));
        JPButtons1.setBackground(new Color(-7086643));
        JPMain.add(JPButtons1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JBBorrow = new JButton();
        JBBorrow.setBackground(new Color(-2976583));
        JBBorrow.setEnabled(true);
        JBBorrow.setForeground(new Color(-328966));
        JBBorrow.setText("Borrowings");
        JPButtons1.add(JBBorrow);
        JBReservings = new JButton();
        JBReservings.setBackground(new Color(-15022631));
        JBReservings.setForeground(new Color(-328966));
        JBReservings.setText("Reservings");
        JPButtons1.add(JBReservings);
        JBDesire = new JButton();
        JBDesire.setBackground(new Color(-13345850));
        JBDesire.setForeground(new Color(-789517));
        JBDesire.setText("Desirings");
        JPButtons1.add(JBDesire);
        JPButton2 = new JPanel();
        JPButton2.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        JPButton2.setBackground(new Color(-6828067));
        JPMain.add(JPButton2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JBPick = new JButton();
        JBPick.setText("PickUp");
        JPButton2.add(JBPick);
        JBReturn = new JButton();
        JBReturn.setText("Return Book");
        JPButton2.add(JBReturn);
        JBBack = new JButton();
        JBBack.setText("Back");
        JPButton2.add(JBBack);
        JPTable = new JPanel();
        JPTable.setLayout(new BorderLayout(0, 0));
        JPMain.add(JPTable, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JTableBorrow = new JTable();
        JTableBorrow.setBackground(new Color(-5007154));
        JTableBorrow.setForeground(new Color(-16777216));
        JPTable.add(JTableBorrow, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return JPMain;
    }

}
