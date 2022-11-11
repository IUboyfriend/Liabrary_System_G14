package View.Admin;

import Controller.OracleDB;
import Controller.logController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;

public class Log {
    private JTable JTableLog;
    JPanel JPMain;
    private JPanel JPTable;
    private JButton JBBack;
    private JPanel JPButton2;

    public Log(JFrame frame) {
        String[] titles = {"Admin Account", "Operation Detail", "Operation Time"};
        String[][] data = {};
        String id = "1";
        DefaultTableModel model = new DefaultTableModel(data, titles);
        JTableLog.setModel(model);
        JScrollPane s = new JScrollPane(JTableLog);
        JPMain.add(s, BorderLayout.NORTH);
        OracleDB oracleDB = new OracleDB();
        try {
            ResultSet res1 = logController.rgetall(id, oracleDB);
            ResultSet res2 = logController.ogetall(id, oracleDB);
            if (res1.next()) {
                Vector<String> row = new Vector();
                row.add(id);
                row.add("reactivate");
                row.add(res1.getString("ReactivationTime"));
                model.addRow(row);
            }
            if (res2.next()) {
                Vector<String> row = new Vector();
                row.add(id);
                row.add(res2.getString("OperationType"));
                row.add(res2.getString("OperationTime"));
                model.addRow(row);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        frame.setTitle("Admin Log");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

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
        JPTable = new JPanel();
        JPTable.setLayout(new BorderLayout(0, 0));
        JPMain.add(JPTable, BorderLayout.NORTH);
        JTableLog = new JTable();
        JTableLog.setBackground(new Color(-7086643));
        JTableLog.setForeground(new Color(-16777216));
        JPTable.add(JTableLog, BorderLayout.CENTER);
        JPButton2 = new JPanel();
        JPButton2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(20, 0, 0, 30), -1, -1));
        JPButton2.setBackground(new Color(-6828067));
        JPMain.add(JPButton2, BorderLayout.CENTER);
        JBBack = new JButton();
        JBBack.setText("Back");
        JPButton2.add(JBBack, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        JPButton2.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        JPButton2.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return JPMain;
    }

}