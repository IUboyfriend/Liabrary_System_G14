package View.Admin;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class UserManagement {
    private JPanel Panel;
    private JLabel JLableUserID;
    private JButton JBActivate;
    private JButton JBDeactivate;
    private JButton JBBack;
    private JPanel JPInput;
    private JPanel JPButtons;
    private JTextField JTUserID;


    public static void main(String[] args) {
        JFrame frame = new JFrame("UserManagement");
        frame.setContentPane(new UserManagement().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(350, 120);
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
        Panel = new JPanel();
        Panel.setLayout(new BorderLayout(0, 0));
        JPInput = new JPanel();
        JPInput.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 5, new Insets(10, 0, 10, 0), -1, -1));
        JPInput.setBackground(new Color(-7086643));
        Panel.add(JPInput, BorderLayout.NORTH);
        JLableUserID = new JLabel();
        Font JLableUserIDFont = this.$$$getFont$$$(null, -1, 14, JLableUserID.getFont());
        if (JLableUserIDFont != null) JLableUserID.setFont(JLableUserIDFont);
        JLableUserID.setText("Usesr ID: ");
        JPInput.add(JLableUserID, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        JPInput.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        JPInput.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        JPInput.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        JTUserID = new JTextField();
        JPInput.add(JTUserID, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        JPButtons = new JPanel();
        JPButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JPButtons.setBackground(new Color(-6828067));
        Panel.add(JPButtons, BorderLayout.CENTER);
        JBActivate = new JButton();
        JBActivate.setBackground(new Color(-9017150));
        JBActivate.setText("Activate");
        JPButtons.add(JBActivate);
        JBDeactivate = new JButton();
        JBDeactivate.setBackground(new Color(-15022631));
        JBDeactivate.setText("Deactivate");
        JPButtons.add(JBDeactivate);
        JBBack = new JButton();
        JBBack.setBackground(new Color(-13345850));
        JBBack.setText("Back");
        JPButtons.add(JBBack);
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
        return Panel;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
