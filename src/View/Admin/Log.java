package View.Admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Log {
    private JTable JTableLog;
    private JPanel panel1;
    private JButton JBBack;
    private javax.swing.JPanel JPanel;

    public Log() {
        String[] titles = {"1", "2", "3"};
        String[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, titles);
        JTableLog.setModel(model);
        JScrollPane s = new JScrollPane(JTableLog);
        panel1.add(s, BorderLayout.NORTH);

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Log");
        frame.setContentPane(new Log().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
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
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        JTableLog = new JTable();
        JTableLog.setAutoCreateRowSorter(false);
        JTableLog.setAutoResizeMode(2);
        JTableLog.setBackground(new Color(-7086643));
        JTableLog.setFillsViewportHeight(true);
        JTableLog.setUpdateSelectionOnSort(false);
        JTableLog.putClientProperty("Table.isFileList", Boolean.FALSE);
        panel1.add(JTableLog, BorderLayout.NORTH);
        JPanel = new JPanel();
        JPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JPanel.setBackground(new Color(-6828067));
        panel1.add(JPanel, BorderLayout.CENTER);
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer1);
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer2);
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer3);
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer4);
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer5);
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer6);
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer7);
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer8);
        final com.intellij.uiDesigner.core.Spacer spacer9 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer9);
        final com.intellij.uiDesigner.core.Spacer spacer10 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer10);
        final com.intellij.uiDesigner.core.Spacer spacer11 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer11);
        final com.intellij.uiDesigner.core.Spacer spacer12 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer12);
        final com.intellij.uiDesigner.core.Spacer spacer13 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer13);
        final com.intellij.uiDesigner.core.Spacer spacer14 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer14);
        final com.intellij.uiDesigner.core.Spacer spacer15 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer15);
        final com.intellij.uiDesigner.core.Spacer spacer16 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer16);
        final com.intellij.uiDesigner.core.Spacer spacer17 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer17);
        final com.intellij.uiDesigner.core.Spacer spacer18 = new com.intellij.uiDesigner.core.Spacer();
        JPanel.add(spacer18);
        JBBack = new JButton();
        JBBack.setText("Back");
        JPanel.add(JBBack);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}