package UIClass.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyBookReserve {
    private JPanel JPButtons1;
    private JButton JBBorrow;
    private JButton JBReservings;
    private JButton JBDesire;
    private JPanel JPButton2;
    private JButton JBCancel;
    private JButton JBBack;
    private JPanel JPTable;
    private JTable JTableBorrow;
    private JPanel JPMain;


    public MyBookReserve() {
        String[] titles = {"Book Name", "Publisher", "Author", "Category", "Reserve time", "Expected Pick-up time"};
        String[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, titles);
        JTableBorrow.setModel(model);
        JScrollPane s = new JScrollPane(JTableBorrow);
        JPTable.add(s, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyBookReserve");
        frame.setContentPane(new MyBookReserve().JPMain);
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
        JBReservings.setBackground(new Color(-9866386));
        JBReservings.setEnabled(false);
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
        JBCancel = new JButton();
        JBCancel.setText("Cancel Reservation");
        JPButton2.add(JBCancel);
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
