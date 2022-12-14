package View;

import Controller.InitialController;
import Controller.LoginController;
import Controller.OracleDB;
import View.Admin.AdminOperation;
import View.User.NewUser;
import View.User.UserOperation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Locale;

public class Initial {
    public JPanel JPMain;
    private JButton userLoginButton;
    private JButton adminLoginButton;
    private JButton newUserButton;
    private JTextField JTextFieldID;
    private JPanel headerPanel;
    private JLabel headerJLabel;
    private JPanel JPContent;
    private JPanel JPInput;
    private JPanel JPButton;
    private JPanel JP01;
    private JPanel JP02;
    private JLabel JLableID;
    private JLabel JLablePassword;
    private JPasswordField JPasswordFieldPassword;

    public static String ID;

    private String inputID;
    private String inputPassword;

    public Initial(JFrame frame) {
        frame.setTitle("Welcome to the Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 320);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        userLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputID = JTextFieldID.getText();
                inputPassword = String.valueOf(JPasswordFieldPassword.getPassword());
                String message = checkEmpty();
                if (!message.equals("")) {
                    JOptionPane.showMessageDialog(null, message);
                } else {
                    try {
                        message = LoginController.Login(inputID, inputPassword, "User");
                        if (!message.equals("")) {
                            JOptionPane.showMessageDialog(null, message);
                            return;
                        } else {
                            ID = inputID;
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    //if a user succeeds in logging in, jump to another page
                    frame.setContentPane(new UserOperation(frame).JPMain);
                }

            }
        });
        newUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new NewUser(frame).JPMain);
            }
        });
        adminLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputID = JTextFieldID.getText();
                inputPassword = String.valueOf(JPasswordFieldPassword.getPassword());
                String message = checkEmpty();
                if (!message.equals("")) {
                    JOptionPane.showMessageDialog(null, message);
                } else {
                    try {
                        message = LoginController.Login(inputID, inputPassword, "Admin");
                        if (!message.equals("")) {
                            JOptionPane.showMessageDialog(null, message);
                            return;
                        } else {
                            ID = inputID;
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    //if an admin succeeds in logging in, jump to another page
                    frame.setContentPane(new AdminOperation(frame).JPMain);
                }

            }
        });
    }

    private String checkEmpty() {
        if (inputID.equals("")) {
            return "The account cannot be empty!";
        }
        if (inputPassword.equals("")) {
            return "The password cannot be empty!";
        }
        return "";
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
        JPMain.setBackground(new Color(-8806227));
        JPMain.setForeground(new Color(-8806227));
        headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        headerPanel.setBackground(new Color(-7086643));
        JPMain.add(headerPanel, BorderLayout.NORTH);
        headerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        headerJLabel = new JLabel();
        Font headerJLabelFont = this.$$$getFont$$$("Arial Black", -1, 26, headerJLabel.getFont());
        if (headerJLabelFont != null) headerJLabel.setFont(headerJLabelFont);
        headerJLabel.setForeground(new Color(-394759));
        headerJLabel.setHorizontalAlignment(10);
        headerJLabel.setText("Library Management System");
        headerPanel.add(headerJLabel);
        JPContent = new JPanel();
        JPContent.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        JPContent.setBackground(new Color(-10586488));
        JPMain.add(JPContent, BorderLayout.CENTER);
        JPContent.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        JPInput = new JPanel();
        JPInput.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(25, 0, 25, 0), -1, -1));
        JPInput.setBackground(new Color(-6828067));
        JPContent.add(JPInput, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JP01 = new JPanel();
        JP01.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), 10, 10));
        JP01.setBackground(new Color(-6828067));
        JPInput.add(JP01, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JTextFieldID = new JTextField();
        JP01.add(JTextFieldID, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        JLableID = new JLabel();
        Font JLableIDFont = this.$$$getFont$$$(null, -1, 18, JLableID.getFont());
        if (JLableIDFont != null) JLableID.setFont(JLableIDFont);
        JLableID.setText("User ID:     ");
        JP01.add(JLableID, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JP02 = new JPanel();
        JP02.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(22, 0, 0, 0), 10, 10));
        JP02.setBackground(new Color(-6828067));
        JPInput.add(JP02, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        JLablePassword = new JLabel();
        Font JLablePasswordFont = this.$$$getFont$$$(null, -1, 18, JLablePassword.getFont());
        if (JLablePasswordFont != null) JLablePassword.setFont(JLablePasswordFont);
        JLablePassword.setText("Password:");
        JP02.add(JLablePassword, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JPasswordFieldPassword = new JPasswordField();
        JP02.add(JPasswordFieldPassword, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        JPButton = new JPanel();
        JPButton.setLayout(new BorderLayout(0, 0));
        JPButton.setBackground(new Color(-10982490));
        JPContent.add(JPButton, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, new Dimension(0, 35), null, 0, false));
        userLoginButton = new JButton();
        userLoginButton.setEnabled(true);
        userLoginButton.setForeground(new Color(-6796613));
        userLoginButton.setText("User Login");
        JPButton.add(userLoginButton, BorderLayout.WEST);
        newUserButton = new JButton();
        newUserButton.setForeground(new Color(-4498354));
        newUserButton.setText("New User");
        JPButton.add(newUserButton, BorderLayout.CENTER);
        adminLoginButton = new JButton();
        adminLoginButton.setForeground(new Color(-14435416));
        adminLoginButton.setText("Admin Login");
        JPButton.add(adminLoginButton, BorderLayout.EAST);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return JPMain;
    }

}
